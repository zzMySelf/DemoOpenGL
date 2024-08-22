package com.baidu.netdisk.trade.pay.config;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/baidu/netdisk/trade/pay/config/PayRunTime;", "", "()V", "config", "Lcom/baidu/netdisk/trade/pay/config/IPayConfig;", "getConfig", "()Lcom/baidu/netdisk/trade/pay/config/IPayConfig;", "config$delegate", "Lkotlin/Lazy;", "iRequest", "Lcom/baidu/netdisk/trade/pay/config/IRequest;", "getIRequest", "()Lcom/baidu/netdisk/trade/pay/config/IRequest;", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class _ {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final Lazy f907ad = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PayRunTime$config$2.INSTANCE);
    @NotNull
    public static final _ qw = new _();

    public final IPayConfig ad() {
        return (IPayConfig) f907ad.getValue();
    }

    @Nullable
    public final IRequest qw() {
        IPayConfig ad2 = ad();
        if (ad2 != null) {
            return ad2.getRequest();
        }
        return null;
    }
}
