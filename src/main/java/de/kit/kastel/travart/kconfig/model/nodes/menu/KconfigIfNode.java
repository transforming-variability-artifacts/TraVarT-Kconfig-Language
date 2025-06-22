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

import org.logicng.formulas.Formula;

import de.kit.kastel.travart.kconfig.model.KconfigNode;

@SuppressWarnings("rawtypes")
public class KconfigIfNode extends KconfigMenuNode<KconfigNode> {
	
	final Formula condition;

	public KconfigIfNode(String nodeName, KconfigMenuNode enclosingNode, Formula exp) {
		super(nodeName, enclosingNode);
		this.condition = exp;
	}

	public Formula getCondition() {
		return condition;
	}
}
