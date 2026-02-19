package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public final class BuiltinWriteNode extends LamaNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private ReadFunctionArgNode argNode = new ReadFunctionArgNode(0);

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeInt(frame);
    }
    
    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        Object v = argNode.executeGeneric(frame);

        System.out.println(v);

        return 0;
    }
}
