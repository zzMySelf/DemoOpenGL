package com.google.zxing;

public final class ChecksumException extends ReaderException {
    public static final ChecksumException INSTANCE;

    static {
        ChecksumException checksumException = new ChecksumException();
        INSTANCE = checksumException;
        checksumException.setStackTrace(ReaderException.NO_TRACE);
    }

    public ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.isStackTrace ? new ChecksumException() : INSTANCE;
    }

    public ChecksumException(Throwable th2) {
        super(th2);
    }

    public static ChecksumException getChecksumInstance(Throwable th2) {
        return ReaderException.isStackTrace ? new ChecksumException(th2) : INSTANCE;
    }
}
