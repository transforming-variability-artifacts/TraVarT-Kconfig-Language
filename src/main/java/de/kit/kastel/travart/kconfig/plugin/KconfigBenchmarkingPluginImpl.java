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
package de.kit.kastel.travart.kconfig.plugin;

import java.util.Collections;
import java.util.List;

import org.pf4j.Extension;

import at.jku.cps.travart.core.common.IBenchmarkingPlugin;
import at.jku.cps.travart.core.common.IDeserializer;
import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.common.IStatistics;
import at.jku.cps.travart.core.transformation.AbstractBenchmarkingTransformer;
import de.kit.kastel.travart.kconfig.io.KconfigFormat;
import de.kit.kastel.travart.kconfig.io.KconfigModelDeserializer;
import de.kit.kastel.travart.kconfig.io.KconfigModelSerializer;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.transformation.KconfigModelTransformer;

@Extension
@SuppressWarnings("rawtypes")
public class KconfigBenchmarkingPluginImpl implements IBenchmarkingPlugin {

	public static final String ID = "kconfig-benchmarking-plugin";

	@Override
	public IModelTransformer getTransformer() {
		return new KconfigModelTransformer();
	}

	@Override
	public IDeserializer<KconfigModel> getDeserializer() {
		return new KconfigModelDeserializer();
	}

	@Override
	public IStatistics getStatistics() {
		return null;
	}

	@Override
	public ISerializer<KconfigModel> getSerializer() {
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

	@Override
	public AbstractBenchmarkingTransformer getBenchmarkingTransformer() {
		return new KconfigModelTransformer();

	}
}
