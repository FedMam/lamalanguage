package com.oracle.truffle.lama.types;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;

@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("unused")
public final class Sexp implements TruffleObject {
    private final String name;
    private final Object[] args;

    public Sexp(String name, Object[] args) {
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public int getNumArgs() {
        return args.length;
    }

    public Object getArg(int index) {
        return args[index];
    }

    public void setArg(int index, Object value) {
        args[index] = value;
    }

    @Override
    public String toString() {
        return name + " (" + Arrays.stream(args).map(arg -> arg.toString()).collect(Collectors.joining(", ")) + ")";
    }

    @ExportMessage
    boolean hasArrayElements() { return true; }

    @ExportMessage
    int getArraySize() { return args.length; }

    @ExportMessage
    Object readArrayElement(long index) {
        return getArg((int)index);
    }

    @ExportMessage
    void writeArrayElement(long index, Object value) {
        setArg((int)index, value);
    }

    private boolean isCorrect(int index) {
        return index >= 0 && index < args.length;
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