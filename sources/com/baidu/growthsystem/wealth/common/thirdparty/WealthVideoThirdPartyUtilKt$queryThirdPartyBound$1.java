package com.baidu.growthsystem.wealth.common.thirdparty;

import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"com/baidu/growthsystem/wealth/common/thirdparty/WealthVideoThirdPartyUtilKt$queryThirdPartyBound$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lorg/json/JSONObject;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "data", "statusCode", "", "parseResponse", "response", "Lokhttp3/Response;", "i", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoThirdPartyUtil.kt */
public final class WealthVideoThirdPartyUtilKt$queryThirdPartyBound$1 extends ResponseCallback<JSONObject> {
    final /* synthetic */ WealthVideoThirdPartyQueryBoundCallback $callback;

    WealthVideoThirdPartyUtilKt$queryThirdPartyBound$1(WealthVideoThirdPartyQueryBoundCallback $callback2) {
        this.$callback = $callback2;
    }

    public JSONObject parseResponse(Response response, int i2) {
        Object obj;
        JSONObject jSONObject;
        boolean z = true;
        if (response == null || !response.isSuccessful()) {
            z = false;
        }
        JSONObject jSONObject2 = null;
        if (z) {
            try {
                Result.Companion companion = Result.Companion;
                WealthVideoThirdPartyUtilKt$queryThirdPartyBound$1 wealthVideoThirdPartyUtilKt$queryThirdPartyBound$1 = this;
                ResponseBody body = response.body();
                if (body != null) {
                    jSONObject = new JSONObject(body.string());
                } else {
                    jSONObject = null;
                }
                obj = Result.m8971constructorimpl(jSONObject);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m8977isFailureimpl(obj)) {
                jSONObject2 = obj;
            }
            return jSONObject2;
        }
        JSONObject jSONObject3 = null;
        return null;
    }

    public void onSuccess(JSONObject data, int statusCode) {
        JSONObject optJSONObject;
        String isBind = null;
        if (!Intrinsics.areEqual((Object) data != null ? data.optString("errno") : null, (Object) "0")) {
            this.$callback.onSuccess("-1");
            return;
        }
        JSONObject optJSONObject2 = data.optJSONObject("data");
        if (!(optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("3031")) == null)) {
            isBind = optJSONObject.optString("is_bind");
        }
        CharSequence charSequence = isBind;
        if (charSequence == null || charSequence.length() == 0) {
            this.$callback.onSuccess("-1");
        } else {
            this.$callback.onSuccess(isBind);
        }
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        this.$callback.onFailed(e2);
    }
}
