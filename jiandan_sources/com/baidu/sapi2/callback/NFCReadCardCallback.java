package com.baidu.sapi2.callback;

public interface NFCReadCardCallback {
    void onBegin();

    void onFailure(int i2, String str, String str2);

    void onSuccess(String str);
}
