package com.baidu.sapi2.utils;

public class PassCoreVHelper {
    static {
        System.loadLibrary("passport_core");
    }

    public static native String getAesIv();

    public static native String getAesKey();

    public static native String getOneKeyLoginAppKey();

    public static native String getOneKeyLoginAppSecret();

    public static native String getSofireAppKey();

    public static native String getSofireSecKey();
}
