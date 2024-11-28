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

import at.jku.cps.travart.core.common.IDeserializer;
import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.common.IPlugin;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.common.IStatistics;
import de.kit.kastel.travart.kconfig.io.KconfigFormat;
import de.kit.kastel.travart.kconfig.io.KconfigModelDeserializer;
import de.kit.kastel.travart.kconfig.io.KconfigModelSerializer;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
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
	public IDeserializer<IKconfigModel> getDeserializer() {
		return new KconfigModelDeserializer();
	}

	@Override
	public IStatistics getStatistics() {
		return null;
	}

	@Override
	public ISerializer<IKconfigModel> getSerializer() {
		return new KconfigModelSerializer();
	}

	@Override
	public String getName() {
		return "Kconfig";
	}

	@Override
	public String getVersion() {
		return "0.0.2";
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public List getSupportedFileExtensions() {
		return Collections.unmodifiableList(List.of(KconfigFormat.FILE_EXTENSION));
	}

	@Override
	public String getAbbreviation() {
		return KconfigFormat.LANGUAGE_NAME;
	}
}
