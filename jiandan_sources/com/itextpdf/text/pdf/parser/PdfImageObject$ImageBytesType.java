package com.itextpdf.text.pdf.parser;

public enum PdfImageObject$ImageBytesType {
    PNG("png"),
    JPG("jpg"),
    JP2("jp2"),
    CCITT("tif"),
    JBIG2("jbig2");
    
    public final String fileExtension;

    /* access modifiers changed from: public */
    PdfImageObject$ImageBytesType(String str) {
        this.fileExtension = str;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }
}
