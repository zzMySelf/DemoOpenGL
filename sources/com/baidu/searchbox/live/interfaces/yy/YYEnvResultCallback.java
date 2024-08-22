package com.baidu.searchbox.live.interfaces.yy;

public interface YYEnvResultCallback {
    public static final int CODE_ENV_NOT_EXIST = -1;

    void onFail(int i2, String str);

    void onSuccess();
}
