package com.baidu.swan.card.api.network.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.card.api.network.interceptor.SafeRedirectInterceptor;
import com.baidu.swan.card.card.SwanCard;
import com.baidu.swan.card.card.SwanCardManager;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.pkg.config.SwanCardCommonConfigData;
import com.baidu.swan.card.pkg.config.SwanCardConfigData;
import com.baidu.swan.card.render.ua.SwanCardUserAgent;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;

public class SwanCardNetwork {
    private static final String TAG = "SwanNetworkImpl";

    public static boolean isDebug() {
        return SwanAppLibConfig.DEBUG;
    }

    public static Context getAppContext() {
        return AppRuntime.getAppContext();
    }

    public static CookieManager getCookieManager() {
        return SwanCardRuntime.getSwanCardContext().createCookieManager();
    }

    public static String getUserAgent() {
        String userAgent = SwanAppNetworkUtils.getRequestUserAgent();
        if (!TextUtils.isEmpty(userAgent) || !SwanCardHttpManager.getDefault().enableFrameworkUa()) {
            return userAgent;
        }
        return SwanCardUserAgent.getSwanUA();
    }

    public static int getConnectionTimeout(String cardId) {
        return SwanCardCommonConfigData.NetworkConfig.readRequestTimeout(getNetworkConfig(cardId));
    }

    public static int getReadTimeout(String cardId) {
        return SwanCardCommonConfigData.NetworkConfig.readRequestTimeout(getNetworkConfig(cardId));
    }

    public static int getWriteTimeout(String cardId) {
        return SwanCardCommonConfigData.NetworkConfig.readRequestTimeout(getNetworkConfig(cardId));
    }

    public static List<Interceptor> networkInterceptors() {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new SafeRedirectInterceptor());
        return interceptors;
    }

    public static boolean enableFrameworkUA() {
        return SwanCardRuntime.getSwanCardContext().getBooleanABSwitch("bbasm_framework_request_with_ua", true);
    }

    private static SwanCardCommonConfigData.NetworkConfig getNetworkConfig(String cardId) {
        SwanCard swanCard = SwanCardManager.get().getCard(cardId);
        if (!swanCard.hasAppOccupied()) {
            if (SwanAppLibConfig.DEBUG) {
                Log.e(TAG, "swanapp is null");
            }
            return null;
        }
        SwanCardConfigData config = swanCard.getConfig();
        if (config != null && config.mNetworkConfig != null) {
            return config.mNetworkConfig;
        }
        if (SwanAppLibConfig.DEBUG) {
            Log.e(TAG, "config or mNetworkConfig is null");
        }
        return null;
    }
}
