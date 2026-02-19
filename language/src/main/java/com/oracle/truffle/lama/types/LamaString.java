package com.oracle.truffle.lama.types;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;

@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("unused")
public final class LamaString implements TruffleObject {
    private final int[] chars;

    public LamaString(String value) {
        chars = value.chars().toArray();
    }

    public int getLength() {
        return chars.length;
    }

    public int charAt(int index) {
        return chars[index];
    }

    public void putChar(int index, int chr) {
        chars[index] = chr;
    }

    @Override
    public String toString() {
        return new String(chars, 0, chars.length);
    }

    @ExportMessage
    boolean hasArrayElements() { return true; }

    @ExportMessage
    int getArraySize() { return chars.length; }

    @ExportMessage
    Object readArrayElement(long index) {
        return charAt((int)index);
    }

    @ExportMessage
    void writeArrayElement(long index, Object value) {
        putChar((int)index, (int)value);
    }

    private boolean isCorrect(int index) {
        return index >= 0 && index < chars.length;
    }

    @ExportMessage
    boolean isArrayElementReadable(long index) {
        return isCorrect((int)index);
    }

    @ExportMessage
    boolean isArrayElementModifiable(long index) {
        return isCorrect((int)index);
    }

    @ExportMessage
    boolean isArrayElementInsertable(long index) {
        return false;
    }

    @ExportMessage
    Object toDisplayString(boolean allowSideEffects) { return toString(); }
}