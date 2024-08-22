package com.baidu.sapi2.callback;

public interface NetCallback {
    void onFailure(Throwable th2, int i2, String str);

    void onSuccess(int i2, String str);
}
