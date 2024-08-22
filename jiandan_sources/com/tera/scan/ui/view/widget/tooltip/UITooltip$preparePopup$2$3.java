package com.tera.scan.ui.view.widget.tooltip;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tera/scan/ui/view/widget/tooltip/AttachStateChangeListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UITooltip$preparePopup$2$3 extends Lambda implements Function1<AttachStateChangeListener, Unit> {
    public final /* synthetic */ UITooltip $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UITooltip$preparePopup$2$3(UITooltip uITooltip) {
        super(1);
        this.$this_run = uITooltip;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AttachStateChangeListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AttachStateChangeListener attachStateChangeListener) {
        Intrinsics.checkNotNullParameter(attachStateChangeListener, "$this$addOnAttachStateChangeListener");
        final UITooltip uITooltip = this.$this_run;
        attachStateChangeListener.onViewAttachedToWindow((Function2<? super View, ? super View.OnAttachStateChangeListener, Unit>) new Function2<View, View.OnAttachStateChangeListener, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((View) obj, (View.OnAttachStateChangeListener) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable View view, @NotNull View.OnAttachStateChangeListener onAttachStateChangeListener) {
                Intrinsics.checkNotNullParameter(onAttachStateChangeListener, "<anonymous parameter 1>");
                ValueAnimator fe2 = uITooltip.f7388yj;
                if (fe2 != null) {
                    fe2.start();
                }
                if (uITooltip.f7386th > 0) {
                    uITooltip.f7380de.removeCallbacks(uITooltip.f7383o);
                    uITooltip.f7380de.postDelayed(uITooltip.f7383o, uITooltip.f7386th);
                }
                uITooltip.f7380de.removeCallbacks(uITooltip.f7384pf);
                uITooltip.f7380de.postDelayed(uITooltip.f7384pf, uITooltip.f7381fe);
            }
        });
        final UITooltip uITooltip2 = this.$this_run;
        attachStateChangeListener.onViewDetachedFromWindow((Function2<? super View, ? super View.OnAttachStateChangeListener, Unit>) new Function2<View, View.OnAttachStateChangeListener, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((View) obj, (View.OnAttachStateChangeListener) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable View view, @NotNull View.OnAttachStateChangeListener onAttachStateChangeListener) {
                Intrinsics.checkNotNullParameter(onAttachStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                if (view != null) {
                    view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
                }
                ValueAnimator fe2 = uITooltip2.f7388yj;
                if (fe2 != null) {
                    fe2.cancel();
                }
                uITooltip2.ddd();
            }
        });
    }
}
