package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper;
import fe.fe.ddd.i.qw.qw;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Deprecated
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
    public static final String TAG = "NetWorkUtils";

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

    @Deprecated
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return getActiveNetworkInfo();
    }

    @Deprecated
    public static String getBSSID(@NonNull Context context) {
        return getBSSID();
    }

    @Deprecated
    public static int getIPAddress(@NonNull Context context) {
        return getIPAddress();
    }

    @Deprecated
    public static String getMacAddress(Context context) {
        return getMacAddress();
    }

    public static String getMobileNetworkType(int i2, String str) {
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

    @Deprecated
    public static String getNetworkClass(Context context) {
        return getNetworkClass();
    }

    @Deprecated
    public static int getNetworkId(@NonNull Context context) {
        return getNetworkId();
    }

    @Deprecated
    public static String getNetworkInfo(@NonNull Context context) {
        return getNetworkInfo();
    }

    @Deprecated
    public static NetType getNetworkType(Context context) {
        return getNetworkType();
    }

    @Deprecated
    public static String getWifiInfo(@NonNull Context context) {
        return getWifiInfo();
    }

    @Deprecated
    public static String getWifiName(@NonNull Context context) {
        return getWifiName();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static InetAddress intToInetAddress(int i2) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)});
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    @Deprecated
    public static boolean isHighNetworkConnected(Context context) {
        return isHighNetworkConnected();
    }

    @Deprecated
    public static boolean isMobileNetworkConnected(Context context) {
        return isMobileNetworkConnected();
    }

    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        return isNetworkConnected();
    }

    @Deprecated
    public static boolean isWapNetWorkConnected(@NonNull Context context) {
        return isWapNetWorkConnected();
    }

    @Deprecated
    public static boolean isWifiNetworkConnected(Context context) {
        return isWifiNetworkConnected();
    }

    public static NetworkInfo getActiveNetworkInfo() {
        return com.baidu.android.util.connect.NetWorkUtils.getActiveNetworkInfo(qw.qw());
    }

    public static String getBSSID() {
        WifiInfo connectionInfo = ((WifiManager) qw.qw().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return "NULL";
        }
        return connectionInfo.getBSSID();
    }

    public static int getIPAddress() {
        WifiInfo connectionInfo = ((WifiManager) qw.qw().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getIpAddress();
    }

    @SuppressLint({"HardwareIds"})
    public static String getMacAddress() {
        WifiInfo connectionInfo = ((WifiManager) qw.qw().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return "NULL";
        }
        return WifiInfoHelper.getMac(connectionInfo);
    }

    public static String getNetworkClass() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        return activeNetworkInfo.getType() == 0 ? getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName()) : "unknown";
    }

    public static int getNetworkId() {
        WifiInfo connectionInfo = ((WifiManager) qw.qw().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getNetworkId();
    }

    @Deprecated
    public static String getNetworkInfo() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WiFi";
        }
        if (activeNetworkInfo.getType() != 0) {
            return "unknown";
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return "5G";
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
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
                return "3G";
            case 13:
                return "4G";
            default:
                return "unknown";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.android.util.devices.NetWorkUtils.NetType getNetworkType() {
        /*
            java.lang.String r0 = getNetworkClass()
            int r1 = r0.hashCode()
            r2 = -840472412(0xffffffffcde768a4, float:-4.85299328E8)
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == r2) goto L_0x0068
            r2 = 1653(0x675, float:2.316E-42)
            if (r1 == r2) goto L_0x005e
            r2 = 1684(0x694, float:2.36E-42)
            if (r1 == r2) goto L_0x0054
            r2 = 1715(0x6b3, float:2.403E-42)
            if (r1 == r2) goto L_0x004a
            r2 = 1746(0x6d2, float:2.447E-42)
            if (r1 == r2) goto L_0x0040
            r2 = 3521(0xdc1, float:4.934E-42)
            if (r1 == r2) goto L_0x0036
            r2 = 3649301(0x37af15, float:5.11376E-39)
            if (r1 == r2) goto L_0x002c
            goto L_0x0072
        L_0x002c:
            java.lang.String r1 = "wifi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            r0 = 4
            goto L_0x0073
        L_0x0036:
            java.lang.String r1 = "no"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            r0 = 5
            goto L_0x0073
        L_0x0040:
            java.lang.String r1 = "5g"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            r0 = 3
            goto L_0x0073
        L_0x004a:
            java.lang.String r1 = "4g"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            r0 = 2
            goto L_0x0073
        L_0x0054:
            java.lang.String r1 = "3g"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            r0 = 1
            goto L_0x0073
        L_0x005e:
            java.lang.String r1 = "2g"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            r0 = 0
            goto L_0x0073
        L_0x0068:
            java.lang.String r1 = "unknow"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0072
            r0 = 6
            goto L_0x0073
        L_0x0072:
            r0 = -1
        L_0x0073:
            if (r0 == 0) goto L_0x0091
            if (r0 == r7) goto L_0x008e
            if (r0 == r6) goto L_0x008b
            if (r0 == r5) goto L_0x0088
            if (r0 == r4) goto L_0x0085
            if (r0 == r3) goto L_0x0082
            com.baidu.android.util.devices.NetWorkUtils$NetType r0 = com.baidu.android.util.devices.NetWorkUtils.NetType.UNKOWN
            return r0
        L_0x0082:
            com.baidu.android.util.devices.NetWorkUtils$NetType r0 = com.baidu.android.util.devices.NetWorkUtils.NetType.NONE
            return r0
        L_0x0085:
            com.baidu.android.util.devices.NetWorkUtils$NetType r0 = com.baidu.android.util.devices.NetWorkUtils.NetType.WIFI
            return r0
        L_0x0088:
            com.baidu.android.util.devices.NetWorkUtils$NetType r0 = com.baidu.android.util.devices.NetWorkUtils.NetType._5G
            return r0
        L_0x008b:
            com.baidu.android.util.devices.NetWorkUtils$NetType r0 = com.baidu.android.util.devices.NetWorkUtils.NetType._4G
            return r0
        L_0x008e:
            com.baidu.android.util.devices.NetWorkUtils$NetType r0 = com.baidu.android.util.devices.NetWorkUtils.NetType._3G
            return r0
        L_0x0091:
            com.baidu.android.util.devices.NetWorkUtils$NetType r0 = com.baidu.android.util.devices.NetWorkUtils.NetType._2G
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.devices.NetWorkUtils.getNetworkType():com.baidu.android.util.devices.NetWorkUtils$NetType");
    }

    public static String getWifiInfo() {
        WifiInfo connectionInfo = ((WifiManager) qw.qw().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return "NULL";
        }
        return connectionInfo.toString();
    }

    public static String getWifiName() {
        WifiInfo connectionInfo = ((WifiManager) qw.qw().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return "NULL";
        }
        return connectionInfo.getSSID();
    }

    public static boolean isHighNetworkConnected() {
        String networkClass = getNetworkClass();
        return "wifi".equals(networkClass) || "5g".equals(networkClass) || "4g".equals(networkClass) || "3g".equals(networkClass);
    }

    public static boolean isMobileNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
    }

    public static boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isWapNetWorkConnected() {
        return new ConnectManager(qw.qw().getApplicationContext()).isWapNetwork();
    }

    public static boolean isWifiNetworkConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }
}
