package com.baidu.swan.card.api.component.context;

import org.json.JSONObject;

public interface ISwanAppComponentModel extends IModel, Cloneable {
    void updateModel(JSONObject jSONObject);
}
