package de.kit.kastel.travart.kconfig.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import at.jku.cps.travart.core.factory.impl.CoreModelFactory;
import at.jku.cps.travart.core.helpers.TraVarTUtils;
import de.kit.kastel.travart.kconfig.io.KconfigModelReader;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.transformation.oneway.KconfigModelOneWayTransformer;
import de.kit.kastel.travart.kconfig.transformation.roundtrip.KconfigModelRoundtripTransformer;
import de.vill.model.Feature;
import de.vill.model.FeatureModel;
import de.vill.model.Group.GroupType;

// FIXME After a KconfigWriter is implemented, compare string representations instead of using AssertJ
public class KconfigTest {

	@Test
	// TODO Rewrite test: Compare pre-built model to produced model from one-way transformer
	public void oneWayOrTest() throws IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		CoreModelFactory factory = CoreModelFactory.getInstance();
		KconfigModelReader reader = new KconfigModelReader();
		IKconfigModel model = reader.read(new File(getClass().getClassLoader().getResource("Or.Kconfig").toURI()));
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
	public void simpleTristateTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModelReader reader = new KconfigModelReader();
		IKconfigModel model = reader.read(new File(getClass().getClassLoader().getResource("Tristate.Kconfig").toURI()));
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		// Must ignore graph.dependencies.asMapView!
		// Field used by AbstractMultiValuedMap for caching asMap result
		// See AsMap private member in AbstractMultiValuedMap for more details
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);

	}

	@Test
	public void combinationTristateChoiceTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModelReader reader = new KconfigModelReader();
		IKconfigModel model = reader.read(new File(getClass().getClassLoader().getResource("TristateMultiChoice.Kconfig").toURI()));
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}
	
	@Test
	public void multiMenuTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModelReader reader = new KconfigModelReader();
		IKconfigModel model = reader.read(new File(getClass().getClassLoader().getResource("Multimenu.Kconfig").toURI()));
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}
	
	@Test
	public void optMultiChoiceTest() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModelReader reader = new KconfigModelReader();
		IKconfigModel model = reader.read(new File(getClass().getClassLoader().getResource("OptChoice.Kconfig").toURI()));
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}
	
	@Test
	public void choiceMultDep() throws  IOException, URISyntaxException, NotSupportedVariabilityTypeException {
		KconfigModelReader reader = new KconfigModelReader();
		IKconfigModel model = reader.read(new File(getClass().getClassLoader().getResource("ChoiceMultDep.Kconfig").toURI()));
		KconfigModelRoundtripTransformer rtt = new KconfigModelRoundtripTransformer();
		FeatureModel fm = rtt.transform(model);
		IKconfigModel rtResult = rtt.transform(fm);
		assertThat(rtResult).usingRecursiveComparison().ignoringFields("graph.dependencies.asMapView").isEqualTo(model);
	}
	
}
