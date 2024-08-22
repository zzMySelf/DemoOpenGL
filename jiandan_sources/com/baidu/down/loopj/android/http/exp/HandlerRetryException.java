package com.baidu.down.loopj.android.http.exp;

public class HandlerRetryException extends RuntimeException {
    public HandlerRetryException() {
    }

    public HandlerRetryException(String str) {
        super(str);
    }
}
