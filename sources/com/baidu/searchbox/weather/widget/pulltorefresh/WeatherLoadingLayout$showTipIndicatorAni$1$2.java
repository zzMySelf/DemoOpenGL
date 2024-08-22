package com.baidu.searchbox.weather.widget.pulltorefresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.baidu.searchbox.ui.pullrefresh.HeaderRefreshIndicator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/weather/widget/pulltorefresh/WeatherLoadingLayout$showTipIndicatorAni$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WeatherLoadingLayout.kt */
public final class WeatherLoadingLayout$showTipIndicatorAni$1$2 extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable $task;
    final /* synthetic */ HeaderRefreshIndicator $tipIndicatorView;
    final /* synthetic */ WeatherLoadingLayout this$0;

    WeatherLoadingLayout$showTipIndicatorAni$1$2(HeaderRefreshIndicator $tipIndicatorView2, Runnable $task2, WeatherLoadingLayout $receiver) {
        this.$tipIndicatorView = $tipIndicatorView2;
        this.$task = $task2;
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationStart(animation);
        HeaderRefreshIndicator headerRefreshIndicator = this.$tipIndicatorView;
        headerRefreshIndicator.setTranslationY((float) headerRefreshIndicator.getHeight());
        this.$tipIndicatorView.setVisibility(0);
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        this.$tipIndicatorView.setTranslationY(0.0f);
        Runnable $this$onAnimationEnd_u24lambda_u2d0 = this.$task;
        if ($this$onAnimationEnd_u24lambda_u2d0 != null) {
            this.this$0.postDelayed($this$onAnimationEnd_u24lambda_u2d0, 800);
        }
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationCancel(animation);
        this.$tipIndicatorView.setTranslationY(0.0f);
    }
}
