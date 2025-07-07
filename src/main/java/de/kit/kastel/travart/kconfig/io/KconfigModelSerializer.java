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
package de.kit.kastel.travart.kconfig.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.logicng.formulas.Formula;

import at.jku.cps.travart.core.common.Format;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.*;
import de.kit.kastel.travart.kconfig.model.nodes.choice.KconfigBooleanChoice;
import de.kit.kastel.travart.kconfig.model.nodes.choice.KconfigChoice;
import de.kit.kastel.travart.kconfig.model.nodes.choice.KconfigTristateChoice;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigIfNode;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuconfigNode;
import de.kit.kastel.travart.kconfig.model.nodes.value.*;
import de.kit.kastel.travart.kconfig.parser.TreeProcessor;

public class KconfigModelSerializer implements ISerializer<KconfigModel> {
	
	
	private final static Logger LOGGER = LogManager.getLogger();

	/**
	 * WIP
	 */
	public void serialize(final KconfigModel km, StringBuilder writer, KconfigNode node, int tabulation) throws NotSupportedVariabilityTypeException {
			if (node instanceof KconfigMenuNode) {
				switch (node) {
				case KconfigBooleanChoice bc:
					writer.append("\t".repeat(tabulation) + "choice " + node.getName() + "\n");					
					writer.append("\t".repeat(tabulation+1) + "bool\n");
					for (KconfigNode child : getDefinitionOrder(bc.getSubgraph(km))) {
						LOGGER.info("Calculated subgraph for " + bc.getName() + ", now serializing " + child.getName() + " from subgraph!");
						serialize(km, writer, child, tabulation+1);
					}
					writer.append("\t".repeat(tabulation) + "endchoice\n\n");
					break;
				case KconfigTristateChoice tc:
					writer.append("\t".repeat(tabulation) + "choice " + node.getName() + "\n");
					writer.append("\t".repeat(tabulation+1) + "tristate\n");
					for (KconfigNode child : getDefinitionOrder(tc.getSubgraph(km))) {
						LOGGER.info("Calculated subgraph for " + tc.getName() + ", now serializing " + child.getName() + " from subgraph!");
						serialize(km, writer, child, tabulation+1);
					}
					writer.append("\t".repeat(tabulation) + "endchoice\n\n");
					break;
				case KconfigIfNode cond:
					writer.append("\t".repeat(tabulation) + "if " + detoxDependencyExpression(cond.getCondition().toString()) + "\n");
					for (KconfigNode child : getDefinitionOrder(cond.getSubgraph(km))) {
						LOGGER.info("Calculated subgraph for " + cond.getName() + ", now serializing " + child.getName() + " from subgraph!");
						serialize(km, writer, child, tabulation+1);
					}
					writer.append("\t".repeat(tabulation) + "endif\n\n");
					break;
				case KconfigMenuconfigNode mc:
					writer.append("menuconfig " + node.getName() + "\n");
					break;
				default:
					throw new IllegalStateException("Cannot write invalid Kconfig model!");
				}
			} else if (node instanceof KconfigValueNode) {
				// TODO Ensure that the order in which config symbols occur is valid
				writer.append("\t".repeat(tabulation) + "config " + node.getName() + "\n");
				switch (node) {
				case KconfigBooleanNode b:
					writer.append("\t".repeat(tabulation+1) + "bool\n");
					processDependencies(km, b, writer, tabulation+1);
					break;
				case KconfigIntNode i:
					writer.append("\t".repeat(tabulation+1) + "int\n");
					processDependencies(km, i, writer, tabulation+1);
					break;
				case KconfigTristateNode t:
					writer.append("\t".repeat(tabulation+1) + "tristate\n");
					processDependencies(km, t, writer, tabulation+1);
					break;
				case KconfigStringNode s:
					writer.append("\t".repeat(tabulation+1) + "string\n");
					processDependencies(km, s, writer, tabulation+1);
					break;
				default:
					throw new IllegalStateException("Cannot write invalid Kconfig model!");
				}				
			}
			writer.append('\n');
		}
	

		private void processDependencies(final KconfigModel km, KconfigNode node, StringBuilder writer, int tabulation) {
			if (km.getDependencies().keySet().contains(node)) {
				for (MutablePair<Formula, Boolean> dep : km.getDependencies().get(node)) {
					if (dep.right) {
						writer.append("\t".repeat(tabulation) + "select " + detoxDependencyExpression(dep.left.toString()) + "\n");
					} else {
						writer.append("\t".repeat(tabulation) + "depends on " + detoxDependencyExpression(dep.left.toString()) + "\n");
					}
				}
				writer.append("\n");
			}
		}

	private String detoxDependencyExpression(String dependencyExpression) {
		// TODO Find all discrepancies between LogicNG and Kconfig expression syntax
		return dependencyExpression.replace('~', '!').replace("$", "");

	}

	private List<KconfigNode> getDefinitionOrderWithoutChildren(KconfigGraph graph) {
		LOGGER.info("Called getDefinitionOrderWithoutChildren (will ignore children!)");
		List<KconfigNode> order = new ArrayList<KconfigNode>();
		// Start with random node
		for (KconfigNode node : graph.nodes().values()) {
			LOGGER.debug("Currently " + order.size() + " node(s) in order!");
			// If already processed, skip
			if (order.contains(node))
				continue;
			// Ignore children nodes, these are aggregated when the parent node is being processed
			if (node.getEnclosingNode() != null)
				continue;
			if (order.size() > graph.nodes().size()) {
				throw new IllegalStateException("Order contains more nodes than there are nodes in the KconfigGraph instance! Stuck in loop?");
			}
			order = calculateDefinitionOrder(graph, node, order, new ArrayList<KconfigNode>());
		}
		return order;
	}
	
	private List<KconfigNode> getDefinitionOrder(KconfigGraph graph) {
		LOGGER.info("Called getDefinitionOrder (will not ignore children!)");
		List<KconfigNode> order = new ArrayList<KconfigNode>();
		// Start with random node
		for (KconfigNode node : graph.nodes().values()) {
			// If already processed, skip
			if (order.contains(node))
				continue;
			// Ignore children nodes, these are aggregated when the parent node is being processed
			order = calculateDefinitionOrder(graph, node, order, new ArrayList<KconfigNode>());
		}
		return order;
	}

	@SuppressWarnings("unchecked")
	private List<KconfigNode> calculateDefinitionOrder(KconfigGraph graph, KconfigNode current, List<KconfigNode> order,
			Collection<KconfigNode> visited) {
		if (current.getEnclosingNode() != null)
			LOGGER.debug("Current node (" + current.getName() + ") has enclosing node, is this expected?");		
		var newOrder = order;
		if (visited.contains(current)) {
			LOGGER.warn("Does graph contain cascading choice blocks? Serializer cannot handle those very well...");
			throw new IllegalStateException("Dependency loop? Already visited this node = " + current.getName());
		}
		// Are there any nodes that these nodes depend on that we need to process?
		Stream<MutablePair<Formula, Boolean>> containedDependencies = Stream.empty();
		if (current instanceof KconfigMenuNode) {
			containedDependencies = ((KconfigMenuNode) current).getContents().stream().flatMap((e) -> graph.dependencies().get((KconfigNode) e).stream());
			LOGGER.debug("Node has children, also considering children's dependencies!");
		}
		List<KconfigNode> dependees = Stream.concat(graph.dependencies().get(current).stream(), containedDependencies)
				.flatMap(e -> TreeProcessor.extractNodes(e.left, graph).stream()).collect(Collectors.toList());
		dependees.replaceAll(e -> {
			KconfigNode replacement = e;
			while (replacement.getEnclosingNode() != null 
					&& graph.nodes().containsValue(replacement.getEnclosingNode())) {
				LOGGER.debug("Replacing " + replacement.getName() + " with enclosing " + replacement.getEnclosingNode().getName() + "!");  
				replacement = replacement.getEnclosingNode();
			}
			return replacement;
		});
		visited.add(current);
		dependees = dependees.stream().distinct().toList(); // Cull duplicates!
		for (KconfigNode dependee : dependees) {
			if (order.contains(dependee))
				continue;
			if (dependee == current) {
				continue;
			}
			// FIXME Do we need to clone `order` every time we recurse?
			LOGGER.debug("Recursing deeper to " + dependee.getName() + ", already visited: " + visited);
			order = calculateDefinitionOrder(graph, dependee, order, visited);
			LOGGER.debug("Updated/calculated new suborder: " + order);
		}
		// After dependees and containing nodes are processed, add current node
		newOrder.add(current);
		// Return final order
		return newOrder;
	}

	@Override
	public Format getFormat() {
		return KconfigFormat.getInstance();
	}


	@Override
	public String serialize(KconfigModel model) throws NotSupportedVariabilityTypeException {
		StringBuilder builder = new StringBuilder();
		for (KconfigNode node : getDefinitionOrderWithoutChildren(model.getInnerGraph())) {
			serialize(model, builder, node, 0);
		}
		return builder.toString();
	}
}
