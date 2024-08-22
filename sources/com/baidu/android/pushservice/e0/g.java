package com.baidu.android.pushservice.e0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static ConnectivityManager f8363a;

    public static ConnectivityManager a(Context context) {
        if (context == null) {
            return f8363a;
        }
        if (f8363a == null) {
            f8363a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f8363a;
    }

    public static NetworkInfo b(Context context) {
        try {
            ConnectivityManager a2 = a(context.getApplicationContext());
            if (a2 != null) {
                return a2.getActiveNetworkInfo();
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public static String c(Context context) {
        if (!d(context)) {
            return "connectionless";
        }
        NetworkInfo b2 = b(context);
        int i2 = -1;
        if (b2 != null) {
            i2 = b2.getType();
        }
        switch (i2) {
            case 0:
                return "mobile";
            case 1:
                return "wifi";
            case 2:
                return "mobile_mms";
            case 3:
                return "mobile_supl";
            case 4:
                return "mobile_dun";
            case 5:
                return "mobile_hipri";
            case 6:
                return "wimax";
            default:
                return "connectionless";
        }
    }

    public static boolean d(Context context) {
        NetworkInfo b2 = b(context);
        if (b2 != null) {
            return b2.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean e(Context context) {
        NetworkInfo b2 = b(context);
        return b2 != null && b2.getType() == 1;
    }
}
