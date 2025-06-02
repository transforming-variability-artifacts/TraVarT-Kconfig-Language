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

import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import at.jku.cps.travart.core.transformation.AbstractBenchmarkingTransformer;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.vill.model.FeatureModel;

public class KconfigModelRoundtripBenchmarkingTransformer extends AbstractBenchmarkingTransformer<KconfigModel> {
	
	@Override
	public KconfigModel transformInner(FeatureModel model, String modelName, STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeatureModel transformInner(KconfigModel model, String modelName, STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return null;
	}
}
