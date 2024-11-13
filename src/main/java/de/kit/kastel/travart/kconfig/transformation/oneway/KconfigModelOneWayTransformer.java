/*******************************************************************************
 * TODO: explanation what the class does
 *  
 *  @author Kevin Feichtinger
 *  
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.transformation.oneway;

import at.jku.cps.travart.core.common.IModelTransformer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.transformation.roundtrip.KconfigModelTwoWayGraphTransformer;
import de.vill.model.FeatureModel;

public class KconfigModelOneWayTransformer implements IModelTransformer<IKconfigModel> {

	@Override
	public FeatureModel transform(final IKconfigModel model, final String modelName, final STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		// Bootstrap partial two-way transformation, identical to one-way transformation
		return KconfigModelTwoWayGraphTransformer.processGraph(model);
	}

	@Override
	public IKconfigModel transform(final FeatureModel model, final String modelName, final STRATEGY level)
			throws NotSupportedVariabilityTypeException {
		return KconfigModelOneWayGraphTransformer.processToGraph(model);
	}

}
