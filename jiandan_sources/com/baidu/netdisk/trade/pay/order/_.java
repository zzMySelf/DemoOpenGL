package com.baidu.netdisk.trade.pay.order;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.netdisk.trade.pay.channel.ChannelMode;
import com.baidu.netdisk.trade.pay.order.model.Purchase;
import com.mars.kotlin.extension.Tag;
import fe.fe.when.qw.qw.rg;
import fe.fe.when.qw.qw.yj.ad;
import i.qw.Cif;
import i.qw.i0;
import i.qw.u;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"Lcom/baidu/netdisk/trade/pay/order/OrderManager;", "", "()V", "createOrder", "Landroidx/lifecycle/LiveData;", "Lcom/baidu/netdisk/trade/pay/order/model/Purchase;", "map", "", "", "pay", "Lcom/baidu/netdisk/trade/pay/finishpay/PayResult;", "activity", "Landroidx/fragment/app/FragmentActivity;", "purchase", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("OrderManager")
public final class _ {
    @NotNull
    public final LiveData<Purchase> ad(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        MutableLiveData mutableLiveData = new MutableLiveData();
        Job unused = Cif.fe(i0.f6136ad, u.ad(), (CoroutineStart) null, new OrderManager$createOrder$1(map, mutableLiveData, (Continuation<? super OrderManager$createOrder$1>) null), 2, (Object) null);
        return mutableLiveData;
    }

    @NotNull
    public final LiveData<ad> qw(@NotNull FragmentActivity fragmentActivity, @NotNull Purchase purchase) {
        Object obj;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        try {
            Result.Companion companion = Result.Companion;
            Map<String, String> _2 = purchase._();
            obj = Result.m1155constructorimpl(_2 != null ? new JSONObject(_2).toString() : null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        int __ = purchase.__();
        boolean z3 = false;
        if (__ == ChannelMode.WEBCHAT.getValue() || __ == ChannelMode.DXM_ALI.getValue()) {
            z = true;
        } else {
            z = false;
        }
        if (!z && __ != ChannelMode.DXM_SIGN.getValue()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 || __ == ChannelMode.DXM_WEBCHAT.getValue()) {
            z3 = true;
        }
        if (z3) {
            return new rg().de(fragmentActivity, purchase.__(), str, (com.baidu.netdisk.trade.pay._) null);
        }
        return rg.fe(new rg(), fragmentActivity, str, (com.baidu.netdisk.trade.pay._) null, 4, (Object) null);
    }
}
