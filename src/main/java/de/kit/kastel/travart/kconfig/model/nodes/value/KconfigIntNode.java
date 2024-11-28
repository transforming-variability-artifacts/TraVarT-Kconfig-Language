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
package de.kit.kastel.travart.kconfig.model.nodes.value;

import java.util.Objects;

import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

// TODO Also implement KconfigHexNode
// Right now, hex config symbols are parsed as integer confsyms
public class KconfigIntNode extends KconfigValueNode<Integer> {

	public KconfigIntNode(String nodeName, KconfigMenuNode<?> enclosingNode) {
		super(nodeName, enclosingNode);
	}

	@Override
	public boolean isConfigured() {
		return Objects.nonNull(getValue());
	}

	@Override
	public void setConfigured(boolean selected) {
		if (selected) {
			if (!this.isConfigured()) {
				setValue(0);
			}
		} else {
			setValue(null);
		}
	}

}
