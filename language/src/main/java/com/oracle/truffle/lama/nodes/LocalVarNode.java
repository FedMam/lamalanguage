package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.ClosureConstructor;
import com.oracle.truffle.lama.types.Undefined;
import com.oracle.truffle.lama.types.ref.LocalVarRef;
import com.oracle.truffle.lama.types.ref.Ref;

public class LocalVarNode extends LamaNode {
    private final int slotId;

    public LocalVarNode(int slotId) {
        this.slotId = slotId;
    }

    public int getSlotId() {
        return slotId;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object v = frame.getObject(slotId);

        if (v == null || v instanceof Undefined)
            throw new LamaLanguageException("usage of uninitialized variable");
        // see ClosureConstructor.java for explanation
        if (v instanceof ClosureConstructor constructor)
            return constructor.build(frame);

        return v;
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        LocalVarRef r = new LocalVarRef(slotId);
        return r;
    }
}
