package com.oracle.truffle.lama.types.ref;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.language.LamaLanguageContext;
import com.oracle.truffle.lama.types.Sexp;

public final class SexpElemRef extends Ref {
    private final Sexp underlyingSexp;
    private final int index;

    public SexpElemRef(Sexp underlyingSexp, int index) {
        this.underlyingSexp = underlyingSexp;
        this.index = index;
    }

    @Override
    public Object getAt(LamaLanguageContext context, VirtualFrame frame) {
        return underlyingSexp.getArg(index);
    }

    @Override
    public void setAt(LamaLanguageContext context, VirtualFrame frame, Object value) {
        underlyingSexp.setArg(index, value);
    }
}
