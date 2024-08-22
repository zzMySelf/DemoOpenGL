package com.itextpdf.text;

public class DocumentException extends Exception {
    public static final long serialVersionUID = -2191131489390840739L;

    public DocumentException(Exception exc) {
        super(exc);
    }

    public DocumentException() {
    }

    public DocumentException(String str) {
        super(str);
    }
}
