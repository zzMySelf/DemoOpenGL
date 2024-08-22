package com.baidu.swan.card.settings.oauth;

public class OAuthException extends RuntimeException {
    public final int mErrorCode;

    public OAuthException(int errorCode) {
        this.mErrorCode = errorCode;
    }

    public OAuthException(String message, int errorCode) {
        super(message);
        this.mErrorCode = errorCode;
    }

    public OAuthException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.mErrorCode = errorCode;
    }

    public OAuthException(Throwable cause, int errorCode) {
        super(cause);
        this.mErrorCode = errorCode;
    }

    public OAuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.mErrorCode = errorCode;
    }
}
