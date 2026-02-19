package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.LamaString;
import com.oracle.truffle.lama.types.Sexp;

public final class BuiltinLengthNode extends LamaNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private ReadFunctionArgNode argNode = new ReadFunctionArgNode(0);

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeInt(frame);
    }
    
    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        Object obj = argNode.executeGeneric(frame);
        
        if (obj instanceof Object[] arr)
            return arr.length;
        else if (obj instanceof LamaString str)
            return str.getLength();
        else if (obj instanceof Sexp sexp)
            return sexp.getNumArgs();
        else if (obj == null)
            throw new LamaLanguageException("object of type 'null' has no length");

        throw new LamaLanguageException("object of type '" + obj.getClass().getSimpleName() + "' has no length");
    }
}
