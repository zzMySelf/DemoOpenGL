package com.baidu.searchbox.feed.payment.core.service;

import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.feed.config.FeedUrlConfig;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import com.baidu.searchbox.feed.payment.PayRequestAspect;
import com.baidu.searchbox.feed.payment.PayResponseCallback;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.privacy.FeedIdentityManager;
import com.google.gson.Gson;
import java.net.ConnectException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J:\u0010\r\u001a\u0004\u0018\u00010\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015J\u0006\u0010\u0016\u001a\u00020\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0001H\u0002J8\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u001a\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/core/service/BaseRequester;", "", "cmd", "", "(Ljava/lang/String;)V", "aspect", "Lcom/baidu/searchbox/feed/payment/PayRequestAspect;", "getAspect", "()Lcom/baidu/searchbox/feed/payment/PayRequestAspect;", "setAspect", "(Lcom/baidu/searchbox/feed/payment/PayRequestAspect;)V", "getCmd", "()Ljava/lang/String;", "executeAsyncOnUIBack", "Lcom/baidu/searchbox/http/Cancelable;", "T", "path", "postParams", "responseClass", "Ljava/lang/Class;", "cb", "Lcom/baidu/searchbox/feed/payment/PayResponseCallback;", "getBaseUrl", "getRequest", "Lcom/baidu/searchbox/http/request/PostFormRequest;", "getResponseCallback", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseRequester.kt */
public class BaseRequester {
    private PayRequestAspect aspect;
    private final String cmd;

    public BaseRequester(String cmd2) {
        Intrinsics.checkNotNullParameter(cmd2, "cmd");
        this.cmd = cmd2;
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final PayRequestAspect getAspect() {
        return this.aspect;
    }

    public final void setAspect(PayRequestAspect payRequestAspect) {
        this.aspect = payRequestAspect;
    }

    public final <T> Cancelable executeAsyncOnUIBack(String path, Object postParams, Class<T> responseClass, PayResponseCallback<T> cb) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(postParams, "postParams");
        Intrinsics.checkNotNullParameter(responseClass, "responseClass");
        Intrinsics.checkNotNullParameter(cb, "cb");
        try {
            PayRequestAspect payRequestAspect = this.aspect;
            if (payRequestAspect != null) {
                payRequestAspect.onPostParams(getBaseUrl(), MapsKt.mapOf(TuplesKt.to("data", new Gson().toJson(postParams))));
            }
            if (NetWorkUtils.isConnected(FeedpayKt.appContext())) {
                return getRequest(postParams).executeAsyncOnUIBack(getResponseCallback(path, responseClass, cb));
            }
            ConnectException e2 = new ConnectException();
            cb.onResponse(false, null, e2);
            PayRequestAspect payRequestAspect2 = this.aspect;
            if (payRequestAspect2 != null) {
                payRequestAspect2.onError(e2);
            }
            return null;
        } catch (Exception e3) {
            cb.onResponse(false, null, e3);
            PayRequestAspect payRequestAspect3 = this.aspect;
            if (payRequestAspect3 != null) {
                payRequestAspect3.onError(e3);
            }
            return null;
        }
    }

    private final <T> ResponseCallback<T> getResponseCallback(String path, Class<T> responseClass, PayResponseCallback<T> cb) {
        return new BaseRequester$getResponseCallback$1(this, path, responseClass, cb);
    }

    private final PostFormRequest getRequest(Object postParams) {
        PostFormRequest build = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(FeedpayKt.appContext()).postFormRequest().enableStat(true)).requestFrom(1)).requestSubFrom(400)).url(getBaseUrl())).cookieManager(FeedpayKt.cookieManager(true, false))).params(MapsKt.mapOf(TuplesKt.to("data", new Gson().toJson(postParams))))).build();
        Intrinsics.checkNotNullExpressionValue(build, "getDefault(appContext())…\n                .build()");
        return build;
    }

    public final String getBaseUrl() {
        String processUrl = FeedIdentityManager.processUrl(UrlUtil.addParam(UrlUtil.addParam(FeedUrlConfig.getFeedBaseUrl(), "action", "feed"), "cmd", this.cmd));
        return processUrl == null ? "" : processUrl;
    }
}
