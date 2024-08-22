package com.baidu.searchbox.video.feedflow.serviceimpl;

import com.baidu.pyramid.annotation.ServiceProvider;
import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import com.baidu.searchbox.video.inf.TransitionViewService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0014¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/serviceimpl/TransitionViewServiceFetcher;", "Lcom/baidu/pyramid/runtime/service/CachedServiceFetcher;", "Lcom/baidu/searchbox/video/inf/TransitionViewService;", "()V", "createService", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ServiceProvider(module = "short_video", name = "transition_view")
/* compiled from: TransitionViewServiceFetcher.kt */
public final class TransitionViewServiceFetcher extends CachedServiceFetcher<TransitionViewService> {
    /* access modifiers changed from: protected */
    public TransitionViewService createService() {
        return new TransitionViewServiceImpl();
    }
}
