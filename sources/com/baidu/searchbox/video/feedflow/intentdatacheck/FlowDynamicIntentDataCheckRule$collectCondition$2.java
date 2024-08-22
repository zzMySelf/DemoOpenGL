package com.baidu.searchbox.video.feedflow.intentdatacheck;

import com.baidu.searchbox.video.detail.core.exception.IntentDataCheckCondition;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDynamicIntentDataCheckRule.kt */
/* synthetic */ class FlowDynamicIntentDataCheckRule$collectCondition$2 extends FunctionReferenceImpl implements Function1<IntentData, Unit> {
    FlowDynamicIntentDataCheckRule$collectCondition$2(Object obj) {
        super(1, obj, IntentDataCheckCondition.class, "checkPd", "checkPd(Lcom/baidu/searchbox/video/detail/core/model/IntentData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IntentData) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(IntentData p0) {
        Intrinsics.checkNotNullParameter(p0, ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT);
        ((IntentDataCheckCondition) this.receiver).checkPd(p0);
    }
}
