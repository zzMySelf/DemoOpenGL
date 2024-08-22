package com.baidu.searchbox.feed.payment.widget;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AutoScrollHandler$$ExternalSyntheticLambda2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AutoScrollHandler f$0;

    public /* synthetic */ AutoScrollHandler$$ExternalSyntheticLambda2(AutoScrollHandler autoScrollHandler) {
        this.f$0 = autoScrollHandler;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AutoScrollHandler.m19317smoothScrollY$lambda0(this.f$0, valueAnimator);
    }
}
