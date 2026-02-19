package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;

public final class ReadFunctionArgNode extends LamaNode {
    private final int index;

    public ReadFunctionArgNode(int index) {
        this.index = index;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object[] arguments = frame.getArguments();

        if (index >= arguments.length)
            throw new LamaLanguageException("not enough arguments for a function: expected at least " + (index + 1) + ", got " + arguments.length);
        return arguments[index];
    }
}
