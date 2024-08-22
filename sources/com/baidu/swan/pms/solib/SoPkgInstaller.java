package com.baidu.swan.pms.solib;

public interface SoPkgInstaller {
    public static final int RESULT_DEF = 0;
    public static final int RESULT_FAILED = 2;
    public static final int RESULT_NEED_FALLBACK = 5;
    public static final int RESULT_NEED_RELOAD = 3;
    public static final int RESULT_PATH_ERROR = 4;
    public static final int RESULT_SUCCEED = 1;

    public interface Callback {
        void onInstalled(int i2, String str);
    }

    void installSoPkg(String str, Callback callback);
}
