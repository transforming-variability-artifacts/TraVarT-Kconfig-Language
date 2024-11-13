package de.kit.kastel.travart.kconfig.transformation.oneway;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.MutablePair;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Variable;

import at.jku.cps.travart.core.helpers.TraVarTUtils;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.model.KconfigGraph;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.model.KconfigNode;
import de.kit.kastel.travart.kconfig.model.nodes.choice.KconfigBooleanChoice;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;
import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigBooleanNode;
import de.kit.kastel.travart.kconfig.parser.TreeProcessor;
import de.vill.model.Feature;
import de.vill.model.FeatureModel;
import de.vill.model.Group.GroupType;
import de.vill.model.constraint.ImplicationConstraint;

// TODO Break up individual transformation rules and move to TransformKCtoFMUtil
public class KconfigModelOneWayGraphTransformer {

	// FIXME Should probably not be static
	static final private Map<Variable, Formula> NODE_EXP_SUB_MAP = new HashMap<>();

	/***
	 * This method is unused, for the one-way Kconfig transformation, we utilize the
	 * partial two-way transformation in KconfigTwoWayGraphTransformer.
	 * 
	 * TODO Clean up code
	 */
	// Build a feature model using the data contained in a finalised TreeProcessor
	static public FeatureModel processGraph(KconfigGraph graph) {
		throw new UnsupportedOperationException("Dummy method, use partial two-way transformation instead!");
	}

	public static IKconfigModel processToGraph(FeatureModel model) {
		// Flush submap
		NODE_EXP_SUB_MAP.clear();
		FormulaFactory f = new FormulaFactory();
		Feature root = model.getRootFeature();
		KconfigModel kmodel = new KconfigModel("0", root.getFeatureName());
		processFeature(root, null, kmodel.getInnerGraph());
		// Attempt best-effort transformation for feature model constraints
		for (ImplicationConstraint ccc : TraVarTUtils.getOwnConstraints(model).stream()
				.filter(ImplicationConstraint.class::isInstance).map(ImplicationConstraint.class::cast)
				.collect(Collectors.toList())) {
			Formula lhs = TraVarTUtils.buildFormulaFromConstraint(ccc.getLeft(), f);
			Formula rhs = TraVarTUtils.buildFormulaFromConstraint(ccc.getRight(), f);
			var sourceNode = TreeProcessor.extractNodes(lhs, kmodel.getInnerGraph()).getFirst();
			// Map to equivalent dependency if the constraint's lhs is an atomic formula (i.e. node-respective variable)
			if (lhs.isAtomicFormula()) {
				kmodel.addDependency(sourceNode, rhs, false);
			}
		}
		// Substitute dependency expressions according to submap
		for (Map.Entry<KconfigNode, Collection<MutablePair<Formula, Boolean>>> deps : kmodel.getDependencies()
				.entrySet()) {
			for (MutablePair<Formula, Boolean> exp : deps.getValue()) {
				Formula subExp = exp.getLeft();
				for (Map.Entry<Variable, Formula> substitution : NODE_EXP_SUB_MAP.entrySet()) {
					if (substitution.getValue().containsVariable(deps.getKey().getName())) continue;
					// Not very robust, but seems to work... for now
					// In general, avoid substituting if the source node occurs on the rhs of the substitution tuple
					subExp = subExp.substitute(substitution.getKey(), substitution.getValue());
				}
				exp.setLeft(subExp);
			}
		}
		for (KconfigNode node : kmodel.getNodes()) {
			node.close();
		}
		return kmodel;
	}

	// TODO Support feature models with multi-group features
	private static KconfigNode processFeature(Feature current, KconfigMenuNode enclosing, KconfigGraph graph) {
		FormulaFactory f = new FormulaFactory();
		KconfigBooleanNode initial = new KconfigBooleanNode(current.getFeatureName(), enclosing);
		if (TraVarTUtils.hasGroup(current, GroupType.ALTERNATIVE)) {
			// Avoid tristate config symbols, use boolean choice block for alt groups
			KconfigBooleanChoice node = new KconfigBooleanChoice("ALT_" + current.getFeatureName(), enclosing);
			graph.nodes().put(node.getName(), node);
			graph.dependencies().put(node, MutablePair.of(f.variable(initial.getName()), false));
			for (Feature feat : TraVarTUtils.getGroup(current, GroupType.ALTERNATIVE, 0).getFeatures()) {
				node.contents.add((KconfigBooleanNode) processFeature(feat, node, graph));
			}
			graph.nodes().put(current.getFeatureName(), initial);
			return initial;
		} else if (TraVarTUtils.hasGroup(current, GroupType.OR)) {
			// FIXME Unclear how node enclosures are defined for the group-specific choice blocks
			KconfigBooleanChoice node = new KconfigBooleanChoice("CH_" + current.getFeatureName(), null);
			graph.nodes().put(node.getName(), node);
			// FIXME Use NODE_EXP_SUB_MAP instead of defaulting to `initial`
			graph.dependencies().put(node, MutablePair.of(f.variable(initial.getName()), false));
			// FIXME nodeOptions should be a menuconfig node
			KconfigBooleanNode nodeOptions = new KconfigBooleanNode("CH_" + current.getFeatureName() + "_OPT", null);
			graph.nodes().put(nodeOptions.getName(), nodeOptions);
			// Abstract parent for nth selections depend on `false`, only visible after a 1st choice is met!
			graph.dependencies().put(nodeOptions, MutablePair.of(f.falsum(), false));
			// Create a boolean config symbol for each feature contained in the OR group
			for (Feature feature : TraVarTUtils.getGroup(current, GroupType.OR, 0).getFeatures()) {
				KconfigBooleanNode firstChoice = (KconfigBooleanNode) processFeature(feature, node, graph);
				node.contents.add(firstChoice);
				// After a first choice was met, make the parent node for nth selections visible
				graph.dependencies().put(firstChoice, MutablePair.of(f.variable(nodeOptions.getName()), true));
				KconfigBooleanNode optNode = new KconfigBooleanNode("OPT_" + feature.getFeatureName(), null);
				graph.nodes().put(optNode.getName(), optNode);
				graph.dependencies().put(optNode, MutablePair.of(f.not(f.variable(firstChoice.getName())), false));
				graph.dependencies().put(optNode, MutablePair.of(f.variable(nodeOptions.getName()), false));
				// For each processed feature, add a formula mapping entry
				NODE_EXP_SUB_MAP.put(f.variable(feature.getFeatureName()),
						f.or(List.of(f.variable(firstChoice.getName()), f.variable(optNode.getName()))));
			}
			graph.nodes().put(current.getFeatureName(), initial);
			return initial;
		} else if (TraVarTUtils.hasGroup(current, GroupType.OPTIONAL)) {
			for (Feature feature : TraVarTUtils.getGroup(current, GroupType.MANDATORY, 0).getFeatures()) {
				KconfigNode child = processFeature(feature, enclosing, graph);
				// Add B -> A forward dependency for each group member
				graph.dependencies().put(child, MutablePair.of(f.variable(initial.getName()), false));
			}
			graph.nodes().put(current.getFeatureName(), initial);
			return initial;
		} else if (TraVarTUtils.hasGroup(current, GroupType.MANDATORY)) {
			for (Feature feature : TraVarTUtils.getGroup(current, GroupType.MANDATORY, 0).getFeatures()) {
				KconfigNode child = processFeature(feature, enclosing, graph);
				// Add B <- A reverse dependency for each group member
				graph.dependencies().put(initial, MutablePair.of(f.variable(child.getName()), true));
				// Mandatory nodes visible only when selected through parent
				graph.dependencies().put(child, MutablePair.of(f.falsum(), false));
				// FIXME Does `select` recursively enable an entire chain of mandatory features?
			}
			graph.nodes().put(current.getFeatureName(), initial);
			return initial;
		} else {
			// Current feature has no children! Just return initial node (boolean)
			graph.nodes().put(current.getFeatureName(), initial);
			return initial;
		}
	}
}
