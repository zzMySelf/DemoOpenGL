package com.tera.scan.ui.view.widget.tooltip;

import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\t2#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0012\u0010\u0003\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J+\u0010\n\u001a\u00020\t2#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J+\u0010\u000b\u001a\u00020\t2#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016R-\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R-\u0010\n\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R-\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tera/scan/ui/view/widget/tooltip/AnimationListener;", "Landroid/view/animation/Animation$AnimationListener;", "()V", "onAnimationEnd", "Lkotlin/Function1;", "Landroid/view/animation/Animation;", "Lkotlin/ParameterName;", "name", "animation", "", "onAnimationRepeat", "onAnimationStart", "func", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimationListener implements Animation.AnimationListener {
    @Nullable
    public Function1<? super Animation, Unit> onAnimationEnd;
    @Nullable
    public Function1<? super Animation, Unit> onAnimationRepeat;
    @Nullable
    public Function1<? super Animation, Unit> onAnimationStart;

    public void onAnimationEnd(@Nullable Animation animation) {
        Function1<? super Animation, Unit> function1 = this.onAnimationEnd;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    public void onAnimationRepeat(@Nullable Animation animation) {
        Function1<? super Animation, Unit> function1 = this.onAnimationRepeat;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    public void onAnimationStart(@Nullable Animation animation) {
        Function1<? super Animation, Unit> function1 = this.onAnimationStart;
        if (function1 != null) {
            function1.invoke(animation);
        }
    }

    public final void onAnimationEnd(@NotNull Function1<? super Animation, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        this.onAnimationEnd = function1;
    }

    public final void onAnimationRepeat(@NotNull Function1<? super Animation, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        this.onAnimationRepeat = function1;
    }

    public final void onAnimationStart(@NotNull Function1<? super Animation, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        this.onAnimationStart = function1;
    }
}
