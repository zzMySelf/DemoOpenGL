package io.reactivex.exceptions;

public final class ProtocolViolationException extends IllegalStateException {
    public static final long serialVersionUID = 1644750035281290266L;

    public ProtocolViolationException(String str) {
        super(str);
    }
}
