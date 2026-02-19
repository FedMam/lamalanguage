package com.oracle.truffle.lama.types;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;

@ExportLibrary(InteropLibrary.class)
@SuppressWarnings("unused")
public final class Undefined implements TruffleObject {
    private Undefined() { }
    public static final Undefined instance = new Undefined();

    @ExportMessage
    boolean isNull() { return true; }

    @ExportMessage
    Object toDisplayString(boolean allowSideEffects) { return "undefined"; }
}
