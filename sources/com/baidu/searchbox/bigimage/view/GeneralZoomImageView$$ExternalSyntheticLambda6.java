package com.baidu.searchbox.bigimage.view;

import android.animation.ValueAnimator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeneralZoomImageView$$ExternalSyntheticLambda6 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GeneralZoomImageView f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ float f$4;

    public /* synthetic */ GeneralZoomImageView$$ExternalSyntheticLambda6(GeneralZoomImageView generalZoomImageView, int i2, float f2, int i3, float f3) {
        this.f$0 = generalZoomImageView;
        this.f$1 = i2;
        this.f$2 = f2;
        this.f$3 = i3;
        this.f$4 = f3;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        GeneralZoomImageView.m16596animateScale$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, valueAnimator);
    }
}
