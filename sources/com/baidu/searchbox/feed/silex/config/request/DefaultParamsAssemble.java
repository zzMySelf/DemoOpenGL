package com.baidu.searchbox.feed.silex.config.request;

import android.text.TextUtils;
import com.baidu.searchbox.feed.silex.config.IParamsAssemble;
import com.baidu.searchbox.feed.silex.infrastructure.remotedata.request.DefaultRequest;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DefaultParamsAssemble implements IParamsAssemble {
    public void assembleParams(Map<String, String> map, Map<String, String> postParams) {
        try {
            boolean isRestful = TextUtils.equals(postParams.get(DefaultRequest.POST_IS_RESTFUL), "1");
            String dataStr = postParams.get("data");
            if (dataStr != null) {
                JSONObject dataJson = new JSONObject(dataStr);
                if (!isRestful) {
                    JSONObject innerDataJson = dataJson.optJSONObject("data");
                    customPostParamsOuterLayerDataJson(dataJson);
                    customPostParamsDataJson(innerDataJson);
                } else {
                    customPostParamsDataJson(dataJson);
                }
                postParams.put("data", dataJson.toString());
            }
        } catch (JSONException e2) {
        }
    }

    /* access modifiers changed from: protected */
    public void customPostParamsDataJson(JSONObject dataJson) {
    }

    /* access modifiers changed from: protected */
    public void customPostParamsOuterLayerDataJson(JSONObject dataJson) {
    }
}
