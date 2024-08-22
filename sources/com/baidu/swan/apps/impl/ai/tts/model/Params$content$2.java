package com.baidu.swan.apps.impl.ai.tts.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/swan/apps/impl/ai/tts/model/Content;", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Params.kt */
final class Params$content$2 extends Lambda implements Function1<JSONObject, Content> {
    public static final Params$content$2 INSTANCE = new Params$content$2();

    Params$content$2() {
        super(1);
    }

    public final Content invoke(JSONObject $this$modelDataDelegate) {
        Intrinsics.checkNotNullParameter($this$modelDataDelegate, "$this$modelDataDelegate");
        JSONArray it = $this$modelDataDelegate.optJSONArray("content");
        return it != null ? new Content(it) : new Content((JSONArray) null, 1, (DefaultConstructorMarker) null);
    }
}
