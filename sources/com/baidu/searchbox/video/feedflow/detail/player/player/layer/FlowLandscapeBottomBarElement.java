package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import com.baidu.searchbox.player.element.VideoControlLandscapeBottomBarElement;
import com.baidu.searchbox.player.ui.BdLayerSeekBar;
import com.baidu.searchbox.video.videoplayer.ui.full.BdThumbSeekBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowLandscapeBottomBarElement;", "Lcom/baidu/searchbox/player/element/VideoControlLandscapeBottomBarElement;", "()V", "initElement", "", "onStartTrackingTouch", "seekBar", "Lcom/baidu/searchbox/video/videoplayer/ui/full/BdThumbSeekBar;", "onStopTrackingTouch", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowLandscapeBottomBarElement.kt */
public final class FlowLandscapeBottomBarElement extends VideoControlLandscapeBottomBarElement {
    public void initElement() {
        super.initElement();
        BdLayerSeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setSeekBarStyle(BdThumbSeekBar.BdSeekBarStyle.ROUND_RECT);
            seekBar.setProgressViewMarginLeft(0);
            seekBar.setSeekBarTraceHeight(2);
        }
    }

    public void onStartTrackingTouch(BdThumbSeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        getVideoPlayer().disableOrientationEventHelper();
    }

    public void onStopTrackingTouch(BdThumbSeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        getVideoPlayer().enableOrientationEventHelper();
    }
}
