package com.oracle.truffle.lama.types.pattern;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.lama.types.LamaList;

public final class ConsPattern extends Pattern {
    private final Pattern[] elements;
    private final Pattern tail;

    public ConsPattern(Pattern[] elements, Pattern tail) {
        this.elements = elements;
        this.tail = tail;
    }

    @Override
    public boolean match(Object value, VirtualFrame frame) {
        if (value instanceof LamaList list) {
            if (list.getSize() < elements.length)
                return false;

            Object[] listElements = list.takeN(elements.length);
            for (int i = 0; i < elements.length; i++) {
                if (!elements[i].match(listElements[i], frame))
                    return false;
            }
            
            return tail.match(list.dropN(elements.length), frame);
        } else return false;
    }
}
