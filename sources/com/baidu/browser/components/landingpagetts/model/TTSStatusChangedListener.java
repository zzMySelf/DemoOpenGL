package com.baidu.browser.components.landingpagetts.model;

import org.json.JSONObject;

public interface TTSStatusChangedListener {
    public static final int CODE_ERROR = 102;
    public static final int CODE_NET_WORK_ERROR = 100;
    public static final int CODE_PARSE_ERROR = 101;

    void onCancel();

    void onFailed(int i2);

    void onStart();

    void onSuccess(JSONObject jSONObject);
}
