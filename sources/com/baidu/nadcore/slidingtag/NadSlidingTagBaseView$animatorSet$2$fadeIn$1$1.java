package com.baidu.nadcore.slidingtag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/nadcore/slidingtag/NadSlidingTagBaseView$animatorSet$2$fadeIn$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "animation", "Landroid/animation/Animator;", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadSlidingTagBaseView.kt */
public final class NadSlidingTagBaseView$animatorSet$2$fadeIn$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ NadSlidingTagBaseView this$0;

    NadSlidingTagBaseView$animatorSet$2$fadeIn$1$1(NadSlidingTagBaseView $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        NadSlidingTagBaseView nadSlidingTagBaseView = this.this$0;
        nadSlidingTagBaseView.setCurrentIdx(nadSlidingTagBaseView.getNextIndex());
        TextView tv = (TextView) CollectionsKt.getOrNull(this.this$0.getTvList(), this.this$0.getCurrentIdx());
        if (tv != null) {
            NadSlidingTagBaseView nadSlidingTagBaseView2 = this.this$0;
            nadSlidingTagBaseView2.getLinear().addView(nadSlidingTagBaseView2.removeFromParent(tv), nadSlidingTagBaseView2.newTextViewLayoutParams());
        }
    }
}
