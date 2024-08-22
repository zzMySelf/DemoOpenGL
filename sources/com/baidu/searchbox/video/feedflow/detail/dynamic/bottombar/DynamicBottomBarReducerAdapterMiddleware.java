package com.baidu.searchbox.video.feedflow.detail.dynamic.bottombar;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicConfigModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.bottom.BottomBarReducerAdapterAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.BottomBarReducerAdapterMiddleware;
import com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0016\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\"\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/bottombar/DynamicBottomBarReducerAdapterMiddleware;", "Lcom/baidu/searchbox/video/feedflow/detail/bottom/BottomBarReducerAdapterMiddleware;", "()V", "getBottomBarModel", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/BottomBarModel;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "hasDetailModel", "", "onSuccess", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicBottomBarReducerAdapterMiddleware.kt */
public final class DynamicBottomBarReducerAdapterMiddleware extends BottomBarReducerAdapterMiddleware {
    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, Store<CommonState> store) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(store, "store");
        if (store.getState().isActive()) {
            Object data = action.getData();
            Boolean bool = null;
            DynamicDetailModel bean = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
            if (bean != null) {
                if (DIFactory.INSTANCE.isTeenager()) {
                    dispatchUnEnableCommentView(store);
                } else {
                    dispatchEnableCommentView(store, DynamicBottomBarMapper.INSTANCE.map(bean));
                }
                if (!bean.isOffLine()) {
                    DynamicConfigModel conf = bean.getConf();
                    if (conf != null) {
                        bool = Boolean.valueOf(conf.isForceLoop());
                    }
                    if (!BdPlayerUtils.orFalse(bool)) {
                        StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableAutoPlayView(true));
                        StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableScrollableView(true));
                        return;
                    }
                }
                StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableAutoPlayView(false));
                StoreExtKt.post(store, new BottomBarReducerAdapterAction.SwitchIsEnableScrollableView(false));
            }
        }
    }

    /* access modifiers changed from: protected */
    public BottomBarModel getBottomBarModel(Store<CommonState> store) {
        DynamicDetailModel model;
        Intrinsics.checkNotNullParameter(store, "store");
        CommonState state = store.getState();
        CommonState commonState = state instanceof CommonState ? state : null;
        DynamicDetailState dynamicDetailState = (DynamicDetailState) (commonState != null ? commonState.select(DynamicDetailState.class) : null);
        if (dynamicDetailState == null || (model = dynamicDetailState.getData()) == null) {
            return null;
        }
        return DynamicBottomBarMapper.INSTANCE.map(model);
    }

    /* access modifiers changed from: protected */
    public boolean hasDetailModel(Store<CommonState> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        CommonState state = store.getState();
        DynamicDetailModel dynamicDetailModel = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        DynamicDetailState dynamicDetailState = (DynamicDetailState) (commonState != null ? commonState.select(DynamicDetailState.class) : null);
        if (dynamicDetailState != null) {
            dynamicDetailModel = dynamicDetailState.getData();
        }
        return dynamicDetailModel != null;
    }
}
