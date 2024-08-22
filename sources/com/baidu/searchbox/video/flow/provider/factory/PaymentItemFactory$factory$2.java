package com.baidu.searchbox.video.flow.provider.factory;

import com.baidu.searchbox.video.feedflow.detail.payment.PaymentItemComponentRegister;
import com.baidu.searchbox.video.feedflow.provider.PaymentItemUnitProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/payment/PaymentItemComponentRegister;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentItemFactory.kt */
final class PaymentItemFactory$factory$2 extends Lambda implements Function0<PaymentItemComponentRegister> {
    final /* synthetic */ PaymentItemUnitProvider $provider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentItemFactory$factory$2(PaymentItemUnitProvider paymentItemUnitProvider) {
        super(0);
        this.$provider = paymentItemUnitProvider;
    }

    public final PaymentItemComponentRegister invoke() {
        return new PaymentItemComponentRegister(this.$provider);
    }
}
