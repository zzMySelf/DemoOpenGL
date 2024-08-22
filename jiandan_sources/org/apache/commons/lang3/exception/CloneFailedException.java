package org.apache.commons.lang3.exception;

public class CloneFailedException extends RuntimeException {
    public static final long serialVersionUID = 20091223;

    public CloneFailedException(String str) {
        super(str);
    }

    public CloneFailedException(Throwable th2) {
        super(th2);
    }

    public CloneFailedException(String str, Throwable th2) {
        super(str, th2);
    }
}
