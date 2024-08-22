package com.cmic.sso.sdk.auth;

import org.json.JSONObject;

public interface TokenListener {
    void onGetTokenComplete(JSONObject jSONObject);
}
