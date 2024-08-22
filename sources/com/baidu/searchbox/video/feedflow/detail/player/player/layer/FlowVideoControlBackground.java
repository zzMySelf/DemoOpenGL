package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import com.baidu.searchbox.player.element.VideoControlBackground;
import com.baidu.searchbox.player.event.VideoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowVideoControlBackground;", "Lcom/baidu/searchbox/player/element/VideoControlBackground;", "()V", "onEventNotify", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "wakeUpEnd", "wakeUpStart", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoControlBackground.kt */
public final class FlowVideoControlBackground extends VideoControlBackground {
    public void onEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public void wakeUpStart() {
        setTopShadowVisible(true);
    }

    public void wakeUpEnd() {
        setTopShadowVisible(false);
    }
}
