package de.kit.kastel.travart.kconfig.cli;

import at.jku.cps.travart.core.cli.CliUtils;
import de.kit.kastel.travart.kconfig.transformation.KconfigModelTransformer;
import de.kit.kastel.travart.kconfig.io.*;

public class Entry {

	public static void main(String[] args) {
		CliUtils.cliPluginDelegate(args, 
				new KconfigModelTransformer(),
				new KconfigModelSerializer(),
				new KconfigModelDeserializer());
	}
}
