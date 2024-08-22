package com.itextpdf.text.pdf.fonts.otf;

public class FontReadingException extends Exception {
    public static final long serialVersionUID = 1;

    public FontReadingException(String str) {
        super(str);
    }

    public FontReadingException(String str, Exception exc) {
        super(str, exc);
    }
}
