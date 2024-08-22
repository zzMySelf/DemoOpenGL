package com.baidu.searchbox.video.feedflow.detail.dynamic.favor;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState;
import com.baidu.searchbox.video.feedflow.detail.favor.FavorReducer;
import com.baidu.searchbox.video.feedflow.detail.favor.FlowDetailFavorState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u001c\u0010\u000b\u001a\u00020\u00042\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/favor/DynamicFavorReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorReducer;", "()V", "notifyFavorStatus", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "num", "", "isFavor", "", "onSuccess", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicFavorReducer.kt */
public final class DynamicFavorReducer extends FavorReducer {
    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, CommonState state) {
        FlowDetailFavorState $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Object data = action.getData();
        DynamicDetailModel bean = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
        if (bean != null && ($this$onSuccess_u24lambda_u2d1_u24lambda_u2d0 = (FlowDetailFavorState) state.select(FlowDetailFavorState.class)) != null) {
            $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0.getData().setValue(bean.getFavouriteInfo());
        }
    }

    /* access modifiers changed from: protected */
    public void notifyFavorStatus(CommonState state, int num, boolean isFavor) {
        DynamicDetailModel data;
        Intrinsics.checkNotNullParameter(state, "state");
        DynamicDetailState dynamicDetailState = (DynamicDetailState) state.select(DynamicDetailState.class);
        if (dynamicDetailState != null && (data = dynamicDetailState.getData()) != null) {
            data.notifyFavorStatus(num, isFavor);
        }
    }
}
