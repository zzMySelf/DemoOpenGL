package com.baidu.down.loopj.android.http;

import java.io.IOException;

public class HttpResponseException extends IOException {
    private int mStatusCode;

    public HttpResponseException(int status, String msg) {
        super(msg);
        this.mStatusCode = status;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
