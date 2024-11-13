/*******************************************************************************
 * TODO: explanation what the class does
 *
 *  @author Kevin Feichtinger
 *
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.transformation;

import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.transformation.oneway.KconfigModelOneWayTransformer;
//import de.kit.kastel.travart.kconfig.transformation.roundtrip.DecisionModelRoundtripTransformer;
import de.vill.model.FeatureModel;

public class KconfigModelTransformer implements IModelTransformer<IKconfigModel> {

	//private final DecisionModelRoundtripTransformer decisionModelRoundtripTransformer = new DecisionModelRoundtripTransformer();
	private final KconfigModelOneWayTransformer decisionModelOneWayTransformer = new KconfigModelOneWayTransformer();

	@Override
	public FeatureModel transform(final IKconfigModel model, final String modelName, final STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		if (level == STRATEGY.ROUNDTRIP) {
			throw new UnsupportedOperationException("Not implemented yet");
		}
		return decisionModelOneWayTransformer.transform(model, modelName);
	}

	@Override
	public IKconfigModel transform(final FeatureModel model, final String modelName, final STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		if (level == STRATEGY.ROUNDTRIP) {
			throw new UnsupportedOperationException("Not implemented yet");
		}
		return decisionModelOneWayTransformer.transform(model, modelName);
	}

}
