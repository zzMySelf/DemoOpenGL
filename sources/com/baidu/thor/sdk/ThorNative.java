package com.baidu.thor.sdk;

public class ThorNative {
    public static Long sNativePtr = Long.valueOf(nativeCreate());

    static {
        System.loadLibrary("thor-native");
    }

    public static native boolean isInlineInit();

    public static native boolean isPLTInit();

    public static native long nativeBackup();

    private static native long nativeCreate();
}
