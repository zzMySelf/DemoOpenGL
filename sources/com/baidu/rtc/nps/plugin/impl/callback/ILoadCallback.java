package com.baidu.rtc.nps.plugin.impl.callback;

public interface ILoadCallback {
    public static final int INSTALL_FAIL = 400;
    public static final int INVOKE_FAIL = 410;
    public static final int NO_ERROR = 0;

    void onResult(int i2, int i3, String str);
}
