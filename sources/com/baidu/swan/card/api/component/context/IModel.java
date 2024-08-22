package com.baidu.swan.card.api.component.context;

import org.json.JSONException;
import org.json.JSONObject;

public interface IModel {
    boolean isValid();

    void parseFromJson(JSONObject jSONObject) throws JSONException;
}
