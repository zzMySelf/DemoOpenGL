package com.baidu.swan.apps.llm.api;

import com.baidu.swan.apps.api.result.SwanApiResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Lcom/baidu/swan/apps/api/result/SwanApiResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanAiCallApi.kt */
final class SwanAiCallApi$checkStatusAndInvokeAiCall$1 extends Lambda implements Function1<SwanApiResult, Unit> {
    final /* synthetic */ String $cb;
    final /* synthetic */ SwanAiCallApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwanAiCallApi$checkStatusAndInvokeAiCall$1(SwanAiCallApi swanAiCallApi, String str) {
        super(1);
        this.this$0 = swanAiCallApi;
        this.$cb = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SwanApiResult) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SwanApiResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.this$0.invokeCallback(this.$cb, result);
    }
}
