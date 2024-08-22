package com.tera.scan.ui.view.widget.tooltip;

import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fe.mmm.qw.f.ad.de.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tera/scan/ui/view/widget/tooltip/AttachStateChangeListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UITooltip$setupListeners$1 extends Lambda implements Function1<AttachStateChangeListener, Unit> {
    public final /* synthetic */ UITooltip this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UITooltip$setupListeners$1(UITooltip uITooltip) {
        super(1);
        this.this$0 = uITooltip;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AttachStateChangeListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AttachStateChangeListener attachStateChangeListener) {
        Intrinsics.checkNotNullParameter(attachStateChangeListener, "$this$addOnAttachStateChangeListener");
        final UITooltip uITooltip = this.this$0;
        attachStateChangeListener.onViewDetachedFromWindow((Function2<? super View, ? super View.OnAttachStateChangeListener, Unit>) new Function2<View, View.OnAttachStateChangeListener, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((View) obj, (View.OnAttachStateChangeListener) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable View view, @NotNull View.OnAttachStateChangeListener onAttachStateChangeListener) {
                Intrinsics.checkNotNullParameter(onAttachStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                qw.qw.qw(uITooltip.qw, "anchorView detached from parent");
                if (view != null) {
                    view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
                }
                uITooltip.ggg();
            }
        });
    }
}
