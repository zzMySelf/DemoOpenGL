package com.baidu.growthsystem.wealth.video.dialogtoast;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import com.baidu.growthsystem.wealth.video.dialogtoast.WealthVideoDialogToast;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WealthVideoDialogToast$RewardToastAnimateVisitor$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WealthVideoDialogToast f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ PointF f$2;
    public final /* synthetic */ PointF f$3;
    public final /* synthetic */ float f$4;
    public final /* synthetic */ float f$5;
    public final /* synthetic */ Animator.AnimatorListener f$6;

    public /* synthetic */ WealthVideoDialogToast$RewardToastAnimateVisitor$$ExternalSyntheticLambda1(WealthVideoDialogToast wealthVideoDialogToast, View view2, PointF pointF, PointF pointF2, float f2, float f3, Animator.AnimatorListener animatorListener) {
        this.f$0 = wealthVideoDialogToast;
        this.f$1 = view2;
        this.f$2 = pointF;
        this.f$3 = pointF2;
        this.f$4 = f2;
        this.f$5 = f3;
        this.f$6 = animatorListener;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        WealthVideoDialogToast.RewardToastAnimateVisitor.m13806setBigGoldImagesAnimation$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, valueAnimator);
    }
}
