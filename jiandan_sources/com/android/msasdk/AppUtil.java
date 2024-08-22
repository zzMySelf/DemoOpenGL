package com.android.msasdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.Keep;

@Keep
public class AppUtil {
    @Keep
    public static native PackageInfo getAppInfo(Context context, String str);

    @Keep
    public static native boolean isDebuggable(Context context);

    @Keep
    public static native boolean isInstalled(Context context, String str);

    @Keep
    public static native boolean isSystemApp(Context context, String str);
}
