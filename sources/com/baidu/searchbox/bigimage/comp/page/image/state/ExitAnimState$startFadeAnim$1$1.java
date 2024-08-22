package com.baidu.searchbox.bigimage.comp.page.image.state;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.bigimage.comp.page.image.AnimationCallback;
import com.baidu.searchbox.bigimage.comp.page.image.AnimationType;
import com.baidu.searchbox.bigimage.comp.page.image.ImagePageComp;
import com.baidu.searchbox.nacomp.fsm.EmptyState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/bigimage/comp/page/image/state/ExitAnimState$startFadeAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExitAnimState.kt */
public final class ExitAnimState$startFadeAnim$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ImagePageComp $owner;

    ExitAnimState$startFadeAnim$1$1(ImagePageComp $owner2) {
        this.$owner = $owner2;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        AnimationCallback animationCallback = this.$owner.getAnimationCallback();
        if (animationCallback != null) {
            animationCallback.onExitAnimStart(AnimationType.Fade);
        }
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        AnimationCallback animationCallback = this.$owner.getAnimationCallback();
        if (animationCallback != null) {
            animationCallback.onExitAnimEnd(AnimationType.Fade);
        }
        this.$owner.getFsm$lib_search_bigimage_release().changeState(new EmptyState());
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        AnimationCallback animationCallback = this.$owner.getAnimationCallback();
        if (animationCallback != null) {
            animationCallback.onExitAnimEnd(AnimationType.Fade);
        }
        this.$owner.getFsm$lib_search_bigimage_release().changeState(new EmptyState());
    }
}
