package com.tera.scan.vip.util;

import com.mars.united.international.pay.PayMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "msg", "Lcom/mars/united/international/pay/PayMessage;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VipSellerCodeReview$launchBuy$1 extends Lambda implements Function1<PayMessage, Unit> {
    public final /* synthetic */ String $serverOrderId;
    public final /* synthetic */ VipSellerCodeReview this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipSellerCodeReview$launchBuy$1(VipSellerCodeReview vipSellerCodeReview, String str) {
        super(1);
        this.this$0 = vipSellerCodeReview;
        this.$serverOrderId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PayMessage) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable PayMessage payMessage) {
        if (payMessage != null) {
            this.this$0.rg(payMessage, this.$serverOrderId);
        }
    }
}
