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
import java.util.Collections;
import java.util.List;

import at.jku.cps.travart.core.common.Format;
import at.jku.cps.travart.core.common.IDeserializer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.factory.impl.KconfigModelFactory;
import de.kit.kastel.travart.kconfig.model.IKconfigModel;
import de.kit.kastel.travart.kconfig.model.KconfigModel;
import de.kit.kastel.travart.kconfig.parser.KconfigParserDispatcher;
import de.kit.kastel.travart.kconfig.parser.TreeProcessor;

public class KconfigModelDeserializer implements IDeserializer<IKconfigModel> {

	private final KconfigModelFactory factory;

	public KconfigModelDeserializer() {
		factory = KconfigModelFactory.getInstance();
	}

	@Override
	public Iterable<String> fileExtensions() {
		return Collections.unmodifiableList(List.of(KconfigFormat.FILE_EXTENSION));
	}

	@Override
	public IKconfigModel deserialize(String serial, Format format) throws NotSupportedVariabilityTypeException {
		KconfigModel km = factory.create();
		KconfigParserDispatcher dispatcher = new KconfigParserDispatcher();
		// Might throw IOException
		try {
			var parRes = dispatcher.parse(serial);
			// Process syntax tree to KconfigGraph
			TreeProcessor tp = new TreeProcessor(parRes.getRight());
			tp.processAST(parRes.getLeft(), null, false);
			// Insert graph into wrapper object
			km.addAll(tp.getGraph());
			return km;
		} catch(IOException e) {
			throw new NotSupportedVariabilityTypeException(e);
		}
	}

	@Override
	public Iterable<Format> supportedFormats() {
		return List.of(KconfigFormat.getInstance());
	}
}
