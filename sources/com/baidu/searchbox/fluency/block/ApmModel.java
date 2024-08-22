package com.baidu.searchbox.fluency.block;

import org.json.JSONObject;

public interface ApmModel<T> {
    boolean check();

    JSONObject toJson();

    T toModel(JSONObject jSONObject);
}
