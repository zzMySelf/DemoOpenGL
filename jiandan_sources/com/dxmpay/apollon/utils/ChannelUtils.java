package com.dxmpay.apollon.utils;

public final class ChannelUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static String f4076ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static String f4077de = "";

    /* renamed from: fe  reason: collision with root package name */
    public static String f4078fe;
    public static boolean qw;

    public static String getHostPackageName() {
        return f4077de;
    }

    public static String getHostUA() {
        return f4078fe;
    }

    public static String getSDKVersion() {
        return f4076ad;
    }

    public static void initBussinessParams(String str, boolean z) {
        f4076ad = str;
        qw = z;
    }

    public static void initHostParams(String str) {
        f4078fe = str;
    }

    public static boolean isSpecailPackage() {
        return qw;
    }

    public static void setHostPackageName(String str) {
        f4077de = str;
    }
}
