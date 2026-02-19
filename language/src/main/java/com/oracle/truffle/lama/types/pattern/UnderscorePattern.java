package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class UnderscorePattern extends Pattern {
    @Override
    public boolean match(Object value, VirtualFrame frame) {
        return true;
    }
}