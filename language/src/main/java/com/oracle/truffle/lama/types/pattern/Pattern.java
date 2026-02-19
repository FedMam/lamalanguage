package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;

public abstract class Pattern {
    // if match successful, can have side effects, namely assignment of local variables inside pattern
    public abstract boolean match(Object value, VirtualFrame frame);
}