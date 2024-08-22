package com.baidu.searchbox.video.feedflow.detail.search.view;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchMarkAnimManager$$ExternalSyntheticLambda7 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ SearchMarkAnimManager f$1;

    public /* synthetic */ SearchMarkAnimManager$$ExternalSyntheticLambda7(View view2, SearchMarkAnimManager searchMarkAnimManager) {
        this.f$0 = view2;
        this.f$1 = searchMarkAnimManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchMarkAnimManager.m13421handleExpandHideScaleAnim$lambda1$lambda0(this.f$0, this.f$1, valueAnimator);
    }
}
