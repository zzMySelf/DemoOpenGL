package fe.fe.when.qw.qw.th;

import android.content.Context;
import android.widget.Toast;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.baidu.netdisk.trade.pay.channel._____;
import com.baidu.netdisk.trade.pay.finishpay._;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import fe.fe.when.qw.qw.yj.ad;
import fe.fe.when.qw.qw.yj.de;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* renamed from: fe.fe.when.qw.qw.th.switch  reason: invalid class name */
public final class Cswitch implements _____, _<BaseResp> {
    @Nullable
    public MutableLiveData<ad> qw;

    public int de(@Nullable Integer num) {
        if (num != null && num.intValue() == 0) {
            return 0;
        }
        return (num != null && num.intValue() == -2) ? 1004 : 1001;
    }

    public final PayReq fe(String str) {
        PayReq payReq = new PayReq();
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject(str);
            payReq.appId = jSONObject.optString("appid");
            payReq.partnerId = jSONObject.optString("partnerid");
            payReq.prepayId = jSONObject.optString("prepayid");
            payReq.packageValue = jSONObject.optString("package");
            payReq.nonceStr = jSONObject.optString("noncestr");
            payReq.timeStamp = jSONObject.optString("timestamp");
            payReq.sign = jSONObject.optString("paySign");
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        return payReq;
    }

    public void qw(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull MutableLiveData<ad> mutableLiveData, @Nullable com.baidu.netdisk.trade.pay._ _2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(str, "purchaseInfo");
        Intrinsics.checkNotNullParameter(mutableLiveData, "result");
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(fragmentActivity, (String) null);
        if (!createWXAPI.isWXAppInstalled()) {
            Toast.makeText(fragmentActivity, "您没有安装微信，请选择其他支付方式", 0).show();
            return;
        }
        this.qw = mutableLiveData;
        PayReq fe2 = fe(str);
        createWXAPI.registerApp(fe2.appId);
        createWXAPI.sendReq(fe2);
    }

    /* renamed from: rg */
    public void ad(@NotNull Context context, @Nullable BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (baseResp == null) {
            Toast.makeText(context, "微信返回失败", 0).show();
            return;
        }
        MutableLiveData<ad> mutableLiveData = this.qw;
        if (mutableLiveData != null) {
            de.ad(mutableLiveData, de(Integer.valueOf(baseResp.errCode)), baseResp.errStr);
        }
    }
}
