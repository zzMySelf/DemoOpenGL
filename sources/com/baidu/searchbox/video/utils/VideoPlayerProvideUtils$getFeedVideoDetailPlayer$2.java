package com.baidu.searchbox.video.utils;

import android.content.Context;
import com.baidu.searchbox.player.ShortVideoPlayer;
import com.baidu.searchbox.player.layer.ControlLayer;
import com.baidu.searchbox.player.layer.KernelLayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/utils/VideoPlayerProvideUtils$getFeedVideoDetailPlayer$2", "Lcom/baidu/searchbox/player/ShortVideoPlayer;", "initControlLayer", "Lcom/baidu/searchbox/player/layer/ControlLayer;", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerProvideUtils.kt */
public final class VideoPlayerProvideUtils$getFeedVideoDetailPlayer$2 extends ShortVideoPlayer {
    VideoPlayerProvideUtils$getFeedVideoDetailPlayer$2(Context $context, KernelLayer $kernelLayer, String $nid) {
        super($context, $kernelLayer, $nid);
    }

    /* access modifiers changed from: protected */
    public ControlLayer initControlLayer() {
        return VideoPlayerProvideUtils.getFeedVideoDetailPlayerControlLayer();
    }
}
