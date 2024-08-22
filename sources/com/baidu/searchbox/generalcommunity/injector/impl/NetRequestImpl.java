package com.baidu.searchbox.generalcommunity.injector.impl;

import com.baidu.searchbox.generalcommunity.injector.NetRequestFactory;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class NetRequestImpl implements NetRequestFactory {
    public JSONObject buildBusinessParams(boolean isPullToRefresh) {
        return null;
    }

    public Map<String, Object> buildExtPostParams() {
        return null;
    }

    public String provideShieldUrl() {
        return null;
    }

    public JSONObject customWrapPostJson(JSONObject postJson) throws JSONException {
        return postJson;
    }

    public Map<String, String> buildUrlParams(boolean isPullToRefresh) {
        return null;
    }

    public Map<String, String> buildExtraParams() {
        return null;
    }
}
