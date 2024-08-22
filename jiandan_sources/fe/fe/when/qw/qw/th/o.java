package fe.fe.when.qw.qw.th;

import android.widget.Toast;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.lbspay.BaiduLBSPay;
import com.baidu.netdisk.trade.pay._;
import com.baidu.netdisk.trade.pay.channel.DXMChannelValue;
import com.baidu.netdisk.trade.pay.channel._____;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import fe.fe.when.qw.qw.yj.ad;
import fe.fe.when.qw.qw.yj.de;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class o implements _____ {
    @NotNull
    public final DXMChannelValue qw;

    public o(@NotNull DXMChannelValue dXMChannelValue) {
        Intrinsics.checkNotNullParameter(dXMChannelValue, "channelValue");
        this.qw = dXMChannelValue;
    }

    public static final void de() {
    }

    public static final void fe(MutableLiveData mutableLiveData, o oVar, int i2, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$result");
        Intrinsics.checkNotNullParameter(oVar, "this$0");
        de.ad(mutableLiveData, oVar.ad(Integer.valueOf(i2)), str);
    }

    public static final void rg(_ _2, String str, String str2, String str3) {
        _2.qw(str, str2, str3);
    }

    public static final void th() {
    }

    public static final void yj(MutableLiveData mutableLiveData, o oVar, int i2, String str) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$result");
        Intrinsics.checkNotNullParameter(oVar, "this$0");
        de.ad(mutableLiveData, oVar.ad(Integer.valueOf(i2)), str);
    }

    public int ad(@Nullable Integer num) {
        if (num != null && num.intValue() == 2) {
            return 1004;
        }
        return (num != null && num.intValue() == 0) ? 0 : 1001;
    }

    public void qw(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull MutableLiveData<ad> mutableLiveData, @Nullable _ _2) {
        Object obj;
        FragmentActivity fragmentActivity2 = fragmentActivity;
        MutableLiveData<ad> mutableLiveData2 = mutableLiveData;
        _ _3 = _2;
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "purchaseInfo");
        Intrinsics.checkNotNullParameter(mutableLiveData, "result");
        String reqData = BaiduLBSPay.getInstance().getReqData(fragmentActivity);
        boolean z = false;
        if (this.qw != DXMChannelValue.DXM_WEBCHAT || WXAPIFactory.createWXAPI(fragmentActivity, (String) null).isWXAppInstalled()) {
            if (reqData == null || reqData.length() == 0) {
                de.ad(mutableLiveData, 1001, "dxm ali pay req null");
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                JSONObject jSONObject = new JSONObject(reqData);
                jSONObject.put("token", "lbspay");
                obj = Result.m1155constructorimpl(jSONObject.put("payChannel", this.qw.getValue()));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj)) {
                obj = null;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            String jSONObject3 = jSONObject2 != null ? jSONObject2.toString() : null;
            if (jSONObject3 == null || jSONObject3.length() == 0) {
                z = true;
            }
            if (z) {
                de.ad(mutableLiveData, 1001, "dxm ali pay req null not json");
            } else if (_3 == null) {
                BaiduLBSPay.getInstance().doCallFrontCashierPay(fragmentActivity, qw.qw, new de(mutableLiveData, this), fe.fe.when.qw.qw.fe.ad.de(str), jSONObject3);
            } else {
                BaiduLBSPay.getInstance().doCallFrontCashierPay(fragmentActivity, th.qw, new rg(mutableLiveData, this), fe.fe.when.qw.qw.fe.ad.de(str), jSONObject3, new fe(_3));
            }
        } else {
            Toast.makeText(fragmentActivity, "您没有安装微信，请选择其他支付方式", 0).show();
        }
    }
}
