package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class AliasPattern extends Pattern {
    private final int slotId;
    private final Pattern innerPattern;

    public AliasPattern(int slotId, Pattern innerPattern) {
        this.slotId = slotId;
        this.innerPattern = innerPattern;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (innerPattern.match(value, frame)) {
            frame.setObject(slotId, value);
            return true;
        }
        return false;
    }
}
