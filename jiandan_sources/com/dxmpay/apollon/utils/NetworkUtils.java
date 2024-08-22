package com.dxmpay.apollon.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public final class NetworkUtils {
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 3;
    public static final int NETWORK_4G = 4;
    public static final int NETWORK_5G = 5;
    public static final int NETWORK_NO_PERMISSION = -2;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final int NETWORK_TYPE_NR = 20;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NETWORK_UNAVAILABLE = -1;
    public static final int NETWORK_UNKNOW = 0;
    public static final int NETWORK_WIFI = 1;

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            LogUtil.e("", "NetworkStatus", e);
            return null;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static String getNetName(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        return (activeNetworkInfo.getTypeName() == null || activeNetworkInfo.getExtraInfo() == null) ? "" : activeNetworkInfo.getExtraInfo().toLowerCase();
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                if (activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        return 1;
                    }
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo2 != null) {
                        NetworkInfo.State state2 = networkInfo2.getState();
                        String subtypeName = networkInfo2.getSubtypeName();
                        if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                case 16:
                                    return 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                case 18:
                                    return 3;
                                case 13:
                                    return 4;
                                case 20:
                                    return 5;
                                default:
                                    if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                        return 3;
                                    }
                                    return 0;
                            }
                        }
                    }
                }
            }
            return -1;
        } catch (Exception e) {
            LogUtil.e(com.baidu.apollon.utils.NetworkUtils.a, "read networktype error", e);
            StatisticManager.onEventWithValue(StatServiceEvent.NET_TYPE_ERROR, e.toString());
            return -2;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(com.baidu.apollon.utils.NetworkUtils.a, "context is null!");
            }
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(com.baidu.apollon.utils.NetworkUtils.a, "couldn't get connectivity manager");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(com.baidu.apollon.utils.NetworkUtils.a, "network is not available");
            }
            return false;
        } else if (!ApollonConstants.DEBUG) {
            return true;
        } else {
            LogUtil.d(com.baidu.apollon.utils.NetworkUtils.a, "network is available");
            return true;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            boolean z = ApollonConstants.DEBUG;
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            boolean z2 = ApollonConstants.DEBUG;
            return false;
        }
        boolean z3 = ApollonConstants.DEBUG;
        return true;
    }

    public static boolean isNetworkRoaming(Context context) {
        TelephonyManager telephonyManager;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.v(com.baidu.apollon.utils.NetworkUtils.a, "couldn't get connectivity manager");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || !telephonyManager.isNetworkRoaming()) {
            return false;
        }
        if (!ApollonConstants.DEBUG) {
            return true;
        }
        LogUtil.v(com.baidu.apollon.utils.NetworkUtils.a, "network is roaming");
        return true;
    }

    public static boolean isWifiNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            if (ApollonConstants.DEBUG) {
                LogUtil.d(com.baidu.apollon.utils.NetworkUtils.a, "couldn't get connectivity manager");
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }
}
