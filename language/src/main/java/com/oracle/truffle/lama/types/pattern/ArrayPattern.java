package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;

public final class ArrayPattern extends Pattern {
    private final Pattern[] elements;

    public ArrayPattern(Pattern[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (value instanceof Object[] array) {
            if (elements.length != array.length)
                return false;
            
            for (int i = 0; i < elements.length; i++) {
                if (!elements[i].match(array[i], frame))
                    return false;
            }
            return true;
        } else return false;
    }
}
