package com.oracle.truffle.lama.types.pattern;

import java.util.List;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.FunctionObject;
import com.oracle.truffle.lama.types.Sexp;

public final class ValTagPattern extends Pattern {
    @Override
    public boolean match(Object value, VirtualFrame frame) {
        return !(value instanceof FunctionObject) &&
            !(value instanceof Sexp) &&
            !(value instanceof Object[]) &&
            !(value instanceof List);
    }
}