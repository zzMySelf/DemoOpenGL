package com.baidu.searchbox.video.feedflow.push;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PushClickDoneServiceImpl.kt */
final class PushClickDoneServiceImpl$onPushClickDone$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JSONObject $paramsObj;
    final /* synthetic */ JSONObject $transVideoInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushClickDoneServiceImpl$onPushClickDone$1(JSONObject jSONObject, JSONObject jSONObject2) {
        super(0);
        this.$transVideoInfo = jSONObject;
        this.$paramsObj = jSONObject2;
    }

    public final void invoke() {
        PushIntoVideoFlowUtilsKt.handlePushPrerender(this.$transVideoInfo, this.$paramsObj);
    }
}
