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
package de.kit.kastel.travart.kconfig.io;

import at.jku.cps.travart.core.common.Format;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;

public class KconfigModelSerializer implements ISerializer<IKconfigModel> {

	@Override
	public String getFileExtension() {
		return KconfigFormat.FILE_EXTENSION;
	}

	@Override
	public String serialize(IKconfigModel model) throws NotSupportedVariabilityTypeException {
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public Format getFormat() {
		return KconfigFormat.getInstance();
	}
}
