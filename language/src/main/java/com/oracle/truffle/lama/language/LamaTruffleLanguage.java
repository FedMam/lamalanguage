package com.oracle.truffle.lama.language;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.Env;
import com.oracle.truffle.api.TruffleLanguage.ParsingRequest;
import com.oracle.truffle.lama.nodes.LamaRootNode;
import com.oracle.truffle.lama.parser.LamaTruffleParser;

@TruffleLanguage.Registration(id = "lama", name = "Lama")
public final class LamaTruffleLanguage extends TruffleLanguage<LamaLanguageContext> {
    public LamaTruffleLanguage() {
        super();
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        LamaRootNode rootNode = LamaTruffleParser.parse(this, request.getSource().getReader());
        return rootNode.getCallTarget();
    }

    @Override
    protected LamaLanguageContext createContext(Env env) {
        return new LamaLanguageContext(this);
    }
}
