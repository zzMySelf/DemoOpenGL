package com.cmic.sso.sdk.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.alipay.sdk.m.s.a;

public class f {
    public static String a(Context context) {
        String str = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            String str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(d(context), 0));
            if (str2 != null) {
                return str2;
            }
            try {
                PackageInfo c = c(context);
                if (c == null) {
                    return null;
                }
                return context.getResources().getString(c.applicationInfo.labelRes);
            } catch (Exception e) {
                e = e;
                str = str2;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return str;
        }
    }

    public static String b(Context context) {
        try {
            PackageInfo c = c(context);
            if (c == null) {
                return "";
            }
            return d(context) + a.n + c.versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static PackageInfo c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(Context context) {
        PackageInfo c = c(context);
        if (c == null) {
            return "";
        }
        return c.packageName;
    }
}
