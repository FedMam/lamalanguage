package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.Undefined;

public final class SkipNode extends LamaNode {
    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return Undefined.instance;
    }
}