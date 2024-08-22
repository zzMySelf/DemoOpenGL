package com.baidu.searchbox.smartmenu.utils;

import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnimatorHelperKt$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ View f$2;

    public /* synthetic */ AnimatorHelperKt$$ExternalSyntheticLambda1(View view2, View view3, View view4) {
        this.f$0 = view2;
        this.f$1 = view3;
        this.f$2 = view4;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimatorHelperKt.m3169makeCardHideAnimator$lambda7(this.f$0, this.f$1, this.f$2, valueAnimator);
    }
}
