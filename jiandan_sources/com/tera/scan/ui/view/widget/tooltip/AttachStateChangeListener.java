package com.tera.scan.ui.view.widget.tooltip;

import android.view.View;
import com.dlife.ctaccountapi.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\n28\u0010\f\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004J\u0010\u0010\u0003\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016J@\u0010\u000b\u001a\u00020\n28\u0010\f\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016RB\u0010\u0003\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000RB\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tera/scan/ui/view/widget/tooltip/AttachStateChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "()V", "onViewAttachedToWindow", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "listener", "", "onViewDetachedFromWindow", "func", "v", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AttachStateChangeListener implements View.OnAttachStateChangeListener {
    @Nullable
    public Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> onViewAttachedToWindow;
    @Nullable
    public Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> onViewDetachedFromWindow;

    public final void onViewAttachedToWindow(@NotNull Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "func");
        this.onViewAttachedToWindow = function2;
    }

    public final void onViewDetachedFromWindow(@NotNull Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "func");
        this.onViewDetachedFromWindow = function2;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, v.d);
        Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> function2 = this.onViewAttachedToWindow;
        if (function2 != null) {
            function2.invoke(view, this);
        }
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, v.d);
        Function2<? super View, ? super View.OnAttachStateChangeListener, Unit> function2 = this.onViewDetachedFromWindow;
        if (function2 != null) {
            function2.invoke(view, this);
        }
    }
}
