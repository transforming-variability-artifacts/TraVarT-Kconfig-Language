package de.kit.kastel.travart.kconfig.validation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

// Normally I would prefer using Apache Commons, but only Guava provides a powerSet utility method
import com.google.common.collect.Sets;
import org.sat4j.specs.TimeoutException;

import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.base.IFeature;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.configuration.ConfigurationAnalyzer;
import de.ovgu.featureide.fm.core.init.FMCoreLibrary;
import de.ovgu.featureide.fm.core.init.LibraryManager;
import de.ovgu.featureide.fm.core.io.manager.FeatureModelManager;

// This class isn't an unit test, but it’s supposed to be used by unit tests as an util class.
// TODO Ensure that this works with UVL models
public class KFeatureValidator {

    final private static String KLOCALIZER_ENABLE_SYMBOL_FLAG = "-D";
    final private static String KLOCALIZER_DISABLE_SYMBOL_FLAG = "-U";
    private static final String CONFIG_SYMBOL_PREFIX = "CONFIG_";

    /****
     * 
     * This method does some automated validation of feature models created by
     * KFeature.
     * 
     * To be exact, it does the following:
     * 
     * 0. We call Kextract and Kclause on the given Kconfig file as the output data
     * is required for Klocalizer to function properly.
     * 
     * 1. It loads the target feature model through the featureModel file
     * descriptor. It uses FeatureModelManager's load method.
     * 
     * 2. It uses Configuration.getSolutions to generate a list of all valid
     * configurations for the feature model. Additionally, the power set of the set
     * of all non-abstract features is calculated, which correspond to the set of
     * all possible (but not necessarily valid) unique solutions of the given
     * feature model.
     * 
     * 3. These configurations are then sent over to kmax, which exits with a
     * non-zero integer or zero. If the sent configuration is in the set of
     * solutions of the feature model and kmax has returned zero, this means that
     * kmax has recognized the solution of the feature model as a valid Kconfig
     * configuration. If the sent configuration isn't a solution and kmax has
     * returned a non-zero integer, this means kmax has recognized as a non-solution
     * to the feature model as an invalid Kconfig configuration.
     * 
     * 4. If all solutions (resp. non-solutions) are recognized as valid (resp.
     * invalid) Kconfig configurations, it is proven that Kfeature has completely
     * preserved the semantics of the
     * underlying Kconfig file whilst transforming it into a feature model.
     * 
     * @param kconfigFile  Path descriptor for the Kconfig file that was transformed
     * @param featureModel Path descriptor for the feature model that was created by
     *                     KFeature through transforming kconfigFile
     * 
     */
    public static boolean validateTransformation(Path kconfigFile, Path featureModel) {
        ProcessBuilder invokeKExtract = new ProcessBuilder();
        invokeKExtract.command(List.of("sh", "-c",
                "kextract --extract " + kconfigFile.getFileName().toString() + " > Kconfig.kextract"));
        invokeKExtract.directory(kconfigFile.getParent().toFile());
        try {
            Process kextractProcess = invokeKExtract.start();
            kextractProcess.waitFor();
            kextractProcess.destroy();
        } catch (IOException | InterruptedException e) {
            // kmax possibly not installed? Check if kmax and its helper tools are in PATH
            e.printStackTrace();
        }
        invokeKExtract.directory(kconfigFile.getParent().toFile());
        /*
         * Invoke kextract to generate list of config symbols and dependencies for klocalizer
         */
        ProcessBuilder invokeKClause = new ProcessBuilder();
        invokeKClause.command(List.of("sh", "-c", "kclause -e < Kconfig.kextract > Kconfig.kclause"));
        invokeKClause.directory(kconfigFile.getParent().toFile());
        try {
            Process kclauseProcess = invokeKClause.start();
            kclauseProcess.waitFor();
            kclauseProcess.destroy();
        } catch (IOException | InterruptedException e) {
            // kmax possibly not installed?
            e.printStackTrace();
        }
        /*
         * Invoke kclause to generate SMT-LIB constraints corresponding to the
         * dependencies in the Kconfig file, which is also used by klocalizer
         */
        assert featureModel.toFile().exists();
        LibraryManager.registerLibrary(FMCoreLibrary.getInstance());
        FeatureModelFormula fmf = new FeatureModelFormula(FeatureModelManager.load(featureModel));
        Configuration conf = new Configuration(fmf);
        
        /*
         * conf is a null configuration, alas all features are undefined (neither
         * selected nor unselected)
         */
        // We first get a list with all features that appear in the feature model
        Collection<IFeature> features = fmf.getFeatureModel().getFeatures();
        
        /*
         * FeatureIDE creates solutions as lists consisting of feature names, so we
         * create a list with the names of all features that occur in the feature
         * model. Sublists of this list correspond to possible (but not necessarily
         * valid) configurations of the current feature model.
         */
        List<String> featureNames = features.stream().map(e -> e.getName()).toList();
        
        /*
         * Abstract features do not correspond to any configuration symbols, hence they
         * are not respected by kmax whilst checking for satisfiability. We will use
         * this set to eliminate non-unique configurations.
         */
        Set<String> abstractFeatures = features.stream().filter(e -> e.getStructure().isAbstract())
                .map(e -> e.getName()).collect(Collectors.toSet());
        
        /*
         * We generate the power set of all non-abstract features. This should
         * correspond to the set of all unique configurations.
         */
        Set<Set<String>> allConfigurations = Sets
                .powerSet(Sets.difference(featureNames.stream().collect(Collectors.toSet()), abstractFeatures));
        ConfigurationAnalyzer cAnalyzer = new ConfigurationAnalyzer(fmf, conf);
        Set<Set<String>> solutions = new HashSet<>();
        try {
            solutions = cAnalyzer.getSolutions(Long.valueOf(cAnalyzer.number()).intValue()).stream()
                    .map(HashSet::new).collect(Collectors.toSet());
        } catch (TimeoutException exp) {
            System.err.println("Too many possible solutions! This feature model cannot be verified automatically.");
            return false;
        }
        solutions.forEach(e -> e.removeAll(abstractFeatures));
        // Ignore abstract features in solutions (see previous comment)
        for (Set<String> configuration : allConfigurations) {
            int result = -1;
            StringJoiner sj = new StringJoiner(" ");
            for (String feature : featureNames) {
                if (configuration.contains(feature)) {
                    sj.add(KLOCALIZER_ENABLE_SYMBOL_FLAG + CONFIG_SYMBOL_PREFIX + feature);
                } else if (!abstractFeatures.contains(feature)) {
                    sj.add(KLOCALIZER_DISABLE_SYMBOL_FLAG + CONFIG_SYMBOL_PREFIX + feature);
                }
            }
            ProcessBuilder invokeKLocalizer = new ProcessBuilder();
            invokeKLocalizer.command(List.of("sh", "-c",
                    "klocalizer --kextract Kconfig.kextract --kclause-formulas Kconfig.kclause --disable-downloading-formulas "
                            + sj.toString()));
            invokeKLocalizer.directory(kconfigFile.getParent().toFile());
            Process satisfyProcess;
            try {
                satisfyProcess = invokeKLocalizer.start();
                result = satisfyProcess.waitFor();
                satisfyProcess.destroy();
            } catch (IOException | InterruptedException e) {
                // kmax possibly not installed?
                e.printStackTrace();
            }
            if (solutions.stream().anyMatch(e -> e.equals(configuration))) {
                /*
                 * Calling `contains` unfortunately does not work due to how UnifiedSet's implemented
                 */
                if (result != 0)
                    return false;
            } else {
                if (result == 0)
                    return false;
            }
        }
        return true;
    }
}
