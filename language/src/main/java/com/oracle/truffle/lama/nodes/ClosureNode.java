package com.oracle.truffle.lama.nodes;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.language.LamaTruffleLanguage;
import com.oracle.truffle.lama.types.ClosureVarKeeper;
import com.oracle.truffle.lama.types.FunctionObject;

// A node that builds a closure in place once executed
@SuppressWarnings("FieldMayBeFinal")
public final class ClosureNode extends LamaNode {
    @Children
    private LamaNode[] closureArgNodes;

    private final String[] closureArgNames;
    private final LamaTruffleLanguage language;
    private final FrameDescriptor.Builder fdBuilder;
    private final LamaNode funBody;
    private final int keeperSlot;

    public ClosureNode(LamaNode[] closureArgNodes, String[] closureArgNames, LamaTruffleLanguage language, FrameDescriptor.Builder fdBuilder, LamaNode funBody, int keeperSlot) {
        this.closureArgNodes = closureArgNodes;
        this.closureArgNames = closureArgNames;
        this.language = language;
        this.fdBuilder = fdBuilder;
        this.funBody = funBody;
        this.keeperSlot = keeperSlot;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeFunctionObject(frame);
    }

    @Override
    public FunctionObject executeFunctionObject(VirtualFrame frame) throws UnexpectedResultException {
        Map<String, Object> closureArgs = new HashMap<>();
        for (int i = 0; i < closureArgNodes.length; i++) {
            if (closureArgNodes[i] instanceof LocalFunctionNode localFunctionNode) {
                FunctionObject func = new FunctionObject(null);
                closureArgNodes[i] = new FunctionObjectNode(func);
                func.changeCallTarget(localFunctionNode.executeFunctionObject(frame).getCallTarget());
                closureArgs.put(closureArgNames[i], func);
            } else {
                Object closureArgValue =  closureArgNodes[i].executeGeneric(frame);
                closureArgs.put(closureArgNames[i], closureArgValue);
            }
        }
        
        ClosureVarKeeper keeper = new ClosureVarKeeper(closureArgs);

        // also need to wrap with anti-ClosureConstructor screen
        LamaNode funBodyWithKeeper = new SeqNode(
            new AssignmentNode(new LocalVarNode(keeperSlot), new ObjectLiteralNode(keeper)),
            funBody
        );
        LamaRootNode rootNode = new LamaRootNode(language, fdBuilder.build(), funBodyWithKeeper);

        return new FunctionObject(rootNode.getCallTarget());
    }
}
