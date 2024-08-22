package com.baidu.searchbox.video.feedflow.detail.moveup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/moveup/MoveUpAnimationPlugin$progressAnimator$2$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "isReverse", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MoveUpAnimationPlugin.kt */
public final class MoveUpAnimationPlugin$progressAnimator$2$1$2 extends AnimatorListenerAdapter {
    final /* synthetic */ MoveUpAnimationPlugin this$0;

    MoveUpAnimationPlugin$progressAnimator$2$1$2(MoveUpAnimationPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        for (PanelMoveUpListener panelMoveUpListener : this.this$0.moveUpListenerSet) {
            panelMoveUpListener.onPanelAnimatorEnd();
        }
        if (!this.this$0.isPanelShowing) {
            for (PanelMoveUpListener panelMoveUpListener2 : this.this$0.moveUpListenerSet) {
                panelMoveUpListener2.onPanelHiddenAnimatorEnd();
            }
            this.this$0.isPanelRealShowing = false;
        }
    }

    public void onAnimationStart(Animator animation, boolean isReverse) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationStart(animation, isReverse);
        for (PanelMoveUpListener panelMoveUpListener : this.this$0.moveUpListenerSet) {
            panelMoveUpListener.onPanelAnimatorStart();
        }
    }
}
