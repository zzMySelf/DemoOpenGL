package com.baidu.searchbox.video.feedflow.detail.dynamic.comment;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.ext.common.UbcBean;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailCommentModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.video.component.comment.CommonCommentAction;
import com.baidu.searchbox.video.component.comment.CommonCommentModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentMiddleware;
import com.baidu.searchbox.video.feedflow.detail.comment.TryAutoShowCommentPanelAction;
import com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0016\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\"\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/comment/DynamicCommentMiddleware;", "Lcom/baidu/searchbox/video/feedflow/detail/comment/CommentMiddleware;", "()V", "getCommentModel", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailCommentModel;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getNid", "", "getSource", "ubcBean", "Lcom/baidu/searchbox/feed/detail/ext/common/UbcBean;", "isCommentSupportShowMaterial", "", "onSuccess", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicCommentMiddleware.kt */
public final class DynamicCommentMiddleware extends CommentMiddleware {
    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, Store<CommonState> store) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(store, "store");
        Object data = action.getData();
        Object obj = null;
        DynamicDetailModel bean = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
        if (bean != null) {
            CommonState state = store.getState();
            CommonState commonState = state instanceof CommonState ? state : null;
            if (commonState != null) {
                obj = commonState.select(UbcBean.class);
            }
            CommonCommentModel model = updateCommentPanel(DynamicCommentMapper.INSTANCE.map(bean), (UbcBean) obj, LandscapeFlowSwitchKt.isLandscapeFlowMode((AbsState) store.getState()), store);
            if (model != null) {
                StoreExtKt.post(store, new CommonCommentAction.BindData(model));
            }
            StoreExtKt.post(store, TryAutoShowCommentPanelAction.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public String getNid(Store<CommonState> store) {
        DynamicDetailModel data;
        String nid;
        Intrinsics.checkNotNullParameter(store, "store");
        CommonState state = store.getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? state : null;
        if (commonState != null) {
            obj = commonState.select(DynamicDetailState.class);
        }
        DynamicDetailState dynamicDetailState = (DynamicDetailState) obj;
        return (dynamicDetailState == null || (data = dynamicDetailState.getData()) == null || (nid = data.getNid()) == null) ? "" : nid;
    }

    /* access modifiers changed from: protected */
    public FlowDetailCommentModel getCommentModel(Store<CommonState> store) {
        DynamicDetailModel data;
        Intrinsics.checkNotNullParameter(store, "store");
        CommonState state = store.getState();
        CommonState commonState = state instanceof CommonState ? state : null;
        DynamicDetailState dynamicDetailState = (DynamicDetailState) (commonState != null ? commonState.select(DynamicDetailState.class) : null);
        if (dynamicDetailState == null || (data = dynamicDetailState.getData()) == null) {
            return null;
        }
        return data.getComment();
    }

    /* access modifiers changed from: protected */
    public String getSource(UbcBean ubcBean) {
        return VideoFlowUBCHelper.INSTANCE.getDynamicUbcSource(ubcBean);
    }

    public boolean isCommentSupportShowMaterial(Store<CommonState> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        return false;
    }
}
