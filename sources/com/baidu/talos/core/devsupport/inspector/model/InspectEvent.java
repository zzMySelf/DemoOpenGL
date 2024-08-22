package com.baidu.talos.core.devsupport.inspector.model;

import android.util.Log;
import com.baidu.talos.core.Debug;
import org.json.JSONObject;

public class InspectEvent {
    private final String method;
    private final JSONObject paramsObject;

    public InspectEvent(String method2, JSONObject paramsObject2) {
        this.method = method2;
        this.paramsObject = paramsObject2;
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("method", this.method);
            jsonObject.put("params", this.paramsObject);
            return jsonObject.toString();
        } catch (Exception e2) {
            if (!Debug.isDebug()) {
                return null;
            }
            Log.e("InspectEvent", "toJson, exception:", e2);
            return null;
        }
    }
}
