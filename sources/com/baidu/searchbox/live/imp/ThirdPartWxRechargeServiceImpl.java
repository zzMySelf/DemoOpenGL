package com.baidu.searchbox.live.imp;

import android.app.Activity;
import android.util.Log;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.live.interfaces.service.yy.ThirdPartWxRechargeService;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.ugc.utils.TextViewExtKt;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/live/imp/ThirdPartWxRechargeServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService;", "()V", "paymentManager", "Lcom/baidu/payment/PaymentManager;", "getPaymentManager", "()Lcom/baidu/payment/PaymentManager;", "paymentManager$delegate", "Lkotlin/Lazy;", "dispatchWxPayResult", "", "activity", "Landroid/app/Activity;", "code", "", "result", "", "type", "Lcom/baidu/searchbox/live/interfaces/service/yy/ThirdPartWxRechargeService$WxPayType;", "initWx", "isWxInstalled", "", "wxRecharge", "payUrl", "Companion", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThirdPartWxRechargeServiceImpl.kt */
public final class ThirdPartWxRechargeServiceImpl implements ThirdPartWxRechargeService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HOST_DISPATCH_KEY_WX_RECHARGE_RESULT = "wx_pay_result";
    public static final String HOST_DISPATCH_KEY_YY_WX_RECHARGE_RESULT = "yy_wx_pay_result";
    private static final String KEY_WX_RECHARGE_RESULT_ERROR_CODE = "_wxapi_baseresp_errcode";
    private static final String KEY_WX_RECHARGE_RESULT_ERROR_STR = "_wxapi_baseresp_errstr";
    private final Lazy paymentManager$delegate = LazyKt.lazy(ThirdPartWxRechargeServiceImpl$paymentManager$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/imp/ThirdPartWxRechargeServiceImpl$Companion;", "", "()V", "HOST_DISPATCH_KEY_WX_RECHARGE_RESULT", "", "HOST_DISPATCH_KEY_YY_WX_RECHARGE_RESULT", "KEY_WX_RECHARGE_RESULT_ERROR_CODE", "KEY_WX_RECHARGE_RESULT_ERROR_STR", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ThirdPartWxRechargeServiceImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final PaymentManager getPaymentManager() {
        return (PaymentManager) this.paymentManager$delegate.getValue();
    }

    public void wxRecharge(String payUrl, ThirdPartWxRechargeService.WxPayType type) {
        String str;
        Intrinsics.checkNotNullParameter(payUrl, "payUrl");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            JSONObject payJson = new JSONObject(payUrl);
            payJson.put("packagealias", payJson.optString("package"));
            str = payJson.toString();
        } catch (JSONException e2) {
            str = payUrl;
        }
        Intrinsics.checkNotNullExpressionValue(str, "try {\n            val pa…         payUrl\n        }");
        String payParams = str;
        Activity activity = BdBoxActivityManager.getTopActivity();
        if (activity != null) {
            Activity activity2 = activity;
            if (!getPaymentManager().wxPay(activity, payParams, new ThirdPartWxRechargeServiceImpl$$ExternalSyntheticLambda0(this, activity, type))) {
                dispatchWxPayResult(activity, 6, "wx_start_failed", type);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: wxRecharge$lambda-1$lambda-0  reason: not valid java name */
    public static final void m170wxRecharge$lambda1$lambda0(ThirdPartWxRechargeServiceImpl this$0, Activity $activity, ThirdPartWxRechargeService.WxPayType $type, int statusCode, String result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($type, "$type");
        if (AppConfig.isDebug()) {
            Log.i("ThirdPartWxRecharge", "onPayResult  " + statusCode + TextViewExtKt.TEXT_WITH_ICON_END_TEXT_SPACE + result);
        }
        Intrinsics.checkNotNullExpressionValue($activity, "activity");
        this$0.dispatchWxPayResult($activity, statusCode, result, $type);
    }

    private final void dispatchWxPayResult(Activity activity, int code, String result, ThirdPartWxRechargeService.WxPayType type) {
        int statusCode;
        if (code == 2) {
            statusCode = -2;
        } else {
            statusCode = code;
        }
        HashMap params = new HashMap();
        params.put(KEY_WX_RECHARGE_RESULT_ERROR_CODE, Integer.valueOf(statusCode));
        params.put(KEY_WX_RECHARGE_RESULT_ERROR_STR, result == null ? "" : result);
        if (Intrinsics.areEqual((Object) type, (Object) ThirdPartWxRechargeService.WxPayType.WxPayYYLive.INSTANCE)) {
            LiveNPSPluginManager.getInstance().dispatchHostEvent(activity, HOST_DISPATCH_KEY_WX_RECHARGE_RESULT, params);
        } else if (Intrinsics.areEqual((Object) type, (Object) ThirdPartWxRechargeService.WxPayType.WxPayYYPay.INSTANCE)) {
            LiveNPSPluginManager.getInstance().dispatchHostEvent(activity, HOST_DISPATCH_KEY_YY_WX_RECHARGE_RESULT, params);
        }
    }

    public boolean isWxInstalled() {
        return getPaymentManager().isWxAppInstalled();
    }

    public void initWx() {
    }
}
