package com.baidu.swan.apps.account;

public interface OnSwanAppLoginResultListener {
    public static final int AUTH_THIRD_PHONE = 1010;
    public static final int CANCELED = -2;
    public static final int FAILED = -1;
    public static final int SUCCESS = 0;

    void onResult(int i2);
}
