package com.baidu.sapi2.callback;

import org.json.JSONObject;

public abstract class UbcUploadImplCallback {
    public abstract void onEvent(String str, JSONObject jSONObject);
}
