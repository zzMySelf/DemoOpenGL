package com.baidu.searchbox.net;

import android.text.TextUtils;
import com.baidu.common.ua.CustomOSInfo;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpUAManager;
import com.baidu.searchbox.http.ProductUserAgentHandler;
import com.baidu.searchbox.network.NetworkRuntime;
import com.baidu.swan.config.ISwanConfig;
import com.baidu.swan.config.SwanConfigRuntime;
import okhttp3.internal.Version;

public class UserAgentManager {
    private static final String EMPTY_CHAR = " ";
    private static CustomOSInfo customOSInfo;

    public static String getUserAgent() {
        return generateUserAgent(Version.userAgent());
    }

    public static String generateUserAgent(String originalUserAgent) {
        ISwanConfig swanConfig = SwanConfigRuntime.getContext();
        if (swanConfig != null && swanConfig.enableSwanVersionUAExt()) {
            originalUserAgent = originalUserAgent + " " + swanConfig.getSwanNativeVersionGroup();
        }
        if (customOSInfo == null) {
            customOSInfo = new CustomOSInfo();
        }
        String osInfo = customOSInfo.getOSUserAgent();
        if (!TextUtils.isEmpty(osInfo)) {
            originalUserAgent = originalUserAgent + " " + osInfo;
        }
        ProductUserAgentHandler productUserAgent = HttpManager.getProductUserAgent();
        String defaultUserAgent = HttpUAManager.getDefaultUserAgent(NetworkRuntime.getAppContext());
        if (productUserAgent == null || TextUtils.isEmpty(productUserAgent.getProductUserAgent())) {
            return originalUserAgent + " " + defaultUserAgent;
        }
        return originalUserAgent + " " + encodeIllegalInfo(productUserAgent.getProductUserAgent());
    }

    private static String encodeIllegalInfo(String userAgentInfo) {
        StringBuilder sb = new StringBuilder();
        int length = userAgentInfo.length();
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = userAgentInfo.charAt(i2);
            if (c2 <= 31 || c2 >= 127) {
                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c2)}));
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }
}
