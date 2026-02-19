package com.oracle.truffle.lama.types;

import com.oracle.truffle.api.CallTarget;

public class FunctionObject {
    // The callTarget is not final purely for ClosureConstructor and
    // ClosureVarKeeper to do a little trick to avoid infinite recursion.
    private CallTarget callTarget;

    public FunctionObject(CallTarget callTarget) {
        this.callTarget = callTarget;
    }

    public CallTarget getCallTarget() {
        return callTarget;
    }

    public void changeCallTarget(CallTarget callTarget) {
        this.callTarget = callTarget;
    }
}
