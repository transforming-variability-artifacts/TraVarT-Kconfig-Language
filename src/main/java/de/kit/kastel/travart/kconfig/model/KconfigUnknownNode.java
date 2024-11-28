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
package de.kit.kastel.travart.kconfig.model;

/**
 * Corresponds to the former KconfigType.UNKNOWN enum entry
 */
public class KconfigUnknownNode extends KconfigNode {

	public KconfigUnknownNode(String name) {
		super(name);
	}

	@Override
	public boolean isConfigured() {
		throw new UnsupportedOperationException("Cannot invoke isSelected() on placeholder node: Faulty model!");
	}

	@Override
	public void setConfigured(boolean configured) {
		throw new UnsupportedOperationException("Cannot invoke setSelected() on placeholder node: Faulty model!");
	}

}
