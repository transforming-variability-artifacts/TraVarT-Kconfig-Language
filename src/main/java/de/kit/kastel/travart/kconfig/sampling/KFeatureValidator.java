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
package de.kit.kastel.travart.kconfig.sampling;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import at.jku.cps.travart.core.common.IConfigurable;
import at.jku.cps.travart.core.common.ISampler;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.KconfigModel;

public class KFeatureValidator implements ISampler<KconfigModel> {

	@Override
	public Set<Map<IConfigurable, Boolean>> sampleValidConfigurations(KconfigModel model)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}

	@Override
	public Set<Map<IConfigurable, Boolean>> sampleValidConfigurations(KconfigModel model, long maxNumber)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}

	@Override
	public Set<Map<IConfigurable, Boolean>> sampleInvalidConfigurations(KconfigModel model)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}

	@Override
	public Set<Map<IConfigurable, Boolean>> sampleInvalidConfigurations(KconfigModel model, long maxNumber)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}

	@Override
	public boolean verifySampleAs(KconfigModel model, Map<IConfigurable, Boolean> sample)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return false;
	}

}
