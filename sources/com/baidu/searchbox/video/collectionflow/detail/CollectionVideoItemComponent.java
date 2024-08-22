package com.baidu.searchbox.video.collectionflow.detail;

import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.frame.api.IActionTransferInterceptor;
import com.baidu.searchbox.video.assemble.creator.CollectionItemArchCreator;
import com.baidu.searchbox.video.collectionflow.action.CollectionFlowActionInterceptor;
import com.baidu.searchbox.video.component.base.AbsItemComponent;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.detail.ClearDetailCache;
import com.baidu.searchbox.video.feedflow.detail.FlowDetailModelService;
import com.baidu.searchbox.video.feedflow.detail.IFlowDetailModelService;
import com.baidu.searchbox.video.feedflow.detail.RequestDetailData;
import com.baidu.searchbox.video.feedflow.detail.base.BaseItemComponent;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.BaikePanelState;
import com.baidu.searchbox.video.feedflow.flow.bottom.barrageinputbar.IBarrageInputBarService;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState;
import com.baidu.searchbox.video.feedflow.flow.collection.SimilarCollectionState;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.CommonListPanelState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.helper.VideoItemComponentHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/detail/CollectionVideoItemComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createArchDetailFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "createComponentManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "createStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "getActionInterceptor", "Lcom/baidu/searchbox/feed/detail/frame/api/IActionTransferInterceptor;", "onBindData", "", "position", "", "model", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "onRelease", "registerTransmitServices", "transmitStateToChildStore", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionVideoItemComponent.kt */
public class CollectionVideoItemComponent extends BaseItemComponent<CommonState> {
    /* access modifiers changed from: protected */
    public ComponentArchManager createComponentManager() {
        ComponentArchManager $this$createComponentManager_u24lambda_u2d0 = CollectionItemArchCreator.Impl.INSTANCE.get().createManager();
        $this$createComponentManager_u24lambda_u2d0.registerServices(IFlowDetailModelService.class, new FlowDetailModelService((CommonState) getItemStore().getState()));
        return $this$createComponentManager_u24lambda_u2d0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory createArchDetailFactory() {
        /*
            r6 = this;
            com.baidu.searchbox.video.assemble.creator.CollectionItemArchCreator$Impl r0 = com.baidu.searchbox.video.assemble.creator.CollectionItemArchCreator.Impl.INSTANCE
            com.baidu.searchbox.video.assemble.creator.CollectionItemArchCreator r0 = r0.get()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r6.getStore()
            r2 = 0
            if (r1 == 0) goto L_0x0024
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0019
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001a
        L_0x0019:
            r4 = r2
        L_0x001a:
            if (r4 == 0) goto L_0x0022
            java.lang.Class<com.baidu.searchbox.video.detail.business.VideoBusiness> r2 = com.baidu.searchbox.video.detail.business.VideoBusiness.class
            java.lang.Object r2 = r4.select(r2)
        L_0x0022:
            com.baidu.searchbox.video.detail.business.VideoBusiness r2 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r2
        L_0x0024:
            com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory r0 = r0.createFactory(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.collectionflow.detail.CollectionVideoItemComponent.createArchDetailFactory():com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.baidu.searchbox.video.detail.business.VideoBusiness} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.frame.AbsStore<com.baidu.searchbox.feed.detail.arch.ext.CommonState> createStore() {
        /*
            r6 = this;
            com.baidu.searchbox.video.assemble.creator.CollectionItemArchCreator$Impl r0 = com.baidu.searchbox.video.assemble.creator.CollectionItemArchCreator.Impl.INSTANCE
            com.baidu.searchbox.video.assemble.creator.CollectionItemArchCreator r0 = r0.get()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r6.getStore()
            r2 = 0
            if (r1 == 0) goto L_0x0024
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0019
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001a
        L_0x0019:
            r4 = r2
        L_0x001a:
            if (r4 == 0) goto L_0x0022
            java.lang.Class<com.baidu.searchbox.video.detail.business.VideoBusiness> r2 = com.baidu.searchbox.video.detail.business.VideoBusiness.class
            java.lang.Object r2 = r4.select(r2)
        L_0x0022:
            com.baidu.searchbox.video.detail.business.VideoBusiness r2 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r2
        L_0x0024:
            com.baidu.searchbox.feed.detail.frame.AbsStore r0 = r0.createStore(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.collectionflow.detail.CollectionVideoItemComponent.createStore():com.baidu.searchbox.feed.detail.frame.AbsStore");
    }

    /* access modifiers changed from: protected */
    public void registerTransmitServices() {
        VideoItemComponentHelper.Impl.INSTANCE.get().transmitCollectionVideoItemServices(new CollectionVideoItemComponent$registerTransmitServices$1(this));
        registerServiceInternal(IBarrageInputBarService.class);
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
        super.transmitStateToChildStore();
        Store $this$transmitStateToChildStore_u24lambda_u2d1 = getStore();
        if ($this$transmitStateToChildStore_u24lambda_u2d1 != null) {
            VideoItemComponentHelper.Impl.INSTANCE.get().transmitVideoItemState($this$transmitStateToChildStore_u24lambda_u2d1, getItemStore());
        }
        AbsItemComponent this_$iv = this;
        Store access$getStore = this_$iv.store;
        if (!(access$getStore == null || (absState4 = (AbsState) access$getStore.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4 = absState4.select(CommonListPanelState.class)) == null)) {
            AbsState state = this_$iv.getItemStore().getState();
            String name = CommonListPanelState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
            state.put(name, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4);
        }
        AbsItemComponent this_$iv2 = this;
        Store access$getStore2 = this_$iv2.store;
        if (!(access$getStore2 == null || (absState3 = (AbsState) access$getStore2.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3 = absState3.select(CollectionPanelState.class)) == null)) {
            AbsState state2 = this_$iv2.getItemStore().getState();
            String name2 = CollectionPanelState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "T::class.java.name");
            state2.put(name2, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3);
        }
        AbsItemComponent this_$iv3 = this;
        Store access$getStore3 = this_$iv3.store;
        if (!(access$getStore3 == null || (absState2 = (AbsState) access$getStore3.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2 = absState2.select(BaikePanelState.class)) == null)) {
            AbsState state3 = this_$iv3.getItemStore().getState();
            String name3 = BaikePanelState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "T::class.java.name");
            state3.put(name3, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2);
        }
        AbsItemComponent this_$iv4 = this;
        Store access$getStore4 = this_$iv4.store;
        if (access$getStore4 != null && (absState = (AbsState) access$getStore4.getState()) != null && ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv = absState.select(SimilarCollectionState.class)) != null) {
            AbsState state4 = this_$iv4.getItemStore().getState();
            String name4 = SimilarCollectionState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "T::class.java.name");
            state4.put(name4, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv);
        }
    }

    /* access modifiers changed from: protected */
    public IActionTransferInterceptor getActionInterceptor() {
        return new CollectionFlowActionInterceptor();
    }

    /* access modifiers changed from: protected */
    public void onBindData(int position, ItemModel<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.onBindData(position, model);
        getItemStore().dispatch(new RequestDetailData(position, (String) null, false, 0, 0, false, 62, (DefaultConstructorMarker) null));
    }

    public void onRelease() {
        super.onRelease();
        Store itemStore = getItemStore();
        Store $this$select$iv = getStore();
        String str = null;
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            IntentData intentData = (IntentData) (commonState != null ? commonState.select(IntentData.class) : null);
            if (intentData != null) {
                str = intentData.page;
            }
        }
        if (str == null) {
            str = "";
        }
        StoreExtKt.post(itemStore, new ClearDetailCache(str));
    }
}
