package com.oracle.truffle.lama.error;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class LamaParsingException extends LamaLanguageException {
    private final int line;
    private final int column;

    public LamaParsingException(String message, int line, int column) {
        super("Error at line " + (line != -1 ? String.valueOf(line) : "null") + ", char " + (column != -1 ? String.valueOf(column) : "null") + ": " + message);
        this.line = line;
        this.column = column;
    }

    public LamaParsingException(String message, Token token) {
        this(message, token != null ? token.getLine() : -1, token != null ? token.getCharPositionInLine() : -1);
    }

    public LamaParsingException(String message, ParserRuleContext ctx) {
        this(message, ctx != null ? ctx.getStart() : null);
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}