package com.baidu.swan.apps.adaptation.interfaces;

import org.json.JSONObject;

public interface IInnerSkipChecker {
    boolean isNeedCheckOrAuthorize(JSONObject jSONObject);
}
