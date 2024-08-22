package com.baidu.searchbox.lockscreen.net;

import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.lockscreen.bridge.LockScreenRuntime;
import com.baidu.searchbox.lockscreen.model.LockScreenFlowModel;
import com.baidu.searchbox.lockscreen.util.LockScreenConfig;
import com.baidu.searchbox.privacy.FeedIdentityManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class LockScreenRequester {
    private static final String KEY_ACTION = "action";
    private static final String KEY_CMD = "cmd";
    private static final String VALUE_ACTION = "feed";

    public static void getLockScreenFlow(Map<String, String> getParams, Map<String, String> postParams, ResponseCallback<LockScreenFlowModel> listener, String tag) {
        String url = UrlUtil.addParam(getBaseUrl("202"), getParams);
        if (url.startsWith("https://")) {
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(LockScreenRuntime.getAppContext()).postFormRequest().tag(tag)).url(url)).params(postParams)).cookieManager(LockScreenRuntime.getLockScreenInterface().newCookieManagerInstance(true, false))).connectionTimeout(3000)).build().executeAsyncOnUIBack(listener);
            return;
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(LockScreenRuntime.getAppContext()).postFormRequest().tag(tag)).url(url)).params(postParams)).connectionTimeout(3000)).build().executeAsyncOnUIBack(listener);
    }

    public static String getBaseUrl(String cmd) {
        return FeedIdentityManager.processUrl(UrlUtil.addParam(UrlUtil.addParam(LockScreenConfig.getLockScreenBaseUrl(), "action", "feed"), "cmd", cmd));
    }

    private static Map<String, String> jsonToMap(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Map<String, String> params = new HashMap<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            params.put(key, jsonObject.optString(key));
        }
        return params;
    }
}
