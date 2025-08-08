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

import org.apache.logging.log4j.Logger;

import at.jku.cps.travart.core.common.IStatistics;
import de.kit.kastel.travart.kconfig.model.KconfigModel;

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
		// Sum of size of all lists across all nodes
		return model.getInnerGraph().dependencies().size();
	}

	@Override
	public void logModelStatistics(Logger logger, KconfigModel model) {
		logger.info("Statistics for " + model.getName() + ":");
		logger.info("Number of nodes: " + model.getInnerGraph().nodes().size());
		logger.info("Number of dependencies: " + model.getInnerGraph().dependencies().size());
		logger.info("select-type reverse dependencies from above: " +
				model.getInnerGraph().dependencies().values().stream().filter(e -> e.getRight().booleanValue()).count());		
	}
}
