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
package de.kit.kastel.travart.kconfig.model.nodes.menu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.tuple.MutablePair;
import org.logicng.formulas.Formula;

import de.kit.kastel.travart.kconfig.model.KconfigGraph;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.model.KconfigNode;

public class KconfigMenuNode<T extends KconfigNode> extends KconfigNode {

	public Set<T> contents;

	public KconfigMenuNode(String nodeName, KconfigMenuNode<?> enclosingNode) {
		super(nodeName, enclosingNode);
		this.contents = new HashSet<T>();
	}

	@Override
	public boolean isConfigured() {
		// Cannot be selected; menu nodes are, by default, abstract
		return false;
	}

	@Override
	public void setConfigured(boolean selected) {
		// Cannot be selected; menu nodes are, by default, abstract
	}
	
	public Set<KconfigNode> getContents() {
		return (Set<KconfigNode>) contents;
	}
	
	public KconfigGraph getSubgraph(final KconfigModel model) {
		assert model.contains(this);
		ListValuedMap<KconfigNode, MutablePair<Formula, Boolean>> dependencies = new ArrayListValuedHashMap<>();
		Map<String, KconfigNode> nodeMap = new HashMap<>();
		for (KconfigNode child : this.getContents()) {
			dependencies.putAll(child, model.getInnerGraph().dependencies().get(child));
		}
		for (KconfigNode child : this.getContents()) {
			nodeMap.put(child.getName(), child);
			assert model.contains(child) && model.getNodeNames().contains(child.getName());
		}
		return new KconfigGraph(nodeMap, dependencies);
	}
}
