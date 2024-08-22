package com.itextpdf.text.exceptions;

import java.io.IOException;

public class BadPasswordException extends IOException {
    public static final long serialVersionUID = -4333706268155063964L;

    public BadPasswordException(String str) {
        super(str);
    }
}
