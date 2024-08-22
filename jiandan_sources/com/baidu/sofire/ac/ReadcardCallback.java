package com.baidu.sofire.ac;

public interface ReadcardCallback {
    void onBegin();

    void onFailure(int i2, String str, String str2);

    void onSuccess(String str);
}
