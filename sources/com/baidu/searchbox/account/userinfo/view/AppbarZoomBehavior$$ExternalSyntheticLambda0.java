package com.baidu.searchbox.account.userinfo.view;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppbarZoomBehavior$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AppbarZoomBehavior f$0;
    public final /* synthetic */ AppBarLayout f$1;

    public /* synthetic */ AppbarZoomBehavior$$ExternalSyntheticLambda0(AppbarZoomBehavior appbarZoomBehavior, AppBarLayout appBarLayout) {
        this.f$0 = appbarZoomBehavior;
        this.f$1 = appBarLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppbarZoomBehavior.m14625recovery$lambda4(this.f$0, this.f$1, valueAnimator);
    }
}
