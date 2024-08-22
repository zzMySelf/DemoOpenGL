package com.baidu.searchbox.panorama.exception;

public class PanoramaException extends Exception {
    private int mErrorCode;
    private String mErrorInfo;

    public PanoramaException(int errorCode) {
        this(errorCode, "");
    }

    public PanoramaException(String errorInfo) {
        this(-1, errorInfo);
    }

    public PanoramaException(int errorCode, String errorInfo) {
        this.mErrorCode = errorCode;
        this.mErrorInfo = errorInfo;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorInfo() {
        return this.mErrorInfo;
    }
}
