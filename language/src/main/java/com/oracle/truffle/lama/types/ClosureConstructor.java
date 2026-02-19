package com.oracle.truffle.lama.types;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.language.LamaTruffleLanguage;
import com.oracle.truffle.lama.nodes.AssignmentNode;
import com.oracle.truffle.lama.nodes.FunctionObjectNode;
import com.oracle.truffle.lama.nodes.LamaNode;
import com.oracle.truffle.lama.nodes.LamaRootNode;
import com.oracle.truffle.lama.nodes.LocalFunctionNode;
import com.oracle.truffle.lama.nodes.LocalVarNode;
import com.oracle.truffle.lama.nodes.ObjectLiteralNode;
import com.oracle.truffle.lama.nodes.SeqNode;

// By the VERY VERY strange logic of Lama, we must create a closure
// and take a snapshot of the respective variables every time we
// request the value of a local variable in code.
// So we'll use these as constructors of closures.
public final class ClosureConstructor implements TruffleObject {
    private final LamaNode[] closureArgNodes;
    private final String[] closureArgNames;
    private final LamaTruffleLanguage language;
    private final FrameDescriptor.Builder fdBuilder;
    private final LamaNode funBody;
    private final int keeperSlot;

    public ClosureConstructor(LamaNode[] closureArgNodes, String[] closureArgNames, LamaTruffleLanguage language, FrameDescriptor.Builder fdBuilder, LamaNode funBody, int keeperSlot) {
        this.closureArgNodes = closureArgNodes;
        this.closureArgNames = closureArgNames;
        this.language = language;
        this.fdBuilder = fdBuilder;
        this.funBody = funBody;
        this.keeperSlot = keeperSlot;
    }

    public FunctionObject build(VirtualFrame frame) throws UnexpectedResultException {
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
