package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.LamaString;
import com.oracle.truffle.lama.types.Sexp;

public final class BuiltinStringNode extends LamaNode {
    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private ReadFunctionArgNode argNode = new ReadFunctionArgNode(0);
    
    private static String stringRepr(Object obj) {
        String repr = "";
        if (obj instanceof Object[] arr) {
            repr += "[";
            for (int i = 0; i < arr.length; i++) {
                repr += stringRepr(arr[i]);
                if (i < arr.length - 1)
                    repr += ", ";
            }
            repr += "]";
        } else if (obj instanceof Sexp sexp) {
            repr += sexp.getName();
            if (sexp.getNumArgs() > 0) { 
                repr += " (";
                for (int i = 0; i < sexp.getNumArgs(); i++) {
                    repr += stringRepr(sexp.getArg(i));
                    if (i < sexp.getNumArgs() - 1)
                        repr += ", ";
                }
                repr += ")";
            }
        } else if (obj instanceof LamaString str) {
            repr = "\"" + str.toString() + "\"";
        } else if (obj == null) {
            repr = "null";
        } else repr = obj.toString();

        return repr;
    }
    
    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeString(frame);
    }

    @Override
    public LamaString executeString(VirtualFrame frame) throws UnexpectedResultException {
        Object obj = argNode.executeGeneric(frame);
        String repr = stringRepr(obj);
        return new LamaString(repr);
    }
}
