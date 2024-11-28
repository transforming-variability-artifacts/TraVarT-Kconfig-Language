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

import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigBooleanNode;

public class KconfigMenuconfigNode extends KconfigMenuNode {

	private KconfigBooleanNode underlyingNode;

	public KconfigMenuconfigNode(String nodeName, KconfigMenuNode<?> enclosingNode) {
		super(nodeName, enclosingNode);
		underlyingNode = new KconfigBooleanNode(nodeName, enclosingNode);
	}

	public KconfigBooleanNode getUnderlyingNode() {
		return underlyingNode;
	}
}
