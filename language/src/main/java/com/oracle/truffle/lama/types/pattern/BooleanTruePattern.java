package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class BooleanTruePattern extends Pattern {
    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (value instanceof Integer sv)
            return sv != 0;
        return false;
    }
}