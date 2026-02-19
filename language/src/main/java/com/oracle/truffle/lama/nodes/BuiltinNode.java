package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.language.LamaLanguageContext;
import com.oracle.truffle.lama.types.ref.Ref;

public final class BuiltinNode extends LamaNode {
    private final String name;

    public BuiltinNode(String name) {
        this.name = name;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return LamaLanguageContext.getBuiltin(name);
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        throw new LamaLanguageException("cannot reassign builtins");
    }
}
