package de.kit.kastel.travart.kconfig.transformation.roundtrip;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Variable;

import at.jku.cps.travart.core.factory.impl.CoreModelFactory;
import at.jku.cps.travart.core.helpers.TraVarTUtils;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.model.KconfigGraph;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.model.KconfigNode;
import de.kit.kastel.travart.kconfig.model.nodes.choice.KconfigBooleanChoice;
import de.kit.kastel.travart.kconfig.model.nodes.choice.KconfigChoice;
import de.kit.kastel.travart.kconfig.model.nodes.choice.KconfigTristateChoice;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigIfNode;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;
import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigBooleanNode;
import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigTristateNode;
import de.kit.kastel.travart.kconfig.parser.TreeProcessor;
import de.vill.model.Feature;
import de.vill.model.FeatureModel;
import de.vill.model.Group.GroupType;
import de.vill.model.constraint.Constraint;
import de.vill.model.constraint.ImplicationConstraint;

// Break up individual transformation rules and move to TransformKCtoFMUtil
public class KconfigModelTwoWayGraphTransformer {

	static final private String TRISTATE_ATTRIBUTE_NAME = "active";
	
	static final private String SELECT_MARKER = "hasSelectDep";

	static final private String ROOT_NODE_NAME = "Kconfig";

	/***
	 * Transform given IKconfigModel into a FeatureModel. Transformation done with underlying KconfigGraph.
	 * Model metadata copied into root feature of the generated feature model.
	 */
	// Build a feature model using the data contained in a finalised TreeProcessor
	static public FeatureModel processGraph(IKconfigModel model) {
		KconfigGraph graph = model.getInnerGraph();
		// Initialize factory
		CoreModelFactory factory = CoreModelFactory.getInstance();
		FormulaFactory ffactory = new FormulaFactory();
		// First step: Initialize new feature model and convert nodes to features
		FeatureModel fm = factory.create();		
		// Create the root node
		Feature root = factory.createFeature(ROOT_NODE_NAME);
		TraVarTUtils.addAttribute(root, "name", model.getName());
		TraVarTUtils.addAttribute(root, "sourceFile", model.getSourceFile());
		TraVarTUtils.addAttribute(root, "factoryId", model.getFactoryId());
		TraVarTUtils.setAbstract(root, true);
		TraVarTUtils.addFeature(fm, root);
		TraVarTUtils.setRoot(fm, root);
		// Process the internal nodes
		// Add them directly to the root of the feature model
		for (KconfigNode node : graph.nodes().values()) {
			processNode(node, fm);
		}

		// TODO Refactor to make process* methods to directly add the generated constraints instead of returning them
		for (Entry<KconfigNode, Collection<MutablePair<Formula, Boolean>>> dependenciesPerNode : graph.dependencies()
				.asMap()
				.entrySet()) {
			KconfigNode sourceNode = dependenciesPerNode.getKey();
			for (Pair<Formula, Boolean> dependency : dependenciesPerNode.getValue()) {
				// Model as implication if dependency expression composite or `select` switch active
				if (dependency.getRight() || !dependency.getLeft().isAtomicFormula()) {
					Constraint impl = TraVarTUtils.buildConstraintFromFormula(
							ffactory.implication(ffactory.variable(sourceNode.getName()), ffactory.importFormula(dependency.getLeft()))); 
					TraVarTUtils.addOwnConstraint(fm, impl);							
					if (dependency.getRight()) {
						// When ran as partial two-way transformation (= one-way Kconfig -> FM), SELECT_MARKER attribute redundant
						// FIXME Probably breaks for nodes with multiple select dependencies
						TraVarTUtils.addAttribute(TraVarTUtils.getFeature(fm, sourceNode.getName()), SELECT_MARKER, fm.getOwnConstraints().indexOf(impl));
					}
				} else {
					for (KconfigNode targetNode : TreeProcessor.extractNodes(dependency.getLeft(), graph)) {
						// If the dependency expression is an atomic formula, extractNodes should return only one node
						assert TreeProcessor.extractNodes(dependency.getLeft(), graph).size() == 1;
						TraVarTUtils.addOwnConstraints(fm, processRule(sourceNode, targetNode, fm));
					}
				}
			}
			switch (sourceNode) {
			case KconfigIfNode node -> TraVarTUtils.addOwnConstraints(fm, processChoiceBlock(sourceNode, fm));
			case KconfigBooleanChoice node ->
				TraVarTUtils.addOwnConstraints(fm, processChoiceBlock(sourceNode, fm));
			case KconfigTristateChoice node -> 
				TraVarTUtils.addOwnConstraints(fm, processChoiceBlock(sourceNode, fm));
			default -> {}
			}
		}
		return fm;
	}

	private static Collection<Constraint> processChoiceBlock(KconfigNode choiceBlock, FeatureModel fm) {
		CoreModelFactory factory = CoreModelFactory.getInstance();
		Feature respFeature = TraVarTUtils.getFeature(fm, choiceBlock.getName());
		switch (choiceBlock) {
		case KconfigBooleanChoice choice -> {
			return List.of();
		}
		case KconfigTristateChoice choice -> {
			TraVarTUtils.addAttribute(respFeature, TRISTATE_ATTRIBUTE_NAME, false);
			// The feature corresponding to the choice block can only be "active" iff one of the choices are set to "active"
			// Use logicNG's pseudo-boolean constraints
			FormulaFactory ffactory = new FormulaFactory();
			List<Variable> pseudoConjVars = new ArrayList<Variable>();
			for (Feature child : respFeature.getChildren().stream().flatMap(g -> g.getFeatures().stream())
					.collect(Collectors.toList())) {
				pseudoConjVars.add(ffactory.variable(child.getFeatureName() + "." + TRISTATE_ATTRIBUTE_NAME));
			}
			Formula atMostOne = ffactory.amo(pseudoConjVars);			
			// Sum of all "active" tristate symbols in a choice block can at most be 1 (amo = at-most-one)
			//Formula exactlyOne = ffactory.equivalence(ffactory.variable(respFeature.getFeatureName() + "." + TRISTATE_ATTRIBUTE_NAME), ffactory.exo(pseudoConjVars));
			// Due to a uvl-metamodel bug, the exo variable cannot be parsed correctly!
			// Use slightly relaxed condition instead...
			Formula exactlyOne = ffactory.equivalence(ffactory.variable(respFeature.getFeatureName() + "." + TRISTATE_ATTRIBUTE_NAME), ffactory.or(pseudoConjVars));
			// Iff the parent is set to "active", one of the children must be set to active
			Constraint atMostOneConstraint = TraVarTUtils.buildConstraintFromFormula(atMostOne);
			Constraint exactlyOneConstraint = TraVarTUtils.buildConstraintFromFormula(exactlyOne);			
			return List.of(atMostOneConstraint, exactlyOneConstraint);
		}
		case KconfigIfNode ifb -> {
			// For if blocks, add iff constraint with the expression of the if block
			return List.of(
					factory.createEquivalenceConstraint(factory.createLiteralConstraint(respFeature.getFeatureName()),
							TraVarTUtils.buildConstraintFromFormula(ifb.getCondition())));
		}
		default -> {
			throw new UnsupportedOperationException("Cannot process choice block: Unknown type");
		}
		}
	}

	/**
	 * Convert given config symbol (represented by a KConfigNode object) to a
	 * feature (or multiple features). The transformation is applied based on the
	 * type of the config symbol.
	 * 
	 * @param node    the KConfigNode instance to process, represents a config
	 *                symbol
	 * @param factory factory instance to use during the transformation
	 * @return
	 */
	static private void processNode(KconfigNode node, FeatureModel root) {
		CoreModelFactory factory = CoreModelFactory.getInstance();
		if (TraVarTUtils.getFeature(root, node.getName()) != null) {
			// This node was already processed (probably enclosing choice block)
			return;
		}
		Feature feature = factory.createFeature(node.getName());
		GroupType gt;
		if (node.isOptional()) {
			gt = GroupType.OPTIONAL;
		} else {
			gt = GroupType.MANDATORY;
		}
		if (!TraVarTUtils.hasRoot(root))
			return;
		// Rule 1: A boolean config symbol corresponds to a feature (A eqv. A)
		// Special cases for menus and tristate symbols
		if (node instanceof KconfigMenuNode || node instanceof KconfigBooleanChoice) {
			// No ambiguity here: Abstract feature with optional group -> menu
			TraVarTUtils.setAbstract(feature, true);
		} else if (node instanceof KconfigTristateNode) {
			// For tristate symbols, add additional attribute to represent ´t´ state
			// Additional attribute for tristate choice blocks are added in post-processing
			TraVarTUtils.addAttribute(feature, TRISTATE_ATTRIBUTE_NAME, false);
		}
		if (node.getEnclosingNode() == null) {
			// If there is no enclosing node, make new feature direct child of root
			TraVarTUtils.addToGroup(root, feature, root.getRootFeature(), gt, 0);
			// TODO Allow multiple groups of the same type (make method UVL-conform)
		} else {
			switch (node.getEnclosingNode()) {
			case KconfigBooleanChoice choice -> {
				gt = GroupType.ALTERNATIVE;
			}
			case KconfigTristateChoice choice -> {
				gt = GroupType.OR;
			}
			default -> {
			}
			}
			Feature immediateParent;
			while (true) {
				immediateParent = TraVarTUtils.getFeature(root, node.getEnclosingNode().getName());
				if (immediateParent == null) {
					processNode(node.getEnclosingNode(), root);
				} else {
					break;
				}
			}
			TraVarTUtils.addToGroup(root, feature, immediateParent, gt, 0);
			return;
		}
	}

	/**
	 * Process a dependency between the config symbols `source` and `target`.
	 * This method only processes one-to-one dependencies, dependencies with composite target expression should be handled in processGraph.
	 * 
	 * This method manipulates the structure of the feature model `fm`.
	 * Some dependencies cannot be transformed merely through
	 * structural changes. If cross-tree constraints are required to transform a
	 * dependency, this method will output cross-tree constraints (possibly multiple
	 * of them, hence the Collection output). These Constraint instances should be added to
	 * the respective ConstraintsType instance by the caller.
	 * 
	 * @param source  The left-hand side of the dependency (depender)
	 * @param target  The right-hand side of the dependency (dependee)
	 * @param fm      Underlying feature model
	 * @return List containing Constraint instances representing cross-tree
	 *         constraints to be added to the respective feature model
	 */
	static private Collection<Constraint> processRule(KconfigNode source, KconfigNode target, FeatureModel fm) {
		CoreModelFactory factory = CoreModelFactory.getInstance();
		Feature sourceFeature = TraVarTUtils.getFeature(fm, source.getName());
		Feature targetFeature = TraVarTUtils.getFeature(fm, target.getName());
		if (source instanceof KconfigTristateNode || source instanceof KconfigTristateChoice) {
			// TODO Do not ignore menuconfig nodes
			if (target instanceof KconfigBooleanNode || target instanceof KconfigBooleanChoice) {
				// Boolean configuration symbols do not affect the "active" attribute, process dependency as if it's a boolean-to-boolean dependency
				if (source.getEnclosingNode() != null || !sourceFeature.getParentFeature().equals(fm.getRootFeature())
						|| target instanceof KconfigBooleanChoice) {
					// Source node enclosed, no structural changes
					// Additionally, avoid structural processing of dependencies on choice blocks
					Constraint dependencyRuleExpression = factory.createImplicationConstraint(
							factory.createLiteralConstraint(sourceFeature.getFeatureName()),
							factory.createLiteralConstraint(targetFeature.getFeatureName()));
					return List.of(dependencyRuleExpression);
				}
				TraVarTUtils.setGroup(fm, sourceFeature, targetFeature, GroupType.MANDATORY);
				// Emit no cross-tree constraints
				return List.of();
			} else if (target instanceof KconfigTristateNode || target instanceof KconfigTristateChoice) {
				// Add two implications, one for "active" attribute, one for the feature selection
				Constraint tConstraint = factory.createImplicationConstraint(
						factory.createLiteralConstraint(sourceFeature.getFeatureName() + "." + TRISTATE_ATTRIBUTE_NAME),
						factory.createLiteralConstraint(
								targetFeature.getFeatureName() + "." + TRISTATE_ATTRIBUTE_NAME));
				Constraint sConstraint = factory.createImplicationConstraint(
						factory.createLiteralConstraint(sourceFeature.getFeatureName()),
						factory.createLiteralConstraint(targetFeature.getFeatureName()));
				return List.of(tConstraint, sConstraint);
			} else if (target instanceof KconfigMenuNode) {
				// Menus cannot occur as dependency targets
				throw new UnsupportedOperationException(
						"Cannot process constaint: Constaint has menu node on right-hand side");
			} else {
				throw new UnsupportedOperationException(
						"Cannot process constraint: Unknown node type (right-hand side).");
			}
		} else if (source instanceof KconfigBooleanNode || source instanceof KconfigBooleanChoice
				|| source instanceof KconfigMenuNode) {
			if (target instanceof KconfigBooleanNode) { // TODO Do not ignore menuconfig nodes
				if (source.getEnclosingNode() == null || sourceFeature.getParentFeature().equals(fm.getRootFeature())) {
					TraVarTUtils.setGroup(fm, sourceFeature, targetFeature, GroupType.MANDATORY);
					// Emit no cross-tree constraints
					return List.of();
				}
				// FIXME Fall though if there is an enclosing node (avoid code duplication)
				Constraint dependencyRuleExpression = factory.createImplicationConstraint(
						factory.createLiteralConstraint(sourceFeature.getFeatureName()),
						factory.createLiteralConstraint(targetFeature.getFeatureName()));
				return List.of(dependencyRuleExpression);
			} else if (target instanceof KconfigChoice || target instanceof KconfigTristateNode || target instanceof KconfigTristateChoice) {
				Constraint dependencyRuleExpression = factory.createImplicationConstraint(
						factory.createLiteralConstraint(sourceFeature.getFeatureName()),
						factory.createLiteralConstraint(targetFeature.getFeatureName()));
				return List.of(dependencyRuleExpression);
			} else if (target instanceof KconfigMenuNode) {
				// Menus cannot occur as dependency targets
				throw new UnsupportedOperationException(
						"Cannot process constaint: Constaint has menu node on right-hand side");
			} else {
				throw new UnsupportedOperationException(
						"Cannot process constraint: Unknown node type (right-hand side).");
			}
		} else {
			throw new UnsupportedOperationException("Cannot process constraint: Unknown node type (left-hand side).");
		}
		//return null;
	}

	public static IKconfigModel processToGraph(FeatureModel model) {
		FormulaFactory f = new FormulaFactory();
		Feature root = model.getRootFeature();
		KconfigModel kmodel = new KconfigModel(
				(String) TraVarTUtils.getAttributeValue(root, "factoryId"),
				(String) TraVarTUtils.getAttributeValue(root, "name"));
		kmodel.setSourceFile((String) TraVarTUtils.getAttributeValue(root, "sourceFile"));
		processFeature(root, null, kmodel.getInnerGraph());
		// Finalize model
		kmodel.getInnerGraph().nodes().values().forEach(e -> e.close());
		for (ImplicationConstraint ccc : TraVarTUtils.getOwnConstraints(model).stream()
				.filter(ImplicationConstraint.class::isInstance).map(ImplicationConstraint.class::cast)
				.collect(Collectors.toList())) {
			// By filtering non-implications, we also ignore the constraints that added by, e.g., tristate choices
			Formula sourceExp = TraVarTUtils.buildFormulaFromConstraint(ccc.getLeft(), f);
			Formula targetExp = TraVarTUtils.buildFormulaFromConstraint(ccc.getRight(), f);
			var sourceNodes = TreeProcessor.extractNodes(sourceExp, kmodel.getInnerGraph());
			if (sourceNodes.isEmpty()) continue; // Probably an implication with attributes, ignore it
			if (sourceNodes.size() > 1) throw new IllegalStateException("While processing dependencies: Dependency contains illegal source expression!");
			// Is the currently processed implication marked as a select dependency? Compare attributes
			int selectMarker = (int) ObjectUtils.defaultIfNull(TraVarTUtils.getAttributeValue(TraVarTUtils.getFeature(model, sourceNodes.getFirst().getName()), SELECT_MARKER), -99);
			kmodel.getInnerGraph().dependencies().put(sourceNodes.getFirst(), MutablePair.of(targetExp, selectMarker == model.getOwnConstraints().indexOf(ccc)));
		}
		return kmodel;
	}

	// TODO Support feature models with multi-group features
	private static KconfigNode processFeature(Feature current, KconfigMenuNode enclosing, KconfigGraph graph) {
		FormulaFactory f = new FormulaFactory();
		KconfigNode node = null;
		if (current.getFeatureName() == ROOT_NODE_NAME) {
			for (Feature feat : TraVarTUtils.getGroup(current, GroupType.OPTIONAL, 0).getFeatures()) {
				processFeature(feat, null, graph);
			}
			return null;
		}
		if (TraVarTUtils.hasGroup(current, GroupType.ALTERNATIVE)) {
			// Has to be a boolean choice
			node = new KconfigBooleanChoice(current.getFeatureName(), enclosing);
			for (Feature feat : TraVarTUtils.getGroup(current, GroupType.ALTERNATIVE, 0).getFeatures()) {
				((KconfigBooleanChoice) node).contents.add((KconfigBooleanNode) processFeature(feat, (KconfigBooleanChoice) node, graph));
			}
		} else if (TraVarTUtils.hasGroup(current, GroupType.OR)) {
			// Has to be a tristate choice
			node = new KconfigTristateChoice(current.getFeatureName(), enclosing);
			for (Feature feat : TraVarTUtils.getGroup(current, GroupType.OR, 0).getFeatures()) {
				// FIXME With this business logic, OR groups may not contain children that have children in alt groups!
				((KconfigTristateChoice) node).contents.add((KconfigTristateNode) processFeature(feat, (KconfigTristateChoice) node, graph));
			}
		} else if (TraVarTUtils.hasGroup(current, GroupType.OPTIONAL)) {
			if (TraVarTUtils.isAbstract(current)) {
				node = new KconfigMenuNode(current.getFeatureName(), enclosing);
			} else {
				node = new KconfigBooleanNode(current.getFeatureName(), enclosing);
			}
			for (Feature feat : TraVarTUtils.getGroup(current, GroupType.OPTIONAL, 0).getFeatures()) {
				// Add B -> A forward dependency for each group member
				KconfigNode child;
				if (TraVarTUtils.isAbstract(current)) {
					// FIXME Very type-unsafe!
					child = processFeature(feat, (KconfigMenuNode) node, graph);
					((KconfigMenuNode) node).contents.add(child);
				} else {
					child = processFeature(feat, enclosing, graph);
					graph.dependencies().put(child, MutablePair.of(f.variable(node.getName()), false));
				}				
			}
		} else if (TraVarTUtils.hasGroup(current, GroupType.MANDATORY)) {
			if (TraVarTUtils.containsAttribute(current, TRISTATE_ATTRIBUTE_NAME)) {
				node = new KconfigTristateChoice(current.getFeatureName(), enclosing);
			} else {
				node = new KconfigBooleanNode(current.getFeatureName(), enclosing);
			}
			for (Feature feat : TraVarTUtils.getGroup(current, GroupType.MANDATORY, 0).getFeatures()) {
				// Add B -> A forward dependency for each group member
				graph.dependencies().put(processFeature(feat, enclosing, graph), MutablePair.of(f.variable(node.getName()), false));
			}
		} else {
			// Current feature has no children!
			if (TraVarTUtils.containsAttribute(current, TRISTATE_ATTRIBUTE_NAME)) {
				node = new KconfigTristateNode(current.getFeatureName(), enclosing);
			} else {
				node = new KconfigBooleanNode(current.getFeatureName(), enclosing);
			}
		}
		// The if block above should initialize `node` in all cases
		// If `current` was root, this code isn't reachable
		assert Objects.nonNull(node);
		graph.nodes().put(current.getFeatureName(), node);
		return node;
	}
}
