package com.baidu.helios;

import android.os.Bundle;

public interface OnGetIdResultCallback<T> {
    void onError(int i2, Throwable th2, Bundle bundle);

    void onResult(T t, Bundle bundle);
}
