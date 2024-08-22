package com.baidu.searchbox.youthhome.content.api;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.youthhome.content.api.listener.IYouthHomeContentListener;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/youthhome/content/api/IYouthHomeContentApi;", "", "addPageChangeListener", "", "tabId", "", "listener", "Lcom/baidu/searchbox/youthhome/content/api/listener/IYouthHomeContentListener;", "getCurrentItem", "", "removeOnPageChangeListener", "setCurrentItem", "index", "Companion", "youth-home-content-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IYouthHomeTabPageApi.kt */
public interface IYouthHomeContentApi {
    public static final Companion Companion = Companion.$$INSTANCE;
    @StableApi
    public static final String NAME = "youth_home_content";
    @StableApi
    public static final String NAME_SPACE = "home";

    void addPageChangeListener(String str, IYouthHomeContentListener iYouthHomeContentListener);

    int getCurrentItem();

    void removeOnPageChangeListener(IYouthHomeContentListener iYouthHomeContentListener);

    void setCurrentItem(int i2);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/youthhome/content/api/IYouthHomeContentApi$Companion;", "", "()V", "NAME", "", "NAME_SPACE", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getApi", "Lcom/baidu/searchbox/youthhome/content/api/IYouthHomeContentApi;", "youth-home-content-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IYouthHomeTabPageApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @StableApi
        public static final String NAME = "youth_home_content";
        @StableApi
        public static final String NAME_SPACE = "home";
        @StableApi
        private static final ServiceReference SERVICE_REFERENCE = new ServiceReference("home", "youth_home_content");

        private Companion() {
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }

        @StableApi
        public final IYouthHomeContentApi getApi() {
            return (IYouthHomeContentApi) ServiceManager.getService(SERVICE_REFERENCE);
        }
    }
}
