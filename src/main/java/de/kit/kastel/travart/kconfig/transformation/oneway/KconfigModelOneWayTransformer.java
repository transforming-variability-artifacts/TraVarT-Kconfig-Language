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
package de.kit.kastel.travart.kconfig.transformation.oneway;

import org.slf4j.event.Level;

import com.google.common.eventbus.EventBus;

import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.transformation.roundtrip.KconfigModelTwoWayGraphTransformer;
import de.vill.model.FeatureModel;

public class KconfigModelOneWayTransformer implements IModelTransformer<KconfigModel> {

	@Override
	public FeatureModel transform(final KconfigModel model, final String modelName, final STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		// Bootstrap partial two-way transformation, identical to one-way transformation
		return KconfigModelTwoWayGraphTransformer.processGraph(model);
	}

	@Override
	public KconfigModel transform(final FeatureModel model, final String modelName, final STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		var transformer = new KconfigModelOneWayGraphTransformer();
		return transformer.processToGraph(model);
	}
	
	public KconfigModel transform(final FeatureModel model, final String modelName, EventBus emitTo, Level verbosity)
			throws NotSupportedVariabilityTypeException {
		var transformer = new KconfigModelOneWayGraphTransformer(emitTo, verbosity);
		return transformer.processToGraph(model);
	}
}
