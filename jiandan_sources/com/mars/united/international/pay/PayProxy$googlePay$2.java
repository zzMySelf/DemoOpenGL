package com.mars.united.international.pay;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/mars/united/international/pay/GooglePay;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class PayProxy$googlePay$2 extends Lambda implements Function0<GooglePay> {
    public final /* synthetic */ PayProxy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayProxy$googlePay$2(PayProxy payProxy) {
        super(0);
        this.this$0 = payProxy;
    }

    @NotNull
    public final GooglePay invoke() {
        return new GooglePay(this.this$0.qw);
    }
}
