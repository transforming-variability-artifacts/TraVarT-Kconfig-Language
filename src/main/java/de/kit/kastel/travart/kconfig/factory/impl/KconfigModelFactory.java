/*******************************************************************************
 * TODO: explanation what the class does
 *  
 *  @author Kevin Feichtinger
 *  
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
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
