package com.baidu.searchbox.pinchsummary.widget;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchSummaryLayout.kt */
final class PinchSummaryLayout$requestDisallowInterceptTouchEvent$1 extends Lambda implements Function0<String> {
    final /* synthetic */ boolean $actualDisallow;
    final /* synthetic */ boolean $disallowIntercept;
    final /* synthetic */ PinchSummaryLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PinchSummaryLayout$requestDisallowInterceptTouchEvent$1(boolean z, boolean z2, PinchSummaryLayout pinchSummaryLayout) {
        super(0);
        this.$disallowIntercept = z;
        this.$actualDisallow = z2;
        this.this$0 = pinchSummaryLayout;
    }

    public final String invoke() {
        return "requestDisallowInterceptTouchEvent(" + this.$disallowIntercept + "), actualDisallow=" + this.$actualDisallow + ", needIntercept=" + this.this$0.needIntercept;
    }
}
