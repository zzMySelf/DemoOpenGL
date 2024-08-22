package com.baidu.searchbox.video.detail;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.detail.CoreAction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/detail/CommonReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/video/detail/VideoState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoDetailRedux.kt */
public final class CommonReducer implements Reducer<VideoState> {
    public VideoState reduce(VideoState state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        VideoState newState = VideoState.copy$default(state, (Map) null, (CoreAction) null, action, 3, (Object) null);
        if (action instanceof CoreAction.Attach) {
            return VideoState.copy$default(newState, (Map) null, CoreAction.Attach.INSTANCE, (Action) null, 5, (Object) null);
        } else if (action instanceof CoreAction.Detach) {
            return VideoState.copy$default(newState, (Map) null, CoreAction.Detach.INSTANCE, (Action) null, 5, (Object) null);
        } else if (!(action instanceof CoreAction.PageSelected)) {
            return newState;
        } else {
            return VideoState.copy$default(newState, (Map) null, (CoreAction) action, (Action) null, 5, (Object) null);
        }
    }
}
