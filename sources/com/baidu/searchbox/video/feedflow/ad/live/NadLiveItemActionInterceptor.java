package com.baidu.searchbox.video.feedflow.ad.live;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.common.VideoFlowActionInterceptor;
import com.baidu.searchbox.video.feedflow.detail.liveexception.LiveExceptionCountDownDetach;
import com.baidu.searchbox.video.feedflow.detail.liveexception.LiveExceptionCountDownFinish;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle;
import com.baidu.searchbox.video.feedflow.flow.showclick.ItemShowAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/live/NadLiveItemActionInterceptor;", "Lcom/baidu/searchbox/video/feedflow/common/VideoFlowActionInterceptor;", "()V", "accept", "", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "deliver", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadLiveItemActionInterceptor.kt */
public final class NadLiveItemActionInterceptor extends VideoFlowActionInterceptor {
    public boolean deliver(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(action instanceof LiveExceptionCountDownFinish) && !(action instanceof LiveExceptionCountDownDetach)) {
            return super.deliver(action);
        }
        return true;
    }

    public boolean accept(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof ItemShowAction) {
            return true;
        }
        if (action instanceof UpdateFlowStyle) {
            return false;
        }
        return super.accept(action);
    }
}
