package com.baidu.searchbox.mvp.widget;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MVPLoadingView$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ MVPLoadingView$$ExternalSyntheticLambda0(View view2) {
        this.f$0 = view2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        MVPLoadingView.m1502blur$lambda2(this.f$0, valueAnimator);
    }
}
