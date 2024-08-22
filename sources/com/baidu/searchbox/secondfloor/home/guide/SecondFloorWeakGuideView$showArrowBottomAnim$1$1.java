package com.baidu.searchbox.secondfloor.home.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.secondfloor.home.guide.SecondFloorWeakGuideView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/secondfloor/home/guide/SecondFloorWeakGuideView$showArrowBottomAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib-secondfloor-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SecondFloorWeakGuideView.kt */
public final class SecondFloorWeakGuideView$showArrowBottomAnim$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ SecondFloorWeakGuideView this$0;

    SecondFloorWeakGuideView$showArrowBottomAnim$1$1(SecondFloorWeakGuideView $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        SecondFloorWeakGuideView.ArrowBottomRunnable it = this.this$0.mArrowBottomRunnable;
        if (it != null) {
            UiThreadUtils.getMainHandler().postDelayed(it, 250);
        }
    }
}
