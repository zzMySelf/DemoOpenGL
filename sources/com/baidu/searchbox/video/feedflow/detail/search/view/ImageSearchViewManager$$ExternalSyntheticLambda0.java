package com.baidu.searchbox.video.feedflow.detail.search.view;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageSearchViewManager$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ ValueAnimator f$1;

    public /* synthetic */ ImageSearchViewManager$$ExternalSyntheticLambda0(View view2, ValueAnimator valueAnimator) {
        this.f$0 = view2;
        this.f$1 = valueAnimator;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ImageSearchViewManager.m13407buildExpandAnimator$lambda17$lambda16(this.f$0, this.f$1, valueAnimator);
    }
}
