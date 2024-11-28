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
 * Kconfig Format for de-/serialization.
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.io;

import at.jku.cps.travart.core.common.Format;

public final class KconfigFormat extends Format {

	private static KconfigFormat kconfigFormat;

	public static KconfigFormat getInstance() {
		if (kconfigFormat == null) {
			kconfigFormat = new KconfigFormat();
		}
		return kconfigFormat;
	}

	public static final String LANGUAGE_NAME = "Kconfig";
	public static final String FILE_EXTENSION = ".Kconfig";

	private KconfigFormat() {
		super(LANGUAGE_NAME, FILE_EXTENSION, true, true);
	}
}
