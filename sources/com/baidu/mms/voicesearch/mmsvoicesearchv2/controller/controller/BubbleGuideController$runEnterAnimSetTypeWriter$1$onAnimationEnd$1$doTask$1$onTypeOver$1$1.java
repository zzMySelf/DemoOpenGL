package com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller;

import android.animation.Animator;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/BubbleGuideController$runEnterAnimSetTypeWriter$1$onAnimationEnd$1$doTask$1$onTypeOver$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BubbleGuideController.kt */
public final class BubbleGuideController$runEnterAnimSetTypeWriter$1$onAnimationEnd$1$doTask$1$onTypeOver$1$1 implements Animator.AnimatorListener {
    final /* synthetic */ BubbleGuideController this$0;

    BubbleGuideController$runEnterAnimSetTypeWriter$1$onAnimationEnd$1$doTask$1$onTypeOver$1$1(BubbleGuideController $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ImageView access$getBtnIcon$p = this.this$0.btnIcon;
        if (access$getBtnIcon$p != null) {
            access$getBtnIcon$p.setVisibility(0);
        }
        TextView access$getBtnTextView$p = this.this$0.btnTextView;
        if (access$getBtnTextView$p != null) {
            access$getBtnTextView$p.setVisibility(0);
        }
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }
}
