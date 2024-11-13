/**
 * Provides the actual plugin information for DOPLER.
 *
 * @author Kevin Feichtinger
*
* Copyright 2023 Johannes Kepler University Linz
* LIT Cyber-Physical Systems Lab
* All rights reserved
 */
package de.kit.kastel.travart.kconfig.plugin;

import java.util.Collections;
import java.util.List;

import org.pf4j.Extension;

import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.common.IPlugin;
import at.jku.cps.travart.core.common.IReader;
import at.jku.cps.travart.core.common.IStatistics;
import at.jku.cps.travart.core.common.IWriter;
import de.kit.kastel.travart.kconfig.io.KconfigModelReader;
import de.kit.kastel.travart.kconfig.io.KconfigModelWriter;
import de.kit.kastel.travart.kconfig.transformation.KconfigModelTransformer;

@Extension
@SuppressWarnings("rawtypes")
public class KconfigPluginImpl implements IPlugin {

	public static final String ID = "kconfig-plugin";

	@Override
	public IModelTransformer getTransformer() {
		return new KconfigModelTransformer();
	}

	@Override
	public IReader getReader() {
		return new KconfigModelReader();
	}

	@Override
	public IStatistics getStatistics() {
		return null;
	}

	@Override
	public IWriter getWriter() {
		return new KconfigModelWriter();
	}

	@Override
	public String getName() {
		return "Kconfig";
	}

	@Override
	public String getVersion() {
		return "0.0.0";
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public List getSupportedFileExtensions() {
		return Collections.unmodifiableList(List.of(KconfigModelReader.FILE_EXTENSION_KCONFIG));		
	}

}
