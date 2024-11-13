/**
 * The class implementing the Plugin class to enable code injection.
 *
 * @author Kevin Feichtinger
*
* Copyright 2023 Johannes Kepler University Linz
* LIT Cyber-Physical Systems Lab
* All rights reserved
 */
package de.kit.kastel.travart.kconfig.plugin;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

public class KconfigPlugin extends Plugin {
	public KconfigPlugin(final PluginWrapper wrapper) {
		super(wrapper);
	}
}
