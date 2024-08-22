package com.baidu.searchbox.video.feedflow.detail.queryspecial;

import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.frame.api.IActionTransferInterceptor;
import com.baidu.searchbox.video.component.base.AbsItemComponent;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.feedflow.ad.position.AdStrategyState;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.config.AbConfig;
import com.baidu.searchbox.video.feedflow.config.GcpConfig;
import com.baidu.searchbox.video.feedflow.config.LocalConfig;
import com.baidu.searchbox.video.feedflow.detail.base.BaseItemComponent;
import com.baidu.searchbox.video.feedflow.detail.relatedsearch.service.IRelatedSearchPanelService;
import com.baidu.searchbox.video.feedflow.detail.toast.simple.SimpleTipState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0014J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0014¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/queryspecial/QuerySpecialCardItemComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createArchDetailFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "createStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "getActionInterceptor", "Lcom/baidu/searchbox/feed/detail/frame/api/IActionTransferInterceptor;", "onBindData", "", "position", "", "model", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "registerTransmitServices", "transmitStateToChildStore", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuerySpecialCardItemComponent.kt */
public final class QuerySpecialCardItemComponent extends BaseItemComponent<CommonState> {
    /* access modifiers changed from: protected */
    public IArchDetailFactory createArchDetailFactory() {
        return new QuerySpecialCardItemFactory();
    }

    /* access modifiers changed from: protected */
    public AbsStore<CommonState> createStore() {
        return new QuerySpecialCardItemStore(new CommonState(new LinkedHashMap()));
    }

    /* access modifiers changed from: protected */
    public IActionTransferInterceptor getActionInterceptor() {
        return new VideoFlowActionInterceptor();
    }

    /* access modifiers changed from: protected */
    public void registerTransmitServices() {
        registerServiceInternal(IRelatedSearchPanelService.class);
    }

    /* access modifiers changed from: protected */
    public void onBindData(int position, ItemModel<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.onBindData(position, model);
        ((CommonState) getItemStore().getState()).put(model);
    }

    /* access modifiers changed from: protected */
    public void transmitStateToChildStore() {
        AbsState absState;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv;
        AbsState absState2;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2;
        AbsState absState3;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3;
        AbsState absState4;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4;
        AbsState absState5;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5;
        AbsState absState6;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6;
        super.transmitStateToChildStore();
        AbsItemComponent this_$iv = this;
        Store access$getStore = this_$iv.store;
        if (!(access$getStore == null || (absState6 = (AbsState) access$getStore.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6 = absState6.select(AdStrategyState.class)) == null)) {
            AbsState state = this_$iv.getItemStore().getState();
            String name = AdStrategyState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
            state.put(name, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6);
        }
        AbsItemComponent this_$iv2 = this;
        Store access$getStore2 = this_$iv2.store;
        if (!(access$getStore2 == null || (absState5 = (AbsState) access$getStore2.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5 = absState5.select(VideoBusiness.class)) == null)) {
            AbsState state2 = this_$iv2.getItemStore().getState();
            String name2 = VideoBusiness.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "T::class.java.name");
            state2.put(name2, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5);
        }
        AbsItemComponent this_$iv3 = this;
        Store access$getStore3 = this_$iv3.store;
        if (!(access$getStore3 == null || (absState4 = (AbsState) access$getStore3.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4 = absState4.select(AbConfig.class)) == null)) {
            AbsState state3 = this_$iv3.getItemStore().getState();
            String name3 = AbConfig.class.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "T::class.java.name");
            state3.put(name3, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4);
        }
        AbsItemComponent this_$iv4 = this;
        Store access$getStore4 = this_$iv4.store;
        if (!(access$getStore4 == null || (absState3 = (AbsState) access$getStore4.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3 = absState3.select(GcpConfig.class)) == null)) {
            AbsState state4 = this_$iv4.getItemStore().getState();
            String name4 = GcpConfig.class.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "T::class.java.name");
            state4.put(name4, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3);
        }
        AbsItemComponent this_$iv5 = this;
        Store access$getStore5 = this_$iv5.store;
        if (!(access$getStore5 == null || (absState2 = (AbsState) access$getStore5.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2 = absState2.select(LocalConfig.class)) == null)) {
            AbsState state5 = this_$iv5.getItemStore().getState();
            String name5 = LocalConfig.class.getName();
            Intrinsics.checkNotNullExpressionValue(name5, "T::class.java.name");
            state5.put(name5, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2);
        }
        AbsItemComponent this_$iv6 = this;
        Store access$getStore6 = this_$iv6.store;
        if (access$getStore6 != null && (absState = (AbsState) access$getStore6.getState()) != null && ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv = absState.select(SimpleTipState.class)) != null) {
            AbsState state6 = this_$iv6.getItemStore().getState();
            String name6 = SimpleTipState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name6, "T::class.java.name");
            state6.put(name6, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv);
        }
    }
}
