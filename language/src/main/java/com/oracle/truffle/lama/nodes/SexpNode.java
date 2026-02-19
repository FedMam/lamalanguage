package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.Sexp;

@SuppressWarnings("FieldMayBeFinal")
public final class SexpNode extends LamaNode {
    private final String name;

    @Children
    private LamaNode[] args;

    public SexpNode(String name, LamaNode[] args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeSexp(frame);
    }

    @Override
    public Sexp executeSexp(VirtualFrame frame) throws UnexpectedResultException {
        Object[] vals = new Object[args.length];
        
        for (int i = 0; i < args.length; i++) {
            Object val = args[i].executeGeneric(frame);
            vals[i] = val;
        }

        return new Sexp(name, vals);
    }
}
