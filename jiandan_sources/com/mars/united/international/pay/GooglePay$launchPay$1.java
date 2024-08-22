package com.mars.united.international.pay;

import fe.de.qw.qw.o;
import fe.ggg.ad.ad.qw.de;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class GooglePay$launchPay$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ de $params;
    public final /* synthetic */ o $productDetails;
    public final /* synthetic */ GooglePay this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePay$launchPay$1(GooglePay googlePay, de deVar, o oVar) {
        super(0);
        this.this$0 = googlePay;
        this.$params = deVar;
        this.$productDetails = oVar;
    }

    public final void invoke() {
        this.this$0.m707if(this.$params, this.$productDetails);
    }
}
