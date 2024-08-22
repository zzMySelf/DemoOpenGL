package com.baidu.sapi2.callback.inner;

import org.json.JSONArray;

public interface GetOnlineAppCallback {
    void onFailure();

    void onSuccess(JSONArray jSONArray);
}
