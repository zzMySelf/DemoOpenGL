package com.baidu.swan.apps.impl.ai.tts.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lorg/json/JSONObject;", "invoke", "(Lorg/json/JSONObject;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Context.kt */
final class Context$disableFloatView$2 extends Lambda implements Function1<JSONObject, Boolean> {
    public static final Context$disableFloatView$2 INSTANCE = new Context$disableFloatView$2();

    Context$disableFloatView$2() {
        super(1);
    }

    public final Boolean invoke(JSONObject $this$modelDataDelegate) {
        Intrinsics.checkNotNullParameter($this$modelDataDelegate, "$this$modelDataDelegate");
        return Boolean.valueOf($this$modelDataDelegate.optBoolean(Context.K_DISABLE_FLOAT_VIEW, false));
    }
}
