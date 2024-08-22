package com.baidu.searchbox.video.feedflow.detail.payment.shortPlayAutoUnlock;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShortPlayAutoUnlockView$$ExternalSyntheticLambda2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ShortPlayAutoUnlockView f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ ShortPlayAutoUnlockView$$ExternalSyntheticLambda2(ShortPlayAutoUnlockView shortPlayAutoUnlockView, int i2, int i3) {
        this.f$0 = shortPlayAutoUnlockView;
        this.f$1 = i2;
        this.f$2 = i3;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ShortPlayAutoUnlockView.m12053initAnim$lambda2(this.f$0, this.f$1, this.f$2, valueAnimator);
    }
}
