package com.baidu.searchbox.vip.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.vip.R;
import com.baidu.searchbox.vip.VipUserInfoManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/vip/utils/VipBuyActiveCommonUtilsKt$commonActiveVip$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "msg", "lib-vip_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipBuyActiveCommonUtils.kt */
public final class VipBuyActiveCommonUtilsKt$commonActiveVip$1 extends NAReceiverCallback {
    final /* synthetic */ WeakReference<Context> $cxt;
    final /* synthetic */ Function2<String, Integer, Unit> $vipActiveFailCb;
    final /* synthetic */ Function1<String, Unit> $vipActiveSuccessCb;

    VipBuyActiveCommonUtilsKt$commonActiveVip$1(WeakReference<Context> $cxt2, Function2<? super String, ? super Integer, Unit> $vipActiveFailCb2, Function1<? super String, Unit> $vipActiveSuccessCb2) {
        this.$cxt = $cxt2;
        this.$vipActiveFailCb = $vipActiveFailCb2;
        this.$vipActiveSuccessCb = $vipActiveSuccessCb2;
    }

    public void onReceive(String action, String msg) {
        Context it;
        if (AppConfig.isDebug() && (it = (Context) this.$cxt.get()) != null) {
            Log.d("VipBuyActiveCommonUtils", it.getResources().getString(R.string.vip_data_channel_active));
        }
        if (Intrinsics.areEqual((Object) "com.baidu.datachannel.vip.activation", (Object) action)) {
            CharSequence charSequence = msg;
            if (!(charSequence == null || charSequence.length() == 0)) {
                try {
                    JSONObject obj = new JSONObject(msg);
                    if (obj.has("errno")) {
                        VipBuyActiveCommonUtilsKt.unregisterVipActive();
                    }
                    int status = obj.optInt("errno");
                    String type = obj.optString("type");
                    if (status == 0) {
                        VipUserInfoManager.syncVipInfo(new VipBuyActiveCommonUtilsKt$commonActiveVip$1$onReceive$2(this.$vipActiveSuccessCb, type), false);
                        return;
                    }
                    Function2<String, Integer, Unit> function2 = this.$vipActiveFailCb;
                    if (function2 != null) {
                        Function2<String, Integer, Unit> function22 = function2;
                        Intrinsics.checkNotNullExpressionValue(type, "type");
                        function2.invoke(type, Integer.valueOf(status));
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
