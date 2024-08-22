package com.baidu.bdtask.framework.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.bdtask.framework.service.a;

public class AppUtils {
    private static String sBoxVersionCode;
    private static String sBoxVersionName;
    private static String sPackageName;

    public static String getPackageName() {
        if (TextUtils.isEmpty(sPackageName)) {
            sPackageName = a.f10840a.getEnvService().getAppContext().getPackageName();
        }
        return sPackageName;
    }

    public static String getVersionCode() {
        if (TextUtils.isEmpty(sBoxVersionCode)) {
            try {
                Context appContext = a.f10840a.getEnvService().getAppContext();
                sBoxVersionCode = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionCode + "";
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return sBoxVersionCode;
    }

    public static String getVersionName() {
        if (TextUtils.isEmpty(sBoxVersionName)) {
            try {
                Context appContext = a.f10840a.getEnvService().getAppContext();
                sBoxVersionName = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName + "";
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return sBoxVersionName;
    }
}
