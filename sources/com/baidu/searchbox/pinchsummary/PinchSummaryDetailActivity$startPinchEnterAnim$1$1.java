package com.baidu.searchbox.pinchsummary;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/pinchsummary/PinchSummaryDetailActivity$startPinchEnterAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "pinch-summary_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchSummaryDetailActivity.kt */
public final class PinchSummaryDetailActivity$startPinchEnterAnim$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ PinchSummaryDetailActivity this$0;

    PinchSummaryDetailActivity$startPinchEnterAnim$1$1(PinchSummaryDetailActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.onEnterAnimEnd();
        this.this$0.enterAnimSet = null;
    }
}
