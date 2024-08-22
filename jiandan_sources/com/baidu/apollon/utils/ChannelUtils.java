package com.baidu.apollon.utils;

public final class ChannelUtils {
    public static boolean a = false;
    public static String b = null;
    public static String c = "";
    public static String d;

    public static String getHostPackageName() {
        return c;
    }

    public static String getHostUA() {
        return d;
    }

    public static String getSDKVersion() {
        return b;
    }

    public static void initBussinessParams(String str, boolean z) {
        b = str;
        a = z;
    }

    public static void initHostParams(String str) {
        d = str;
    }

    public static boolean isSpecailPackage() {
        return a;
    }

    public static void setHostPackageName(String str) {
        c = str;
    }
}
