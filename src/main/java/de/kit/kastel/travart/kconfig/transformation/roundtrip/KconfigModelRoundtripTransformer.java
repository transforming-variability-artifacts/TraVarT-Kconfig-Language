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
package de.kit.kastel.travart.kconfig.transformation.roundtrip;

import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.vill.model.FeatureModel;

public class KconfigModelRoundtripTransformer implements IModelTransformer<IKconfigModel> {

	@Override
	public FeatureModel transform(IKconfigModel model, String modelName, STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		return KconfigModelTwoWayGraphTransformer.processGraph(model);
	}

	@Override
	public IKconfigModel transform(FeatureModel model, String modelName, STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		return KconfigModelTwoWayGraphTransformer.processToGraph(model);
	}
}
