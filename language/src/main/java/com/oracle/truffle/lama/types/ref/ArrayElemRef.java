package com.oracle.truffle.lama.types.ref;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.language.LamaLanguageContext;

public final class ArrayElemRef extends Ref {
    private final Object[] underlyingArray;
    private final int index;

    public ArrayElemRef(Object[] underlyingArray, int index) {
        this.underlyingArray = underlyingArray;
        this.index = index;
    }

    @Override
    public Object getAt(LamaLanguageContext context, VirtualFrame frame) {
        return underlyingArray[index];
    }

    @Override
    public void setAt(LamaLanguageContext context, VirtualFrame frame, Object value) {
        underlyingArray[index] = value;
    }
}
