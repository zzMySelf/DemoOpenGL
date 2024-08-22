package com.baidu.abtest.transmite.Exception;

public class TransmitException extends Exception {
    public int detailErrorCode = -1;
    public int failStatus = -1;

    public TransmitException() {
    }

    public int getDetailErrorCode() {
        return this.detailErrorCode;
    }

    public int getFailStatus() {
        return this.failStatus;
    }

    public TransmitException(String str) {
        super(str);
    }

    public TransmitException(int i2, String str) {
        super(str);
        this.failStatus = i2;
    }

    public TransmitException(int i2, int i3, String str) {
        super(str);
        this.failStatus = i2;
        this.detailErrorCode = i3;
    }
}
