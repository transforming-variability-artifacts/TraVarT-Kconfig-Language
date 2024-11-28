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
package de.kit.kastel.travart.kconfig.parser;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Invoke ANTLR-generated parser on a Kconfig file.
 */
public class KconfigParserDispatcher {

	public Pair<CommonTree, CommonTokenStream> parse(File toParse) throws IOException {
		CharStream cs = new ANTLRFileStream(toParse.getAbsolutePath());
		LKCLexer lexer = new LKCLexer(cs);
		return parse(lexer);
	}

	public Pair<CommonTree, CommonTokenStream> parse(String serial) throws IOException {
		ANTLRStringStream antlrStream = new ANTLRStringStream(serial);
		LKCLexer lexer = new LKCLexer(antlrStream);
		return parse(lexer);
	}

	private Pair<CommonTree, CommonTokenStream> parse(LKCLexer lexer) throws IOException  {
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		LKCParser parser = new LKCParser(tokens);
		LKCParser.input_return parserResult = null;
		try {
			parserResult = parser.input();
		} catch (RecognitionException e) {
			throw new IOException(e);
		}
		return Pair.of(parserResult.getTree(), tokens);
	}
}
