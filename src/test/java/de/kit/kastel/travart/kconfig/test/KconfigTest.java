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

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import at.jku.cps.travart.core.factory.impl.CoreModelFactory;
import at.jku.cps.travart.core.helpers.TraVarTUtils;
import at.jku.cps.travart.core.io.UVLDeserializer;
import de.kit.kastel.travart.kconfig.io.KconfigFormat;
import de.kit.kastel.travart.kconfig.io.KconfigModelDeserializer;
import de.kit.kastel.travart.kconfig.io.KconfigModelSerializer;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.transformation.oneway.KconfigModelOneWayTransformer;
import de.kit.kastel.travart.kconfig.transformation.roundtrip.KconfigModelRoundtripTransformer;
import de.vill.model.Feature;
import de.vill.model.FeatureModel;
import de.vill.model.Group.GroupType;

// FIXME After a KconfigWriter is implemented, compare string representations instead of using AssertJ
class KconfigTest {
	
	@Test
	void splotUVLtoKCTest() throws IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		Configurator.setRootLevel(Level.ALL);
		File uvlFilesRoot = new File(getClass().getResource("/uvl2kc").toURI());
		assert uvlFilesRoot.isDirectory();
		List<File> uvlFiles = Arrays
				.stream(uvlFilesRoot.listFiles())
				.filter(e -> e.getAbsolutePath().endsWith("uvl")).toList();
		Map<Integer, String> failedFiles = new TreeMap<>();
		int idx = 0;
		for (File uvlFile : uvlFiles) {
			System.out.println("Now transforming " + uvlFile + " (index " + idx + " of " + uvlFiles.size() + ")");
			// Use new deserializer/transformer for each file
			UVLDeserializer deserializer = new UVLDeserializer();
			var model = deserializer.deserializeFromFile(uvlFile);
			KconfigModelOneWayTransformer owt = new KconfigModelOneWayTransformer();
			try {
				KconfigModel resultingModel = owt.transform(model);
				System.out.println("Transformed! Now trying to serialize resulting model...");
				KconfigModelSerializer serializer = new KconfigModelSerializer();
				serializer.serializeToFile(resultingModel, Path.of(uvlFile.getPath() + ".Kconfig"));
			} catch (Exception e) {
				failedFiles.put(idx, uvlFile.getName());
				System.err.println(e.getMessage());
				System.err.println("Transformation/serialization for " + uvlFile + " failed! Current index " + idx);
				System.out.flush();
				System.err.flush();
				// Let's just try to go through all models without aborting... for now
			}
			idx++;			
		}		
		System.out.println(
				"Attempt to transform all UVL files; failed " + failedFiles.size() + " from " + uvlFiles.size() + "!");
		System.out.println(failedFiles);
	}

	@Test
	@Disabled
	// TODO Rewrite test: Compare pre-built model to produced model from one-way transformer
	void oneWayOrTest() throws IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		CoreModelFactory factory = CoreModelFactory.getInstance();
		KconfigModel model = parse("Or.Kconfig");
		FeatureModel fmSource = new FeatureModel();
		Feature featureA = factory.createFeature("FEATURE_A");
		TraVarTUtils.addFeature(fmSource, featureA);
		TraVarTUtils.setRoot(fmSource, featureA);
		List<Feature> featureAOrGroup = new ArrayList<Feature>();
		featureAOrGroup.add(factory.createFeature("FEATURE_B"));
		featureAOrGroup.add(factory.createFeature("FEATURE_C"));
		Feature featureD = factory.createFeature("FEATURE_D");
		featureAOrGroup.add(featureD);
		TraVarTUtils.addGroup(fmSource, featureAOrGroup, featureA, GroupType.OR);
		List<Feature> featureDOrGroup = new ArrayList<Feature>();
		featureDOrGroup.add(factory.createFeature("FEATURE_E"));
		featureDOrGroup.add(factory.createFeature("FEATURE_F"));
		TraVarTUtils.addGroup(fmSource, featureDOrGroup, featureD, GroupType.OR);
		KconfigModelOneWayTransformer rtt = new KconfigModelOneWayTransformer();
		KconfigModel fmResult = rtt.transform(fmSource);
		KconfigModelSerializer serializer = new KconfigModelSerializer();
		Path resourcesFolder = Paths.get(this.getClass().getResource("/").getPath());
		Path output = Paths.get(resourcesFolder.toAbsolutePath() + "/Oneway.Kconfig");
		serializer.serializeToFile(fmResult, output);
		// TODO Add some assertion for the serialized Kconfig file
		// Ignore model-specific metadata
		assertThat(fmResult).usingRecursiveComparison()
		.ignoringFields("graph.dependencies.asMapView", "sourceFile", "name", "factoryId")
		.isEqualTo(model);
	}

	// TODO Move common parts of unit tests into preamble method
	@Test
	@Disabled
	void simpleTristateTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModel model = parse("Tristate.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		KconfigModel rtResult = rtt.transform(fm);
		// Must ignore graph.dependencies.asMapView!
		// Field used by AbstractMultiValuedMap for caching asMap result
		// See AsMap private member in AbstractMultiValuedMap for more details
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);

	}

	@Test
	@Disabled
	void combinationTristateChoiceTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModel model = parse("TristateMultiChoice.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		KconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	@Test
	@Disabled
	void multiMenuTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModel model = parse("Multimenu.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		KconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	@Test
	@Disabled
	void optMultiChoiceTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModel model = parse("OptChoice.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		KconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	@Test
	@Disabled
	void choiceMultDep() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModel model = parse("ChoiceMultDep.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		KconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	private KconfigModel parse(String fileName) throws URISyntaxException, IOException, NotSupportedVariabilityTypeException {
		Path filePath = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
		String content = Files.readString(filePath, StandardCharsets.UTF_8);
		KconfigModelDeserializer reader = new KconfigModelDeserializer();
		KconfigModel model = reader.deserialize(content, KconfigFormat.getInstance());
		model.setName(filePath.getFileName().toString());
		model.setSourceFile(filePath.toAbsolutePath().toString());
		return model;
	}

}
