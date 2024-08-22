package com.google.zxing.searchbox;

public abstract class ReaderException extends Exception {
    ReaderException() {
    }

    public final Throwable fillInStackTrace() {
        return null;
    }
}
