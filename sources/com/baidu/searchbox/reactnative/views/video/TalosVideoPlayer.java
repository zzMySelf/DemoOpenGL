package com.baidu.searchbox.reactnative.views.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.player.callback.IUniversalPlayerCallback;
import com.baidu.searchbox.player.config.PlayerConfig;
import com.baidu.searchbox.player.config.PlayerConfigKit;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.MuteBtnEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.KernelSwitchManager;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.searchbox.player.layer.ErrorLayer;
import com.baidu.searchbox.player.layer.ShareFullLayer;
import com.baidu.searchbox.player.property.GroupScope;
import com.baidu.searchbox.player.property.PlayerPropertyManifestKt;
import com.baidu.searchbox.player.utils.BdVolumeUtils;
import com.baidu.searchbox.player.utils.VideoPlayerSpUtil;
import com.baidu.searchbox.reactnative.views.video.barrage.TalosBarrageManager;
import com.baidu.searchbox.reactnative.views.video.events.OnPlayerCallBackImmediatelyListener;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.webkit.sdk.Log;
import kotlin.jvm.functions.Function0;

public class TalosVideoPlayer extends BaseVideoPlayer {
    private static final String TALOS_PLAYER_LOCK_GROUP_NAME = "talos_player_lock_group";
    private static final String TALOS_VIDEO_LAYER_SIMPLIFY = "search_talos_video_layer_simplify";
    private static PlayerConfig playerConfig = new PlayerConfig();
    private boolean enableHeadsetPlugin = false;
    private boolean isPlayerAlwaysMuteMode = false;
    private boolean mAutoRotate = false;
    private TalosBarrageManager mBarrageManager;
    private Context mContext;
    private TalosControlLayer mControlLayer;
    private boolean mEnableToastNetTip = true;
    private TalosGestureLayer mGestureLayer;
    private TalosFakeMuteLayer mMuteLayer;
    private TalosNetTipsLayer mNetTipLayer;
    private String mPlayerAlwaysMuteModeTips;
    private OnPlayerCallBackImmediatelyListener onPlayerCallBackImmediatelyListener;

    public TalosVideoPlayer(Context context) {
        super(context, createDefaultKernelLayer(), "", createPlayerConfig(context));
        this.mContext = context;
    }

    private static PlayerConfig createPlayerConfig(Context context) {
        PlayerConfigKit.setLockConfig(playerConfig, (Function0<Boolean>) null, new GroupScope(TALOS_PLAYER_LOCK_GROUP_NAME));
        if ((context instanceof TalosPageContext) && TextUtils.equals("FeedSnVideoPlaylet", ((TalosPageContext) context).getModuleName())) {
            PlayerConfigKit.setMuteConfig(playerConfig, new TalosVideoPlayer$$ExternalSyntheticLambda1(), new GroupScope(PlayerPropertyManifestKt.FEED_GLOBAL_MUTE_GROUP_NAME));
        }
        return playerConfig;
    }

    /* access modifiers changed from: protected */
    public void setupLayers(Context context) {
        Boolean isEnableLayerSimplify = Boolean.valueOf(isFromSearch(context) && enablePlayerLayerSimplify());
        if (AppConfig.isDebug()) {
            Log.v("TalosVideoPlayer", "setupLayers isEnableLayerSimplify = " + isEnableLayerSimplify);
        }
        addLayer(new TalosPosterLayer());
        if (!isEnableLayerSimplify.booleanValue()) {
            if (context instanceof Activity) {
                this.mGestureLayer = new TalosGestureLayer((Activity) context, true);
            } else {
                this.mGestureLayer = new TalosGestureLayer(true);
            }
            addLayer(this.mGestureLayer);
            addLayer(new TalosShareLayer());
            addLayer(new ShareFullLayer());
        }
        addLayer(new ErrorLayer());
        TalosControlLayer talosControlLayer = new TalosControlLayer();
        this.mControlLayer = talosControlLayer;
        addLayer(talosControlLayer);
        TalosFakeMuteLayer talosFakeMuteLayer = new TalosFakeMuteLayer();
        this.mMuteLayer = talosFakeMuteLayer;
        addLayer(talosFakeMuteLayer);
    }

    public boolean onInfo(int what, int extra, Object object) {
        OnPlayerCallBackImmediatelyListener onPlayerCallBackImmediatelyListener2;
        if ((what == 904 || what == 956) && (onPlayerCallBackImmediatelyListener2 = this.onPlayerCallBackImmediatelyListener) != null) {
            onPlayerCallBackImmediatelyListener2.onFirstFrame();
        }
        return super.onInfo(what, extra, object);
    }

    /* access modifiers changed from: protected */
    public void initHelper() {
        super.initHelper();
        this.mStyleSwitchHelper = new TalosSwitchHelper(this);
    }

    public int getPlayerStageType() {
        return 50;
    }

    /* access modifiers changed from: protected */
    public void initCallBackManager() {
        this.mCallbackManager = new TalosPlayerCallBackManager();
    }

    public TalosPlayerCallBackManager getPlayerCallbackManager() {
        if (this.mCallbackManager == null) {
            initCallBackManager();
        }
        return (TalosPlayerCallBackManager) this.mCallbackManager;
    }

    public void setPlayerCallBackImmediatelyListener(OnPlayerCallBackImmediatelyListener listener) {
        this.onPlayerCallBackImmediatelyListener = listener;
    }

    public void setVideoPlayerListener(IUniversalPlayerCallback callback) {
        getPlayerCallbackManager().setUniversalPlayerCallback(callback);
    }

    public void setMuteChangeListener(OnMuteChangeListener listener) {
        getPlayerCallbackManager().setMuteChangeListener(listener);
    }

    public void setSystemVolumeChangeListener(OnSystemVolumeChangeListener listener) {
        getPlayerCallbackManager().setSystemVolumeChangeListener(listener);
    }

    /* JADX WARNING: type inference failed for: r1v11, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Activity getActivity() {
        /*
            r2 = this;
            r0 = 0
            android.view.ViewGroup r1 = r2.mPlayerContainer
            if (r1 == 0) goto L_0x0030
            android.view.ViewGroup r1 = r2.mPlayerContainer
            android.content.Context r1 = r1.getContext()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0018
            android.view.ViewGroup r1 = r2.mPlayerContainer
            android.content.Context r1 = r1.getContext()
            r0 = r1
            android.app.Activity r0 = (android.app.Activity) r0
        L_0x0018:
            if (r0 != 0) goto L_0x0030
            android.view.ViewGroup r1 = r2.mPlayerContainer
            android.content.Context r1 = r1.getContext()
            boolean r1 = r1 instanceof com.baidu.talos.core.context.TalosPageContext
            if (r1 == 0) goto L_0x0030
            android.view.ViewGroup r1 = r2.mPlayerContainer
            android.content.Context r1 = r1.getContext()
            com.baidu.talos.core.context.TalosPageContext r1 = (com.baidu.talos.core.context.TalosPageContext) r1
            android.app.Activity r0 = r1.getHostActivity()
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.reactnative.views.video.TalosVideoPlayer.getActivity():android.app.Activity");
    }

    public void start() {
        if (BdVolumeUtils.getVolume(AppRuntime.getAppContext()) <= 0) {
            setMuteMode(true);
        }
        super.start();
    }

    public void pause(int pauseType) {
        super.pause(pauseType);
    }

    public void resume() {
        super.resume();
    }

    public void stop() {
        super.stop();
    }

    public KernelSwitchManager getReuseHelper() {
        if (this.mReuseHelper == null) {
            this.mReuseHelper = new TalosKernelSwitchManager();
        }
        return (TalosKernelSwitchManager) this.mReuseHelper;
    }

    public void configControlType(String type) {
        if (TextUtils.equals("onlyProgress", type)) {
            TalosGestureLayer talosGestureLayer = this.mGestureLayer;
            if (talosGestureLayer != null) {
                talosGestureLayer.showThumbSeekBarAlways(true);
            }
            if (this.mLayerContainer != null) {
                this.mLayerContainer.detachLayer((AbsLayer) this.mControlLayer, true);
            }
        } else if (!TextUtils.equals("showNormalControl", type)) {
            TalosGestureLayer talosGestureLayer2 = this.mGestureLayer;
            if (talosGestureLayer2 != null) {
                talosGestureLayer2.hideThumbSeekBar();
            }
            if (this.mLayerContainer != null) {
                this.mLayerContainer.detachLayer((AbsLayer) this.mControlLayer, true);
            }
        }
    }

    public void configMuteGroup(String muteGroup) {
        if (!TextUtils.isEmpty(muteGroup)) {
            PlayerConfigKit.setMuteConfig(playerConfig, new TalosVideoPlayer$$ExternalSyntheticLambda0(), new GroupScope(muteGroup));
            setMuteMode(((Boolean) PlayerConfigKit.getMuteConfig(playerConfig).getState()).booleanValue());
        }
    }

    public void setVideoSeriesForPrepare(BdVideoSeries series, boolean isNeedPrepare) {
        super.setVideoSeriesForPrepare(series, isNeedPrepare);
    }

    public void onFirstFrame() {
        TalosBarrageManager talosBarrageManager = this.mBarrageManager;
        if (talosBarrageManager != null) {
            talosBarrageManager.onFirstFrame();
        }
    }

    public void setEnableHeadsetPlugin(boolean enableHeadsetPlugin2) {
        this.enableHeadsetPlugin = enableHeadsetPlugin2;
    }

    public boolean isEnableHeadsetPlugin() {
        return this.enableHeadsetPlugin;
    }

    public void setPlayerAlpha(float alpha) {
        if (this.mKernelLayer != null && this.mKernelLayer.getContentView() != null) {
            this.mKernelLayer.getContentView().setAlpha(alpha);
        }
    }

    public void setPlayerAlwaysMuteMode(boolean alwaysMuteMode) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setAcceptVolumeChange(!alwaysMuteMode);
        }
        if (alwaysMuteMode) {
            setMuteMode(true);
            if (this.mMuteLayer != null) {
                getLayerContainer().detachLayer((AbsLayer) this.mMuteLayer, true);
            }
        } else if (this.mMuteLayer != null) {
            getLayerContainer().addLayer(this.mMuteLayer);
        }
        this.isPlayerAlwaysMuteMode = alwaysMuteMode;
    }

    public boolean isPlayerAlwaysMuteMode() {
        return this.isPlayerAlwaysMuteMode;
    }

    public void setPlayerAlwaysMuteModeTips(String tips) {
        this.mPlayerAlwaysMuteModeTips = tips;
    }

    public String getPlayerAlwaysMuteModeTips() {
        return this.mPlayerAlwaysMuteModeTips;
    }

    /* access modifiers changed from: protected */
    public void showNetTipToast() {
        if (this.mEnableToastNetTip) {
            super.showNetTipToast();
        }
    }

    public void setEnableToastNetTip(boolean enableToastNetTip) {
        this.mEnableToastNetTip = enableToastNetTip;
    }

    public boolean getAutoRotate() {
        return this.mAutoRotate;
    }

    public void setAutoRotate(boolean autoRotate) {
        this.mAutoRotate = autoRotate;
    }

    public void pause() {
        super.pause();
        saveProgressToDb();
    }

    /* access modifiers changed from: protected */
    public boolean isRecordHistoryEnable() {
        return true;
    }

    public void setDirection(int direction) {
        if (this.mStyleSwitchHelper instanceof TalosSwitchHelper) {
            ((TalosSwitchHelper) this.mStyleSwitchHelper).setDirection(direction);
        }
    }

    public void setShowNoWifiTips(boolean showNoWifiTip) {
        if (this.mNetTipLayer == null) {
            TalosNetTipsLayer talosNetTipsLayer = new TalosNetTipsLayer();
            this.mNetTipLayer = talosNetTipsLayer;
            addLayer(talosNetTipsLayer);
        }
        this.mNetTipLayer.setPlayWithoutWifi(!showNoWifiTip);
        VideoPlayerSpUtil.setAutoPlayInGPRS(!showNoWifiTip);
    }

    public void setEnableVerticalSlide(boolean isFullScreen, boolean enable) {
        TalosGestureLayer talosGestureLayer = this.mGestureLayer;
        if (talosGestureLayer != null) {
            talosGestureLayer.setEnableVerticalSlide(isFullScreen, enable);
        }
    }

    public void setEnableHorizontalSlide(boolean isFullScreen, boolean enable) {
        TalosGestureLayer talosGestureLayer = this.mGestureLayer;
        if (talosGestureLayer != null) {
            talosGestureLayer.setEnableHorizontalSlide(isFullScreen, enable);
        }
    }

    public void setShowRateBtn() {
        TalosControlLayer talosControlLayer = this.mControlLayer;
        if (talosControlLayer != null) {
            talosControlLayer.delayAddPlaySpeedElement();
        }
    }

    public void setEnableBarrage(boolean isBarrageEnable) {
        if (this.mBarrageManager == null) {
            this.mBarrageManager = new TalosBarrageManager(this, this.mControlLayer);
        }
        this.mBarrageManager.setEnableBarrage(isBarrageEnable);
    }

    public void setShowBarrageBtn(boolean showBarrageBtn) {
        TalosBarrageManager talosBarrageManager = this.mBarrageManager;
        if (talosBarrageManager != null) {
            talosBarrageManager.setShowBarrageBtn(showBarrageBtn);
        }
    }

    public TalosBarrageManager getBarrageManager() {
        if (this.mBarrageManager == null) {
            this.mBarrageManager = new TalosBarrageManager(this, this.mControlLayer);
        }
        return this.mBarrageManager;
    }

    public void setMuteMode(boolean mute) {
        super.setMuteMode(mute);
        VideoEvent event = LayerEvent.obtainEvent(MuteBtnEvent.ACTION_MUTE_ICON_UPDATE);
        event.putExtra(1, Boolean.valueOf(mute));
        sendEvent(event);
    }

    public boolean isUseCacheEnable() {
        return true;
    }

    private boolean isFromSearch(Context context) {
        if (!(context instanceof TalosPageContext)) {
            return false;
        }
        String runtimeKey = ((TalosPageContext) context).getRuntimeKey();
        if (TextUtils.isEmpty(runtimeKey) || runtimeKey.indexOf("rnplugin.searchmanifest") <= 0) {
            return false;
        }
        return true;
    }

    private boolean enablePlayerLayerSimplify() {
        if (AppConfig.isDebug()) {
            return true;
        }
        return TalosAdapterManager.getABTestManager().getSwitch(TALOS_VIDEO_LAYER_SIMPLIFY, false);
    }

    public void release() {
        super.release();
        this.onPlayerCallBackImmediatelyListener = null;
    }
}
