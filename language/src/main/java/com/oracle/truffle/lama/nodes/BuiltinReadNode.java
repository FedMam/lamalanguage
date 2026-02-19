package com.oracle.truffle.lama.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;

public final class BuiltinReadNode extends LamaNode {
    private static int readInt(InputStream is) throws IOException, NoSuchElementException {
        boolean started = false;
        boolean isNegative = false;
        int abs = 0;
        while (true) {
            int b = is.read();
            if (b == -1) { // EOF
                return abs * (isNegative ? -1 : 1);
            }
            char ch = (char)b;

            if (Character.isWhitespace(ch)) {
                if (!started)
                    continue;
                return abs * (isNegative ? -1 : 1);
            } else if (ch == '-') {
                if (started || isNegative)
                    throw new InputMismatchException("unexpected character: '-' (45)");
                isNegative = false;
            } else if (Character.isDigit(ch)) {
                started = true;
                abs *= 10;
                abs += (int)ch - (int)'0';
            } else {
                throw new InputMismatchException("unexpected character: '" + ch + "' (" + (int)ch + ")");
            }
        }
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeInt(frame);
    }

    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        System.out.print("> ");
        try {
            return readInt(System.in);
        } catch (IOException | NoSuchElementException e) {
            throw new LamaLanguageException("failed to read int from stdin: " + e.getMessage());
        }
    }
}
