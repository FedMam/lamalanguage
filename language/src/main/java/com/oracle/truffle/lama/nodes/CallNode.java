package com.oracle.truffle.lama.nodes;

import java.util.List;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.ClosureConstructor;
import com.oracle.truffle.lama.types.FunctionObject;

public final class CallNode extends LamaNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private LamaNode targetFunction;

    @Children
    private final LamaNode[] callArguments;

    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private FunctionDispatchNode dispatchNode;

    public CallNode(LamaNode targetFunction, List<LamaNode> callArguments) {
        this.targetFunction = targetFunction;
        this.callArguments = callArguments.toArray(LamaNode[]::new);
        this.dispatchNode = FunctionDispatchNodeGen.create();
    }

    // closure arguments are treated as simple arguments
    @Override
    @ExplodeLoop
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        FunctionObject function = targetFunction.executeFunctionObject(frame);
        Object[] argumentValues;

        argumentValues = new Object[callArguments.length];
        for (int i = 0; i < callArguments.length; i++) {
            argumentValues[i] = callArguments[i].executeGeneric(frame);

            // we are not allowed to transfer ClosureConstructors directly
            // into other functions, so we should prevent that by immediately building them
            if (argumentValues[i] instanceof ClosureConstructor constructor) {
                argumentValues[i] = constructor.build(frame);
            }
        }

        return dispatchNode.executeDispatch(dispatchNode, function, argumentValues);
    }
}
