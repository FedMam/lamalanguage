package com.oracle.truffle.lama.parser;

import java.io.IOException;
import java.io.Reader;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.lama.language.LamaTruffleLanguage;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.LamaRootNode;

public final class LamaTruffleParser {
    public static LamaRootNode parse(LamaTruffleLanguage language, String program) {
        return parse(language, CharStreams.fromString(program));
    }

    public static LamaRootNode parse(LamaTruffleLanguage language, Reader program) throws IOException {
        return parse(language, CharStreams.fromReader(program));
    }

    // DEBUG
    /* public static final boolean ENABLE_DEBUG = false;
    public static void debugNode(Node node, int indent) {
        System.out.print(" ".repeat(indent));
        System.out.println(node.getClass().getSimpleName());
        for (Node child: node.getChildren()) {
            debugNode(child, indent + 1);
        }
    } */

    private static LamaRootNode parse(LamaTruffleLanguage language, CharStream inputStream) {
        var lexer = new LamaLanguageLexer(inputStream);
        lexer.removeErrorListeners();

        // DEBUG
        /* if (ENABLE_DEBUG) {
            for (var tk: lexer.getAllTokens()) {
                System.out.print("<" + lexer.getVocabulary().getSymbolicName(tk.getType()) + ">");
            }
            System.out.println();
            lexer.reset();
        } */

        var parser = new LamaLanguageParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.setErrorHandler(new BailErrorStrategy());
        LamaLanguageParser.LamaLanguageContext context = parser.lamaLanguage();

        // DEBUG
        /* if (ENABLE_DEBUG) {
            System.out.println("@@@");
            System.out.println(context.toStringTree(parser));
        } */

        FrameDescriptor.Builder builder = FrameDescriptor.newBuilder();
        LamaNode entryNode = LamaScopeParser.parseGlobalScope(context.scopeExp(), language, builder);

        // DEBUG
        /* if (ENABLE_DEBUG) {
            System.out.println("~~~~~~~~~~~~~~~~");
            debugNode(entryNode, 0);
        } */

        LamaRootNode rootNode = new LamaRootNode(language, builder.build(), entryNode);

        // DEBUG
        /* if (ENABLE_DEBUG)
            System.out.println("Parsed"); */

        return rootNode;
    }
}
