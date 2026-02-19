package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.ClosureConstructor;

// This node is the only node which can return a ClosureConstructor.
// To be used only in automatically generated variable assignments.
// LocalVarNode will immediately build() all ClosureConstructors,
// because of the VERY VERY strange logic of Lama (see ClosureConstructor.java for details).
@SuppressWarnings("FieldMayBeFinal")
public final class ClosureConstructorNode extends LamaNode {
    private final ClosureConstructor constructor;

    public ClosureConstructorNode(ClosureConstructor constructor) {
        this.constructor = constructor;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return constructor;
    }
}