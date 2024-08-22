package com.baidu.searchbox.video.feedflow.detail.loading;

import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.frame.api.IActionTransferInterceptor;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.feedflow.ad.position.AdStrategyState;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.detail.base.BaseItemComponent;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0014¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/loading/LoadingItemComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createArchDetailFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "createStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "getActionInterceptor", "Lcom/baidu/searchbox/feed/detail/frame/api/IActionTransferInterceptor;", "onBindData", "", "position", "", "model", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "onCreate", "registerTransmitServices", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadingItemComponent.kt */
public final class LoadingItemComponent extends BaseItemComponent<CommonState> {
    /* access modifiers changed from: protected */
    public IArchDetailFactory createArchDetailFactory() {
        return new LoadingItemFactory();
    }

    /* access modifiers changed from: protected */
    public AbsStore<CommonState> createStore() {
        return new LoadingItemStore(new CommonState(new LinkedHashMap()));
    }

    /* access modifiers changed from: protected */
    public void registerTransmitServices() {
    }

    /* access modifiers changed from: protected */
    public IActionTransferInterceptor getActionInterceptor() {
        return new VideoFlowActionInterceptor();
    }

    public void onCreate() {
        super.onCreate();
        Store $this$select$iv = getStore();
        Object obj = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            AdStrategyState state2 = (AdStrategyState) (commonState != null ? commonState.select(AdStrategyState.class) : null);
            if (state2 != null) {
                ((CommonState) getItemStore().getState()).put(state2);
            }
        }
        Store $this$select$iv2 = getStore();
        if ($this$select$iv2 != null) {
            State state3 = $this$select$iv2.getState();
            CommonState commonState2 = state3 instanceof CommonState ? (CommonState) state3 : null;
            if (commonState2 != null) {
                obj = commonState2.select(VideoBusiness.class);
            }
            VideoBusiness state4 = (VideoBusiness) obj;
            if (state4 != null) {
                ((CommonState) getItemStore().getState()).put(state4);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onBindData(int position, ItemModel<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.onBindData(position, model);
        ((CommonState) getItemStore().getState()).put(model);
    }
}
