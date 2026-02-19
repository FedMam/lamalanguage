package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.Undefined;

@SuppressWarnings("FieldMayBeFinal")
public final class WhileLoopNode extends LamaNode {
    @Child
    private LamaNode condition;
    @Child
    private LamaNode body;

    private final boolean isDoWhileLoop;

    public WhileLoopNode(LamaNode condition, LamaNode body, boolean isDoWhileLoop) {
        this.condition = condition;
        this.body = body;
        this.isDoWhileLoop = isDoWhileLoop;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        if (!isDoWhileLoop) {
            while (condition.executeInt(frame) != 0) {
                body.executeGeneric(frame);
            }
        } else {
            do { 
                body.executeGeneric(frame);
            } while (condition.executeInt(frame) != 0);
        }

        return Undefined.instance;
    }
}
