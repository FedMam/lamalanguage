package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.LamaString;
import com.oracle.truffle.lama.types.Sexp;
import com.oracle.truffle.lama.types.ref.ArrayElemRef;
import com.oracle.truffle.lama.types.ref.Ref;
import com.oracle.truffle.lama.types.ref.SexpElemRef;
import com.oracle.truffle.lama.types.ref.StringElemRef;

@SuppressWarnings("FieldMayBeFinal")
public final class IndexAccessNode extends LamaNode {
    @Child
    private LamaNode refNode;
    
    @Child
    private LamaNode indexNode;

    public IndexAccessNode(LamaNode refNode, LamaNode indexNode) {
        this.refNode = refNode;
        this.indexNode = indexNode;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object obj = refNode.executeGeneric(frame);
        int index = indexNode.executeInt(frame);

        if (obj instanceof Object[] arr)
            return arr[index];
        else if (obj instanceof LamaString str)
            return str.charAt(index);
        else if (obj instanceof Sexp sexp)
            return sexp.getArg(index);
        else if (obj == null)
            throw new LamaLanguageException("'null' object is not suscriptable");
        
        throw new LamaLanguageException("'" + obj.getClass().getSimpleName() + "' object is not suscriptable");
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        Object obj = refNode.executeGeneric(frame);
        int index = indexNode.executeInt(frame);

        if (obj instanceof Object[] arr)
            return new ArrayElemRef(arr, index);
        else if (obj instanceof LamaString str)
            return new StringElemRef(str, index);
        else if (obj instanceof Sexp sexp)
            return new SexpElemRef(sexp, index);
        else if (obj == null)
            throw new LamaLanguageException("'null' object is not suscriptable");
        
        throw new LamaLanguageException("'" + obj.getClass().getSimpleName() + "' object is not suscriptable");
    }
}