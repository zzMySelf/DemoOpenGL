package com.itextpdf.text.exceptions;

import java.io.IOException;

public class InvalidPdfException extends IOException {
    public static final long serialVersionUID = -2319614911517026938L;
    public final Throwable cause;

    public InvalidPdfException(String str) {
        this(str, (Throwable) null);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public InvalidPdfException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }
}
