package com.itextpdf.text;

public class BadElementException extends DocumentException {
    public static final long serialVersionUID = -799006030723822254L;

    public BadElementException(Exception exc) {
        super(exc);
    }

    public BadElementException() {
    }

    public BadElementException(String str) {
        super(str);
    }
}
