package com.oracle.truffle.lama.nodes;

import java.util.Collection;
import java.util.List;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.Undefined;

public final class GlobalDeclNode extends LamaNode {
    private final List<String> varNames;

    public GlobalDeclNode(Collection<String> varNames) {
        this.varNames = List.copyOf(varNames);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        var context = currentLanguageContext();
        for (String varName: varNames)
            context.declareGlobal(varName);
        return Undefined.instance;
    }
}