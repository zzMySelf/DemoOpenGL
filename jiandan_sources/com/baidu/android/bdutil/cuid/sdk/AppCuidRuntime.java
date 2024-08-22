package com.baidu.android.bdutil.cuid.sdk;

public class AppCuidRuntime {
    public static IAppCuidManager getAppCuidManager() {
        return new DefaultIAppCuidManager();
    }
}
