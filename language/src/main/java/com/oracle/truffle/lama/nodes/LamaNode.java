package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.language.LamaLanguageContext;
import com.oracle.truffle.lama.types.FunctionObject;
import com.oracle.truffle.lama.types.LamaList;
import com.oracle.truffle.lama.types.LamaString;
import com.oracle.truffle.lama.types.Sexp;
import com.oracle.truffle.lama.types.ref.Ref;

public abstract class LamaNode extends Node {
    protected final LamaLanguageContext currentLanguageContext() {
        return LamaLanguageContext.get(this);
    }
    
    public abstract Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException;

    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        Object v = executeGeneric(frame);
        if (v instanceof Integer sv)
            return sv;
        throw new UnexpectedResultException(v);
    }

    public LamaString executeString(VirtualFrame frame) throws UnexpectedResultException {
        Object v = executeGeneric(frame);
        if (v instanceof LamaString sv)
            return sv;
        throw new UnexpectedResultException(v);
    }

    public Object[] executeArray(VirtualFrame frame) throws UnexpectedResultException {
        Object v = executeGeneric(frame);
        if (v instanceof Object[] sv)
            return sv;
        throw new UnexpectedResultException(v);
    }

    public Sexp executeSexp(VirtualFrame frame) throws UnexpectedResultException {
        Object v = executeGeneric(frame);
        if (v instanceof Sexp sv)
            return sv;
        throw new UnexpectedResultException(v);
    }

    public LamaList executeList(VirtualFrame frame) throws UnexpectedResultException {
        Object v = executeGeneric(frame);
        if (v instanceof LamaList sv)
            return sv;
        throw new UnexpectedResultException(v);
    }

    public FunctionObject executeFunctionObject(VirtualFrame frame) throws UnexpectedResultException {
        Object v = executeGeneric(frame);
        if (v instanceof FunctionObject sv)
            return sv;
        throw new UnexpectedResultException(v);
    }

    // to be overridden
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        throw new LamaLanguageException("cannot execute " + this.getClass().getSimpleName() + " as lvalue (reference)");
    }
}
