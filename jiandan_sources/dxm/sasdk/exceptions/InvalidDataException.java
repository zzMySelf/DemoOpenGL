package dxm.sasdk.exceptions;

public class InvalidDataException extends Exception {
    public InvalidDataException(String str) {
        super(str);
    }

    public InvalidDataException(Throwable th2) {
        super(th2);
    }
}
