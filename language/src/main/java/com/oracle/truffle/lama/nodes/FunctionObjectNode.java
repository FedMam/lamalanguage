package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.FunctionObject;

public final class FunctionObjectNode extends LamaNode {
    private final FunctionObject functionObject;

    public FunctionObjectNode(FunctionObject functionObject) {
        this.functionObject = functionObject;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return functionObject;
    }

    @Override
    public FunctionObject executeFunctionObject(VirtualFrame frame) {
        return functionObject;
    }
}