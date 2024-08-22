package com.baidu.growthsystem.wealth.packet.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WealthVideoDialogCollapseAnim$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WealthVideoDialogCollapseAnim f$0;
    public final /* synthetic */ PointF f$1;
    public final /* synthetic */ PointF f$2;
    public final /* synthetic */ Animator.AnimatorListener f$3;
    public final /* synthetic */ float f$4;
    public final /* synthetic */ View f$5;

    public /* synthetic */ WealthVideoDialogCollapseAnim$$ExternalSyntheticLambda0(WealthVideoDialogCollapseAnim wealthVideoDialogCollapseAnim, PointF pointF, PointF pointF2, Animator.AnimatorListener animatorListener, float f2, View view2) {
        this.f$0 = wealthVideoDialogCollapseAnim;
        this.f$1 = pointF;
        this.f$2 = pointF2;
        this.f$3 = animatorListener;
        this.f$4 = f2;
        this.f$5 = view2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        WealthVideoDialogCollapseAnim.m13678createDialogPackUpAnimation$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, valueAnimator);
    }
}
