package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;
import org.json.JSONObject;

@Keep
public interface IShareResult {
    void shareResult(boolean z, JSONObject jSONObject);
}
