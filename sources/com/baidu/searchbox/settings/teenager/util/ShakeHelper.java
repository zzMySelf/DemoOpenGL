package com.baidu.searchbox.settings.teenager.util;

import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J,\u0010\u0015\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0019R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\u00060\nR\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper;", "", "()V", "shakeAnimator", "Landroid/animation/ValueAnimator;", "getShakeAnimator", "()Landroid/animation/ValueAnimator;", "shakeAnimator$delegate", "Lkotlin/Lazy;", "shakeAnimatorUpdateListener", "Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper$ShakeAnimatorUpdateListener;", "getShakeAnimatorUpdateListener", "()Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper$ShakeAnimatorUpdateListener;", "shakeAnimatorUpdateListener$delegate", "shakeView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "vibrateHelper", "Lcom/baidu/searchbox/settings/teenager/util/VibrateHelper;", "onDestroy", "", "startShake", "triggerPhysicalVibrate", "", "shakeCallback", "Lkotlin/Function0;", "Companion", "ShakeAnimatorUpdateListener", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShakeHelper.kt */
public final class ShakeHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float SHAKE_AMPLITUDE = 20.0f;
    private static final long SHAKE_DURATION = 150;
    private static final int SHAKE_REPEAT_COUNT = 3;
    private final Lazy shakeAnimator$delegate = LazyKt.lazy(new ShakeHelper$shakeAnimator$2(this));
    private final Lazy shakeAnimatorUpdateListener$delegate = LazyKt.lazy(new ShakeHelper$shakeAnimatorUpdateListener$2(this));
    /* access modifiers changed from: private */
    public WeakReference<View> shakeView;
    private VibrateHelper vibrateHelper;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper$Companion;", "", "()V", "SHAKE_AMPLITUDE", "", "SHAKE_DURATION", "", "SHAKE_REPEAT_COUNT", "", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShakeHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final ShakeAnimatorUpdateListener getShakeAnimatorUpdateListener() {
        return (ShakeAnimatorUpdateListener) this.shakeAnimatorUpdateListener$delegate.getValue();
    }

    private final ValueAnimator getShakeAnimator() {
        Object value = this.shakeAnimator$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shakeAnimator>(...)");
        return (ValueAnimator) value;
    }

    public static /* synthetic */ void startShake$default(ShakeHelper shakeHelper, View view2, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            function0 = null;
        }
        shakeHelper.startShake(view2, z, function0);
    }

    public final void startShake(View shakeView2, boolean triggerPhysicalVibrate, Function0<Unit> shakeCallback) {
        if (shakeView2 != null) {
            View targetView = shakeView2;
            this.shakeView = new WeakReference<>(targetView);
            if (!getShakeAnimator().isStarted()) {
                getShakeAnimator().start();
                if (triggerPhysicalVibrate) {
                    if (this.vibrateHelper == null) {
                        this.vibrateHelper = new VibrateHelper();
                    }
                    VibrateHelper vibrateHelper2 = this.vibrateHelper;
                    if (vibrateHelper2 != null) {
                        vibrateHelper2.vibrate(targetView.getContext());
                    }
                }
                if (shakeCallback != null) {
                    shakeCallback.invoke();
                }
            }
        }
    }

    public final void onDestroy() {
        if (getShakeAnimator().isStarted()) {
            getShakeAnimator().cancel();
        }
        this.vibrateHelper = null;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper$ShakeAnimatorUpdateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "(Lcom/baidu/searchbox/settings/teenager/util/ShakeHelper;)V", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShakeHelper.kt */
    private final class ShakeAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        public ShakeAnimatorUpdateListener() {
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            View targetView;
            float realProgress;
            Intrinsics.checkNotNullParameter(animation, "animation");
            WeakReference access$getShakeView$p = ShakeHelper.this.shakeView;
            if (access$getShakeView$p != null && (targetView = (View) access$getShakeView$p.get()) != null) {
                float progress = animation.getAnimatedFraction();
                if (progress < 0.4f) {
                    realProgress = (progress / 0.25f) * -20.0f;
                } else if (progress < 0.6f) {
                    realProgress = (((progress - 0.25f) / 0.25f) - 1.0f) * 20.0f;
                } else if (progress < 0.8f) {
                    realProgress = ((progress - 0.5f) / 0.25f) * 20.0f;
                } else if (progress <= 1.0f) {
                    realProgress = (1.0f - ((progress - 0.75f) / 0.25f)) * 20.0f;
                } else {
                    realProgress = 0.0f;
                }
                targetView.setTranslationX(realProgress);
            }
        }
    }
}
