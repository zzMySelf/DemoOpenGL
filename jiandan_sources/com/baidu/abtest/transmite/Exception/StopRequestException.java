package com.baidu.abtest.transmite.Exception;

public class StopRequestException extends TransmitException {
    public StopRequestException() {
    }

    public StopRequestException(String str) {
        super(str);
    }

    public StopRequestException(int i2, String str) {
        super(i2, str);
    }

    public StopRequestException(int i2, int i3, String str) {
        super(i2, i3, str);
    }
}
