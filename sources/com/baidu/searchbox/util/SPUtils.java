package com.baidu.searchbox.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class SPUtils {
    private static final String SEARCH_H5_FLOATING_ENABLE = "h5_floating_enable";
    private static final String SEARCH_H5_FLOATING_SP = "com.baidu.searchbox.search.h5.video.pref";

    public static boolean getBooleanPreferenceInSP(Context context, String spName, String key, boolean defaultValue) {
        SharedPreferences preferences;
        if (context == null || (preferences = context.getSharedPreferences(spName, 0)) == null) {
            return defaultValue;
        }
        return preferences.getBoolean(key, defaultValue);
    }

    public static boolean isH5FloatingEnable() {
        return getBooleanPreferenceInSP(AppRuntime.getAppContext(), SEARCH_H5_FLOATING_SP, "h5_floating_enable", false);
    }
}
