package de.kit.kastel.travart.kconfig.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import at.jku.cps.travart.core.factory.impl.CoreModelFactory;
import at.jku.cps.travart.core.helpers.TraVarTUtils;
import de.kit.kastel.travart.kconfig.io.KconfigFormat;
import de.kit.kastel.travart.kconfig.io.KconfigModelDeserializer;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.transformation.oneway.KconfigModelOneWayTransformer;
import de.kit.kastel.travart.kconfig.transformation.roundtrip.KconfigModelRoundtripTransformer;
import de.vill.model.Feature;
import de.vill.model.FeatureModel;
import de.vill.model.Group.GroupType;

// FIXME After a KconfigWriter is implemented, compare string representations instead of using AssertJ
class KconfigTest {

	@Test
	// TODO Rewrite test: Compare pre-built model to produced model from one-way transformer
	void oneWayOrTest() throws IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		CoreModelFactory factory = CoreModelFactory.getInstance();
		IKconfigModel model = parse("Or.Kconfig");
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
		IKconfigModel fmResult = rtt.transform(fmSource);
		// Ignore model-specific metadata
		assertThat(fmResult).usingRecursiveComparison()
		.ignoringFields("graph.dependencies.asMapView", "sourceFile", "name", "factoryId")
		.isEqualTo(model);
	}

	// TODO Move common parts of unit tests into preamble method
	@Test
	void simpleTristateTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		IKconfigModel model = parse("Tristate.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		// Must ignore graph.dependencies.asMapView!
		// Field used by AbstractMultiValuedMap for caching asMap result
		// See AsMap private member in AbstractMultiValuedMap for more details
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);

	}

	@Test
	void combinationTristateChoiceTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		IKconfigModel model = parse("TristateMultiChoice.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	@Test
	void multiMenuTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		IKconfigModel model = parse("Multimenu.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	@Test
	void optMultiChoiceTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		IKconfigModel model = parse("OptChoice.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	@Test
	void choiceMultDep() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		IKconfigModel model = parse("ChoiceMultDep.Kconfig");
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}

	private IKconfigModel parse(String fileName) throws URISyntaxException, IOException, NotSupportedVariabilityTypeException {
		Path filePath = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
		String content = Files.readString(filePath, StandardCharsets.UTF_8);
		KconfigModelDeserializer reader = new KconfigModelDeserializer();
		IKconfigModel model = reader.deserialize(content, KconfigFormat.getInstance());
		model.setName(filePath.getFileName().toString());
		model.setSourceFile(filePath.toAbsolutePath().toString());
		return model;
	}

}
