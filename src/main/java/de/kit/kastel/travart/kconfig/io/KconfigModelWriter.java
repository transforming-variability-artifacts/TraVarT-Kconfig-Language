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

import java.io.IOException;
import java.nio.file.Path;

import at.jku.cps.travart.core.common.IWriter;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;

//@SuppressWarnings({ "rawtypes", "unchecked" })
public class KconfigModelWriter implements IWriter<IKconfigModel> {
	
	public void write(final IKconfigModel km, final Path path) throws IOException {
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public String getFileExtension() {
		return ".Kconfig";
	}
}
