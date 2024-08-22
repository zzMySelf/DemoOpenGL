package com.baidu.searchbox.thirdparty.alipay;

import com.baidu.searchbox.thirdparty.base.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/thirdparty/alipay/AliPaySdkManager$requestOpenId$1", "Lcom/baidu/searchbox/thirdparty/base/IResultListener;", "onFail", "", "errNo", "", "errMsg", "", "onSuccess", "jsonData", "Lorg/json/JSONObject;", "lib-openid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AliPaySdkManager.kt */
public final class AliPaySdkManager$requestOpenId$1 implements IResultListener {
    final /* synthetic */ IResultListener $callback;

    AliPaySdkManager$requestOpenId$1(IResultListener $callback2) {
        this.$callback = $callback2;
    }

    public void onSuccess(JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        IResultListener iResultListener = this.$callback;
        if (iResultListener != null) {
            iResultListener.onSuccess(jsonData);
        }
    }

    public void onFail(int errNo, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        IResultListener iResultListener = this.$callback;
        if (iResultListener != null) {
            iResultListener.onFail(errNo, errMsg);
        }
    }
}
