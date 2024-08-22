package com.baidu.talos.core.devsupport.inspector.network;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.core.devsupport.inspector.DevToolsConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevToolsCookieManager {
    private static volatile DevToolsCookieManager mInstance;

    public static DevToolsCookieManager getInstance() {
        if (mInstance == null) {
            synchronized (DevToolsCookieManager.class) {
                if (mInstance == null) {
                    mInstance = new DevToolsCookieManager();
                }
            }
        }
        return mInstance;
    }

    public JSONObject getCookies(JSONArray urlList, String id) {
        if (urlList == null || urlList.length() <= 0) {
            return null;
        }
        JSONObject data = new JSONObject();
        JSONObject result = new JSONObject();
        JSONArray cookies = new JSONArray();
        for (int i2 = 0; i2 < urlList.length(); i2++) {
            String url = urlList.optString(i2);
            if (!TextUtils.isEmpty(url)) {
                String domain = Uri.parse(url).getHost();
                String cookie = TalosAdapterManager.getCookieManager().getCookie(url);
                if (!TextUtils.isEmpty(cookie)) {
                    try {
                        JSONObject jsonCookie = new JSONObject();
                        jsonCookie.put("domain", domain);
                        jsonCookie.put("value", cookie);
                        cookies.put(jsonCookie);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        try {
            result.put("cookies", cookies);
            data.put("result", result);
            try {
                data.put("id", Integer.parseInt(id));
            } catch (Throwable e3) {
                e3.printStackTrace();
            }
            data.put("method", DevToolsConstants.ACTION_NETWORK_GETCOOKIES);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return data;
    }
}
