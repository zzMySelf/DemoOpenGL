package com.baidu.searchbox.feed.payment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/feed/payment/FeedPay;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: feedpay.kt */
final class FeedPayManager$setRequestAspect$1 extends Lambda implements Function1<FeedPay, Unit> {
    final /* synthetic */ PayRequestAspect $aspect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedPayManager$setRequestAspect$1(PayRequestAspect payRequestAspect) {
        super(1);
        this.$aspect = payRequestAspect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((FeedPay) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(FeedPay it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setRequestAspect(this.$aspect);
    }
}
