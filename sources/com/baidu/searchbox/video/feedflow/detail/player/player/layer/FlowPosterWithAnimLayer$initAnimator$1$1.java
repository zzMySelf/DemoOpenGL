package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowPosterWithAnimLayer$initAnimator$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowPosterWithAnimLayer.kt */
public final class FlowPosterWithAnimLayer$initAnimator$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ SimpleDraweeView $poster;

    FlowPosterWithAnimLayer$initAnimator$1$1(SimpleDraweeView $poster2) {
        this.$poster = $poster2;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$poster.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$poster.setVisibility(8);
        this.$poster.setAlpha(1.0f);
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.$poster.setVisibility(8);
        this.$poster.setAlpha(1.0f);
    }
}
