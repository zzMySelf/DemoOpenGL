package com.baidu.searchbox.video.feedflow.view;

import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowPullRefreshSuccessTipView.kt */
final class VideoFlowPullRefreshSuccessTipView$animatorHide$2 extends Lambda implements Function0<ValueAnimator> {
    public static final VideoFlowPullRefreshSuccessTipView$animatorHide$2 INSTANCE = new VideoFlowPullRefreshSuccessTipView$animatorHide$2();

    VideoFlowPullRefreshSuccessTipView$animatorHide$2() {
        super(0);
    }

    public final ValueAnimator invoke() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ValueAnimator $this$invoke_u24lambda_u2d0 = ofFloat;
        $this$invoke_u24lambda_u2d0.setDuration(180);
        $this$invoke_u24lambda_u2d0.setInterpolator(new DecelerateInterpolator());
        return ofFloat;
    }
}
