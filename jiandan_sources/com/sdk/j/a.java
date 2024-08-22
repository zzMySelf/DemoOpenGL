package com.sdk.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.sdk.f.f;
import java.security.MessageDigest;
import java.util.Stack;

public class a extends com.sdk.i.a {
    public static final String a = "com.sdk.j.a";
    public static boolean b = f.a;

    static {
        new Stack();
    }

    @SuppressLint({"NewApi"})
    public static int a() {
        int i2;
        try {
            i2 = Build.VERSION.SDK_INT;
            try {
                com.sdk.o.a.a("android ：", String.valueOf(i2), Boolean.valueOf(b));
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            i2 = -1;
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            return i2;
        }
        return i2;
    }

    public static String a(Context context) {
        if (context == null) {
            com.sdk.i.a.a(a, "getAppLable", "mContext 为空", b);
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
        /*
            if (r2 == 0) goto L_0x0036
            java.lang.Boolean r0 = com.sdk.o.a.a(r3)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x000d
            goto L_0x0036
        L_0x000d:
            android.content.pm.PackageManager r0 = r2.getPackageManager()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r2 = c(r2)     // Catch:{ Exception -> 0x0026 }
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r0.getApplicationInfo(r2, r1)     // Catch:{ Exception -> 0x0026 }
            if (r2 == 0) goto L_0x0036
            android.os.Bundle r2 = r2.metaData     // Catch:{ Exception -> 0x0026 }
            if (r2 == 0) goto L_0x0036
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0037
        L_0x0026:
            r2 = move-exception
            java.lang.String r3 = a
            java.lang.String r2 = r2.getMessage()
            boolean r0 = b
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.sdk.o.a.b(r3, r2, r0)
        L_0x0036:
            r2 = 0
        L_0x0037:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Boolean r3 = com.sdk.o.a.a(r2)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0045
            java.lang.String r2 = com.sdk.v.a.c
        L_0x0045:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.j.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr, String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        byte[] digest = instance.digest();
        String str2 = "";
        for (int i2 = 0; i2 < digest.length; i2++) {
            if (i2 != 0) {
                str2 = str2 + ":";
            }
            String hexString = Integer.toHexString(digest[i2] & 255);
            if (hexString.length() == 1) {
                str2 = str2 + "0";
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e) {
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        int i2 = packageInfo.applicationInfo.flags;
        try {
            return a(packageInfo.signatures[0].toByteArray(), "MD5");
        } catch (Exception e2) {
            com.sdk.o.a.a(a, e2.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }

    public static String c(Context context) {
        if (context == null) {
            com.sdk.o.a.c(a, "mContext 为空", Boolean.valueOf(b));
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }

    public static int d(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c(context), 1);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            return -1;
        }
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }
}
