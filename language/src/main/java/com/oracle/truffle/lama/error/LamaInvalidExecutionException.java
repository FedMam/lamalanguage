package com.oracle.truffle.lama.error;

public class LamaInvalidExecutionException extends LamaLanguageException {
    private final Class nodeClass;
    private final Class expectedType;
    private final Class actualType;

    public LamaInvalidExecutionException(Class nodeClass, Class expectedType, Class actualType) {
        super("invalid execution of " + nodeClass.getSimpleName() + ": expected " + expectedType + ", trying to execute as " + actualType);

        this.nodeClass = nodeClass;
        this.actualType = actualType;
        this.expectedType = expectedType;
    }

    public Class getNodeClass() {
        return nodeClass;
    }

    public Class getExpectedType() {
        return expectedType;
    }

    public Class getActualType() {
        return actualType;
    }
}