package com.baidu.searchbox.player.ad;

import com.baidu.searchbox.player.element.MuteBtnElement;
import com.baidu.searchbox.player.utils.BdVolumeUtils;

public class AdMuteElement extends MuteBtnElement {
    /* access modifiers changed from: protected */
    public void sycVideoMute() {
        updateMuteIconImg(getVideoPlayer().isMute());
    }

    /* access modifiers changed from: protected */
    public void switchVolumeMode() {
        boolean isMute = isMute();
        if (isMute && BdVolumeUtils.getVolume(getContext()) == 0) {
            BdVolumeUtils.setVolume(getContext(), (int) (((double) BdVolumeUtils.getMaxVolume(getContext())) * 0.35d));
        }
        syncMuteAutoPlayState(isMute);
        boolean isMute2 = !isMute;
        updateMuteIconImg(isMute2);
        setPlayerMuteMode(isMute2);
    }

    /* access modifiers changed from: protected */
    public void setPlayerMuteMode(boolean isMute) {
        getVideoPlayer().setMuteMode(isMute);
    }

    /* access modifiers changed from: protected */
    public boolean isMute() {
        return getVideoPlayer().isMute();
    }
}
