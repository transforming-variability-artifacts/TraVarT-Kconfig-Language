/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Kaan Berk Yaman
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;

import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.tuple.MutablePair;

import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.formulas.Variable;
import org.logicng.io.parsers.ParserException;

import de.kit.kastel.travart.kconfig.model.*;
import de.kit.kastel.travart.kconfig.model.nodes.*;
import de.kit.kastel.travart.kconfig.model.nodes.choice.*;
import de.kit.kastel.travart.kconfig.model.nodes.menu.*;
import de.kit.kastel.travart.kconfig.model.nodes.value.*;

// TODO: Refactor into KconfigPostProcessor
public class TreeProcessor {
	
	public TreeProcessor(TokenStream tokens) {
		this.underlyingTokenStream = tokens;
	}

	private final TokenStream underlyingTokenStream;
	
	private final KconfigGraph graph = new KconfigGraph(new HashMap<String, KconfigNode>(),
			new ArrayListValuedHashMap<KconfigNode, MutablePair<Formula, Boolean>>());

	public KconfigGraph getGraph() {
		/*
		 * if (graph.nodes().values().stream().anyMatch(e -> e.getType() ==
		 * KconfigNodeType.UNKNOWN)) { throw new
		 * IllegalStateException("Kconfig file incomplete: Undefined nodes appear in generated graph!"
		 * ); }
		 */
		return graph;
	}

	public void processAST(CommonTree ast, KconfigMenuNode enclosingNode, boolean immediateEnclosure) {
		if (null == ast.getParent()) {
			// This is the root of our parse tree. Traverse through the children
			for (Object child : ast.getChildren()) {
				assert !immediateEnclosure;
				processAST((CommonTree) child, null, false);
			}
			// Close all nodes once we are done traversing
			graph.nodes().values().forEach((e) -> e.close());
			// Sort dependencies according to heuristic (see rule 1)
			sortDependencies();
			return;
		}
		switch (ast.getType()) {
		case LKCParser.CONFIG, LKCParser.MENUCONFIG:
			// "config" rule: Plain config symbol
			processConfigSymbol(ast, enclosingNode, immediateEnclosure);
			break;
		case LKCParser.CHOICE:
			processChoice(ast, enclosingNode, immediateEnclosure);
			break;
		case LKCParser.MENU:
			processMenu(ast, enclosingNode, immediateEnclosure);
			break;
		}
	}

	private void sortDependencies() {
		for (KconfigNode currentNode : graph.nodes().values()) {
//			graph.dependencies().get(currentNode).sort(Comparator.comparingInt(cs -> calculateNodeDepth(cs.getLeft())));
		}
	}

	private int calculateNodeDepth(KconfigNode node) {
		return calculateNodeDepth(node, List.of());
	}

	private int calculateNodeDepth(KconfigNode node, List<KconfigNode> alreadyVisited) {
		// FIXME Cycle detection broken with new dependency structure (pair mapping with true/false)
		// Need to differ between reverse and forward dependencies
		int minimumParentDepth = 0;
		for (Formula depExp : graph.dependencies().get(node).stream().map(e -> e.getLeft()).toList()) {
			List<KconfigNode> dependees = extractNodes(depExp, graph);
			if (!Collections.disjoint(alreadyVisited, dependees))
				throw new IllegalStateException("Graph contains cyclic dependencies! Transformation halted.");
			int maxParentDepth = dependees.stream()
					.mapToInt(e -> calculateNodeDepth(e, ListUtils.union(alreadyVisited, List.of(node)))).max()
					.getAsInt();
			if (minimumParentDepth == 0 || maxParentDepth < minimumParentDepth)
				minimumParentDepth = maxParentDepth;
		}
		// TODO Re-implement handling of menuconfig symbols after model rewrite
		return 1 + minimumParentDepth;
		// Manipulate depth value to favour dependency paths with menuconfig symbols
	}

	static public List<KconfigNode> extractNodes(Formula exp, KconfigGraph graph) {
		List<KconfigNode> corrNodes = new ArrayList<>();
		for (Variable var : exp.variables()) {
			corrNodes.add(graph.nodes().get(var.toString()));
		}
		CollectionUtils.filter(corrNodes, PredicateUtils.notNullPredicate());
		return corrNodes;
	}

	private void processMenu(CommonTree ast, KconfigMenuNode enclosingNode, boolean immediateEnclosure) {
		// Handling of placeholders shouldn't be necessary for menu blocks
		String nodeName = ast.getChild(0).getText();
		KconfigMenuNode cs;
		cs = new KconfigMenuNode(nodeName, enclosingNode);
		for (Object child : ast.getChildren()) {
			CommonTree option = (CommonTree) child;
			switch (option.getType()) {
			case LKCParser.DEPENDS:
				processDependency(cs, option, false);
				break;
			case LKCParser.BLOCK:
				for (Object subtrees : option.getChildren()) {
					processAST((CommonTree) subtrees, cs, true);
				}
				break;
			}
		}
		if (immediateEnclosure) enclosingNode.contents.add(cs);
		graph.nodes().put(nodeName, cs);
	}

	private void processChoice(CommonTree ast, KconfigMenuNode enclosingNode, boolean immediateEnclosure) {
		String nodeName = ast.getChild(0).getText();
		KconfigMenuNode cs = null;
		// Because we know that we are parsing a choice block, we can explicitly type cs
		// as KconfigMenuNode
		KconfigUnknownNode placeholder;
		placeholder = (KconfigUnknownNode) graph.nodes().get(nodeName);
		for (Object child : ast.getChildren()) {
			/*
			 * We have to iterate over Objects because the CommonTree class does not have a
			 * method that returns a list of its children as CommonTree instances.
			 */
			CommonTree option = (CommonTree) child;
			/*
			 * Instead of using magic strings, we retrieve token values off the static
			 * fields of the generated Parser class.
			 */
			switch (option.getType()) {
			case LKCParser.DEPENDS:
				processDependency(cs, option, false);
				break;
			case LKCParser.SELECT:
				processDependency(cs, option, true);
				break;
			case LKCParser.T__50:
			case LKCParser.T__51:
				// "bool" is an alias for "boolean" (nevertheless valid syntax)
				cs = new KconfigBooleanChoice(nodeName, enclosingNode);
				break;
			case LKCParser.T__54:
				cs = new KconfigTristateChoice(nodeName, enclosingNode);
				break;
			case LKCParser.CONFIG:
				processConfigSymbol(option, cs, true);
				break;
			case LKCParser.OPTIONAL:
				if (!cs.isOptional())
					cs.toggleOptional();
			}
		}
		if (!Objects.isNull(placeholder))
			redirectDependencies(placeholder, cs);
		if (immediateEnclosure) enclosingNode.contents.add(cs);
		graph.nodes().put(nodeName, cs);
	}

	private void processConfigSymbol(CommonTree ast, KconfigMenuNode enclosingNode, boolean immediateEnclosure) {
		/*
		 * We build the config symbol "on-line": The initial stub is created upon
		 * calling this method, the node type and the concrete name of the node is
		 * initialized once the respective options are processed in the following `for`
		 * loop.
		 */
		String nodeName = ast.getChild(0).getText();
		KconfigNode cs = null;
		KconfigUnknownNode placeholder;
		placeholder = (KconfigUnknownNode) graph.nodes().get(nodeName);
		for (Object child : ast.getChildren()) {
			/*
			 * We have to iterate over Objects because the CommonTree class does not have a
			 * method that returns a list of its children as CommonTree instances.
			 */
			CommonTree option = (CommonTree) child;
			/*
			 * Instead of using magic strings, we retrieve token values off the static
			 * fields of the generated Parser class.
			 */
			switch (option.getType()) {
			case LKCParser.DEPENDS:
				processDependency(cs, option, false);
				break;
			case LKCParser.SELECT:
				processDependency(cs, option, true);
				break;
			case LKCParser.T__50:
			case LKCParser.T__51:
				// "bool" is an alias for "boolean" (nevertheless valid syntax)
				cs = new KconfigBooleanNode(nodeName, enclosingNode);
				break;
			case LKCParser.T__54:
				cs = new KconfigTristateNode(nodeName, enclosingNode);
				break;
			}
		}
		if (!Objects.isNull(placeholder))
			redirectDependencies(placeholder, cs);
		if (immediateEnclosure) enclosingNode.contents.add(cs);
		graph.nodes().put(nodeName, cs);
	}

	/***
	 * Process the given dependency option within a config symbol definition.
	 * 
	 * @param cs                The source node of the dependency, i.e. the
	 *                          depender.
	 * @param option            The subtree containing the dependency option to be
	 *                          processed. This should correspond to the name of the
	 *                          target node of the dependency, i.e. the dependee.
	 * @param reverseDependency If set to true, the dependency is reversed; use this
	 *                          to process the `select` option in configuration
	 *                          symbols.
	 */
	private void processDependency(KconfigNode cs, CommonTree option, boolean reverseDependency) {
		FormulaFactory f = new FormulaFactory();
		var targetExpression = option.getChild(0);
		int a = targetExpression.getTokenStartIndex();
		int b = targetExpression.getTokenStopIndex();
		var targetExpressionContent = underlyingTokenStream.toString(a, b);
		Formula parsedTarget = null;
		try {
			parsedTarget = f.parse(targetExpressionContent);
		} catch (ParserException e) {
			e.printStackTrace();
			throw new IllegalStateException("Invalid dependency expression in syntax tree!");
		}
		// var targetName = option.getChild(0).getText();
		// Check if the target node is already present
		for (Variable nodeVar : parsedTarget.variables()) {
			if (graph.nodes().get(nodeVar.name()) == null) {
				// Target node was not processed yet, create placeholder node with unknown type
				var targetNode = new KconfigUnknownNode(nodeVar.name());
				graph.nodes().put(nodeVar.name(), targetNode);
			}
		}
		graph.dependencies().put(cs, MutablePair.of(parsedTarget, reverseDependency));
	}

	private void redirectDependencies(KconfigUnknownNode former, KconfigNode target) {
		// Redirecting of the dependencies themselves is not required, as we use formulas
		graph.nodes().replace(target.getName(), target);
	}

}
