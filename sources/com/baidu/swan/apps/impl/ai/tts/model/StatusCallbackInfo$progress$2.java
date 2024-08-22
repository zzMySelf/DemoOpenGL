package com.baidu.swan.apps.impl.ai.tts.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lorg/json/JSONObject;", "it", "", "invoke", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StatusCallbackInfo.kt */
final class StatusCallbackInfo$progress$2 extends Lambda implements Function2<JSONObject, String, Integer> {
    public static final StatusCallbackInfo$progress$2 INSTANCE = new StatusCallbackInfo$progress$2();

    StatusCallbackInfo$progress$2() {
        super(2);
    }

    public final Integer invoke(JSONObject $this$modelDataDelegate, String it) {
        Intrinsics.checkNotNullParameter($this$modelDataDelegate, "$this$modelDataDelegate");
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf($this$modelDataDelegate.optInt(it));
    }
}
