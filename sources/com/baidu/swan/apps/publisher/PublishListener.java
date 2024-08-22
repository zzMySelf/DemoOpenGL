package com.baidu.swan.apps.publisher;

import org.json.JSONObject;

public interface PublishListener {
    void onCancel();

    void onPublish(JSONObject jSONObject);
}
