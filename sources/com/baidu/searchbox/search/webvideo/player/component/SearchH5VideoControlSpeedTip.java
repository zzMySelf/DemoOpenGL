package com.baidu.searchbox.search.webvideo.player.component;

import android.widget.FrameLayout;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.player.element.VideoControlSpeedTip;
import com.baidu.searchbox.player.utils.BdVolumeUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/player/component/SearchH5VideoControlSpeedTip;", "Lcom/baidu/searchbox/player/element/VideoControlSpeedTip;", "()V", "getFullParams", "Landroid/widget/FrameLayout$LayoutParams;", "getHalfParams", "getLeftMargin4Half", "", "setSpeed", "", "speed", "", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5VideoControlSpeedTip.kt */
public final class SearchH5VideoControlSpeedTip extends VideoControlSpeedTip {
    public FrameLayout.LayoutParams getFullParams() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, 374);
        params.bottomMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 9.0f);
        if (getVideoPlayer().isMute() || BdVolumeUtils.getVolume(getContext()) <= 0) {
            params.setMarginStart(DeviceUtils.ScreenInfo.dp2px(getContext(), 45.0f));
        } else {
            params.setMarginStart(0);
        }
        params.gravity = 80;
        return params;
    }

    public FrameLayout.LayoutParams getHalfParams() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 80;
        params.bottomMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 10.5f);
        params.leftMargin = getLeftMargin4Half();
        return params;
    }

    private final int getLeftMargin4Half() {
        if (getVideoPlayer().isMute() || BdVolumeUtils.getVolume(getContext()) <= 0) {
            return DeviceUtils.ScreenInfo.dp2px(getContext(), 45.0f);
        }
        return DeviceUtils.ScreenInfo.dp2px(getContext(), 15.0f);
    }

    public void setSpeed(float speed) {
        super.setSpeed(speed);
        if (getVideoPlayer().isFullMode()) {
            this.mRlSpeedTips.setLayoutParams(getFullParams());
        }
    }
}
