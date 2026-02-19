package com.oracle.truffle.lama.types;

import java.util.HashMap;
import java.util.Map;

import com.oracle.truffle.api.interop.TruffleObject;

public final class ClosureVarKeeper implements TruffleObject {
    private final Map<String, Object> vars = new HashMap<>();;

    public ClosureVarKeeper(Map<String, Object> args) {
        this.vars.putAll(args);
    }

    public int getNumVars() {
        return vars.size();
    }

    public boolean hasVar(String name) {
        return vars.containsKey(name);
    }

    public Object getVar(String name) {
        return vars.get(name);
    }

    public void setVar(String name, Object value) {
        vars.put(name, value);
    }
}