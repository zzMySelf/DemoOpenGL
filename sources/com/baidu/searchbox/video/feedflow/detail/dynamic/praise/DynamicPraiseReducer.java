package com.baidu.searchbox.video.feedflow.detail.dynamic.praise;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.video.feedflow.detail.dynamic.DynamicDetailState;
import com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState;
import com.baidu.searchbox.video.feedflow.detail.praise.PraiseReducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001c\u0010\r\u001a\u00020\u00042\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/praise/DynamicPraiseReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/praise/PraiseReducer;", "()V", "notifyPraiseStatus", "", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "nid", "", "isPraise", "", "praiseCount", "", "onSuccess", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicPraiseReducer.kt */
public final class DynamicPraiseReducer extends PraiseReducer {
    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, CommonState state) {
        FlowDetailPraiseState $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Object data = action.getData();
        DynamicDetailModel bean = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
        if (bean != null && ($this$onSuccess_u24lambda_u2d1_u24lambda_u2d0 = (FlowDetailPraiseState) state.select(FlowDetailPraiseState.class)) != null) {
            $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0.getData().setValue(DynamicPraiseMapper.INSTANCE.map(bean));
        }
    }

    /* access modifiers changed from: protected */
    public void notifyPraiseStatus(CommonState state, String nid, boolean isPraise, int praiseCount) {
        DynamicDetailModel data;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(nid, "nid");
        DynamicDetailState dynamicDetailState = (DynamicDetailState) state.select(DynamicDetailState.class);
        if (dynamicDetailState != null && (data = dynamicDetailState.getData()) != null) {
            data.notifyPraiseStatus(nid, isPraise, praiseCount);
        }
    }
}
