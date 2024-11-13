/*******************************************************************************
 * TODO: explanation what the class does
 *
 *  @author Kevin Feichtinger
 *
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.io;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.antlr.runtime.tree.CommonTree;

import at.jku.cps.travart.core.common.IReader;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.factory.impl.KconfigModelFactory;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.parser.KconfigParserDispatcher;
import de.kit.kastel.travart.kconfig.parser.TreeProcessor;

//@SuppressWarnings({ "rawtypes", "unchecked" })
public class KconfigModelReader implements IReader<IKconfigModel> {

	public static final String FILE_EXTENSION_KCONFIG = ".Kconfig";

	//private static final String CARDINALITY_NOT_SUPPORTED_ERROR = "Cardinality %s not supported for decision of type %s";

	private final KconfigModelFactory factory;

	public KconfigModelReader() {
		factory = KconfigModelFactory.getInstance();
	}

	@Override
	public IKconfigModel read(final Path path) throws IOException, NotSupportedVariabilityTypeException {
		Objects.requireNonNull(path);
		KconfigModel km = factory.create();
		km.setName(path.getFileName().toString());
		km.setSourceFile(path.toAbsolutePath().toString());
		//CSVFormat dmFormat = DecisionModelUtils.createCSVFormat(true);
		KconfigParserDispatcher dispatcher = new KconfigParserDispatcher();
		// Might throw IOException
		var parRes = dispatcher.parse(path.toFile());
		// Process syntax tree to KconfigGraph
		TreeProcessor tp = new TreeProcessor(parRes.getRight());
		tp.processAST(parRes.getLeft(), null, false);
		// Insert graph into wrapper object
		km.addAll(tp.getGraph());
		return km;		
	}

	@Override
	public Iterable<String> fileExtensions() {
		return Collections.unmodifiableList(List.of(FILE_EXTENSION_KCONFIG));
	}
}
