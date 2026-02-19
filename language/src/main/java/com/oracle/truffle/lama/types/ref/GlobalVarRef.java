package com.oracle.truffle.lama.types.ref;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.language.LamaLanguageContext;

public class GlobalVarRef extends Ref {
    private final String name;

    public GlobalVarRef(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object getAt(LamaLanguageContext context, VirtualFrame frame) {
        return context.getGlobal(name);
    }

    @Override
    public void setAt(LamaLanguageContext context, VirtualFrame frame, Object value) {
        context.setGlobal(name, value);
    }
}
