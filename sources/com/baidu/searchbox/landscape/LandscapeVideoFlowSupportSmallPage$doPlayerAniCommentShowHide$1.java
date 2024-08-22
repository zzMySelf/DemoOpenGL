package com.baidu.searchbox.landscape;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.ViewGroup;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.video.player.landscape.ILandscapeVideoPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/landscape/LandscapeVideoFlowSupportSmallPage$doPlayerAniCommentShowHide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib-feed-video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeVideoFlowSupportSmallPage.kt */
public final class LandscapeVideoFlowSupportSmallPage$doPlayerAniCommentShowHide$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewGroup $target;
    final /* synthetic */ LandscapeVideoFlowSupportSmallPage this$0;

    LandscapeVideoFlowSupportSmallPage$doPlayerAniCommentShowHide$1(LandscapeVideoFlowSupportSmallPage $receiver, ViewGroup $target2) {
        this.this$0 = $receiver;
        this.$target = $target2;
    }

    public void onAnimationEnd(Animator animation) {
        ILandscapeVideoPlayer currentPlayer;
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        AnimatorSet access$getMShrinkAnimator$p = this.this$0.mShrinkAnimator;
        if (access$getMShrinkAnimator$p != null) {
            access$getMShrinkAnimator$p.removeAllListeners();
        }
        if (this.this$0.mPanelVisibility && (currentPlayer = this.this$0.getCurrentPlayer()) != null) {
            currentPlayer.setControlLayerVisibility(8);
        }
        ILandscapeVideoPlayer currentPlayer2 = this.this$0.getCurrentPlayer();
        if (currentPlayer2 != null) {
            VideoEvent $this$onAnimationEnd_u24lambda_u2d0 = LayerEvent.obtainEvent(LayerEvent.ACTION_POPUP_SHOW);
            $this$onAnimationEnd_u24lambda_u2d0.putExtra(28, true);
            Intrinsics.checkNotNullExpressionValue($this$onAnimationEnd_u24lambda_u2d0, "obtainEvent(LayerEvent.A…ue)\n                    }");
            currentPlayer2.sendEvent($this$onAnimationEnd_u24lambda_u2d0);
        }
        this.this$0.adjustAnimator(this.$target);
        if (!this.this$0.mLandscapeBottomBar.isCommentPopupShowing()) {
            this.this$0.doPlayerAniCommentShowHide(false);
        }
    }
}
