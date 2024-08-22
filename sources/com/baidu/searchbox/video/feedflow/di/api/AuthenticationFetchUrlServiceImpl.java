package com.baidu.searchbox.video.feedflow.di.api;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.authentication.api.AuthenticationApi;
import com.baidu.searchbox.flowvideo.authentication.api.AuthenticationBean;
import com.baidu.searchbox.video.detail.common.NetworkEngine;
import com.baidu.searchbox.video.feedflow.common.FlowUrlConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\nH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/di/api/AuthenticationFetchUrlServiceImpl;", "Lcom/baidu/searchbox/flowvideo/authentication/api/AuthenticationApi;", "()V", "requestData", "", "post", "", "", "get", "callback", "Lcom/baidu/searchbox/feed/detail/ext/common/OnDataLoaded;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/authentication/api/AuthenticationBean;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthenticationFetchUrlServiceImpl.kt */
public final class AuthenticationFetchUrlServiceImpl implements AuthenticationApi {
    public void requestData(Map<String, String> post, Map<String, String> get, OnDataLoaded<Result<AuthenticationBean>> callback) {
        Intrinsics.checkNotNullParameter(post, "post");
        NetworkEngine.fetchData$default(NetworkEngine.INSTANCE, FlowUrlConfig.INSTANCE.getFetchVideoUrlUrl(), new LinkedHashMap(), new AuthenticationFetchUrlServiceImpl$requestData$1(callback), false, get, 8, (Object) null);
    }
}
