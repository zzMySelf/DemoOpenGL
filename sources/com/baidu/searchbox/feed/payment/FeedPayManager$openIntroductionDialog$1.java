package com.baidu.searchbox.feed.payment;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/feed/payment/FeedPay;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: feedpay.kt */
final class FeedPayManager$openIntroductionDialog$1 extends Lambda implements Function1<FeedPay, Unit> {
    final /* synthetic */ int $biz;
    final /* synthetic */ DismissCallback $callback;
    final /* synthetic */ int $columnType;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedPayManager$openIntroductionDialog$1(Context context, String str, int i2, int i3, DismissCallback dismissCallback) {
        super(1);
        this.$context = context;
        this.$type = str;
        this.$biz = i2;
        this.$columnType = i3;
        this.$callback = dismissCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((FeedPay) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(FeedPay it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.openIntroductionDialog(this.$context, this.$type, this.$biz, this.$columnType, this.$callback);
    }
}
