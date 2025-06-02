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

import org.apache.commons.lang3.tuple.MutablePair;
import org.logicng.formulas.Formula;

import at.jku.cps.travart.core.common.Format;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.*;
import de.kit.kastel.travart.kconfig.model.nodes.value.*;
import de.kit.kastel.travart.kconfig.parser.TreeProcessor;

public class KconfigModelSerializer implements ISerializer<KconfigModel> {

	/**
	 * WIP
	 */
	public String serialize(final KconfigModel km) throws NotSupportedVariabilityTypeException {
		StringBuilder fileContents = new StringBuilder();
		// throw new UnsupportedOperationException("Not implemented!");
		// TODO Find the right order to process the nodes
		for (KconfigNode node : getDefinitionOrder(km.getInnerGraph())) {
			StringBuilder nodeCode = new StringBuilder();
			if (node instanceof KconfigValueNode) {
				// FIXME Do not ignore menu and choice blocks
				// TODO Ensure that the order in which config symbols occur is valid
				nodeCode.append("config " + node.getName() + "\n\r");
				switch (node) {
				case KconfigBooleanNode b:
					nodeCode.append("\t bool\n\r");
					break;
				case KconfigIntNode i:
					nodeCode.append("\t int\n\r");
					break;
				case KconfigTristateNode t:
					nodeCode.append("\t tristate\n\r");
					break;
				case KconfigStringNode s:
					nodeCode.append("\t string\n\r");
					break;
				default:
					throw new IllegalStateException("Cannot write illegal Kconfig model!");
				}
				if (km.getDependencies().keySet().contains(node)) {
					for (MutablePair<Formula, Boolean> dep : km.getDependencies().get(node)) {
						if (dep.right) {
							nodeCode.append("\t select " + detoxDependencyExpression(dep.left.toString()) + "\n\r");
						} else {
							nodeCode.append("\t depends on " + detoxDependencyExpression(dep.left.toString()) + "\n\r");
						}
					}
					nodeCode.append("\n\r");
					fileContents.append(nodeCode.toString());
				}
			}
		}
		return fileContents.toString();
	}

	private String detoxDependencyExpression(String dependencyExpression) {
		// TODO Find all discrepancies between LogicNG and Kconfig expression syntax
		return dependencyExpression.replace('~', '!').replace("$", "");

	}
	
	private List<KconfigNode> getDefinitionOrder(KconfigGraph graph) {
		List<KconfigNode> order = new ArrayList<KconfigNode>();
		// Start with random node
		for (KconfigNode node : graph.nodes().values()) {
			// If already processed, skip
			if (order.contains(node)) continue;
			order.addAll(calculateDefinitionOrder(graph, node, order, List.of()));
		}
		return order;
	}
	
	private List<KconfigNode> calculateDefinitionOrder(KconfigGraph graph, KconfigNode current, 
			List<KconfigNode> order, Collection<KconfigNode> visited) {
		if (visited.contains(current)) throw new IllegalStateException("Cannot serialize model; model contains dependency loop!");
		// Is this node contained within some other node?
		// If yes, process that first!
		if (current.getEnclosingNode() != null) {
			// TODO Calculate order within a choice/if block
		}
		// FIXME Consider case where the current node contains other nodes
		// Are there any nodes that these nodes depend on that we need to process?
		List<KconfigNode> dependees = graph.dependencies().get(current).stream()
				.flatMap(e -> TreeProcessor.extractNodes(e.left, graph).stream()).toList();
		for (KconfigNode dependee : dependees) {
			if (order.contains(dependee)) continue;
			var visitedNew = new ArrayList<KconfigNode>(visited);
			visited.add(current);
			// FIXME Do we need to clone `order` every time we recurse?
			order.addAll(calculateDefinitionOrder(graph, dependee, order, visitedNew));
		}
		// After dependees and containing nodes are processed, add current node and return order
		order.add(current);
		return order;
	}

	@Override
	public Format getFormat() {
		return KconfigFormat.getInstance();
	}
}
