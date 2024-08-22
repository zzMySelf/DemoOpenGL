package com.baidu.swan.apps.impl.ai.summary;

import com.baidu.swan.apps.impl.ai.tts.action.SwanTTSPrivateApi;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SwanPinchSummaryController$$ExternalSyntheticLambda0 implements TypedCallback {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ TypedCallback f$1;

    public /* synthetic */ SwanPinchSummaryController$$ExternalSyntheticLambda0(Ref.ObjectRef objectRef, TypedCallback typedCallback) {
        this.f$0 = objectRef;
        this.f$1 = typedCallback;
    }

    public final void onCallback(Object obj) {
        SwanPinchSummaryController.m7952decodePageContent$lambda6(this.f$0, this.f$1, (SwanTTSPrivateApi.ServerContentResult) obj);
    }
}
