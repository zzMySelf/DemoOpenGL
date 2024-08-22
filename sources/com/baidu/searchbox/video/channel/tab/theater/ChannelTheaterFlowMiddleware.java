package com.baidu.searchbox.video.channel.tab.theater;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Next;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.flow.api.FlowListBean;
import com.baidu.searchbox.flowvideo.flow.repos.FlowListParam;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.video.channel.HomeTabOperationManager;
import com.baidu.searchbox.video.channel.HomeTabOperationManagerKt;
import com.baidu.searchbox.video.channel.flow.utils.VideoChannelUtils;
import com.baidu.searchbox.video.channel.tab.ChannelRedDotManager;
import com.baidu.searchbox.video.feedflow.flow.list.FlowActionManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.FlowMiddleware;
import com.baidu.searchbox.video.feedflow.flow.list.RequestListData;
import com.unionpay.tsmservice.data.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0010H\u0014J,\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0014J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0014\u0010\u0019\u001a\u00020\u00122\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/theater/ChannelTheaterFlowMiddleware;", "Lcom/baidu/searchbox/video/feedflow/flow/list/FlowMiddleware;", "()V", "requestRefreshState", "", "apply", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "action", "next", "Lcom/baidu/searchbox/feed/detail/frame/Next;", "checkRequestPass", "", "isLand", "Lcom/baidu/searchbox/video/feedflow/flow/list/RequestListData;", "dispatchLoadBottomSuccess", "", "param", "Lcom/baidu/searchbox/flowvideo/flow/repos/FlowListParam;", "responseData", "Lcom/baidu/searchbox/feed/detail/ext/common/Result$Success;", "Lcom/baidu/searchbox/flowvideo/flow/api/FlowListBean;", "handleRequestParam", "updateLastRequestTime", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTheaterFlowMiddleware.kt */
public final class ChannelTheaterFlowMiddleware extends FlowMiddleware {
    private String requestRefreshState = "";

    public Action apply(Store<CommonState> store, Action action, Next<CommonState> next) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(next, "next");
        if (action instanceof NetAction.Success) {
            updateLastRequestTime((NetAction.Success) action);
        }
        return super.apply(store, action, next);
    }

    private final void updateLastRequestTime(NetAction.Success<?> action) {
        Object data = action.getData();
        if ((data instanceof FlowListBean ? (FlowListBean) data : null) != null) {
            ChannelRedDotManager.INSTANCE.updateLastRequestTime("8", System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkRequestPass(boolean isLand, RequestListData action) {
        Intrinsics.checkNotNullParameter(action, "action");
        boolean result = super.checkRequestPass(isLand, action) || FlowActionManifestKt.isForceRefreshState(action.getRefreshState());
        if (result) {
            this.requestRefreshState = action.getRefreshState();
        }
        return result;
    }

    /* access modifiers changed from: protected */
    public void dispatchLoadBottomSuccess(FlowListParam param, Store<CommonState> store, Result.Success<FlowListBean> responseData) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(responseData, Constant.KEY_RESPONSE_DATA);
        if (Intrinsics.areEqual((Object) this.requestRefreshState, (Object) param.getRefreshState())) {
            super.dispatchLoadBottomSuccess(param, store, responseData);
        }
    }

    /* access modifiers changed from: protected */
    public void handleRequestParam(FlowListParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (Intrinsics.areEqual((Object) param.getRefreshState(), (Object) "3") || Intrinsics.areEqual((Object) param.getRefreshState(), (Object) "8")) {
            String requestData = HomeTabOperationManager.INSTANCE.getRequestData();
            if (!StringsKt.isBlank(requestData)) {
                BdVideoLog.d(HomeTabOperationManagerKt.HOME_TAB_OPERATION_ONLINE_LOG_TAG, "剧场Tab，请求添加运营透传参数");
            }
            param.addExtParams("red_point_info_pass_through", requestData);
        }
        param.addExtParams("extra_pd", VideoChannelUtils.EXTRA_PD);
        param.addExtParams("video_source", VideoChannelUtils.VIDEO_SOURCE);
    }
}
