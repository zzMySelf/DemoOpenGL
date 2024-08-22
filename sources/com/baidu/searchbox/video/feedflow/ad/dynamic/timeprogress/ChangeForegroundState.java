package com.baidu.searchbox.video.feedflow.ad.dynamic.timeprogress;

import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/dynamic/timeprogress/ChangeForegroundState;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "isForeground", "", "(Z)V", "()Z", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDynamicTimeProgressActionManifest.kt */
public final class ChangeForegroundState implements Action {
    private final boolean isForeground;

    public ChangeForegroundState(boolean isForeground2) {
        this.isForeground = isForeground2;
    }

    public final boolean isForeground() {
        return this.isForeground;
    }
}
