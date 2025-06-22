/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors:
 *     @author Kevin Feichtinger
 *
 * The class provides access to statistical information of the pivot model.
 *
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import at.jku.cps.travart.core.common.IStatistics;
import at.jku.cps.travart.core.helpers.TraVarTUtils;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.vill.model.Feature;
import de.vill.model.FeatureModel;
import de.vill.model.Group;

public final class KconfigModelStatistics implements IStatistics<KconfigModel> {

	private static KconfigModelStatistics instance;

	private KconfigModelStatistics() {
	}

	public static KconfigModelStatistics getInstance() {
		if (instance == null) {
			instance = new KconfigModelStatistics();
		}
		return instance;
	}

	@Override
	public int getVariabilityElementsCount(KconfigModel model) {
		return model.getNodes().size();
	}

	@Override
	public int getConstraintsCount(KconfigModel model) {
		return model.getDependencies().size();

	}

	@Override
	public void logModelStatistics(Logger logger, KconfigModel model) {
		// TODO Provide information on dependency structure etc.
	}
}
