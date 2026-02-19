package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.LamaString;

public final class StringLiteralPattern extends Pattern {
    private final String litValue;

    public StringLiteralPattern(String value) {
        this.litValue = value;
    }

    public String getValue() {
        return litValue;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (value instanceof LamaString sv) {
            return litValue.equals(sv.toString());
        } return false;
    }
}