package dxm.sasdk.exceptions;

public class ResponseErrorException extends Exception {
    public ResponseErrorException(String str) {
        super(str);
    }

    public ResponseErrorException(Throwable th2) {
        super(th2);
    }
}
