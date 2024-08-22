package com.dxmbumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    public static final long serialVersionUID = 1;
    public final int statusCode;

    public HttpException(int i2) {
        this("Http request failed", i2);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Deprecated
    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i2) {
        this(str, i2, (Throwable) null);
    }

    public HttpException(String str, int i2, @Nullable Throwable th2) {
        super(str + ", status code: " + i2, th2);
        this.statusCode = i2;
    }
}
