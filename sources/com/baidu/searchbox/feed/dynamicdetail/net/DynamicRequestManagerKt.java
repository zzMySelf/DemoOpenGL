package com.baidu.searchbox.feed.dynamicdetail.net;

import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.dynamicdetail.context.DynamicRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"PRE_TIME_OUT", "", "REQUEST_TAG", "", "TAG", "getPreConnectUrl", "preConnectMBD", "", "callback", "Lcom/baidu/searchbox/http/callback/StringResponseCallback;", "lib-feed-dynamic-detail_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicRequestManager.kt */
public final class DynamicRequestManagerKt {
    private static final int PRE_TIME_OUT = 300;
    public static final String REQUEST_TAG = "DynamicImmersiveRequest";
    private static final String TAG = "DynamicRequestManager";

    public static final void preConnectMBD(StringResponseCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        PostFormRequest.PostFormRequestBuilder builder = (PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(DynamicRuntime.INSTANCE.getAppContext()).postFormRequest().requestFrom(1)).requestSubFrom(103);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) builder.url(getPreConnectUrl())).connectionTimeout(600)).readTimeout(300);
        builder.cookieManager(FeedRuntime.getFeedContext().newCookieManagerInstance(true, false));
        builder.build().executeAsyncOnUIBack(callback);
    }

    public static final String getPreConnectUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/preconnect", Arrays.copyOf(new Object[]{HostConfig.getSearchboxHostForHttps()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }
}
