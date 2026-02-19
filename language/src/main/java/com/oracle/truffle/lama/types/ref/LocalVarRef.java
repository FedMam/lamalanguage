package com.oracle.truffle.lama.types.ref;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.language.LamaLanguageContext;

public class LocalVarRef extends Ref {
    private final int slotId;

    public LocalVarRef(int slotId) {
        this.slotId = slotId;
    }

    public int getSlotId() {
        return slotId;
    }

    @Override
    public Object getAt(LamaLanguageContext context, VirtualFrame frame) {
        return frame.getObject(slotId);
    }

    @Override
    public void setAt(LamaLanguageContext context, VirtualFrame frame, Object value) {
        frame.setObject(slotId, value);
    }
}
