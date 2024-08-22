package com.tera.scan.ui.view.widget.tooltip;

import android.view.View;
import com.tera.scan.ui.view.widget.tooltip.UITooltip;
import fe.mmm.qw.f.de.de.de.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tera/scan/ui/view/widget/tooltip/AttachStateChangeListener;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UITooltip$show$1 extends Lambda implements Function1<AttachStateChangeListener, Unit> {
    public final /* synthetic */ boolean $fitToScreen;
    public final /* synthetic */ UITooltip.Gravity $gravity;
    public final /* synthetic */ View $parent;
    public final /* synthetic */ UITooltip this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UITooltip$show$1(UITooltip uITooltip, View view, UITooltip.Gravity gravity, boolean z) {
        super(1);
        this.this$0 = uITooltip;
        this.$parent = view;
        this.$gravity = gravity;
        this.$fitToScreen = z;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m926invoke$lambda0(UITooltip uITooltip, View view, UITooltip.Gravity gravity, boolean z) {
        Intrinsics.checkNotNullParameter(uITooltip, "this$0");
        Intrinsics.checkNotNullParameter(view, "$parent");
        Intrinsics.checkNotNullParameter(gravity, "$gravity");
        uITooltip.nn(view, gravity, z);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AttachStateChangeListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AttachStateChangeListener attachStateChangeListener) {
        Intrinsics.checkNotNullParameter(attachStateChangeListener, "$this$addOnAttachStateChangeListener");
        this.this$0.f7380de.post(new qw(this.this$0, this.$parent, this.$gravity, this.$fitToScreen));
    }
}
