/*******************************************************************************
 * TODO: explanation what the class does
 *
 *  @author Kevin Feichtinger
 *
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.io;

import at.jku.cps.travart.core.common.Format;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;

//@SuppressWarnings({ "rawtypes", "unchecked" })
public class KconfigModelSerializer implements ISerializer<IKconfigModel> {

	@Override
	public String getFileExtension() {
		return KconfigFormat.FILE_EXTENSION;
	}

	@Override
	public String serialize(IKconfigModel model) throws NotSupportedVariabilityTypeException {
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public Format getFormat() {
		return KconfigFormat.getInstance();
	}
}
