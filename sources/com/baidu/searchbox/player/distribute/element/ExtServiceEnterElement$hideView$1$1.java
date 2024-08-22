package com.baidu.searchbox.player.distribute.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/player/distribute/element/ExtServiceEnterElement$hideView$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtServiceEnterElement.kt */
public final class ExtServiceEnterElement$hideView$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ boolean $isLightPanelShowing;
    final /* synthetic */ ExtServiceEnterElement this$0;

    ExtServiceEnterElement$hideView$1$1(ExtServiceEnterElement $receiver, boolean $isLightPanelShowing2) {
        this.this$0 = $receiver;
        this.$isLightPanelShowing = $isLightPanelShowing2;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.updateSlotViewLayoutParams(this.$isLightPanelShowing);
        ViewGroup access$getRootView$p = this.this$0.rootView;
        if (access$getRootView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            access$getRootView$p = null;
        }
        access$getRootView$p.setVisibility(8);
    }
}
