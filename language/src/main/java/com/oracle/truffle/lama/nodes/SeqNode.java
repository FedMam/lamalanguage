package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.ref.Ref;

@SuppressWarnings("FieldMayBeFinal")
public final class SeqNode extends LamaNode {
    @Child
    private LamaNode node1;
    @Child
    private LamaNode node2;

    public SeqNode(LamaNode node1, LamaNode node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        node1.executeGeneric(frame);
        return node2.executeGeneric(frame);
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        node1.executeGeneric(frame);
        return node2.executeRef(frame);
    }
}