package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.ClosureConstructor;
import com.oracle.truffle.lama.types.FunctionObject;

// This node is used to LOAD (not assign!) a local function
public class LocalFunctionNode extends LamaNode {
    private final int slotId;

    public LocalFunctionNode(int slotId) {
        this.slotId = slotId;
    }

    public int getSlotId() {
        return slotId;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeFunctionObject(frame);
    }

    @Override
    public FunctionObject executeFunctionObject(VirtualFrame frame) throws UnexpectedResultException {
        Object v = frame.getObject(slotId);
        if (v instanceof FunctionObject func) {
            return func;
        } else if (v instanceof ClosureConstructor constructor) {
            return constructor.build(frame);
        }
        throw new UnexpectedResultException(v);
    }
}
