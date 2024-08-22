package com.baidu.swan.games.uuap;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.binding.model.JSObjectMap;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.setting.oauth.ScopeInfo;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.games.binding.model.JSCommonResult;
import com.baidu.swan.games.utils.SwanGameAsyncCallbackUtils;
import com.baidu.webkit.sdk.CookieManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SwanGameUuapApi {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String ERROR_MSG_INTERNAL_ERROR = "internal error";
    private static final String PARAM_DOMAIN = "domain";
    private static final String TAG = "SwanGameUuapApi";
    private static final String UUAP_COOKIE_DEFAULT_DOMAIN = "baidu.com";
    private static final String UUAP_P_TOKEN = "UUAP_P_TOKEN";
    private static final String UUAP_P_TOKEN_OFFLINE = "UUAP_P_TOKEN_OFFLINE";
    private static final String UUAP_S_TOKEN = "UUAP_S_TOKEN";

    public static void getUUAPInfo(JsObject jsObj) {
        final JSObjectMap jsObjectMap = JSObjectMap.parseFromJSObject(jsObj);
        if (jsObjectMap != null) {
            SwanApp swanApp = SwanApp.getOrNull();
            if (swanApp == null) {
                callFailureCallback(jsObjectMap, "internal error");
                return;
            }
            final String domain = jsObjectMap.optString("domain", "baidu.com");
            if (DEBUG) {
                Log.i(TAG, "getUUAPInfo-domain: " + domain);
            }
            swanApp.getSetting().checkAuthorize("mapp_uuap_info", new TypedCallback<ScopeInfo>() {
                public void onCallback(ScopeInfo msg) {
                    if (msg == null || msg.forbidden || msg.tipStatus != 1) {
                        SwanGameUuapApi.callFailureCallback(JSObjectMap.this, "system deny");
                    } else {
                        SwanGameUuapApi.getUUAPInfoAfterAuthorize(JSObjectMap.this, domain);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void getUUAPInfoAfterAuthorize(JSObjectMap jsObjectMap, String domain) {
        SwanGameUuapJsResult info = new SwanGameUuapJsResult();
        String cookieString = CookieManager.getInstance().getCookie(domain);
        if (!TextUtils.isEmpty(cookieString)) {
            Map<String, String> cookieMap = parseCookie(cookieString);
            info.uuap_p_token = cookieMap.get(UUAP_P_TOKEN);
            info.uuap_p_token_offline = cookieMap.get(UUAP_P_TOKEN_OFFLINE);
            info.uuap_s_token = cookieMap.get(UUAP_S_TOKEN);
        }
        SwanGameAsyncCallbackUtils.call(jsObjectMap, true, info);
    }

    /* access modifiers changed from: private */
    public static void callFailureCallback(JSObjectMap jsObjectMap, String errMsg) {
        JSCommonResult result = new JSCommonResult();
        result.errMsg = errMsg;
        SwanGameAsyncCallbackUtils.call(jsObjectMap, false, result);
    }

    private static Map<String, String> parseCookie(String cookieString) {
        Map<String, String> cookieMap = new HashMap<>();
        for (String oneCookie : cookieString.split(";")) {
            if (oneCookie != null && oneCookie.contains("=")) {
                int position = oneCookie.indexOf("=");
                cookieMap.put(oneCookie.substring(0, position).trim().toUpperCase(Locale.US), oneCookie.substring(position + 1));
            }
        }
        return cookieMap;
    }
}
