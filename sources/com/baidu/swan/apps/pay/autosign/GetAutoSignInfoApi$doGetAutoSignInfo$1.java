package com.baidu.swan.apps.pay.autosign;

import com.baidu.swan.apps.api.result.SwanApiResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/swan/apps/pay/autosign/GetAutoSignInfoApi$doGetAutoSignInfo$1", "Lcom/baidu/swan/apps/pay/autosign/GetAutoSignInfoCallback;", "onFail", "", "errMsg", "", "onSuccess", "jsonString", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetAutoSignInfoApi.kt */
public final class GetAutoSignInfoApi$doGetAutoSignInfo$1 implements GetAutoSignInfoCallback {
    final /* synthetic */ String $cb;
    final /* synthetic */ GetAutoSignInfoApi this$0;

    GetAutoSignInfoApi$doGetAutoSignInfo$1(GetAutoSignInfoApi $receiver, String $cb2) {
        this.this$0 = $receiver;
        this.$cb = $cb2;
    }

    public void onSuccess(String jsonString) {
        CharSequence charSequence = jsonString;
        if (charSequence == null || charSequence.length() == 0) {
            this.this$0.invokeCallback(this.$cb, new SwanApiResult(10001, "get signInfo fail"));
        } else {
            this.this$0.handleGetAutoSignInfoApiCallback(jsonString, this.$cb);
        }
    }

    public void onFail(String errMsg) {
        String errMessage = errMsg;
        CharSequence charSequence = errMessage;
        if (charSequence == null || charSequence.length() == 0) {
            errMessage = "get signInfo fail";
        }
        this.this$0.invokeCallback(this.$cb, new SwanApiResult(10001, errMessage));
    }
}
