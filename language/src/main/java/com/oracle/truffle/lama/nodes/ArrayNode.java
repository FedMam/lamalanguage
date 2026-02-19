package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

@SuppressWarnings("FieldMayBeFinal")
public final class ArrayNode extends LamaNode {
    @Children
    private LamaNode[] elements;

    public ArrayNode(LamaNode[] elements) {
        this.elements = elements;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeArray(frame);
    }

    @Override
    public Object[] executeArray(VirtualFrame frame) throws UnexpectedResultException {
        Object[] vals = new Object[elements.length];
        
        for (int i = 0; i < elements.length; i++) {
            Object val = elements[i].executeGeneric(frame);
            vals[i] = val;
        }

        return vals;
    }
}