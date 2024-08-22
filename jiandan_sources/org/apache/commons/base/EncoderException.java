package org.apache.commons.base;

public class EncoderException extends Exception {
    public static final long serialVersionUID = 1;

    public EncoderException() {
    }

    public EncoderException(String str) {
        super(str);
    }

    public EncoderException(String str, Throwable th2) {
        super(str, th2);
    }

    public EncoderException(Throwable th2) {
        super(th2);
    }
}
