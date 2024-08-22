package com.baidu.swan.apps.event.message;

import com.baidu.swan.apps.event.JSEventDispatcher;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SwanAppCustomMessage extends SwanAppBaseMessage {
    protected final Map<String, Object> mParams = new HashMap();

    public SwanAppCustomMessage(String event) {
        this.mEventName = event;
    }

    public void put(String key, Object value) {
        this.mParams.put(key, value);
    }

    public boolean putValueToData(String key, Object value) {
        Object data = this.mParams.get("data");
        if (data == null) {
            data = new JSONObject();
            this.mParams.put("data", data);
        }
        if (!(data instanceof JSONObject)) {
            return false;
        }
        SwanAppJSONUtils.setValue((JSONObject) data, key, value);
        return true;
    }

    public String genSetDataStatement(String eventVar) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> param : this.mParams.entrySet()) {
            Object value = param.getValue();
            if (value instanceof JSONObject) {
                builder.append(JSEventDispatcher.genJSVarKeyValue(eventVar, param.getKey(), (JSONObject) value));
            } else {
                builder.append(JSEventDispatcher.genJSVarKeyValue(eventVar, param.getKey(), value));
            }
        }
        return builder.toString();
    }
}
