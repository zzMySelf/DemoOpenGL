package com.baidu.searchbox.video.feedflow.ad.toptitle;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.ad.summary.AdSummaryAction;
import com.baidu.searchbox.video.feedflow.ad.toptitle.NadTopTitleAction;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryModel;
import com.baidu.searchbox.video.feedflow.detail.summary.mapper.SummaryMapper;
import com.baidu.searchbox.video.feedflow.detail.toptitle.UpdateTopTitleData;
import com.baidu.searchbox.video.feedflow.detail.toptitle.UpdateTopTitleHeight;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/toptitle/NadTopTitleMiddleware;", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadTopTitleMiddleware.kt */
public final class NadTopTitleMiddleware implements Middleware<CommonState> {
    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof NetAction.Success) {
            Object data = ((NetAction.Success) action).getData();
            FlowDetailModel bean = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
            if (!(bean == null || bean.getTitleZone() == null)) {
                SummaryModel $this$apply_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0 = SummaryMapper.INSTANCE.map(bean);
                $this$apply_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0.setNeedShow(true);
                StoreExtKt.post(store, new UpdateTopTitleData($this$apply_u24lambda_u2d2_u24lambda_u2d1_u24lambda_u2d0));
            }
        } else if (action instanceof NestedAction.OnAttachToScreen) {
            StoreExtKt.post(store, new NadTopTitleAction.UpdateTopTitleVisible(true));
        } else if (action instanceof AdSummaryAction.DarkButtonDurationAction) {
            StoreExtKt.post(store, new NadTopTitleAction.SetAnimationBegin(((AdSummaryAction.DarkButtonDurationAction) action).getDuration()));
        } else if (action instanceof UpdateFlowStyle) {
            StoreExtKt.post(store, new NadTopTitleAction.UpdateFlowStyle(((UpdateFlowStyle) action).isLandscapeFlow()));
        } else if (action instanceof NestedAction.OnBindData) {
            StoreExtKt.post(store, NadTopTitleAction.ResetState.INSTANCE);
        } else if (action instanceof UpdateTopTitleHeight) {
            StoreExtKt.post(store, new NadTopTitleAction.UpdateNadTopTitleHeight(((UpdateTopTitleHeight) action).getHeight()));
        }
        return next.next(store, action);
    }
}
