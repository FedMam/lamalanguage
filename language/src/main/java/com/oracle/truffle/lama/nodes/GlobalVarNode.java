package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.ClosureConstructor;
import com.oracle.truffle.lama.types.Undefined;
import com.oracle.truffle.lama.types.ref.GlobalVarRef;
import com.oracle.truffle.lama.types.ref.Ref;

public final class GlobalVarNode extends LamaNode {
    private final String name;

    public GlobalVarNode(String name) {
        this.name = name;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object v = currentLanguageContext().getGlobal(name);

        if (v == null || v instanceof Undefined)
            throw new LamaLanguageException("usage of uninitialized variable");
        // see ClosureConstructor.java for explanation
        if (v instanceof ClosureConstructor constructor)
            return constructor.build(frame);
        
        return v;
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        GlobalVarRef r = new GlobalVarRef(name);
        return r;
    }
}
