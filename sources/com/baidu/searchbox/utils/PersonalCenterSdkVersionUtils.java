package com.baidu.searchbox.utils;

import android.os.Build;

public class PersonalCenterSdkVersionUtils {
    public static boolean versionCompare(int targetVersion) {
        return Build.VERSION.SDK_INT >= targetVersion;
    }
}
