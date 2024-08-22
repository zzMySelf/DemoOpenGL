package com.baidu.down.loopj.android.http.exp;

import java.io.IOException;

public class RetryStrategyException extends IOException {
    public RetryStrategyException() {
    }

    public RetryStrategyException(String str) {
        super(str);
    }
}
