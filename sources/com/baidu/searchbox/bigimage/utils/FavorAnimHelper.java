package com.baidu.searchbox.bigimage.utils;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewStub;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J)\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0011R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/bigimage/utils/FavorAnimHelper;", "", "favorView", "Landroid/view/View;", "favorLottieViewStub", "Landroid/view/ViewStub;", "(Landroid/view/View;Landroid/view/ViewStub;)V", "favorAlphaAnim", "Landroid/animation/ValueAnimator;", "favorPagView", "Lorg/libpag/PAGImageView;", "getFavorPagView", "()Lorg/libpag/PAGImageView;", "favorPagView$delegate", "Lkotlin/Lazy;", "favorScaleAnim", "cancelFavorAnim", "", "favorAnim", "getScaleKeyFrameAnim", "animView", "frames", "", "Landroid/animation/Keyframe;", "(Landroid/view/View;[Landroid/animation/Keyframe;)Landroid/animation/ValueAnimator;", "isFavorAnimRunning", "", "releaseAnim", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorAnimHelper.kt */
public final class FavorAnimHelper {
    private ValueAnimator favorAlphaAnim;
    /* access modifiers changed from: private */
    public final ViewStub favorLottieViewStub;
    private final Lazy favorPagView$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new FavorAnimHelper$favorPagView$2(this));
    private ValueAnimator favorScaleAnim;
    private final View favorView;

    public FavorAnimHelper(View favorView2, ViewStub favorLottieViewStub2) {
        Intrinsics.checkNotNullParameter(favorView2, "favorView");
        Intrinsics.checkNotNullParameter(favorLottieViewStub2, "favorLottieViewStub");
        this.favorView = favorView2;
        this.favorLottieViewStub = favorLottieViewStub2;
    }

    private final PAGImageView getFavorPagView() {
        return (PAGImageView) this.favorPagView$delegate.getValue();
    }

    public final void favorAnim() {
        PAGImageView $this$favorAnim_u24lambda_u2d0 = getFavorPagView();
        if ($this$favorAnim_u24lambda_u2d0 != null) {
            $this$favorAnim_u24lambda_u2d0.setPath("assets://search_big_image_favor_anim.pag");
            $this$favorAnim_u24lambda_u2d0.setVisibility(0);
            $this$favorAnim_u24lambda_u2d0.play();
        }
        ValueAnimator valueAnimator = this.favorScaleAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        View view2 = this.favorView;
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.6f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 0.6f)");
        Keyframe ofFloat2 = Keyframe.ofFloat(0.5f, 1.6f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(0.5f, 1.6f)");
        Keyframe ofFloat3 = Keyframe.ofFloat(0.9f, 0.89f);
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(0.9f, 0.89f)");
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(1f, 1f)");
        ValueAnimator scaleKeyFrameAnim = getScaleKeyFrameAnim(view2, ofFloat, ofFloat2, ofFloat3, ofFloat4);
        ValueAnimator $this$favorAnim_u24lambda_u2d1 = scaleKeyFrameAnim;
        $this$favorAnim_u24lambda_u2d1.setDuration(400);
        $this$favorAnim_u24lambda_u2d1.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.08f, 0.24f, 1.0f));
        $this$favorAnim_u24lambda_u2d1.setStartDelay(40);
        $this$favorAnim_u24lambda_u2d1.start();
        this.favorScaleAnim = scaleKeyFrameAnim;
        ValueAnimator valueAnimator2 = this.favorAlphaAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{0.3f, 1.0f});
        ValueAnimator $this$favorAnim_u24lambda_u2d4 = ofFloat5;
        $this$favorAnim_u24lambda_u2d4.setDuration(200);
        $this$favorAnim_u24lambda_u2d4.setInterpolator(PathInterpolatorCompat.create(0.44f, 0.07f, 0.48f, 1.0f));
        $this$favorAnim_u24lambda_u2d4.setStartDelay(40);
        $this$favorAnim_u24lambda_u2d4.addUpdateListener(new FavorAnimHelper$$ExternalSyntheticLambda1(this));
        $this$favorAnim_u24lambda_u2d4.start();
        this.favorAlphaAnim = ofFloat5;
    }

    /* access modifiers changed from: private */
    /* renamed from: favorAnim$lambda-4$lambda-3  reason: not valid java name */
    public static final void m16581favorAnim$lambda4$lambda3(FavorAnimHelper this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f2 != null) {
            this$0.favorView.setAlpha(f2.floatValue());
        }
    }

    public final void cancelFavorAnim() {
        ValueAnimator valueAnimator = this.favorScaleAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        View view2 = this.favorView;
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.46f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(0f, 0.46f)");
        Keyframe ofFloat2 = Keyframe.ofFloat(0.5f, 1.2f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(0.5f, 1.2f)");
        Keyframe ofFloat3 = Keyframe.ofFloat(0.7f, 0.85f);
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(0.7f, 0.85f)");
        Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(1f, 1f)");
        ValueAnimator scaleKeyFrameAnim = getScaleKeyFrameAnim(view2, ofFloat, ofFloat2, ofFloat3, ofFloat4);
        ValueAnimator $this$cancelFavorAnim_u24lambda_u2d5 = scaleKeyFrameAnim;
        $this$cancelFavorAnim_u24lambda_u2d5.setDuration(500);
        $this$cancelFavorAnim_u24lambda_u2d5.setInterpolator(PathInterpolatorCompat.create(0.44f, 0.07f, 0.58f, 0.95f));
        $this$cancelFavorAnim_u24lambda_u2d5.start();
        this.favorScaleAnim = scaleKeyFrameAnim;
        ValueAnimator valueAnimator2 = this.favorAlphaAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(new float[]{0.1f, 1.0f});
        ValueAnimator $this$cancelFavorAnim_u24lambda_u2d8 = ofFloat5;
        $this$cancelFavorAnim_u24lambda_u2d8.setDuration(250);
        $this$cancelFavorAnim_u24lambda_u2d8.setInterpolator(PathInterpolatorCompat.create(0.44f, 0.07f, 0.86f, 0.0f));
        $this$cancelFavorAnim_u24lambda_u2d8.addUpdateListener(new FavorAnimHelper$$ExternalSyntheticLambda0(this));
        $this$cancelFavorAnim_u24lambda_u2d8.start();
        this.favorAlphaAnim = ofFloat5;
    }

    /* access modifiers changed from: private */
    /* renamed from: cancelFavorAnim$lambda-8$lambda-7  reason: not valid java name */
    public static final void m16580cancelFavorAnim$lambda8$lambda7(FavorAnimHelper this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Float f2 = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f2 != null) {
            this$0.favorView.setAlpha(f2.floatValue());
        }
    }

    private final ValueAnimator getScaleKeyFrameAnim(View animView, Keyframe... frames) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(animView, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("scaleX", (Keyframe[]) Arrays.copyOf(frames, frames.length)), PropertyValuesHolder.ofKeyframe("scaleY", (Keyframe[]) Arrays.copyOf(frames, frames.length))});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(a…ew, scaleXPvh, scaleYPvh)");
        return ofPropertyValuesHolder;
    }

    public final boolean isFavorAnimRunning() {
        ValueAnimator valueAnimator = this.favorAlphaAnim;
        boolean z = true;
        boolean z2 = valueAnimator != null && valueAnimator.isRunning();
        ValueAnimator valueAnimator2 = this.favorScaleAnim;
        boolean z3 = z2 | (valueAnimator2 != null && valueAnimator2.isRunning());
        PAGImageView favorPagView = getFavorPagView();
        if (favorPagView == null || !favorPagView.isPlaying()) {
            z = false;
        }
        return z3 | z;
    }

    public final void releaseAnim() {
        ValueAnimator valueAnimator = this.favorScaleAnim;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.favorAlphaAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.favorAlphaAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator4 = this.favorScaleAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
    }
}
