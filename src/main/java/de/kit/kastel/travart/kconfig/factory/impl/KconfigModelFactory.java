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
package de.kit.kastel.travart.kconfig.factory.impl;

import de.kit.kastel.travart.kconfig.factory.IKconfigModelFactory;
import de.kit.kastel.travart.kconfig.model.KconfigModel;

public class KconfigModelFactory implements IKconfigModelFactory {

	public static final String ID = "de.kit.kastel.travart.kconfig.factory.impl.KconfigModelFactory"; 

	private KconfigModelFactory() {}

	private static KconfigModelFactory factory;

	// Factory as singleton object
	public static KconfigModelFactory getInstance() {
		if (factory == null) {
			factory = new KconfigModelFactory();
		}
		return factory;
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public KconfigModel create() {
		return new KconfigModel(ID);
	}
}
