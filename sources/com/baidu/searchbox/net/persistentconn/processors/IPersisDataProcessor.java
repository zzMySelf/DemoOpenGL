package com.baidu.searchbox.net.persistentconn.processors;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public interface IPersisDataProcessor {
    boolean process(String str, List<JSONObject> list) throws JSONException;

    boolean process(String str, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException;
}
