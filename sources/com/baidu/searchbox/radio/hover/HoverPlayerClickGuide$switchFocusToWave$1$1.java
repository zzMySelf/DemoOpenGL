package com.baidu.searchbox.radio.hover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/radio/hover/HoverPlayerClickGuide$switchFocusToWave$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "lib-bdmedia-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HoverPlayerClickGuide.kt */
public final class HoverPlayerClickGuide$switchFocusToWave$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ HoverPlayerClickGuide this$0;

    HoverPlayerClickGuide$switchFocusToWave$1$1(HoverPlayerClickGuide $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.getLottieView().setVisibility(8);
        this.this$0.getClickStaticView().setAlpha(1.0f);
        this.this$0.getClickStaticView().setVisibility(0);
        this.this$0.getVoiceWaveView().setAlpha(0.0f);
        this.this$0.getVoiceWaveView().setVisibility(0);
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.getClickStaticView().setVisibility(8);
    }
}
