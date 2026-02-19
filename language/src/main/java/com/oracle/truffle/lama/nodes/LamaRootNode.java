package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.language.LamaTruffleLanguage;

public final class LamaRootNode extends RootNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private LamaNode entryNode;

    public LamaRootNode(LamaTruffleLanguage language, LamaNode entryNode) {
        super(language);

        this.entryNode = entryNode;
    }

    public LamaRootNode(LamaTruffleLanguage language, FrameDescriptor frameDescriptor, LamaNode entryNode) {
        super(language, frameDescriptor);

        this.entryNode = entryNode;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        try {
            return this.entryNode.executeGeneric(frame);
        } catch (UnexpectedResultException e) {
            throw new RuntimeException(e);
        }
    }
}
