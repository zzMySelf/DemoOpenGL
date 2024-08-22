package com.baidu.ar.ihttp;

import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class HttpException extends Exception {
    public static final int HTTP_ERROR = 4;
    public static final int INVOKE_ERROR = 3;
    public static final int LIB_ERROR = 2;
    public static final int NET_ERROR = 1;
    public static final int UNKNOWN_ERROR = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f9714a;

    public HttpException(int i2, Exception exc) {
        super(exc);
        this.f9714a = i2;
    }

    public HttpException(int i2, String str) {
        super(str);
        this.f9714a = i2;
    }

    public HttpException(IOException iOException) {
        super(iOException);
        a(iOException);
    }

    private void a(IOException iOException) {
        this.f9714a = ((iOException instanceof ConnectException) || (iOException instanceof SocketTimeoutException) || (iOException instanceof NoRouteToHostException) || (iOException instanceof UnknownHostException)) ? 1 : iOException instanceof IOException ? -1 : 2;
    }

    public int getCode() {
        return this.f9714a;
    }
}
