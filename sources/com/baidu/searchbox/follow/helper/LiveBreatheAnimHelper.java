package com.baidu.searchbox.follow.helper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.skin.NightModeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u001c\u0010\t\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000\u001a$\u0010\r\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u000f"}, d2 = {"cancelLiveBreatheAnim", "", "animator", "Landroid/animation/AnimatorSet;", "pagView", "Lorg/libpag/PAGView;", "createAndStartLiveBreatheAnim", "headView", "Landroid/view/View;", "isLiveBreatheAniming", "", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "restartLiveBreatheAnim", "updateNightLiveBreatheAnim", "lib-follow_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBreatheAnimHelper.kt */
public final class LiveBreatheAnimHelper {
    public static final AnimatorSet createAndStartLiveBreatheAnim(View headView, PAGView pagView) {
        if (headView == null) {
            return null;
        }
        View view2 = headView;
        AnimatorSet animSet = new AnimatorSet();
        restartLiveBreatheAnim(headView, animSet, pagView);
        return animSet;
    }

    public static final void restartLiveBreatheAnim(View headView, AnimatorSet animator, PAGView pagView) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        cancelLiveBreatheAnim(animator, pagView);
        if (headView != null) {
            View $this$restartLiveBreatheAnim_u24lambda_u2d1 = headView;
            ObjectAnimator scaleInX = ObjectAnimator.ofFloat($this$restartLiveBreatheAnim_u24lambda_u2d1, "scaleX", new float[]{1.0f, 0.85f});
            scaleInX.setRepeatCount(-1);
            scaleInX.setRepeatMode(2);
            ObjectAnimator scaleInY = ObjectAnimator.ofFloat($this$restartLiveBreatheAnim_u24lambda_u2d1, "scaleY", new float[]{1.0f, 0.85f});
            scaleInY.setRepeatCount(-1);
            scaleInY.setRepeatMode(2);
            animator.setDuration(450);
            animator.play(scaleInX).with(scaleInY);
            animator.setInterpolator(new LinearInterpolator());
            if (!animator.isStarted()) {
                animator.start();
            }
        }
        if (pagView != null) {
            pagView.setVisibility(0);
        }
        updateNightLiveBreatheAnim(animator, pagView);
    }

    public static final void cancelLiveBreatheAnim(AnimatorSet animator, PAGView pagView) {
        if (animator != null) {
            animator.cancel();
        }
        if (pagView != null) {
            pagView.setVisibility(8);
        }
        if (pagView != null) {
            pagView.stop();
        }
    }

    public static final void updateNightLiveBreatheAnim(AnimatorSet animator, PAGView pagView) {
        String str;
        if (pagView != null) {
            PAGView $this$updateNightLiveBreatheAnim_u24lambda_u2d2 = pagView;
            try {
                if ($this$updateNightLiveBreatheAnim_u24lambda_u2d2.getVisibility() == 0) {
                    if (NightModeHelper.getNightModeSwitcherState()) {
                        str = "assets://follow_playing_head_night_bg.pag";
                    } else {
                        str = "assets://follow_playing_head_day_bg.pag";
                    }
                    $this$updateNightLiveBreatheAnim_u24lambda_u2d2.setPath(str);
                    $this$updateNightLiveBreatheAnim_u24lambda_u2d2.play();
                }
            } catch (Exception e2) {
                cancelLiveBreatheAnim(animator, pagView);
            }
        }
    }

    public static final boolean isLiveBreatheAniming(AnimatorSet animator, LottieAnimationView lottieView) {
        if (!(animator != null ? animator.isStarted() : false)) {
            return false;
        }
        return lottieView != null ? lottieView.isAnimating() : false;
    }
}
