package com.baidu.searchbox.video.feedflow.detail.search.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchMarkAnimManager$$ExternalSyntheticLambda9 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewGroup f$0;

    public /* synthetic */ SearchMarkAnimManager$$ExternalSyntheticLambda9(ViewGroup viewGroup) {
        this.f$0 = viewGroup;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchMarkAnimManager.m13424handleExpandHideScaleAnim$lambda6$lambda5(this.f$0, valueAnimator);
    }
}
