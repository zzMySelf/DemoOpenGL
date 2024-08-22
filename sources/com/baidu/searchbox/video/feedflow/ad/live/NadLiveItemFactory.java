package com.baidu.searchbox.video.feedflow.ad.live;

import com.baidu.searchbox.feed.detail.arch.api.ComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.api.ILayoutManager;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/live/NadLiveItemFactory;", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "(Lcom/baidu/searchbox/feed/detail/frame/Store;)V", "getStore", "()Lcom/baidu/searchbox/feed/detail/frame/Store;", "getAnnotatedPlugins", "", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "getComponentFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/ComponentFactory;", "getLayoutManager", "Lcom/baidu/searchbox/feed/detail/arch/api/ILayoutManager;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadLiveItemFactory.kt */
public class NadLiveItemFactory implements IArchDetailFactory {
    private final Store<AbsState> store;

    public NadLiveItemFactory(Store<AbsState> store2) {
        this.store = store2;
    }

    public final Store<AbsState> getStore() {
        return this.store;
    }

    public List<IPlugin> getAnnotatedPlugins() {
        return NadLiveItemComponentRegister.Companion.getPlugins();
    }

    public ComponentFactory getComponentFactory() {
        return NadLiveItemComponentRegister.Companion.getComponentFactory();
    }

    public ILayoutManager getLayoutManager() {
        return new NadLiveItemLayoutManager();
    }
}
