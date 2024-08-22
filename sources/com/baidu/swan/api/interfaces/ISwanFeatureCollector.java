package com.baidu.swan.api.interfaces;

import java.util.List;
import org.json.JSONObject;

public interface ISwanFeatureCollector {
    List<String> extractSchemeParams();

    JSONObject getConsumeParams();

    void sendSwanFeature(JSONObject jSONObject);
}
