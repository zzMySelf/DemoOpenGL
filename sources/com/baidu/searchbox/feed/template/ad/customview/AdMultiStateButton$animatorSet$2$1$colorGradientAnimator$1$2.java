package com.baidu.searchbox.feed.template.ad.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.feed.template.ad.customview.AdMultiStateButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/feed/template/ad/customview/AdMultiStateButton$animatorSet$2$1$colorGradientAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdMultiStateButton.kt */
public final class AdMultiStateButton$animatorSet$2$1$colorGradientAnimator$1$2 extends AnimatorListenerAdapter {
    final /* synthetic */ AdMultiStateButton<BTN> this$0;

    AdMultiStateButton$animatorSet$2$1$colorGradientAnimator$1$2(AdMultiStateButton<BTN> $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.setAnimating(true);
        this.this$0.getNormalBtn().setVisibility(0);
        this.this$0.getNormalBtn().setAlpha(1.0f);
        this.this$0.getEnhancedBtn().setVisibility(0);
        this.this$0.getEnhancedBtn().setAlpha(0.0f);
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.setAnimating(false);
        this.this$0.getNormalBtn().setVisibility(8);
        this.this$0.getEnhancedBtn().setVisibility(0);
        this.this$0.getEnhancedBtn().setAlpha(1.0f);
        this.this$0.setState(AdMultiStateButton.ButtonMultiState.FINAL);
        AdMultiStateButton.IActionListener actionListener = this.this$0.getActionListener();
        if (actionListener != null) {
            actionListener.onEnhancedButtonShow();
        }
    }
}
