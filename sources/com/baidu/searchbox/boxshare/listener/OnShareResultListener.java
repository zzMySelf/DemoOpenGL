package com.baidu.searchbox.boxshare.listener;

import org.json.JSONObject;

public interface OnShareResultListener {
    void onCancel();

    void onFail(int i2, String str);

    void onStart();

    void onSuccess(JSONObject jSONObject);
}
