package com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.flow.api.FlowListBean;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.FlowComponentConstantManifestKt;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerLoop;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel;
import com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend.LandscapeRelatedRecommendPanelAction;
import com.baidu.searchbox.video.feedflow.flow.collection.mapper.BottomEntryToCollectionFlowMapper;
import com.baidu.searchbox.video.feedflow.flow.list.FoldScreenExpandOrientationChanged;
import com.baidu.searchbox.video.feedflow.flow.list.FoldScreenFoldStateChanged;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.LandscapeRelatedRecommendPanelRequestListData;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/landscaperelatedrecommend/LandscapeRelatedRecommendPanelMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "dealLandscapeClickAction", "", "isAutoShow", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeRelatedRecommendPanelMiddleware.kt */
public final class LandscapeRelatedRecommendPanelMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        boolean z;
        ItemModel model;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof LandscapeRelatedRecommendPanelAction.TryLoadPageAction) {
            if (((LandscapeRelatedRecommendPanelAction.TryLoadPageAction) action).getItemList() != null) {
                StoreExtKt.post(store, new LandscapeRelatedRecommendPanelRequestListData(((LandscapeRelatedRecommendPanelAction.TryLoadPageAction) action).getDirection(), ((LandscapeRelatedRecommendPanelAction.TryLoadPageAction) action).getItemList()));
            }
        } else if (!(action instanceof LandscapeFoldAction.OnViewClick)) {
            boolean z2 = true;
            if (action instanceof LandscapeRelatedRecommendPanelAction.RequestSuccessAction) {
                FlowListBean bean = ((LandscapeRelatedRecommendPanelAction.RequestSuccessAction) action).getData();
                if (!(bean instanceof FlowListBean)) {
                    bean = null;
                }
                if (bean != null) {
                    CollectionFlowModel model2 = BottomEntryToCollectionFlowMapper.FlowListBeanToCollectionFlowMapper.INSTANCE.map(bean);
                    Integer type = ((LandscapeRelatedRecommendPanelAction.RequestSuccessAction) action).getType();
                    if (type != null && type.intValue() == 2) {
                        model2.setFromDirection(-1);
                    } else if (type != null && type.intValue() == 3) {
                        model2.setFromDirection(0);
                    } else if (type != null && type.intValue() == 4) {
                        model2.setFromDirection(1);
                    }
                    StoreExtKt.post(store, new LandscapeRelatedRecommendPanelAction.PanelRequestSuccessAction(((LandscapeRelatedRecommendPanelAction.RequestSuccessAction) action).getType(), model2));
                }
            } else {
                if (action instanceof FoldScreenFoldStateChanged) {
                    z = true;
                } else {
                    z = action instanceof FoldScreenExpandOrientationChanged;
                }
                if (!z) {
                    z2 = action instanceof UpdateFlowStyle;
                }
                if (z2) {
                    StoreExtKt.post(store, LandscapeRelatedRecommendPanelAction.HidePanelAction.INSTANCE);
                } else if (action instanceof LandscapeRelatedRecommendPanelAction.ItemClickAction) {
                    if (!LandscapeRelatedRecommendPanelStateKt.isLandscapeRelatedRecommendPanelNewInteractStyle(store)) {
                        StoreExtKt.post(store, LandscapeRelatedRecommendPanelAction.HidePanelAction.INSTANCE);
                    }
                } else if ((action instanceof PlayerLoop) && CommonStateExtKt.isActive(store) && LandscapeRelatedRecommendPanelStateKt.isLandscapeRelatedRecommendAutoplay(store) && (model = LandscapeRelatedRecommendPanelStateKt.getLandscapeRelatedRecommendNext(store)) != null) {
                    StoreExtKt.post(store, new LandscapeRelatedRecommendPanelAction.AutoPlayNext(model));
                }
            }
        } else if (Intrinsics.areEqual((Object) ((LandscapeFoldAction.OnViewClick) action).getType(), (Object) FlowComponentConstantManifestKt.PANEL_TYPE_LANDSCAPE_RELATED_RECOMMEND)) {
            dealLandscapeClickAction(store, ((LandscapeFoldAction.OnViewClick) action).isAutoShow());
        }
        return next.next(store, action);
    }

    static /* synthetic */ void dealLandscapeClickAction$default(LandscapeRelatedRecommendPanelMiddleware landscapeRelatedRecommendPanelMiddleware, Store store, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        landscapeRelatedRecommendPanelMiddleware.dealLandscapeClickAction(store, z);
    }

    private final void dealLandscapeClickAction(Store<CommonState> store, boolean isAutoShow) {
        CommonState state = store.getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        if (commonState != null) {
            obj = commonState.select(LandscapeRelatedRecommendPanelState.class);
        }
        LandscapeRelatedRecommendPanelState $this$dealLandscapeClickAction_u24lambda_u2d2 = (LandscapeRelatedRecommendPanelState) obj;
        if ($this$dealLandscapeClickAction_u24lambda_u2d2 != null) {
            $this$dealLandscapeClickAction_u24lambda_u2d2.setType(FlowComponentConstantManifestKt.PANEL_TYPE_LANDSCAPE_RELATED_RECOMMEND);
            StoreExtKt.post(store, new LandscapeRelatedRecommendPanelAction.ShowPanelAction(isAutoShow));
        }
    }
}
