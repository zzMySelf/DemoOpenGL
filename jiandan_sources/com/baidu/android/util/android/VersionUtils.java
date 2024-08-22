package com.baidu.android.util.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import fe.fe.ddd.i.qw.qw;

public class VersionUtils {
    public static final String TAG = "VersionUtils";
    public static String sBoxVersionCode;
    public static String sBoxVersionName;

    public static String getVersionCode(Context context) {
        Context qw = qw.qw();
        if (TextUtils.isEmpty(sBoxVersionCode)) {
            try {
                PackageInfo packageInfo = qw.getPackageManager().getPackageInfo(qw.getPackageName(), 0);
                sBoxVersionCode = packageInfo.versionCode + "";
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sBoxVersionCode;
    }

    public static String getVersionName() {
        return getVersionName(qw.qw());
    }

    public static String readFourDotVersionName() {
        Bundle bundle;
        Context qw = qw.qw();
        try {
            ApplicationInfo applicationInfo = qw.getPackageManager().getApplicationInfo(qw.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return "";
            }
            return bundle.getString("versionName");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getVersionName(Context context) {
        Context qw = qw.qw();
        if (TextUtils.isEmpty(sBoxVersionName)) {
            try {
                PackageInfo packageInfo = qw.getPackageManager().getPackageInfo(qw.getPackageName(), 0);
                sBoxVersionName = packageInfo.versionName + "";
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sBoxVersionName;
    }
}
