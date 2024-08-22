package com.baidu.searchbox.video.utils;

import com.baidu.searchbox.player.element.BubbleElement;
import com.baidu.searchbox.player.element.ControlBottomBarElement;
import com.baidu.searchbox.player.element.VideoControlBottomBarElement;
import com.baidu.searchbox.player.element.VideoControlNextPreviousBtn;
import com.baidu.searchbox.player.element.VideoDetailControlBottomBarElement;
import com.baidu.searchbox.player.layer.HalfScreenBarrageControlBtn;
import com.baidu.searchbox.player.layer.ShortVideoControlLayer;
import com.baidu.searchbox.player.utils.HalfScreenBarrageUtils;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.utils.VideoFloatingUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/utils/VideoPlayerProvideUtils$getFeedVideoDetailPlayerControlLayer$1", "Lcom/baidu/searchbox/player/layer/ShortVideoControlLayer;", "addBottomBarElement", "", "addSpecialElement", "isFloatingShowEnabled", "", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPlayerProvideUtils.kt */
public final class VideoPlayerProvideUtils$getFeedVideoDetailPlayerControlLayer$1 extends ShortVideoControlLayer {
    VideoPlayerProvideUtils$getFeedVideoDetailPlayerControlLayer$1() {
    }

    /* access modifiers changed from: protected */
    public void addSpecialElement() {
        addElement(new VideoControlNextPreviousBtn());
        if (HalfScreenBarrageUtils.isHalfScreenBarrageEnable("video_landing")) {
            addElement(new HalfScreenBarrageControlBtn());
        }
    }

    /* access modifiers changed from: protected */
    public void addBottomBarElement() {
        BubbleElement bubbleElement;
        if (IVideoAppConfig.Impl.get().isTeenager()) {
            bubbleElement = new ControlBottomBarElement();
        } else if (isFloatingShowEnabled()) {
            bubbleElement = new VideoDetailControlBottomBarElement();
        } else {
            bubbleElement = new VideoControlBottomBarElement();
        }
        this.mControlBottomBarElement = bubbleElement;
        addElement(this.mControlBottomBarElement);
    }

    private final boolean isFloatingShowEnabled() {
        return VideoFloatingUtils.isFloatingButtonOpen() && VideoFloatingUtils.isVideoFloatingEnable();
    }
}
