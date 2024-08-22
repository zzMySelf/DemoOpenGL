package com.baidu.searchbox.feed.ad.suffix;

import com.baidu.searchbox.feed.ad.model.VideoAdItemModel;
import com.baidu.searchbox.interfaces.IAdSuffixEventListener;
import com.baidu.searchbox.player.ad.AdLayer;

public abstract class AdLayerSuffixBaseManager {
    final AdLayer mAdLayer;
    IAdSuffixEventListener mSuffixAdEventListener;
    VideoAdItemModel mVideoAdItemModel;

    /* access modifiers changed from: package-private */
    public abstract void execute();

    public abstract void handleLayerRelease();

    public abstract void onNightModeChanged(boolean z);

    public abstract void setPlayerMode(boolean z);

    public abstract void startCountDown();

    public abstract void stopCountDown();

    AdLayerSuffixBaseManager(AdLayer adLayer, IAdSuffixEventListener suffixAdEventListener, VideoAdItemModel videoAdItemModel) {
        this.mAdLayer = adLayer;
        this.mSuffixAdEventListener = suffixAdEventListener;
        this.mVideoAdItemModel = videoAdItemModel;
    }

    AdLayerSuffixBaseManager(AdLayer adLayer) {
        this.mAdLayer = adLayer;
    }

    /* access modifiers changed from: protected */
    public void destroy() {
    }

    public boolean isHalfMode() {
        AdLayer adLayer = this.mAdLayer;
        if (adLayer != null) {
            return !adLayer.getBindPlayer().isFullMode();
        }
        return true;
    }
}
