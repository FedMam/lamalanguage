package com.oracle.truffle.lama.types.ref;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.language.LamaLanguageContext;
import com.oracle.truffle.lama.types.LamaString;

public final class StringElemRef extends Ref {
    private final LamaString underlyingString;
    private final int index;

    public StringElemRef(LamaString underlyingString, int index) {
        this.underlyingString = underlyingString;
        this.index = index;
    }

    @Override
    public Object getAt(LamaLanguageContext context, VirtualFrame frame) {
        return underlyingString.charAt(index);
    }

    @Override
    public void setAt(LamaLanguageContext context, VirtualFrame frame, Object value) {
        if (value instanceof Integer chr)
            underlyingString.putChar(index, chr);
        else throw new LamaLanguageException("string characters are integers, did you not know?");
    }
}
