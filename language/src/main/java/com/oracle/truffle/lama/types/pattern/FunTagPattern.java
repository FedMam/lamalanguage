package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.FunctionObject;

public final class FunTagPattern extends Pattern {
    @Override
    public boolean match(Object value, VirtualFrame frame) {
        return value instanceof FunctionObject;
    }
}