package com.baidu.searchbox.browserenhanceengine.container.animation;

import android.animation.Animator;
import android.view.animation.Animation;
import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.browsercontrol.BrowserControlContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/browserenhanceengine/container/animation/TITOAnimation$closeAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "bee_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TITOAnimation.kt */
public final class TITOAnimation$closeAnimation$1 implements Animator.AnimatorListener {
    final /* synthetic */ Container<?> $currContainer;
    final /* synthetic */ ContainerAnimationListener $listener;

    TITOAnimation$closeAnimation$1(Container<?> $currContainer2, ContainerAnimationListener $listener2) {
        this.$currContainer = $currContainer2;
        this.$listener = $listener2;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        if (!((BrowserControlContainer) this.$currContainer).isFromGesture()) {
            this.$currContainer.onContainerAnimationStart(false, true, false);
        }
        ContainerAnimationListener containerAnimationListener = this.$listener;
        if (containerAnimationListener != null) {
            containerAnimationListener.onAnimationStart((Animation) null);
        }
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Container<?> container = this.$currContainer;
        container.onContainerAnimationFinish(false, true, ((BrowserControlContainer) container).isFromGesture());
        ((BrowserControlContainer) this.$currContainer).setIsFromGesture(false);
        ContainerAnimationListener containerAnimationListener = this.$listener;
        if (containerAnimationListener != null) {
            containerAnimationListener.onAnimationEnd((Animation) null);
        }
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        ContainerAnimationListener containerAnimationListener = this.$listener;
        if (containerAnimationListener != null) {
            containerAnimationListener.onAnimationRepeat((Animation) null);
        }
    }
}
