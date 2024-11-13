package de.kit.kastel.travart.kconfig.parser;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
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
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		LKCParser parser = new LKCParser(tokens);
		LKCParser.input_return parserResult = null;
        try {
            parserResult = parser.input();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
		return Pair.of((CommonTree) parserResult.getTree(), tokens);
    }
}
