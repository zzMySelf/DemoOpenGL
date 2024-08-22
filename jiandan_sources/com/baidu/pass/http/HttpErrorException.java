package com.baidu.pass.http;

import com.baidu.pass.a;

public class HttpErrorException extends Exception implements a {
    public int statusCode;

    public HttpErrorException() {
    }

    public HttpErrorException(int i2, String str) {
        super(str);
        this.statusCode = i2;
    }
}
