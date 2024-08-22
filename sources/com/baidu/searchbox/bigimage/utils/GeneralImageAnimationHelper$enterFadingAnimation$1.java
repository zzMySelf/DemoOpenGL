package com.baidu.searchbox.bigimage.utils;

import android.animation.Animator;
import android.widget.FrameLayout;
import com.baidu.searchbox.bigimage.view.BigImageBrowserViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/bigimage/utils/GeneralImageAnimationHelper$enterFadingAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-bigimage-bee-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GeneralImageAnimationHelper.kt */
public final class GeneralImageAnimationHelper$enterFadingAnimation$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function0<Unit> $animaEndCallBack;
    final /* synthetic */ Function0<Unit> $animaStartCallBack;
    final /* synthetic */ GeneralImageAnimationHelper this$0;

    GeneralImageAnimationHelper$enterFadingAnimation$1(GeneralImageAnimationHelper $receiver, Function0<Unit> $animaStartCallBack2, Function0<Unit> $animaEndCallBack2) {
        this.this$0 = $receiver;
        this.$animaStartCallBack = $animaStartCallBack2;
        this.$animaEndCallBack = $animaEndCallBack2;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.this$0.setAniming(true);
        Function0<Unit> function0 = this.$animaStartCallBack;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.this$0.setAniming(false);
        FrameLayout access$getImageRootView$p = this.this$0.imageRootView;
        if (access$getImageRootView$p != null) {
            access$getImageRootView$p.post(new GeneralImageAnimationHelper$enterFadingAnimation$1$$ExternalSyntheticLambda1(this.this$0));
        }
        Function0<Unit> function0 = this.$animaEndCallBack;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAnimationEnd$lambda-0  reason: not valid java name */
    public static final void m16589onAnimationEnd$lambda0(GeneralImageAnimationHelper this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        BigImageBrowserViewPager access$getViewPager$p = this$02.viewPager;
        if (access$getViewPager$p != null) {
            access$getViewPager$p.setVisibility(0);
        }
    }

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.this$0.setAniming(false);
        FrameLayout access$getImageRootView$p = this.this$0.imageRootView;
        if (access$getImageRootView$p != null) {
            access$getImageRootView$p.post(new GeneralImageAnimationHelper$enterFadingAnimation$1$$ExternalSyntheticLambda0(this.this$0));
        }
        Function0<Unit> function0 = this.$animaEndCallBack;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAnimationCancel$lambda-1  reason: not valid java name */
    public static final void m16588onAnimationCancel$lambda1(GeneralImageAnimationHelper this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        BigImageBrowserViewPager access$getViewPager$p = this$02.viewPager;
        if (access$getViewPager$p != null) {
            access$getViewPager$p.setVisibility(0);
        }
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }
}
