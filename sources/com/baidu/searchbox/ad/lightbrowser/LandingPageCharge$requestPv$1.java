package com.baidu.searchbox.ad.lightbrowser;

import com.baidu.nadcore.debug.LogEx;
import com.baidu.searchbox.http.callback.DefaultResponseCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/ad/lightbrowser/LandingPageCharge$requestPv$1", "Lcom/baidu/searchbox/http/callback/DefaultResponseCallback;", "onFail", "", "e", "Ljava/lang/Exception;", "onSuccess", "response", "Lokhttp3/Response;", "code", "", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandingPageCharge.kt */
public final class LandingPageCharge$requestPv$1 extends DefaultResponseCallback {
    LandingPageCharge$requestPv$1() {
    }

    public void onSuccess(Response response, int code) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public void onFail(Exception e2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        LogEx.d("LandingPageCharge", "onFail: 落地页补发 pv 失败，请留意！");
    }
}
