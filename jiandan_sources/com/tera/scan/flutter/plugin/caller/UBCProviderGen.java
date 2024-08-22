package com.tera.scan.flutter.plugin.caller;

import android.app.Application;
import android.os.Bundle;
import androidx.annotation.Keep;
import org.json.JSONObject;

@Keep
public interface UBCProviderGen {
    void initUBCContext(Application application);

    void onEventStatistics(String str, String str2, String str3, String str4, String str5, String str6);

    void onEventStatistics(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject);

    void onEventStatistics(String str, JSONObject jSONObject);

    Bundle onFlowEventBeginStatistics(String str, JSONObject jSONObject);

    void onFlowEventEndStatistics(Bundle bundle);

    void onUBCContext();
}
