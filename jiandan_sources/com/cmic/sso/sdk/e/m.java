package com.cmic.sso.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.cmic.sso.sdk.a;
import java.lang.reflect.Method;

public class m {
    public static final String a = Build.BRAND;
    public static final String b = Build.MODEL;
    public static final String c = (SapiDeviceInfo.OS_TYPE + Build.VERSION.RELEASE);
    public static final boolean d = (Build.VERSION.SDK_INT <= 28);
    public static final String e = Build.MANUFACTURER;

    public static int a(Context context, boolean z, a aVar) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            NetworkInfo networkInfo = null;
            if (connectivityManager != null) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo != null) {
                if (networkInfo.isAvailable()) {
                    int type = networkInfo.getType();
                    if (type == 1) {
                        c.b("TelephonyUtils", "WIFI");
                        boolean a2 = g.a(context, "android.permission.CHANGE_NETWORK_STATE");
                        c.a("TelephonyUtils", "CHANGE_NETWORK_STATE=" + a2);
                        if (!a2 || !z || !a(connectivityManager, context, aVar)) {
                            return 2;
                        }
                        c.b("TelephonyUtils", "流量数据 WIFI 同开");
                        return 3;
                    }
                    if (type == 0) {
                        c.b("TelephonyUtils", "流量");
                        return 1;
                    }
                    return 0;
                }
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String b() {
        return b;
    }

    public static String c() {
        return c;
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        String str = e;
        c.a(UrlOcrConfig.IdCardKey.OS_BRAND, str);
        return "HUAWEI".equalsIgnoreCase(str);
    }

    public static boolean a(ConnectivityManager connectivityManager, Context context, a aVar) {
        boolean z = false;
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            z = ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            c.b("TelephonyUtils", "data is on ---------" + z);
            if (Build.VERSION.SDK_INT >= 26) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && g.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    if (telephonyManager.createForSubscriptionId(SubscriptionManager.getDefaultSubscriptionId()).isDataEnabled()) {
                        aVar.a("networkTypeByAPI", "1");
                    } else {
                        aVar.a("networkTypeByAPI", "0");
                    }
                }
            } else {
                aVar.a("networkTypeByAPI", "-1");
            }
            return z;
        } catch (Exception unused) {
            c.a("TelephonyUtils", "isMobileEnabled ----反射出错-----");
            return z;
        }
    }

    public static String a() {
        return a;
    }

    public static boolean a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || 1 != telephonyManager.getSimState()) {
            return true;
        }
        return false;
    }
}
