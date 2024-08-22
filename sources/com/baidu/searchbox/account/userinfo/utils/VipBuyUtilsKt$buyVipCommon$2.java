package com.baidu.searchbox.account.userinfo.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/account/userinfo/utils/VipBuyUtilsKt$buyVipCommon$2", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "msg", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipBuyUtils.kt */
public final class VipBuyUtilsKt$buyVipCommon$2 extends NAReceiverCallback {
    final /* synthetic */ int $buyVipType;
    final /* synthetic */ Ref.IntRef $status;
    final /* synthetic */ Function1<Integer, Unit> $vipBuyFailCb;
    final /* synthetic */ Function0<Unit> $vipBuySuccessCb;
    final /* synthetic */ Ref.IntRef $vipType;

    VipBuyUtilsKt$buyVipCommon$2(Ref.IntRef $status2, int $buyVipType2, Ref.IntRef $vipType2, Function0<Unit> $vipBuySuccessCb2, Function1<? super Integer, Unit> $vipBuyFailCb2) {
        this.$status = $status2;
        this.$buyVipType = $buyVipType2;
        this.$vipType = $vipType2;
        this.$vipBuySuccessCb = $vipBuySuccessCb2;
        this.$vipBuyFailCb = $vipBuyFailCb2;
    }

    public void onReceive(String action, String msg) {
        if (TextUtils.equals("com.baidu.datachannel.vipPurchasePanel", action)) {
            CharSequence charSequence = msg;
            if (!(charSequence == null || charSequence.length() == 0)) {
                try {
                    if (2 == new JSONObject(msg).optInt("closePage")) {
                        if (1 == this.$status.element && this.$buyVipType == this.$vipType.element) {
                            this.$vipBuySuccessCb.invoke();
                        } else {
                            this.$vipBuyFailCb.invoke(Integer.valueOf(this.$status.element));
                        }
                        VipBuyUtilsKt.unregisterAccountVipBuy();
                        if (AppConfig.isDebug()) {
                            Log.d("VIPBuyUtils", "close panel and callback, status: " + this.$status.element + ", vipType: " + this.$vipType.element);
                        }
                    }
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
