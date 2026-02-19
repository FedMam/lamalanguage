package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.LamaList;

public final class ListPattern extends Pattern {
    private final Pattern[] elements;

    public ListPattern(Pattern[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (value instanceof LamaList list) {
            if (list.getSize() != elements.length)
                return false;
            
            Object[] listElements = list.toArray();
            for (int i = 0; i < elements.length; i++) {
                if (!elements[i].match(listElements[i], frame))
                    return false;
            }
            return true;
        } else return false;
    }
}
