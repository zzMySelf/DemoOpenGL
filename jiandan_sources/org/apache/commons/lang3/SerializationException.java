package org.apache.commons.lang3;

public class SerializationException extends RuntimeException {
    public static final long serialVersionUID = 4029025366392702726L;

    public SerializationException() {
    }

    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(Throwable th2) {
        super(th2);
    }

    public SerializationException(String str, Throwable th2) {
        super(str, th2);
    }
}
