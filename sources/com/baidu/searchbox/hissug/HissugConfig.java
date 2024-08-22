package com.baidu.searchbox.hissug;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;

public final class HissugConfig {
    public static final String TAG = "HissugConfig";

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static boolean isDebug() {
        return AppConfig.isDebug();
    }
}
