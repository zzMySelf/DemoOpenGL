package com.itextpdf.text.pdf;

public class BadPdfFormatException extends PdfException {
    public static final long serialVersionUID = 1802317735708833538L;

    public BadPdfFormatException() {
    }

    public BadPdfFormatException(String str) {
        super(str);
    }
}
