package com.baidu.searchbox.aisearch.comps.conversationmanager.dependents;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationTitleComp.kt */
final class ConversationTitleComp$showDelTitleAnimatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    final /* synthetic */ ConversationTitleComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationTitleComp$showDelTitleAnimatorSet$2(ConversationTitleComp conversationTitleComp) {
        super(0);
        this.this$0 = conversationTitleComp;
    }

    public final AnimatorSet invoke() {
        AnimatorSet animatorSet = new AnimatorSet();
        ConversationTitleComp conversationTitleComp = this.this$0;
        AnimatorSet $this$invoke_u24lambda_u2d0 = animatorSet;
        $this$invoke_u24lambda_u2d0.setDuration(240);
        $this$invoke_u24lambda_u2d0.addListener(new ConversationTitleComp$showDelTitleAnimatorSet$2$1$1(conversationTitleComp));
        $this$invoke_u24lambda_u2d0.playTogether(new Animator[]{ObjectAnimator.ofFloat(conversationTitleComp.getTvCompleted(), "alpha", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(conversationTitleComp.getTvClearAll(), "alpha", new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(conversationTitleComp.getIvSearch(), "alpha", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(conversationTitleComp.getIvDelete(), "alpha", new float[]{1.0f, 0.0f})});
        return animatorSet;
    }
}
