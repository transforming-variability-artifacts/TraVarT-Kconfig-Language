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

import de.kit.kastel.travart.kconfig.model.TristateLogic;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

public class KconfigTristateNode extends KconfigValueNode<TristateLogic> {

	public KconfigTristateNode(String nodeName, KconfigMenuNode<?> enclosingNode) {
		super(nodeName, enclosingNode);
	}

	@Override
	public boolean isConfigured() {
		return getValue() != TristateLogic.FALSE;
	}

	@Override
	public void setConfigured(boolean selected) {
		if (selected) {
			setValue(TristateLogic.SELECTED);
		} else {
			setValue(TristateLogic.FALSE);
		}
	}

}
