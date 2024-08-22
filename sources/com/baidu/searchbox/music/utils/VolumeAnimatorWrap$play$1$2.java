package com.baidu.searchbox.music.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/music/utils/VolumeAnimatorWrap$play$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "lib-music-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VolumeAnimatorWrap.kt */
public final class VolumeAnimatorWrap$play$1$2 extends AnimatorListenerAdapter {
    final /* synthetic */ VolumeAnimatorWrap this$0;

    VolumeAnimatorWrap$play$1$2(VolumeAnimatorWrap $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationStart(animation);
        Function0<Unit> animatorStartInvoke = this.this$0.getAnimatorStartInvoke();
        if (animatorStartInvoke != null) {
            animatorStartInvoke.invoke();
        }
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationCancel(animation);
        Function0<Unit> animatorEndInvoke = this.this$0.getAnimatorEndInvoke();
        if (animatorEndInvoke != null) {
            animatorEndInvoke.invoke();
        }
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        Function0<Unit> animatorEndInvoke = this.this$0.getAnimatorEndInvoke();
        if (animatorEndInvoke != null) {
            animatorEndInvoke.invoke();
        }
    }
}
