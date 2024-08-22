package com.baidu.searchbox.video.feedflow.detail.talos;

import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.frame.api.IActionTransferInterceptor;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.feedflow.ad.position.AdStrategyState;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.detail.base.BaseItemComponent;
import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/talos/FeedTalosItemComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createArchDetailFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "createStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "getActionInterceptor", "Lcom/baidu/searchbox/feed/detail/frame/api/IActionTransferInterceptor;", "onCreate", "", "registerTransmitServices", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTalosItemComponent.kt */
public final class FeedTalosItemComponent extends BaseItemComponent<CommonState> {
    public void onCreate() {
        CommonState commonState;
        VideoBusiness state;
        CommonState commonState2;
        AdStrategyState state2;
        super.onCreate();
        Store store = getStore();
        if (!(store == null || (commonState2 = (CommonState) store.getState()) == null || (state2 = (AdStrategyState) commonState2.select(AdStrategyState.class)) == null)) {
            ((CommonState) getItemStore().getState()).put(state2);
        }
        Store store2 = getStore();
        if (store2 != null && (commonState = (CommonState) store2.getState()) != null && (state = (VideoBusiness) commonState.select(VideoBusiness.class)) != null) {
            ((CommonState) getItemStore().getState()).put(state);
        }
    }

    /* access modifiers changed from: protected */
    public IArchDetailFactory createArchDetailFactory() {
        return new FeedTalosItemFactory();
    }

    /* access modifiers changed from: protected */
    public AbsStore<CommonState> createStore() {
        return new FeedTalosItemStore(new CommonState(new LinkedHashMap()));
    }

    /* access modifiers changed from: protected */
    public IActionTransferInterceptor getActionInterceptor() {
        return new VideoFlowActionInterceptor();
    }

    /* access modifiers changed from: protected */
    public void registerTransmitServices() {
    }
}
