package com.google.zxing;

public final class WriterException extends Exception {
    public WriterException() {
    }

    public WriterException(String str) {
        super(str);
    }

    public WriterException(Throwable th2) {
        super(th2);
    }
}
