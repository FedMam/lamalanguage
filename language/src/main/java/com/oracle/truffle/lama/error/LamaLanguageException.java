package com.oracle.truffle.lama.error;

public class LamaLanguageException extends RuntimeException {
    public LamaLanguageException() {
        super();
    }

    public LamaLanguageException(String message) {
        super(message);
    }

    public LamaLanguageException(Throwable cause) {
        super(cause);
    }

    public LamaLanguageException(String message, Throwable cause) {
        super(message, cause);
    }

    public LamaLanguageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}