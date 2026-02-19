package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.LamaString;

public final class StringLiteralNode extends LamaNode {
    private final LamaString value;

    public StringLiteralNode(String value) {
        this.value = new LamaString(value);
    }

    public LamaString getValue() {
        return this.value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

    @Override
    public LamaString executeString(VirtualFrame frame) {
        return value;
    }
}