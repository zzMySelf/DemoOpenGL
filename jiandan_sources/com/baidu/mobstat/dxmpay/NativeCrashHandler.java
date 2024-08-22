package com.baidu.mobstat.dxmpay;

import android.content.Context;
import java.io.File;

public final class NativeCrashHandler {
    public static boolean qw = true;

    static {
        try {
            System.loadLibrary("crash_analysis");
        } catch (Throwable unused) {
        }
    }

    public static native void nativeException();

    public static native void nativeInit(String str);

    public static native void nativeProcess(String str);

    public static native void nativeUnint();

    public static void qw(Context context) {
        if (context != null && qw) {
            File cacheDir = context.getCacheDir();
            if (cacheDir.exists() && cacheDir.isDirectory()) {
                try {
                    nativeInit(cacheDir.getAbsolutePath());
                } catch (Throwable unused) {
                }
            }
        }
    }
}
