package com.baidu.swan.apps.impl.setting.oauth;

import android.os.Bundle;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.net.SearchBoxCookieManager;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;

public class SwanAppCookieDelegation extends ProviderDelegation {
    public static final String ARG_1 = "param1";
    public static final String ARG_2 = "param2";
    public static final String RESULT = "result";
    public static final String TYPE = "type";
    public static final int TYPE_GET_COOKIE = 4;
    public static final int TYPE_SHOULD_ACCEPT_COOKIE = 1;
    public static final int TYPE_SHOULD_SEND_COOKIE = 2;
    public static final int TYPE_STORE_COOKIE = 3;

    public Bundle execCall(Bundle params) {
        int type = params.getInt("type");
        CookieManager manager = new SearchBoxCookieManager(false, false);
        String httpUrl = params.getString(ARG_1);
        Bundle r = new Bundle();
        switch (type) {
            case 1:
                r.putBoolean("result", manager.shouldAcceptCookie(httpUrl, params.getString(ARG_2)));
                return r;
            case 2:
                r.putBoolean("result", manager.shouldSendCookie(httpUrl, params.getString(ARG_2)));
                return r;
            case 3:
                manager.storeCookie(httpUrl, params.getStringArrayList(ARG_2));
                return r;
            case 4:
                r.putString("result", manager.getCookie(httpUrl));
                return r;
            default:
                return r;
        }
    }
}
