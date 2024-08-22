package com.mars.united.international.pay;

import androidx.lifecycle.MutableLiveData;
import fe.de.qw.qw.o;
import fe.ggg.ad.ad.qw.fe;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class GooglePay$queryProductsPrice$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ List<fe> $productParams;
    public final /* synthetic */ MutableLiveData<List<o>> $productsPriceLiveData;
    public final /* synthetic */ GooglePay this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePay$queryProductsPrice$1(GooglePay googlePay, List<fe> list, MutableLiveData<List<o>> mutableLiveData) {
        super(0);
        this.this$0 = googlePay;
        this.$productParams = list;
        this.$productsPriceLiveData = mutableLiveData;
    }

    public final void invoke() {
        this.this$0.xxx(this.$productParams, this.$productsPriceLiveData);
    }
}
