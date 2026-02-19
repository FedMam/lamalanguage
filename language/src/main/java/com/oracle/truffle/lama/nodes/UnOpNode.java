package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public final class UnOpNode extends LamaNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private LamaNode arg;
    
    private final boolean negate;

    public UnOpNode(LamaNode arg, boolean negate) {
        this.arg = arg;
        this.negate = negate;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeInt(frame);
    }

    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        int n = arg.executeInt(frame);
        return negate ? (-n) : n;
    }
}