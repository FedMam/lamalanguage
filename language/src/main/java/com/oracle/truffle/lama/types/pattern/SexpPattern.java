package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.Sexp;

public final class SexpPattern extends Pattern {
    private final String name;
    private final Pattern[] args;

    public SexpPattern(String name, Pattern[] args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (value instanceof Sexp sexp) {
            if (!name.equals(sexp.getName()))
                return false;
            if (args.length != sexp.getNumArgs())
                return false;
            
            for (int i = 0; i < args.length; i++) {
                if (!args[i].match(sexp.getArg(i), frame))
                    return false;
            }
            return true;
        } else return false;
    }
}
