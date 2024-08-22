package org.apache.commons.lang3.concurrent;

public class ConcurrentException extends Exception {
    public static final long serialVersionUID = 6622707671812226130L;

    public ConcurrentException() {
    }

    public ConcurrentException(Throwable th2) {
        super(ConcurrentUtils.checkedException(th2));
    }

    public ConcurrentException(String str, Throwable th2) {
        super(str, ConcurrentUtils.checkedException(th2));
    }
}
