package com.alipay.sdk.m.a0;

import android.os.Build;
import java.io.File;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f2092a = new e();

    public static e a() {
        return f2092a;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception e2) {
            return str2;
        }
    }

    public static String b() {
        return "android";
    }

    public static boolean c() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i2 = 0;
        while (i2 < 5) {
            try {
                if (new File(strArr[i2] + "su").exists()) {
                    return true;
                }
                i2++;
            } catch (Exception e2) {
            }
        }
        return false;
    }

    public static boolean d() {
        try {
            return Build.HARDWARE.contains("goldfish") || Build.PRODUCT.contains("sdk") || Build.FINGERPRINT.contains("generic");
        } catch (Exception e2) {
            return false;
        }
    }

    public static String e() {
        return Build.BOARD;
    }

    public static String f() {
        return Build.BRAND;
    }

    public static String g() {
        return Build.DEVICE;
    }

    public static String h() {
        return Build.DISPLAY;
    }

    public static String i() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String j() {
        return Build.MANUFACTURER;
    }

    public static String k() {
        return Build.MODEL;
    }

    public static String l() {
        return Build.PRODUCT;
    }

    public static String m() {
        return Build.VERSION.RELEASE;
    }

    public static String n() {
        return Build.VERSION.SDK;
    }

    public static String o() {
        return Build.TAGS;
    }

    public static String p() {
        return a("ro.kernel.qemu", "0");
    }
}
