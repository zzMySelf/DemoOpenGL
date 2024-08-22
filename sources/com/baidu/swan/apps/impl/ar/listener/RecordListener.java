package com.baidu.swan.apps.impl.ar.listener;

public interface RecordListener {
    void onComplete(String str);

    void onFailure();

    void onProgress(int i2);
}
