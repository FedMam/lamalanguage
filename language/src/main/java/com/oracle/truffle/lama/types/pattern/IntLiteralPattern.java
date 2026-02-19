package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class IntLiteralPattern extends Pattern {
    private final int litValue;

    public IntLiteralPattern(int value) {
        this.litValue = value;
    }

    public int getValue() {
        return litValue;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (value instanceof Integer sv)
            return sv == litValue;
        return false;
    }
}