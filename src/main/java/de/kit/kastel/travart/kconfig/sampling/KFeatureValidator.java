package de.kit.kastel.travart.kconfig.sampling;

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
		return null;
	}

	@Override
	public Set<Map<IConfigurable, Boolean>> sampleValidConfigurations(KconfigModel model, long maxNumber)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map<IConfigurable, Boolean>> sampleInvalidConfigurations(KconfigModel model)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Map<IConfigurable, Boolean>> sampleInvalidConfigurations(KconfigModel model, long maxNumber)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifySampleAs(KconfigModel model, Map<IConfigurable, Boolean> sample)
			throws NotSupportedVariabilityTypeException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
