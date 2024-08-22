package com.baidu.swan.pms.node;

import com.baidu.swan.pms.callback.PMSCallback;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AbsNodeProcessor implements INodeDataProcessor {
    public static final int DEFAULT_ERR_CODE = -1;

    public void process(JSONObject configData, PMSCallback coreCallback, PMSCallback gameCallback, PMSCallback soCallback) {
    }

    public void process(JSONArray configData, PMSCallback coreCallback, PMSCallback gameCallback, PMSCallback soCallback) {
    }

    /* access modifiers changed from: protected */
    public JSONObject getData(JSONObject config) {
        if (config != null && config.optInt("errno", -1) == 0) {
            return config.optJSONObject("data");
        }
        return null;
    }
}
