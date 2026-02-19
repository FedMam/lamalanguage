package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class VarPattern extends Pattern {
    private final int slotId;

    public VarPattern(int slotId) {
        this.slotId = slotId;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        frame.setObject(slotId, value);
        return true;
    }
}
