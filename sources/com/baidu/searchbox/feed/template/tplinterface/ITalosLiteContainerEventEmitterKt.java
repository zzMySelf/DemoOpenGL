package com.baidu.searchbox.feed.template.tplinterface;

import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getIntersectionParamsJson", "Lorg/json/JSONObject;", "ratio", "", "lib-feed-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ITalosLiteContainerEventEmitter.kt */
public final class ITalosLiteContainerEventEmitterKt {
    public static final JSONObject getIntersectionParamsJson(float ratio) {
        JSONObject params = new JSONObject();
        try {
            params.put("status", Float.valueOf(ratio));
        } catch (JSONException e2) {
        }
        return params;
    }
}
