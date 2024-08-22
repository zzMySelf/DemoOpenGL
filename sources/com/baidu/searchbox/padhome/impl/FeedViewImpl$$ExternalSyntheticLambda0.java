package com.baidu.searchbox.padhome.impl;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedViewImpl$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ FeedViewImpl f$1;

    public /* synthetic */ FeedViewImpl$$ExternalSyntheticLambda0(int i2, FeedViewImpl feedViewImpl) {
        this.f$0 = i2;
        this.f$1 = feedViewImpl;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FeedViewImpl.m1863setFeedLayoutParams$lambda3$lambda2(this.f$0, this.f$1, valueAnimator);
    }
}
