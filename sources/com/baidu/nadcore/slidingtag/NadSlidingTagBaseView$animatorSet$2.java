package com.baidu.nadcore.slidingtag;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/AnimatorSet;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadSlidingTagBaseView.kt */
final class NadSlidingTagBaseView$animatorSet$2 extends Lambda implements Function0<AnimatorSet> {
    final /* synthetic */ NadSlidingTagBaseView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadSlidingTagBaseView$animatorSet$2(NadSlidingTagBaseView nadSlidingTagBaseView) {
        super(0);
        this.this$0 = nadSlidingTagBaseView;
    }

    public final AnimatorSet invoke() {
        AnimatorSet fadeOut = new AnimatorSet();
        NadSlidingTagBaseView nadSlidingTagBaseView = this.this$0;
        AnimatorSet $this$invoke_u24lambda_u2d4 = fadeOut;
        ValueAnimator fadeOutPositionAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator $this$invoke_u24lambda_u2d4_u24lambda_u2d1 = fadeOutPositionAnimator;
        $this$invoke_u24lambda_u2d4_u24lambda_u2d1.setDuration(200);
        $this$invoke_u24lambda_u2d4_u24lambda_u2d1.setInterpolator(new AccelerateDecelerateInterpolator());
        $this$invoke_u24lambda_u2d4_u24lambda_u2d1.addUpdateListener(new NadSlidingTagBaseView$animatorSet$2$$ExternalSyntheticLambda0(nadSlidingTagBaseView));
        ValueAnimator fadeOutAlphaAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ValueAnimator $this$invoke_u24lambda_u2d4_u24lambda_u2d3 = fadeOutAlphaAnimator;
        $this$invoke_u24lambda_u2d4_u24lambda_u2d3.setDuration(200);
        $this$invoke_u24lambda_u2d4_u24lambda_u2d3.setInterpolator(new LinearInterpolator());
        $this$invoke_u24lambda_u2d4_u24lambda_u2d3.addUpdateListener(new NadSlidingTagBaseView$animatorSet$2$$ExternalSyntheticLambda1(nadSlidingTagBaseView));
        $this$invoke_u24lambda_u2d4.play(fadeOutPositionAnimator).with(fadeOutAlphaAnimator);
        $this$invoke_u24lambda_u2d4.addListener(new NadSlidingTagBaseView$animatorSet$2$fadeOut$1$1(nadSlidingTagBaseView));
        AnimatorSet fadeIn = new AnimatorSet();
        NadSlidingTagBaseView nadSlidingTagBaseView2 = this.this$0;
        AnimatorSet $this$invoke_u24lambda_u2d9 = fadeIn;
        ValueAnimator fadeInPositionAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator $this$invoke_u24lambda_u2d9_u24lambda_u2d6 = fadeInPositionAnimator;
        $this$invoke_u24lambda_u2d9_u24lambda_u2d6.setDuration(200);
        $this$invoke_u24lambda_u2d9_u24lambda_u2d6.setInterpolator(new AccelerateDecelerateInterpolator());
        $this$invoke_u24lambda_u2d9_u24lambda_u2d6.addUpdateListener(new NadSlidingTagBaseView$animatorSet$2$$ExternalSyntheticLambda2(nadSlidingTagBaseView2));
        ValueAnimator fadeInAlphaAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ValueAnimator $this$invoke_u24lambda_u2d9_u24lambda_u2d8 = fadeInAlphaAnimator;
        $this$invoke_u24lambda_u2d9_u24lambda_u2d8.setDuration(200);
        $this$invoke_u24lambda_u2d9_u24lambda_u2d8.setInterpolator(new LinearInterpolator());
        $this$invoke_u24lambda_u2d9_u24lambda_u2d8.addUpdateListener(new NadSlidingTagBaseView$animatorSet$2$$ExternalSyntheticLambda3(nadSlidingTagBaseView2));
        $this$invoke_u24lambda_u2d9.play(fadeInPositionAnimator).with(fadeInAlphaAnimator);
        $this$invoke_u24lambda_u2d9.addListener(new NadSlidingTagBaseView$animatorSet$2$fadeIn$1$1(nadSlidingTagBaseView2));
        ValueAnimator display = ValueAnimator.ofInt(new int[]{0, 1});
        display.setDuration(this.this$0.displayIntervalMillis);
        AnimatorSet animatorSet = new AnimatorSet();
        NadSlidingTagBaseView nadSlidingTagBaseView3 = this.this$0;
        AnimatorSet $this$invoke_u24lambda_u2d11 = animatorSet;
        $this$invoke_u24lambda_u2d11.play(fadeOut).before(fadeIn).before(display);
        $this$invoke_u24lambda_u2d11.addListener(new NadSlidingTagBaseView$animatorSet$2$1$1(nadSlidingTagBaseView3, $this$invoke_u24lambda_u2d11));
        return animatorSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4$lambda-1$lambda-0  reason: not valid java name */
    public static final void m14205invoke$lambda4$lambda1$lambda0(NadSlidingTagBaseView this$02, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(animator, "animator");
        this$02.updateFadeOutPositionAnimation(animator);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4$lambda-3$lambda-2  reason: not valid java name */
    public static final void m14206invoke$lambda4$lambda3$lambda2(NadSlidingTagBaseView this$02, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(animator, "animator");
        this$02.updateAlphaAnimation(animator);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-9$lambda-6$lambda-5  reason: not valid java name */
    public static final void m14207invoke$lambda9$lambda6$lambda5(NadSlidingTagBaseView this$02, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(animator, "animator");
        this$02.updateFadeInPositionAnimation(animator);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-9$lambda-8$lambda-7  reason: not valid java name */
    public static final void m14208invoke$lambda9$lambda8$lambda7(NadSlidingTagBaseView this$02, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        Intrinsics.checkNotNullParameter(animator, "animator");
        this$02.updateAlphaAnimation(animator);
    }
}
