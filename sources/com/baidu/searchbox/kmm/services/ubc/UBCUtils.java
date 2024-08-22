package com.baidu.searchbox.kmm.services.ubc;

import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002\u001a$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u001a$\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u001a\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002\u001a\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"flowMap", "", "", "Lcom/baidu/ubc/Flow;", "paramsMap", "ubcService", "Lcom/baidu/ubc/UBCManager;", "getUbcService", "()Lcom/baidu/ubc/UBCManager;", "ubcService$delegate", "Lkotlin/Lazy;", "getJsonFromMap", "Lorg/json/JSONObject;", "map", "", "", "ubcEvent", "", "eventId", "params", "ubcFlowBegin", "ubcFlowCancel", "ubcFlowEnd", "com.baidu.searchbox.kmm.services.ubc"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UBCUtils.kt */
public final class UBCUtils {
    private static final Map<String, Flow> flowMap = new ConcurrentHashMap();
    private static final Map<String, String> paramsMap = new ConcurrentHashMap();
    private static final Lazy ubcService$delegate = LazyKt.lazy(UBCUtils$ubcService$2.INSTANCE);

    private static final UBCManager getUbcService() {
        Object value = ubcService$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ubcService>(...)");
        return (UBCManager) value;
    }

    public static final void ubcEvent(String eventId, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        String paramString = "";
        boolean z = true;
        if (params == null || !(!params.isEmpty())) {
            z = false;
        }
        if (z) {
            String jSONObject = getJsonFromMap(params).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJsonFromMap(params).toString()");
            paramString = jSONObject;
        }
        getUbcService().onEvent(eventId, paramString, 0);
    }

    public static final void ubcFlowBegin(String eventId, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        String paramString = "";
        boolean z = false;
        if (params != null && (!params.isEmpty())) {
            z = true;
        }
        if (z) {
            String jSONObject = getJsonFromMap(params).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getJsonFromMap(params).toString()");
            paramString = jSONObject;
        }
        Map<String, Flow> map = flowMap;
        if (!map.containsKey(eventId)) {
            Flow beginFlow = getUbcService().beginFlow(eventId, paramString);
            Intrinsics.checkNotNullExpressionValue(beginFlow, "ubcService.beginFlow(eventId, paramString)");
            map.put(eventId, beginFlow);
            paramsMap.put(eventId, paramString);
        }
    }

    public static final void ubcFlowEnd(String eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Map<String, Flow> map = flowMap;
        if (map.containsKey(eventId)) {
            Map<String, String> map2 = paramsMap;
            getUbcService().flowSetValueWithDuration(map.get(eventId), map2.get(eventId));
            getUbcService().flowEnd(map.get(eventId));
            map.remove(eventId);
            map2.remove(eventId);
        }
    }

    public static final void ubcFlowCancel(String eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Map<String, Flow> map = flowMap;
        if (map.containsKey(eventId)) {
            getUbcService().flowCancel(map.get(eventId));
            map.remove(eventId);
        }
    }

    private static final JSONObject getJsonFromMap(Map<String, ? extends Object> map) {
        JSONObject jsonData = new JSONObject();
        for (String key : map.keySet()) {
            JSONArray jSONArray = map.get(key);
            if (jSONArray instanceof Map) {
                jSONArray = getJsonFromMap((Map) jSONArray);
            }
            if (jSONArray instanceof List) {
                JSONArray jsonArray = new JSONArray();
                for (Object it : (Iterable) jSONArray) {
                    if (it instanceof Map) {
                        jsonArray.put(getJsonFromMap((Map) it));
                    }
                }
                jSONArray = jsonArray;
            }
            jsonData.put(key, jSONArray);
        }
        return jsonData;
    }
}
