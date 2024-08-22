package com.baidu.searchbox.newhome.content.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/newhome/content/widget/HomeV1FloatRefreshBtnContainer$initAnim$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeV1FloatRefreshBtnContainer.kt */
public final class HomeV1FloatRefreshBtnContainer$initAnim$2$1 extends AnimatorListenerAdapter {
    final /* synthetic */ HomeV1FloatRefreshBtnContainer this$0;

    HomeV1FloatRefreshBtnContainer$initAnim$2$1(HomeV1FloatRefreshBtnContainer $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.floatContainerView.setVisibility(8);
    }
}
