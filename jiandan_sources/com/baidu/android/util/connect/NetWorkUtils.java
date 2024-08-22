package com.baidu.android.util.connect;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

public class NetWorkUtils {
    public static final boolean DEBUG = false;
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_5G = "5g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final long NOT_NEED_REFRESH = 0;
    public static final int NOT_OPT_NETWORK = 0;
    public static final int OPT_NETWORK_BY_BROADCAST = 1;
    public static final int OPT_NETWORK_BY_NETWORKCALLBACK = 2;
    public static final String TAG = "NetWorkUtils";
    public static volatile ConnectivityManager.NetworkCallback sNetworkCallback;
    public static volatile AtomicLong sNetworkChangedCounter = new AtomicLong(0);
    public static volatile NetworkInfo sNetworkInfo;
    public static volatile BroadcastReceiver sNetworkReceiver;

    public enum NetType {
        NONE("no"),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        _5G("5g"),
        UNKOWN("unknow");
        
        public final String type;

        /* access modifiers changed from: public */
        NetType(String str) {
            this.type = str;
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        Class<NetWorkUtils> cls = NetWorkUtils.class;
        if (context == null) {
            return null;
        }
        try {
            if (DoveRuntime.getIDoveIoc() != null) {
                if (DoveRuntime.getIDoveIoc() == null || DoveRuntime.getIDoveIoc().getNetworkOptType() != 0) {
                    if (Build.VERSION.SDK_INT < 24 || DoveRuntime.getIDoveIoc().getNetworkOptType() != 2) {
                        if (sNetworkReceiver == null) {
                            synchronized (cls) {
                                if (sNetworkReceiver == null) {
                                    sNetworkInfo = getActiveNetworkInfoBySystemService(context);
                                    sNetworkReceiver = new BroadcastReceiver() {
                                        public void onReceive(Context context, Intent intent) {
                                            if (intent.getAction().equals(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION)) {
                                                NetWorkUtils.sNetworkChangedCounter.incrementAndGet();
                                            }
                                        }
                                    };
                                    context.getApplicationContext().registerReceiver(sNetworkReceiver, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
                                }
                            }
                        }
                    } else if (sNetworkCallback == null) {
                        synchronized (cls) {
                            if (sNetworkCallback == null) {
                                sNetworkInfo = getActiveNetworkInfoBySystemService(context);
                                sNetworkCallback = new ConnectivityManager.NetworkCallback() {
                                    public void onAvailable(Network network) {
                                        NetWorkUtils.sNetworkChangedCounter.incrementAndGet();
                                    }

                                    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                                        NetWorkUtils.sNetworkChangedCounter.incrementAndGet();
                                    }

                                    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                                        NetWorkUtils.sNetworkChangedCounter.incrementAndGet();
                                    }

                                    public void onLost(Network network) {
                                        NetWorkUtils.sNetworkChangedCounter.incrementAndGet();
                                    }
                                };
                                ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(sNetworkCallback);
                            }
                        }
                    }
                    long j = sNetworkChangedCounter.get();
                    if (j > 0) {
                        sNetworkInfo = getActiveNetworkInfoBySystemService(context);
                        sNetworkChangedCounter.compareAndSet(j, 0);
                    } else {
                        NetworkInfo networkInfo = sNetworkInfo;
                        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
                            sNetworkInfo = getActiveNetworkInfoBySystemService(context);
                        }
                    }
                    return sNetworkInfo;
                }
            }
            return getActiveNetworkInfoBySystemService(context);
        } catch (Exception unused) {
        }
    }

    public static NetworkInfo getActiveNetworkInfoBySystemService(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static String getBSSID(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "NULL";
        }
        return connectionInfo.getBSSID();
    }

    public static int getIPAddress(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return 0;
        }
        return connectionInfo.getIpAddress();
    }

    public static String getMobileType(int i2, String str) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
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
                return "3g";
            case 13:
            case 18:
            case 19:
                return "4g";
            case 20:
                return "5g";
            default:
                return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) ? "unknown" : "4g";
        }
    }

    public static int getNetworkId(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return 0;
        }
        return connectionInfo.getNetworkId();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.android.util.connect.NetWorkUtils.NetType getNetworkType(android.content.Context r7) {
        /*
            java.lang.String r7 = getNetworkTypeString(r7)
            int r0 = r7.hashCode()
            r1 = -284840886(0xffffffffef05ac4a, float:-4.136979E28)
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r0 == r1) goto L_0x0068
            r1 = 1653(0x675, float:2.316E-42)
            if (r0 == r1) goto L_0x005e
            r1 = 1684(0x694, float:2.36E-42)
            if (r0 == r1) goto L_0x0054
            r1 = 1715(0x6b3, float:2.403E-42)
            if (r0 == r1) goto L_0x004a
            r1 = 1746(0x6d2, float:2.447E-42)
            if (r0 == r1) goto L_0x0040
            r1 = 3521(0xdc1, float:4.934E-42)
            if (r0 == r1) goto L_0x0036
            r1 = 3649301(0x37af15, float:5.11376E-39)
            if (r0 == r1) goto L_0x002c
            goto L_0x0072
        L_0x002c:
            java.lang.String r0 = "wifi"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0072
            r7 = 4
            goto L_0x0073
        L_0x0036:
            java.lang.String r0 = "no"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0072
            r7 = 5
            goto L_0x0073
        L_0x0040:
            java.lang.String r0 = "5g"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0072
            r7 = 3
            goto L_0x0073
        L_0x004a:
            java.lang.String r0 = "4g"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0072
            r7 = 2
            goto L_0x0073
        L_0x0054:
            java.lang.String r0 = "3g"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0072
            r7 = 1
            goto L_0x0073
        L_0x005e:
            java.lang.String r0 = "2g"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0072
            r7 = 0
            goto L_0x0073
        L_0x0068:
            java.lang.String r0 = "unknown"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0072
            r7 = 6
            goto L_0x0073
        L_0x0072:
            r7 = -1
        L_0x0073:
            if (r7 == 0) goto L_0x0091
            if (r7 == r6) goto L_0x008e
            if (r7 == r5) goto L_0x008b
            if (r7 == r4) goto L_0x0088
            if (r7 == r3) goto L_0x0085
            if (r7 == r2) goto L_0x0082
            com.baidu.android.util.connect.NetWorkUtils$NetType r7 = com.baidu.android.util.connect.NetWorkUtils.NetType.UNKOWN
            return r7
        L_0x0082:
            com.baidu.android.util.connect.NetWorkUtils$NetType r7 = com.baidu.android.util.connect.NetWorkUtils.NetType.NONE
            return r7
        L_0x0085:
            com.baidu.android.util.connect.NetWorkUtils$NetType r7 = com.baidu.android.util.connect.NetWorkUtils.NetType.WIFI
            return r7
        L_0x0088:
            com.baidu.android.util.connect.NetWorkUtils$NetType r7 = com.baidu.android.util.connect.NetWorkUtils.NetType._5G
            return r7
        L_0x008b:
            com.baidu.android.util.connect.NetWorkUtils$NetType r7 = com.baidu.android.util.connect.NetWorkUtils.NetType._4G
            return r7
        L_0x008e:
            com.baidu.android.util.connect.NetWorkUtils$NetType r7 = com.baidu.android.util.connect.NetWorkUtils.NetType._3G
            return r7
        L_0x0091:
            com.baidu.android.util.connect.NetWorkUtils$NetType r7 = com.baidu.android.util.connect.NetWorkUtils.NetType._2G
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.connect.NetWorkUtils.getNetworkType(android.content.Context):com.baidu.android.util.connect.NetWorkUtils$NetType");
    }

    public static String getNetworkTypeString(Context context) {
        if (context == null) {
            return "unknown";
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return getMobileType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName());
        }
        return "unknown";
    }

    public static String getWifiInfo(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "NULL";
        }
        return connectionInfo.toString();
    }

    public static String getWifiName(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "NULL";
        }
        return connectionInfo.getSSID();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static InetAddress intToInetAddress(int i2) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)});
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isHighNetworkConnected(Context context) {
        String networkTypeString = getNetworkTypeString(context);
        return "wifi".equals(networkTypeString) || "5g".equals(networkTypeString) || "4g".equals(networkTypeString) || "3g".equals(networkTypeString);
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }
}
