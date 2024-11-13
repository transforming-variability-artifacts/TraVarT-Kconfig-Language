/*******************************************************************************
 * TODO: explanation what the class does
 *
 *  @author Kevin Feichtinger
 *
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
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
