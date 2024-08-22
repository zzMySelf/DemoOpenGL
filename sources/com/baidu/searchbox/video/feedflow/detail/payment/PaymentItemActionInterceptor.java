package com.baidu.searchbox.video.feedflow.detail.payment;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameReplayClickAction;
import com.baidu.searchbox.video.feedflow.detail.payment.lastframe.OnColumnLastFrameShownAction;
import com.baidu.searchbox.video.feedflow.detail.payment.player.PaymentPlayerAction;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameReplayClickAction;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameShownAction;
import com.baidu.searchbox.video.feedflow.flow.payment.authentication.AuthenticationAction;
import com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/PaymentItemActionInterceptor;", "Lcom/baidu/searchbox/video/feedflow/common/VideoFlowActionInterceptor;", "()V", "accept", "", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "deliver", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentItemActionInterceptor.kt */
public final class PaymentItemActionInterceptor extends VideoFlowActionInterceptor {
    public boolean accept(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof PayAction.PayPanelResult) && !(action instanceof PayAction.PaySuccess) && !(action instanceof AuthenticationAction.Success) && !(action instanceof AuthenticationAction.Fail) && !(action instanceof AuthenticationAction.IgnoreToPlay)) {
            return super.accept(action);
        }
        return true;
    }

    public boolean deliver(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof PayAction.PayClickAction) && !(action instanceof PaymentPlayerAction.StartPlay) && !(action instanceof PaymentPlayerAction.Reload) && !(action instanceof OnColumnLastFrameShownAction) && !(action instanceof SubscribeLastFrameShownAction) && !(action instanceof OnColumnLastFrameHiddenAction) && !(action instanceof SubscribeLastFrameHiddenAction) && !(action instanceof OnColumnLastFrameReplayClickAction) && !(action instanceof SubscribeLastFrameReplayClickAction)) {
            return super.deliver(action);
        }
        return true;
    }
}
