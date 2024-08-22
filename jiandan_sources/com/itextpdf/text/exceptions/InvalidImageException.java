package com.itextpdf.text.exceptions;

public class InvalidImageException extends RuntimeException {
    public static final long serialVersionUID = -1319471492541702697L;
    public final Throwable cause;

    public InvalidImageException(String str) {
        this(str, (Throwable) null);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public InvalidImageException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }
}
