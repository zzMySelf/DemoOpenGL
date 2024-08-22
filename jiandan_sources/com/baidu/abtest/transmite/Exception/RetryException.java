package com.baidu.abtest.transmite.Exception;

public class RetryException extends TransmitException {
    public RetryException() {
    }

    public RetryException(String str) {
        super(str);
    }

    public RetryException(int i2, String str) {
        super(i2, str);
    }

    public RetryException(int i2, int i3, String str) {
        super(i2, i3, str);
    }
}
