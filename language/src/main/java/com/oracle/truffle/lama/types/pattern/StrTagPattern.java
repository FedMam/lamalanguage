package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.LamaString;

public final class StrTagPattern extends Pattern {
    @Override
    public boolean match(Object value, VirtualFrame frame) {
        return value instanceof LamaString;
    }
}