package com.oracle.truffle.lama.types.ref;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.language.LamaLanguageContext;

public abstract class Ref implements TruffleObject {
    public abstract Object getAt(LamaLanguageContext context, VirtualFrame frame) throws UnexpectedResultException;

    public abstract void setAt(LamaLanguageContext context, VirtualFrame frame, Object value) throws UnexpectedResultException;
}
