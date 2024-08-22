package com.baidu.searchbox.video.feedflow.flow.attention.guide;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AttentionToRecGuideView$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AttentionToRecGuideView f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ AttentionToRecGuideView$$ExternalSyntheticLambda0(AttentionToRecGuideView attentionToRecGuideView, int i2, int i3) {
        this.f$0 = attentionToRecGuideView;
        this.f$1 = i2;
        this.f$2 = i3;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AttentionToRecGuideView.m5987initAnim$lambda4(this.f$0, this.f$1, this.f$2, valueAnimator);
    }
}
