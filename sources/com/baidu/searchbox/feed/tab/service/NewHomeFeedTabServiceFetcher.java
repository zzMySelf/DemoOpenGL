package com.baidu.searchbox.feed.tab.service;

import com.baidu.pyramid.annotation.ServiceProvider;
import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0014¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/tab/service/NewHomeFeedTabServiceFetcher;", "Lcom/baidu/pyramid/runtime/service/CachedServiceFetcher;", "Lcom/baidu/searchbox/feed/tab/service/INewHomeFeedTabApi;", "()V", "createService", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ServiceProvider(module = "feed", name = "new_home_tab_service")
/* compiled from: NewHomeFeedTabServiceFetcher.kt */
public final class NewHomeFeedTabServiceFetcher extends CachedServiceFetcher<INewHomeFeedTabApi> {
    /* access modifiers changed from: protected */
    public INewHomeFeedTabApi createService() {
        return NewHomeFeedTabApiImpl.INSTANCE;
    }
}
