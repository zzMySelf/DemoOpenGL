package com.baidu.searchbox.player;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.WindowManager;
import com.baidu.searchbox.player.layer.ChannelControlLayer;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
import com.baidu.searchbox.player.utils.VideoNotchUtils;

public class ChannelVideoPlayer extends ShortVideoPlayer {
    public ChannelVideoPlayer(String vid) {
        super(vid);
    }

    public ChannelVideoPlayer(Activity activity, String vid) {
        super((Context) activity, vid);
    }

    /* access modifiers changed from: protected */
    public void addControlLayer() {
        this.mControlLayer = new ChannelControlLayer();
        addLayer(this.mControlLayer);
    }

    public void dismissMuteBubble() {
        if (this.mControlLayer != null) {
            this.mControlLayer.dismissMuteBubble();
        }
    }

    /* access modifiers changed from: protected */
    public boolean isEnablePlayerConfigNotch(boolean switchToFull) {
        if (switchToFull) {
            return !isConfigNotchDisabled();
        }
        return false;
    }

    private boolean isConfigNotchDisabled() {
        Activity activity = getActivity();
        if (Build.VERSION.SDK_INT < 28 || activity == null || !VideoNotchUtils.hasNotchAtHuawei(getAppContext())) {
            return false;
        }
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        BdViewOpUtils.saveDisplayCutoutMode(activity, 1);
        if (lp.layoutInDisplayCutoutMode == 0) {
            return true;
        }
        return false;
    }
}
