package com.baidu.searchbox.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/layout/GenLinearLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* compiled from: layout.kt */
public final class LayoutKt$horizontal$2 extends Lambda implements Function1<GenLinearLayout, Unit> {
    final /* synthetic */ Function1<GenLinearLayout, Unit> $init;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutKt$horizontal$2(Function1<? super GenLinearLayout, Unit> function1) {
        super(1);
        this.$init = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GenLinearLayout) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GenLinearLayout $this$wrap) {
        Intrinsics.checkNotNullParameter($this$wrap, "$this$wrap");
        $this$wrap.setOrientation(0);
        this.$init.invoke($this$wrap);
    }
}
