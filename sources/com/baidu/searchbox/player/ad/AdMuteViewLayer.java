package com.baidu.searchbox.player.ad;

import com.baidu.searchbox.player.layer.MuteViewLayer;
import com.baidu.searchbox.player.utils.BdVolumeUtils;

public class AdMuteViewLayer extends MuteViewLayer {
    /* access modifiers changed from: protected */
    public void sycVideoMute() {
        updateMuteIconImg(getBindPlayer().isMute());
    }

    /* access modifiers changed from: protected */
    public void switchVolumeMode() {
        boolean isMute = isMute();
        if (isMute && BdVolumeUtils.getVolume(getActivity()) == 0) {
            BdVolumeUtils.setVolume(getAppContext(), (int) (((double) BdVolumeUtils.getMaxVolume(getAppContext())) * 0.35d));
        }
        boolean isMute2 = !isMute;
        updateMuteIconImg(isMute2);
        getBindPlayer().setMuteMode(isMute2);
    }

    /* access modifiers changed from: protected */
    public boolean isMute() {
        return getBindPlayer().isMute();
    }
}
