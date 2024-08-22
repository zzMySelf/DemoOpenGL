package com.sdk.base.module.manager;

import android.content.Context;
import android.content.Intent;
import com.sdk.base.api.CallBack;
import com.sdk.f.f;
import com.sdk.v.a;

public abstract class SDKManager {
    public static boolean closePermission = false;
    public static boolean isStrong = true;
    public static Context mContext = null;
    public static boolean smartTrust = true;
    public static String statisticalTestHost = "";
    public static String testHost = "";
    public static boolean useCache = true;
    public static String userAgent;

    public static void closePermission(boolean z) {
        closePermission = z;
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getStatisticalTestHost() {
        return statisticalTestHost;
    }

    public static String getTestHost() {
        return testHost;
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static void init(Context context, String str) {
        mContext = context;
        a.a(context).a((String) null, str);
    }

    public static void init(Context context, String str, String str2) {
        mContext = context;
        a.a(context).a(str, str2);
        Intent intent = new Intent();
        intent.setAction("com.wosdk.mybroad");
        intent.setPackage(mContext.getPackageName());
        mContext.sendBroadcast(intent);
    }

    public static boolean isClosePermission() {
        return closePermission;
    }

    public static boolean isIsStrong() {
        return isStrong;
    }

    public static boolean isSmartTrust() {
        return smartTrust;
    }

    public static void releaseConnect(Context context) {
        com.sdk.u.a.a(context);
    }

    public static void securityType(int i2) {
        String str;
        a.d = i2;
        if (i2 == 0) {
            str = "B";
        } else if (i2 == 2) {
            str = "C";
        } else {
            return;
        }
        a.e = str;
    }

    public static void setDebug(boolean z) {
        f.a = z;
    }

    public static void setDebugHead(boolean z) {
        f.c = z;
    }

    public static void setIsStrong(boolean z) {
        isStrong = z;
    }

    public static void setSmartTrust(boolean z) {
        smartTrust = z;
    }

    public static void setStatisticalTestHost(String str) {
        statisticalTestHost = str;
    }

    public static void setTestHost(String str) {
        testHost = str;
    }

    public static void setUseCache(boolean z) {
        useCache = z;
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }

    public static <T> void toFailed(CallBack<T> callBack, int i2, String str) {
        if (callBack != null) {
            callBack.onFailed(1, i2, str, (String) null);
        }
    }

    public static boolean useCache() {
        return useCache;
    }
}
