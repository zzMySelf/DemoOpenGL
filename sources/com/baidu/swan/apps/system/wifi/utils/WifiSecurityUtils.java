package com.baidu.swan.apps.system.wifi.utils;

import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import com.baidu.swan.apps.system.wifi.model.SwanWifiAccessData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class WifiSecurityUtils {
    public static final int SECURITY_TYPE_EAP = 3;
    public static final int SECURITY_TYPE_NONE = 0;
    public static final int SECURITY_TYPE_PSK = 2;
    public static final int SECURITY_TYPE_UNKNOWN = -1;
    public static final int SECURITY_TYPE_WEP = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SecurityType {
    }

    public static void setSecurityParams(WifiConfiguration wifiConfiguration, int securityType) {
        if (wifiConfiguration != null) {
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            switch (securityType) {
                case 0:
                    wifiConfiguration.allowedKeyManagement.set(0);
                    return;
                case 1:
                    wifiConfiguration.allowedKeyManagement.set(0);
                    wifiConfiguration.allowedAuthAlgorithms.set(0);
                    wifiConfiguration.allowedAuthAlgorithms.set(1);
                    return;
                case 2:
                    wifiConfiguration.allowedKeyManagement.set(1);
                    return;
                case 3:
                    wifiConfiguration.allowedKeyManagement.set(2);
                    wifiConfiguration.allowedKeyManagement.set(3);
                    return;
                default:
                    return;
            }
        }
    }

    public static int getSecurityType(String capabilities) {
        if (TextUtils.isEmpty(capabilities)) {
            return 0;
        }
        if (capabilities.contains("WEP")) {
            return 1;
        }
        if (capabilities.contains("PSK")) {
            return 2;
        }
        if (capabilities.contains("EAP")) {
            return 3;
        }
        return -1;
    }

    public static int getSecurityType(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null) {
            return -1;
        }
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            return 2;
        }
        if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            return 3;
        }
        if (wifiConfiguration.wepKeys[0] != null) {
            return 1;
        }
        if (wifiConfiguration.allowedKeyManagement.get(0)) {
            return 0;
        }
        return -1;
    }

    public static int getSecurityType(SwanWifiAccessData accessData) {
        if (accessData == null) {
            return -1;
        }
        if (TextUtils.isEmpty(accessData.identity) && TextUtils.isEmpty(accessData.password)) {
            return 0;
        }
        if (!TextUtils.isEmpty(accessData.identity) && !TextUtils.isEmpty(accessData.password)) {
            return 3;
        }
        if (!TextUtils.isEmpty(accessData.password)) {
            return 2;
        }
        return -1;
    }
}
