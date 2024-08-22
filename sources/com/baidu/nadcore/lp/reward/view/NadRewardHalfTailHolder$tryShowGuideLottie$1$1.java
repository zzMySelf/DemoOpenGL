package com.baidu.nadcore.lp.reward.view;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/nadcore/lp/reward/view/NadRewardHalfTailHolder$tryShowGuideLottie$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadRewardHalfTailHolder.kt */
public final class NadRewardHalfTailHolder$tryShowGuideLottie$1$1 implements Animator.AnimatorListener {
    final /* synthetic */ NadRewardHalfTailHolder this$0;

    NadRewardHalfTailHolder$tryShowGuideLottie$1$1(NadRewardHalfTailHolder $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        NadRewardHalfTailHolder nadRewardHalfTailHolder = this.this$0;
        nadRewardHalfTailHolder.doViewAlphaAnimation(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320, 8);
        this.this$0.getArrowView().setVisibility(0);
        this.this$0.getArrowView().bringToFront();
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        NadRewardHalfTailHolder nadRewardHalfTailHolder = this.this$0;
        nadRewardHalfTailHolder.doViewAlphaAnimation(nadRewardHalfTailHolder.getLottieGuideView(), 1.0f, 0.0f, 320, 8);
        this.this$0.getArrowView().setVisibility(0);
        this.this$0.getArrowView().bringToFront();
    }

    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }
}
