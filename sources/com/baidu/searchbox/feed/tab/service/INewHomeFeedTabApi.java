package com.baidu.searchbox.feed.tab.service;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/feed/tab/service/INewHomeFeedTabApi;", "", "addFeedTabScrollListener", "", "listener", "Lcom/baidu/searchbox/feed/tab/service/IFeedTabScrollListener;", "getFeedTabHeight", "", "removeListener", "Companion", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: INewHomeFeedTabApi.kt */
public interface INewHomeFeedTabApi {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String NAME = "new_home_tab_service";
    public static final String NAME_SPACE = "feed";

    void addFeedTabScrollListener(IFeedTabScrollListener iFeedTabScrollListener);

    int getFeedTabHeight();

    void removeListener(IFeedTabScrollListener iFeedTabScrollListener);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/feed/tab/service/INewHomeFeedTabApi$Companion;", "", "()V", "NAME", "", "NAME_SPACE", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getNewHomeFeedTabApi", "Lcom/baidu/searchbox/feed/tab/service/INewHomeFeedTabApi;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: INewHomeFeedTabApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String NAME = "new_home_tab_service";
        public static final String NAME_SPACE = "feed";
        private static final ServiceReference SERVICE_REFERENCE = new ServiceReference("feed", "new_home_tab_service");

        private Companion() {
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }

        public final INewHomeFeedTabApi getNewHomeFeedTabApi() {
            return (INewHomeFeedTabApi) ServiceManager.getService(SERVICE_REFERENCE);
        }
    }
}
