package com.baidu.netdisk.transfer.transmitter.throwable;

public class StopRequestException extends Exception {
    private static final long serialVersionUID = 3600587640602555997L;
    public int mFinalStatus;

    private StopRequestException() {
    }

    public StopRequestException(int finalStatus, String message) {
        super(message);
        this.mFinalStatus = finalStatus;
    }

    public StopRequestException(int finalStatus, String message, Throwable throwable) {
        super(message, throwable);
        this.mFinalStatus = finalStatus;
    }
}
