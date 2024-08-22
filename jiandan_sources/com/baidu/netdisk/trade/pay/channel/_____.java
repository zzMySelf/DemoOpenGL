package com.baidu.netdisk.trade.pay.channel;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.baidu.netdisk.trade.pay._;
import fe.fe.when.qw.qw.yj.ad;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0005J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/baidu/netdisk/trade/pay/channel/IChannelPay;", "", "getPayResult", "", "code", "(Ljava/lang/Integer;)I", "pay", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "purchaseInfo", "", "result", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/netdisk/trade/pay/finishpay/PayResult;", "originalPayResultCallback", "Lcom/baidu/netdisk/trade/pay/OriginalPayResultCallback;", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface _____ {
    void qw(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull MutableLiveData<ad> mutableLiveData, @Nullable _ _2);
}
