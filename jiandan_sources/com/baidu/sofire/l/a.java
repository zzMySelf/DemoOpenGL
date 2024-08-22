package com.baidu.sofire.l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.IDevices;
import java.lang.reflect.Field;
import java.util.Collection;

public class a {
    public static String a = "";

    public static synchronized String a(Context context) {
        String[] strArr;
        String[] strArr2;
        synchronized (a.class) {
            if (!TextUtils.isEmpty(a)) {
                String str = a;
                return str;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                String b = b(context);
                a = b;
                if (!TextUtils.isEmpty(b)) {
                    String str2 = a;
                    return str2;
                }
            }
            if (TextUtils.isEmpty(a)) {
                String str3 = Build.CPU_ABI;
                a = str3;
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = a;
                    return str4;
                }
            }
            if (i2 >= 21) {
                if (TextUtils.isEmpty(a)) {
                    boolean c = c.c();
                    if (c && (strArr2 = Build.SUPPORTED_64_BIT_ABIS) != null && strArr2.length > 0) {
                        a = strArr2[0];
                    } else if (!c && (strArr = Build.SUPPORTED_32_BIT_ABIS) != null && strArr.length > 0) {
                        a = strArr[0];
                    }
                    if (!TextUtils.isEmpty(a)) {
                        String str5 = a;
                        return str5;
                    }
                }
            }
            return "";
        }
    }

    public static String b(Context context) {
        ApplicationInfo applicationInfo;
        try {
            if (Build.VERSION.SDK_INT < 21 || (applicationInfo = context.getApplicationInfo()) == null) {
                return "";
            }
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
            return "";
        }
    }

    public static String a(Context context, Collection<String> collection) {
        String[] strArr;
        String[] strArr2;
        if (Build.VERSION.SDK_INT >= 21) {
            String b = b(context);
            if (!TextUtils.isEmpty(b) && collection.contains(b)) {
                return b;
            }
            boolean c = c.c();
            if (c) {
                strArr = Build.SUPPORTED_64_BIT_ABIS;
            } else {
                strArr = Build.SUPPORTED_32_BIT_ABIS;
            }
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (collection.contains(str)) {
                        return str;
                    }
                }
            }
            if (c || !collection.contains("armeabi") || (strArr2 = Build.SUPPORTED_ABIS) == null || strArr2.length <= 0 || IDevices.ABI_MIPS.equals(strArr2[0])) {
                return "";
            }
            return "armeabi";
        }
        String str2 = Build.CPU_ABI;
        if (collection.contains(str2)) {
            return str2;
        }
        String str3 = Build.CPU_ABI2;
        if (collection.contains(str3)) {
            return str3;
        }
        if (!collection.contains("armeabi") || IDevices.ABI_MIPS.equals(str2)) {
            return "";
        }
        return "armeabi";
    }
}
