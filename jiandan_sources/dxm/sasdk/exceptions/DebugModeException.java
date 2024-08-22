package dxm.sasdk.exceptions;

public class DebugModeException extends RuntimeException {
    public DebugModeException(String str) {
        super(str);
    }

    public DebugModeException(Throwable th2) {
        super(th2);
    }
}
