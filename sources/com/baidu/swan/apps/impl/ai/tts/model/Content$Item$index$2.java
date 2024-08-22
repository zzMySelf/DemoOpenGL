package com.baidu.swan.apps.impl.ai.tts.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke", "(Lorg/json/JSONObject;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Content.kt */
final class Content$Item$index$2 extends Lambda implements Function1<JSONObject, Integer> {
    public static final Content$Item$index$2 INSTANCE = new Content$Item$index$2();

    Content$Item$index$2() {
        super(1);
    }

    public final Integer invoke(JSONObject $this$modelDataDelegate) {
        Intrinsics.checkNotNullParameter($this$modelDataDelegate, "$this$modelDataDelegate");
        return Integer.valueOf($this$modelDataDelegate.optInt("index"));
    }
}
