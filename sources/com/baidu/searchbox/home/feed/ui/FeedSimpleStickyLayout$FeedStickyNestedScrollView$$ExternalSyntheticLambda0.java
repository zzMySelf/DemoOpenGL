package com.baidu.searchbox.home.feed.ui;

import android.animation.ValueAnimator;
import com.baidu.searchbox.home.feed.ui.FeedSimpleStickyLayout;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedSimpleStickyLayout$FeedStickyNestedScrollView$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FeedSimpleStickyLayout f$0;
    public final /* synthetic */ FeedSimpleStickyLayout.FeedStickyNestedScrollView f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ FeedSimpleStickyLayout$FeedStickyNestedScrollView$$ExternalSyntheticLambda0(FeedSimpleStickyLayout feedSimpleStickyLayout, FeedSimpleStickyLayout.FeedStickyNestedScrollView feedStickyNestedScrollView, int i2) {
        this.f$0 = feedSimpleStickyLayout;
        this.f$1 = feedStickyNestedScrollView;
        this.f$2 = i2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        FeedSimpleStickyLayout.FeedStickyNestedScrollView.m20130animateScrollWithDuration$lambda3$lambda2(this.f$0, this.f$1, this.f$2, valueAnimator);
    }
}
