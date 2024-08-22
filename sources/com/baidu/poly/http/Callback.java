package com.baidu.poly.http;

/* compiled from: SearchBox */
public class Callback<T> {
    public boolean isBdtls() {
        return false;
    }

    public boolean isEncrypt() {
        return false;
    }

    public void onError(Throwable th2, int i2, String str) {
    }

    @Deprecated
    public void onError(Throwable th2, String str) {
    }

    public void onSuccess(T t) {
    }
}
