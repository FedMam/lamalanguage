package com.oracle.truffle.lama.nodes;

import java.util.List;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.Undefined;
import com.oracle.truffle.lama.types.ref.Ref;

@SuppressWarnings("FieldMayBeFinal")
public final class SeqBlockNode extends LamaNode {
    @Children
    private LamaNode[] instructions;

    public SeqBlockNode(List<LamaNode> instructions) {
        this.instructions = instructions.toArray(LamaNode[]::new);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        if (instructions.length == 0)
            return Undefined.instance;

        for (int i = 0; i < instructions.length - 1; i++)
            instructions[i].executeGeneric(frame);
        return instructions[instructions.length - 1].executeGeneric(frame);
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        if (instructions.length == 0)
            throw new LamaLanguageException("cannot execute empty sequential block as reference");
        
        for (int i = 0; i < instructions.length - 1; i++)
            instructions[i].executeGeneric(frame);
        return instructions[instructions.length - 1].executeRef(frame);
    }
}