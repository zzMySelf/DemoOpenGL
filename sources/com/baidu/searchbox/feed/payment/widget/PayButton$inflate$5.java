package com.baidu.searchbox.feed.payment.widget;

import com.baidu.searchbox.layout.GenLayoutParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/layout/GenLayoutParams;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayButton.kt */
final class PayButton$inflate$5 extends Lambda implements Function1<GenLayoutParams, Unit> {
    public static final PayButton$inflate$5 INSTANCE = new PayButton$inflate$5();

    PayButton$inflate$5() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GenLayoutParams) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GenLayoutParams $this$lparams) {
        Intrinsics.checkNotNullParameter($this$lparams, "$this$lparams");
        $this$lparams.setWidth(-1);
        $this$lparams.setHeight(-1);
        $this$lparams.setGravity(17);
    }
}
