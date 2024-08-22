package com.baidu.android.imsdk.upload.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class RequsetNetworkUtils {
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String TAG = "RequsetNetworkUtils";
    public static ConnectivityManager mConnManager;
    public static TelephonyManager mTelephonyManager;

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (context == null) {
            return mConnManager;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && mConnManager == null) {
            mConnManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return mConnManager;
    }

    @SuppressLint({"SwitchIntDef"})
    public static String getMobileType(Context context) {
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager == null) {
            return "unknown";
        }
        switch (telephonyManager.getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
            case 18:
            case 19:
                return "4G";
            default:
                return "unknown";
        }
    }

    public static NetworkInfo getNetWorkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = getConnectivityManager(context.getApplicationContext());
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Exception e) {
            "exp: " + e.getMessage();
            return null;
        }
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        if (context == null) {
            return mTelephonyManager;
        }
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && mTelephonyManager == null) {
            mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return mTelephonyManager;
    }

    public static boolean isConnected(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        if (netWorkInfo != null) {
            return netWorkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo netWorkInfo = getNetWorkInfo(context);
        if (netWorkInfo == null || netWorkInfo.getType() != 1) {
            return false;
        }
        return true;
    }
}
