package com.baidu.nadcore.utils;

import android.text.TextUtils;

public class UADUtils {
    public static boolean needInterceptLoadJs(String currentUrl, String lpUrl) {
        if (TextUtils.isEmpty(lpUrl) || TextUtils.isEmpty(currentUrl) || currentUrl.startsWith(lpUrl)) {
            return false;
        }
        return true;
    }
}
