package com.tera.scan.ui.view.widget.tooltip;

import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tera/scan/ui/view/widget/tooltip/AnimationListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UITooltip$fadeOut$1 extends Lambda implements Function1<AnimationListener, Unit> {
    public final /* synthetic */ UITooltip this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UITooltip$fadeOut$1(UITooltip uITooltip) {
        super(1);
        this.this$0 = uITooltip;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AnimationListener animationListener) {
        Intrinsics.checkNotNullParameter(animationListener, "$this$setListener");
        final UITooltip uITooltip = this.this$0;
        animationListener.onAnimationEnd((Function1<? super Animation, Unit>) new Function1<Animation, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Animation) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Animation animation) {
                uITooltip.f7379ad = false;
                uITooltip.ddd();
                uITooltip.ggg();
            }
        });
    }
}
