package com.tera.scan.scanner.ui.cameranew;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.mmm.qw.j.i;
import fe.mmm.qw.tt.rg.ad.ad;
import fe.mmm.qw.tt.rg.ad.fe;
import fe.mmm.qw.tt.rg.ad.uk;
import fe.mmm.qw.tt.rg.ad.yj;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J\u0017\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/scanner/ui/cameranew/FocusIndicatorView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentShowId", "", "Ljava/lang/Long;", "show", "", "position", "Landroid/graphics/PointF;", "targetView", "Landroid/view/View;", "startAnimation", "onEnd", "Lkotlin/Function0;", "tryRemove", "removeId", "(Ljava/lang/Long;)V", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
@Tag("FocusIndicatorView")
public final class FocusIndicatorView extends ImageView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    public Long currentShowId;

    public static final class qw implements Animator.AnimatorListener {
        public final /* synthetic */ Function0<Unit> qw;

        public qw(Function0<Unit> function0) {
            this.qw = function0;
        }

        public static final void qw(Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "$onEnd");
            function0.invoke();
        }

        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            LoggerKt.d$default("Animation cancel", (Object) null, 1, (Object) null);
        }

        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            LoggerKt.d$default("Animation end", (Object) null, 1, (Object) null);
            new Handler(Looper.getMainLooper()).post(new fe(this.qw));
        }

        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            LoggerKt.d$default("Animation repeat", (Object) null, 1, (Object) null);
        }

        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animation");
            LoggerKt.d$default("Animation start", (Object) null, 1, (Object) null);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FocusIndicatorView(@NotNull Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FocusIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.currentShowId = 0L;
        setImageResource(R.drawable.ocr_focus_indicator);
        setAdjustViewBounds(true);
    }

    private final void startAnimation(Function0<Unit> function0) {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f}).setDuration(400);
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        duration.addUpdateListener(new yj(this));
        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{0.4f, 1.0f}).setDuration(400);
        duration2.setInterpolator(new AccelerateDecelerateInterpolator());
        duration2.addUpdateListener(new ad(this));
        ValueAnimator duration3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(700);
        duration3.setInterpolator(new AccelerateDecelerateInterpolator());
        duration3.addUpdateListener(new uk(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{duration, duration2, duration3});
        animatorSet.addListener(new qw(function0));
        animatorSet.start();
    }

    /* renamed from: startAnimation$lambda-2  reason: not valid java name */
    public static final void m916startAnimation$lambda2(FocusIndicatorView focusIndicatorView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(focusIndicatorView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            focusIndicatorView.setAlpha(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* renamed from: startAnimation$lambda-3  reason: not valid java name */
    public static final void m917startAnimation$lambda3(FocusIndicatorView focusIndicatorView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(focusIndicatorView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            focusIndicatorView.setAlpha(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* renamed from: startAnimation$lambda-4  reason: not valid java name */
    public static final void m918startAnimation$lambda4(FocusIndicatorView focusIndicatorView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(focusIndicatorView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            focusIndicatorView.setAlpha(((Float) animatedValue).floatValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    /* access modifiers changed from: private */
    public final void tryRemove(Long l) {
        if (l == null || Intrinsics.areEqual((Object) l, (Object) this.currentShowId)) {
            clearAnimation();
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
            this.currentShowId = null;
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @MainThread
    public final void show(@NotNull PointF pointF, @Nullable View view) {
        Intrinsics.checkNotNullParameter(pointF, "position");
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            LoggerKt.d$default("Preparing add new view " + this.currentShowId, (Object) null, 1, (Object) null);
            setVisibility(8);
            tryRemove((Long) null);
            LoggerKt.d$default("Remove any previous view", (Object) null, 1, (Object) null);
            long ad2 = i.ad();
            this.currentShowId = Long.valueOf(ad2);
            viewGroup.addView(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = fe.mmm.qw.p030switch.th.de.ad.qw.qw(viewGroup.getContext(), 60.0f);
            layoutParams.height = fe.mmm.qw.p030switch.th.de.ad.qw.qw(viewGroup.getContext(), 60.0f);
            boolean z = layoutParams instanceof ViewGroup.MarginLayoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams = z ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = (int) (pointF.x - (((float) layoutParams.width) / ((float) 2)));
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = z ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams2 != null) {
                marginLayoutParams2.topMargin = (int) (pointF.y - (((float) layoutParams.height) / ((float) 2)));
            }
            setVisibility(0);
            LoggerKt.d$default("View added, start animation " + ad2, (Object) null, 1, (Object) null);
            startAnimation(new FocusIndicatorView$show$2(ad2, this));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FocusIndicatorView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }
}
