package com.baidu.android.util.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class PkgUtils {
    public static final String TAG = "PkgUtils";

    public static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String getPackageSourcePath(Context context) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.sourceDir;
        }
        return null;
    }

    public static String getPackageVersion(Context context, String str) {
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures.length <= 0) {
                return "";
            }
            return packageInfo.signatures[0].toCharsString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getSignByPermission(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPermissionInfo(str, 128).packageName;
        } catch (Exception unused) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        return getSign(context, str2);
    }
}
