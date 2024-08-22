package com.baidu.searchbox.video.feedflow.tab;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.detail.guide.OnSlideStop;
import com.baidu.searchbox.video.feedflow.detail.more.UninterestedClickAction;
import com.baidu.searchbox.video.feedflow.detail.muteoffguide.OnMuteOffGuideClickAction;
import com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameReplayClickAction;
import com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameShownAction;
import com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentPlayerAction;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameReplayClickAction;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameShownAction;
import com.baidu.searchbox.video.feedflow.flow.authorworks.OnAuthorWorksStatusChange;
import com.baidu.searchbox.video.feedflow.flow.lagfluency.FpsAction;
import com.baidu.searchbox.video.feedflow.flow.list.ListDataChanged;
import com.baidu.searchbox.video.feedflow.flow.list.ListRefreshCompleteAction;
import com.baidu.searchbox.video.feedflow.flow.list.ListRequestFail;
import com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged;
import com.baidu.searchbox.video.feedflow.flow.loading.FlowLoadingAction;
import com.baidu.searchbox.video.feedflow.flow.operation.FlowFunctionPositionCalculateAction;
import com.baidu.searchbox.video.feedflow.flow.payment.authentication.AuthenticationAction;
import com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayModeAction;
import com.baidu.searchbox.video.feedflow.flow.pullrefresh.PullRefreshAction;
import com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableAction;
import com.baidu.searchbox.video.feedflow.pushlinkage.VideoItemContainerAction;
import com.baidu.searchbox.video.feedflow.tab.TabComponentAction;
import com.baidu.searchbox.video.feedflow.tab.attention.AttentionTabAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/TabFlowActionInterceptor;", "Lcom/baidu/searchbox/video/feedflow/common/VideoFlowActionInterceptor;", "()V", "accept", "", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "deliver", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabFlowActionInterceptor.kt */
public final class TabFlowActionInterceptor extends VideoFlowActionInterceptor {
    public boolean accept(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if ((action instanceof ScrollStateChanged) || (action instanceof ListRequestSuccess) || (action instanceof ListRequestFail) || (action instanceof ListDataChanged) || (action instanceof ListRefreshCompleteAction)) {
            return false;
        }
        if (action instanceof UninterestedClickAction) {
            return true;
        }
        if (action instanceof FpsAction.OnFpsEndCollection) {
            return true;
        }
        if (action instanceof PayAction.PayPanelResult) {
            return true;
        }
        if (action instanceof PayAction.PaySuccess) {
            return true;
        }
        if (action instanceof AuthenticationAction.Success) {
            return true;
        }
        if (action instanceof AuthenticationAction.Fail) {
            return true;
        }
        if (action instanceof AuthenticationAction.IgnoreToPlay) {
            return true;
        }
        if (action instanceof TabComponentAction.OnTabPageSelected) {
            return true;
        }
        if (action instanceof VideoItemContainerAction.OnNewsRecommendVideoClickRefreshList) {
            return true;
        }
        if (action instanceof OnMuteOffGuideClickAction) {
            return true;
        }
        if ((action instanceof OnAuthorWorksStatusChange) || (action instanceof PlayModeAction.OnPlayModeChanged)) {
            return false;
        }
        if (action instanceof PullRefreshAction.AutoRefresh) {
            return true;
        }
        return super.accept(action);
    }

    public boolean deliver(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof UpdateFlowDataSuccess) && !(action instanceof ScrollStateChanged) && !(action instanceof AttentionTabAction.RedDotNetSuccess) && !(action instanceof ListRequestSuccess) && !(action instanceof ListRequestFail) && !(action instanceof ListDataChanged) && !(action instanceof PayAction.PayClickAction) && !(action instanceof PaymentPlayerAction.StartPlay) && !(action instanceof PaymentPlayerAction.Reload) && !(action instanceof OnColumnLastFrameShownAction) && !(action instanceof OnColumnLastFrameHiddenAction) && !(action instanceof OnColumnLastFrameReplayClickAction) && !(action instanceof SubscribeLastFrameShownAction) && !(action instanceof SubscribeLastFrameHiddenAction) && !(action instanceof SubscribeLastFrameReplayClickAction) && !(action instanceof FlowLoadingAction.OnLoadingVisible) && !(action instanceof ListRefreshCompleteAction) && !(action instanceof TopExpandableAction.ExpandViewHeightChanged) && !(action instanceof FlowFunctionPositionCalculateAction.CalculateElementPositionAction) && !(action instanceof OnAuthorWorksStatusChange) && !(action instanceof PlayModeAction.OnPlayModeChanged) && !(action instanceof OnSlideStop)) {
            return super.deliver(action);
        }
        return true;
    }
}
