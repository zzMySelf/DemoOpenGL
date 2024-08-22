package com.baidu.searchbox.video.feedflow.detail.payment.secure;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/secure/PaymentSecureManifest;", "", "()V", "switch", "", "getSwitch", "()Z", "switch$delegate", "Lkotlin/Lazy;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSecureUtilsImpl.kt */
public final class PaymentSecureManifest {
    public static final PaymentSecureManifest INSTANCE = new PaymentSecureManifest();
    private static final Lazy switch$delegate = LazyKt.lazy(PaymentSecureManifest$switch$2.INSTANCE);

    private PaymentSecureManifest() {
    }

    public final boolean getSwitch() {
        return ((Boolean) switch$delegate.getValue()).booleanValue();
    }
}
