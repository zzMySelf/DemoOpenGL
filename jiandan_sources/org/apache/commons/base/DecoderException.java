package org.apache.commons.base;

public class DecoderException extends Exception {
    public static final long serialVersionUID = 1;

    public DecoderException() {
    }

    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(String str, Throwable th2) {
        super(str, th2);
    }

    public DecoderException(Throwable th2) {
        super(th2);
    }
}
