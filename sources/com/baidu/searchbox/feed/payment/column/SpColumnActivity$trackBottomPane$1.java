package com.baidu.searchbox.feed.payment.column;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnActivity.kt */
final class SpColumnActivity$trackBottomPane$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ SpColumnMeasureSpec $spec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpColumnActivity$trackBottomPane$1(SpColumnMeasureSpec spColumnMeasureSpec) {
        super(1);
        this.$spec = spColumnMeasureSpec;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int it) {
        this.$spec.adjustBottomPaneHeight(it);
    }
}
