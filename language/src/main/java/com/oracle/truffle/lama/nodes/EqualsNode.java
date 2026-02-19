package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@SuppressWarnings("FieldMayBeFinal")
public final class EqualsNode extends LamaNode {
    @Child
    private LamaNode lArg;
    @Child
    private LamaNode rArg;

    private final boolean invert;

    public EqualsNode(LamaNode lArg, LamaNode rArg, boolean invert) {
        this.lArg = lArg;
        this.rArg = rArg;
        this.invert = invert;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object l = lArg.executeGeneric(frame), r = rArg.executeGeneric(frame);
        return (l.equals(r) != invert) ? 1 : 0;
    }
}