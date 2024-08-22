package com.baidu.searchbox.download.center.ui.video.vulcan;

import com.baidu.searchbox.player.gesture.layer.VulcanGestureLayer;
import com.baidu.searchbox.player.utils.gesture.GestureDispatchType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/video/vulcan/DownloadVulcanGestureLayer;", "Lcom/baidu/searchbox/player/gesture/layer/VulcanGestureLayer;", "()V", "allowHandleLongPressEvent", "", "getGestureDispatchType", "Lcom/baidu/searchbox/player/utils/gesture/GestureDispatchType;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadVulcanGestureLayer.kt */
public final class DownloadVulcanGestureLayer extends VulcanGestureLayer {
    /* access modifiers changed from: protected */
    public GestureDispatchType getGestureDispatchType() {
        return GestureDispatchType.GESTURE_TWO;
    }

    public boolean allowHandleLongPressEvent() {
        return !getBindPlayer().isOrientationLocked();
    }
}
