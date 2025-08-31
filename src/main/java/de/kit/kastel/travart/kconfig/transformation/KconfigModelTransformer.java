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
package de.kit.kastel.travart.kconfig.transformation;

import at.jku.cps.travart.core.transformation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import at.jku.cps.travart.core.common.IStatistics;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.KconfigModelStatistics;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.transformation.oneway.KconfigModelOneWayTransformer;
import de.kit.kastel.travart.kconfig.transformation.roundtrip.KconfigModelRoundtripTransformer;
import de.vill.model.FeatureModel;

public class KconfigModelTransformer extends AbstractBenchmarkingTransformer<KconfigModel> {
	
	private static final Logger LOGGER = LogManager.getLogger(KconfigModelTransformer.class);

	private final KconfigModelOneWayTransformer kconfigModelOneWayTransformer = new KconfigModelOneWayTransformer();
	private final KconfigModelRoundtripTransformer kconfigModelRoundtripTransformer = new KconfigModelRoundtripTransformer();

	@Override
	public FeatureModel transformInner(final KconfigModel model, final String modelName, final STRATEGY strategy)
			throws NotSupportedVariabilityTypeException {
		if (strategy == STRATEGY.ROUNDTRIP) {
			LOGGER.debug("Invoking roundtrip transformer, Kconfig to UVL");
			return kconfigModelRoundtripTransformer.transform(model, modelName);
		}
		return kconfigModelOneWayTransformer.transform(model, modelName);
	}

	@Override
	public KconfigModel transformInner(final FeatureModel model, final String modelName, final STRATEGY strategy)
			throws NotSupportedVariabilityTypeException {
		if (strategy == STRATEGY.ROUNDTRIP) {
			LOGGER.debug("Invoking roundtrip transformer, UVL to Kconfig");
			return kconfigModelRoundtripTransformer.transform(model, modelName);
		}
		return kconfigModelOneWayTransformer.transform(model, modelName, bus, verbosity);
	}

	@Override
	public IStatistics<KconfigModel> getTargetStatistics() {
		return KconfigModelStatistics.getInstance();
	}
	
}
