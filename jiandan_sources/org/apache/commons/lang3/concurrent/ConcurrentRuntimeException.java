package org.apache.commons.lang3.concurrent;

public class ConcurrentRuntimeException extends RuntimeException {
    public static final long serialVersionUID = -6582182735562919670L;

    public ConcurrentRuntimeException() {
    }

    public ConcurrentRuntimeException(Throwable th2) {
        super(ConcurrentUtils.checkedException(th2));
    }

    public ConcurrentRuntimeException(String str, Throwable th2) {
        super(str, ConcurrentUtils.checkedException(th2));
    }
}
