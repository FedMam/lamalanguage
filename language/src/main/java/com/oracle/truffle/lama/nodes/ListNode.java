package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.LamaList;

@SuppressWarnings("FieldMayBeFinal")
public final class ListNode extends LamaNode {
    @Children
    private LamaNode[] elements;

    public ListNode(LamaNode[] elements) {
        this.elements = elements;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeList(frame);
    }

    @Override
    public LamaList executeList(VirtualFrame frame) throws UnexpectedResultException {
        Object[] vals = new Object[elements.length];
        // note: LamaList implementation requires values in tail-to-head
        // order but the code requires execution in head-to-tail order
        for (int i = 0; i < elements.length; i++)
            vals[elements.length - 1 - i] = elements[i].executeGeneric(frame);

        return LamaList.of(vals);
    }
}