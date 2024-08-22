package com.baidu.swan.card.ioc.interfaces.ubc;

import java.util.Map;
import org.json.JSONObject;

public interface ICardStatRouter {
    CardStatFlow beginFlow(String str);

    void cancelFlow(CardStatFlow cardStatFlow);

    void endFlow(CardStatFlow cardStatFlow);

    void flowAddEvent(CardStatFlow cardStatFlow, String str, String str2);

    void flowAddEventWithDate(CardStatFlow cardStatFlow, String str, String str2, long j2);

    void flowSetValueWithDuration(CardStatFlow cardStatFlow, String str);

    void onEvent(String str, String str2);

    void onEvent(String str, Map<String, String> map);

    void onEvent(String str, JSONObject jSONObject);

    void recordUbcEvent(String str, String str2);

    void recordUbcEvent(String str, JSONObject jSONObject);
}
