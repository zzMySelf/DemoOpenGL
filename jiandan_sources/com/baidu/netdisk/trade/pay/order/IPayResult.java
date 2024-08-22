package com.baidu.netdisk.trade.pay.order;

import fe.fe.when.qw.qw.yj.ad;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/baidu/netdisk/trade/pay/order/IPayResult;", "", "actionResult", "", "result", "Lcom/baidu/netdisk/trade/pay/finishpay/PayResult;", "openResultPage", "url", "", "orderId", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IPayResult {
    void actionResult(@NotNull ad adVar);

    void openResultPage(@NotNull String str, @NotNull String str2);
}
