package com.baidu.searchbox.home.tabs.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/home/tabs/utils/HomeTabImmerseHelper$doTranslationAlphaAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "lib-home-tab-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeTabImmerseHelper.kt */
public final class HomeTabImmerseHelper$doTranslationAlphaAnim$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ List<View> $animViews;
    final /* synthetic */ float $endValue;
    final /* synthetic */ Map<View, Float> $originY;

    HomeTabImmerseHelper$doTranslationAlphaAnim$1$1(List<? extends View> $animViews2, float $endValue2, Map<View, Float> $originY2) {
        this.$animViews = $animViews2;
        this.$endValue = $endValue2;
        this.$originY = $originY2;
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        onAnimationEnd(animation);
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        HomeTabImmerseHelper homeTabImmerseHelper = HomeTabImmerseHelper.INSTANCE;
        HomeTabImmerseHelper.curAnimator = null;
        HomeTabImmerseHelper homeTabImmerseHelper2 = HomeTabImmerseHelper.INSTANCE;
        HomeTabImmerseHelper.curAnimType = 0;
        for (View v : this.$animViews) {
            v.setAlpha(this.$endValue);
            Float f2 = this.$originY.get(v);
            if (f2 != null) {
                v.setY(f2.floatValue());
            }
        }
        HomeTabImmerseHelper.INSTANCE.onTabShow();
    }
}
