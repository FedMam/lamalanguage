package com.oracle.truffle.lama.language;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.lama.nodes.BuiltinLengthNode;
import com.oracle.truffle.lama.nodes.BuiltinReadNode;
import com.oracle.truffle.lama.nodes.BuiltinStringNode;
import com.oracle.truffle.lama.nodes.BuiltinWriteNode;
import com.oracle.truffle.lama.nodes.LamaRootNode;
import com.oracle.truffle.lama.types.FunctionObject;
import com.oracle.truffle.lama.types.Undefined;

public final class LamaLanguageContext {
    private static final TruffleLanguage.ContextReference<LamaLanguageContext> REF =
        TruffleLanguage.ContextReference.create(LamaTruffleLanguage.class);
    
    public static LamaLanguageContext get(Node node) {
        return REF.get(node);
    }

    private static final Map<String, Object> builtins = new HashMap<>();
    public static final Set<String> builtinNames = Set.of("read", "write", "length", "string");
    public LamaLanguageContext(LamaTruffleLanguage language) {
        var builtinRead = new LamaRootNode(language, new BuiltinReadNode());
        var builtinWrite = new LamaRootNode(language, new BuiltinWriteNode());
        var builtinLength = new LamaRootNode(language, new BuiltinLengthNode());
        var builtinString = new LamaRootNode(language, new BuiltinStringNode());

        builtins.put("read", new FunctionObject(builtinRead.getCallTarget()));
        builtins.put("write", new FunctionObject(builtinWrite.getCallTarget()));
        builtins.put("length", new FunctionObject(builtinLength.getCallTarget()));
        builtins.put("string", new FunctionObject(builtinString.getCallTarget()));
    }

    public static boolean hasBuiltin(String varName) {
        return builtinNames.contains(varName);
    }

    public static Object getBuiltin(String varName) {
        return builtins.get(varName);
    }

    private final Map<String, Object> globals = new HashMap<>();

    public void declareGlobal(String varName) {
        globals.put(varName, Undefined.instance);
    }

    public boolean hasGlobal(String varName) {
        return globals.containsKey(varName);
    }

    public Object getGlobal(String varName) {
        return globals.get(varName);
    }

    public void setGlobal(String varName, Object value) {
        globals.put(varName, value);
    }
}
