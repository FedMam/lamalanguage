package com.oracle.truffle.lama.types.ref;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.language.LamaLanguageContext;
import com.oracle.truffle.lama.types.ClosureVarKeeper;

public class ClosureVarRef extends Ref {
    private final String name;
    private final ClosureVarKeeper keeper;

    public ClosureVarRef(String name, ClosureVarKeeper keeper) {
        this.name = name;
        this.keeper = keeper;
    }

    public String getName() {
        return name;
    }

    public ClosureVarKeeper getKeeper() {
        return keeper;
    }

    @Override
    public Object getAt(LamaLanguageContext context, VirtualFrame frame) {
        return keeper.getVar(name);
    }

    @Override
    public void setAt(LamaLanguageContext context, VirtualFrame frame, Object value) throws UnexpectedResultException {
        keeper.setVar(name, value);
    }
}
