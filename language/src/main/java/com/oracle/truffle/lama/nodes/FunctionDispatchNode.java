package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.GenerateInline;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.FunctionObject;

@GenerateInline(true)
public abstract class FunctionDispatchNode extends Node {
    public abstract Object executeDispatch(Node node, Object function, Object[] arguments);

    @Specialization(guards = "function.getCallTarget() == directCallNode.getCallTarget()", limit = "2")
    protected static Object dispatchDirectly(
            FunctionObject function, Object[] arguments,
            @Cached(value="create(function.getCallTarget())", inline=false) DirectCallNode directCallNode) {
        return directCallNode.call(arguments);
    }

    @Specialization(replaces = "dispatchDirectly")
    protected static Object dispatchIndirectly(
            FunctionObject function, Object[] arguments,
            @Cached(inline=false) IndirectCallNode indirectCallNode) {
        return indirectCallNode.call(function.getCallTarget(), arguments);
    }

    @Fallback
    protected static Object targetIsNotAFunction(
            Object nonFunction, Object[] arguments)  {
        throw new LamaLanguageException("'" + nonFunction + "' is not a function");
    }
}
