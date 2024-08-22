package com.baidu.searchbox.pinchsummary.widget;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchSummaryLayout.kt */
final class PinchSummaryLayout$dispatchTouchEvent$1 extends Lambda implements Function0<String> {
    final /* synthetic */ MotionEvent $ev;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PinchSummaryLayout$dispatchTouchEvent$1(MotionEvent motionEvent) {
        super(0);
        this.$ev = motionEvent;
    }

    public final String invoke() {
        return "dispatchTouchEvent-" + this.$ev.getActionMasked();
    }
}
