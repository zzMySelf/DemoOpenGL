package com.baidu.chatsearch.aicall.comps.background;

import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AICallBgDrawable$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ AICallBgDrawable$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AICallBgDrawable.m13029createAnimator$lambda1$lambda0(this.f$0, valueAnimator);
    }
}
