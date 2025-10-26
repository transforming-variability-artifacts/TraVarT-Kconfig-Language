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
package de.kit.kastel.travart.kconfig.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import at.jku.cps.travart.core.io.UVLDeserializer;
import de.kit.kastel.travart.kconfig.io.KconfigModelDeserializer;
import de.kit.kastel.travart.kconfig.io.KconfigModelSerializer;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.transformation.oneway.KconfigModelOneWayTransformer;
import de.kit.kastel.travart.kconfig.transformation.roundtrip.KconfigModelRoundtripTransformer;
import de.vill.model.FeatureModel;

// FIXME After a KconfigWriter is implemented, compare string representations instead of using AssertJ
class KconfigTest {

	@Test
	void splotUVLtoKCTest() throws IOException, URISyntaxException,
			NotSupportedVariabilityTypeException {
		Configurator.setRootLevel(Level.ALL);
		File uvlFilesRoot = new File(getClass().getResource("/uvl2kc").toURI());
		assert uvlFilesRoot.isDirectory();
		List<File> uvlFiles = Arrays.stream(uvlFilesRoot.listFiles())
				.filter(e -> e.getAbsolutePath().endsWith("uvl")).toList();
		Map<Integer, String> failedFiles = new TreeMap<>();
		int idx = 0;
		for (File uvlFile : uvlFiles) {
			System.out.println("Now transforming " + uvlFile + " (index " + idx
					+ " of " + uvlFiles.size() + ")");
			// Use new deserializer/transformer for each file
			UVLDeserializer deserializer = new UVLDeserializer();
			var model = deserializer.deserializeFromFile(uvlFile);
			KconfigModelOneWayTransformer owt = new KconfigModelOneWayTransformer();
			try {
				KconfigModel resultingModel = owt.transform(model);
				System.out.println(
						"Transformed! Now trying to serialize resulting model...");
				KconfigModelSerializer serializer = new KconfigModelSerializer();
				serializer.serializeToFile(resultingModel,
						Path.of(uvlFile.getPath() + ".Kconfig"));
			} catch (Exception e) {
				failedFiles.put(idx, uvlFile.getName());
				System.err.println(e.getMessage());
				System.err.println("Transformation/serialization for " + uvlFile
						+ " failed! Current index " + idx);
				System.out.flush();
				System.err.flush();
				// Let's just try to go through all models without aborting...
				// for now
			}
			idx++;
		}
		System.out.println("Attempt to transform all UVL files; failed "
				+ failedFiles.size() + " from " + uvlFiles.size() + "!");
		System.out.println(failedFiles);
	}

	@Test
	void linux269RoundtripTest() throws IOException, URISyntaxException,
			NotSupportedVariabilityTypeException {
		final var assertor = new SoftAssertions();
		int strictness = 2;
		File kcFilesRoot = new File(
				getClass().getResource("/linux269_clean").toURI());
		assert kcFilesRoot.isDirectory();
		List<File> kcFiles = Arrays.stream(kcFilesRoot.listFiles())
				.filter(e -> e.getAbsolutePath().endsWith(".Kconfig")).toList();
		int idx = 1;
		for (File kcFile : kcFiles) {
			System.out.println("Now parsing: " + kcFile.getName() + " (" + idx
					+ "/" + kcFiles.size() + ")");
			KconfigModel model = new KconfigModelDeserializer()
					.deserializeFromFile(kcFile);
			model.setName(kcFile.getName().toString());
			model.setSourceFile(kcFile.getAbsolutePath().toString());
			KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
			FeatureModel fm = rtt.transform(model);
			KconfigModel rtResult = rtt.transform(fm);
			assertor.assertThat(rtResult).usingRecursiveComparison()
					.ignoringCollectionOrder()
					.ignoringFields("graph.dependencies.asMapView")
					.isEqualTo(model);
			if (assertor.assertionErrorsCollected().size() > strictness) {
				System.err.println(
						"Too main imperfect roundtrip transformations, throwing exception from last failure!");
				throw assertor.assertionErrorsCollected().getLast();
			}
			System.out.println(
					"Resulting feature model: " + fm.composedModelToString());
			idx++;
		}
		System.out.println("Imperfect roundtrip transformations: "
				+ assertor.assertionErrorsCollected().size());
	}

}
