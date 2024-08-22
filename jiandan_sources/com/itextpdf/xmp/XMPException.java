package com.itextpdf.xmp;

public class XMPException extends Exception {
    public int errorCode;

    public XMPException(String str, int i2) {
        super(str);
        this.errorCode = i2;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public XMPException(String str, int i2, Throwable th2) {
        super(str, th2);
        this.errorCode = i2;
    }
}
