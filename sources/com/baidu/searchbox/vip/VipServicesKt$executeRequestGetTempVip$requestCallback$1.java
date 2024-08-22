package com.baidu.searchbox.vip;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "responseString", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipServices.kt */
final class VipServicesKt$executeRequestGetTempVip$requestCallback$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ boolean $needConfirmVipRight;
    final /* synthetic */ long $retryIntervalTimes;
    final /* synthetic */ Function3<Integer, String, String, Unit> $tempVipCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VipServicesKt$executeRequestGetTempVip$requestCallback$1(Function3<? super Integer, ? super String, ? super String, Unit> function3, boolean z, long j2) {
        super(1);
        this.$tempVipCallback = function3;
        this.$needConfirmVipRight = z;
        this.$retryIntervalTimes = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String responseString) {
        if (responseString != null) {
            try {
                Function3<Integer, String, String, Unit> function3 = this.$tempVipCallback;
                boolean z = this.$needConfirmVipRight;
                long j2 = this.$retryIntervalTimes;
                JSONObject dataObj = new JSONObject(responseString);
                String errCode = dataObj.optString("errno", "-1");
                if (!TextUtils.equals("0", errCode)) {
                    String errMsg = dataObj.optString("errmsg");
                    if (AppConfig.isDebug()) {
                        Log.d("VipServices", "requestGetTempVip:errCode is " + errCode + ", errMsg is " + errMsg);
                    }
                    function3.invoke(Integer.valueOf(TextUtils.equals(errCode, VipUserInfoManagerKt.DU_MEMBER_ERROR_CODE) ? 1 : -1), errCode, errMsg);
                    return;
                }
                JSONObject data = dataObj.optJSONObject("data");
                if (data != null) {
                    Intrinsics.checkNotNullExpressionValue(data, "data");
                    JSONObject $this$invoke_u24lambda_u2d2_u24lambda_u2d1 = data;
                    int i2 = 0;
                    if (!$this$invoke_u24lambda_u2d2_u24lambda_u2d1.optBoolean("status", false)) {
                        i2 = -1;
                    }
                    int resultCode = i2;
                    if (AppConfig.isDebug()) {
                        JSONObject jSONObject = $this$invoke_u24lambda_u2d2_u24lambda_u2d1;
                        Log.d("VipServices", "requestGetTempVip: resultCode = " + resultCode);
                    }
                    if (resultCode != 0 || !z) {
                        function3.invoke(Integer.valueOf(resultCode), "", "");
                    } else {
                        ExecutorUtilsExt.delayPostOnElastic(new VipServicesKt$executeRequestGetTempVip$requestCallback$1$$ExternalSyntheticLambda0(function3), "SyncLcpFreeVip", 1, j2);
                    }
                }
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    Log.d("VipServices", "requestGetTempVip: data exception " + e2.getMessage());
                }
                this.$tempVipCallback.invoke(-1, "", "");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m7365invoke$lambda2$lambda1$lambda0(Function3 $tempVipCallback2) {
        Intrinsics.checkNotNullParameter($tempVipCallback2, "$tempVipCallback");
        try {
            VipUserInfoManager.syncVipInfo(new VipServicesKt$executeRequestGetTempVip$requestCallback$1$1$1$1$1($tempVipCallback2), true);
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
            $tempVipCallback2.invoke(-1, "", "");
        }
    }
}
