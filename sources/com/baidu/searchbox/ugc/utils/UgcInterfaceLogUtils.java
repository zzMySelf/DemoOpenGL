package com.baidu.searchbox.ugc.utils;

import android.util.Log;
import com.baidu.searchbox.publisher.export.interfaces.BuildConfig;

public class UgcInterfaceLogUtils {
    public static final boolean DEBUG = BuildConfig.DEBUG;
    private static final String TAG = UgcInterfaceLogUtils.class.getSimpleName();

    public static void d(Object... args) {
        if (DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object obj : args) {
                stringBuilder.append(obj);
                stringBuilder.append("; ");
            }
            Log.d(TAG, stringBuilder.toString());
        }
    }
}
