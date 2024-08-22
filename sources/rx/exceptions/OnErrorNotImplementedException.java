package rx.exceptions;

public class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(String message, Throwable e2) {
        super(message, e2 != null ? e2 : new NullPointerException());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(Throwable e2) {
        super(e2 != null ? e2.getMessage() : null, e2 != null ? e2 : new NullPointerException());
    }
}
