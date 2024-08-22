package com.baidu.searchbox.aps.center.callback;

import org.json.JSONObject;

public abstract class PresetCallback {
    public static final String META_DATA_NAME = "aps.plugin.callback.preset";

    public abstract void handleParsePresetInHost(String str, JSONObject jSONObject);

    public void exportDataInHost() {
    }
}
