package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.ClosureConstructor;
import com.oracle.truffle.lama.types.ClosureVarKeeper;
import com.oracle.truffle.lama.types.Undefined;
import com.oracle.truffle.lama.types.ref.ClosureVarRef;
import com.oracle.truffle.lama.types.ref.Ref;

public class ClosureVarNode extends LamaNode {
    private final String name;
    private final int keeperSlot;

    public ClosureVarNode(String name, int keeperSlot) {
        this.name = name;
        this.keeperSlot = keeperSlot;
    }

    public String getName() {
        return name;
    }

    public int getKeeperSlot() {
        return keeperSlot;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        ClosureVarKeeper keeper = (ClosureVarKeeper)frame.getObject(keeperSlot);
        Object v = keeper.getVar(name);

        if (v == null || v instanceof Undefined)
            throw new LamaLanguageException("usage of uninitialized variable");
        // see ClosureConstructor.java for explanation
        // should not reach here
        if (v instanceof ClosureConstructor constructor)
            return constructor.build(frame);
        
        return v;
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        ClosureVarKeeper keeper = (ClosureVarKeeper)frame.getObject(keeperSlot);
        ClosureVarRef r = new ClosureVarRef(name, keeper);
        return r;
    }
}
