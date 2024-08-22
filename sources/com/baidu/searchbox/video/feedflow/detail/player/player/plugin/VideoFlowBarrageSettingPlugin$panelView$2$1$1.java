package com.baidu.searchbox.video.feedflow.detail.player.player.plugin;

import com.baidu.searchbox.player.BaseVulcanVideoPlayer;
import com.baidu.searchbox.player.callback.BaseVulcanVideoPlayerCallbackManager;
import com.baidu.searchbox.player.callback.IControlLayerCallback;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.panel.OnBarrageSettingPanelItemChangeListener;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.utils.BarrageSettingSPDataUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/player/player/plugin/VideoFlowBarrageSettingPlugin$panelView$2$1$1", "Lcom/baidu/searchbox/video/feedflow/detail/barragesetting/panel/OnBarrageSettingPanelItemChangeListener;", "onAlphaValueChange", "", "alpha", "", "actionType", "onFontsizeValueChange", "fontsize", "onLinesValueChange", "lines", "onResumeDefaultClick", "onResumeDefaultShow", "onSpeedValueChange", "speedGear", "speedFactor", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowBarrageSettingPlugin.kt */
public final class VideoFlowBarrageSettingPlugin$panelView$2$1$1 implements OnBarrageSettingPanelItemChangeListener {
    final /* synthetic */ VideoFlowBarrageSettingPlugin this$0;

    VideoFlowBarrageSettingPlugin$panelView$2$1$1(VideoFlowBarrageSettingPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onFooterClick() {
        OnBarrageSettingPanelItemChangeListener.DefaultImpls.onFooterClick(this);
    }

    public void onAlphaValueChange(int alpha, int actionType) {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        IControlLayerCallback controlLayerCallback;
        BarrageSettingSPDataUtils.INSTANCE.saveSysFontSizeSnapshot();
        BarrageSettingSPDataUtils.INSTANCE.setBarrageSettingAlpha(alpha);
        BaseVulcanVideoPlayer bindPlayer = this.this$0.getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null && (controlLayerCallback = playerCallbackManager.getControlLayerCallback()) != null) {
            controlLayerCallback.onBarrageSettingAlphaChange(alpha, actionType);
        }
    }

    public void onSpeedValueChange(int speedGear, float speedFactor, int actionType) {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        IControlLayerCallback controlLayerCallback;
        BarrageSettingSPDataUtils.INSTANCE.saveSysFontSizeSnapshot();
        BarrageSettingSPDataUtils.INSTANCE.setBarrageSettingSpeedGear(speedGear);
        BarrageSettingSPDataUtils.INSTANCE.setBarrageSettingSpeedFactor(speedFactor);
        BaseVulcanVideoPlayer bindPlayer = this.this$0.getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null && (controlLayerCallback = playerCallbackManager.getControlLayerCallback()) != null) {
            controlLayerCallback.onBarrageSettingSpeedChange(speedGear, speedFactor, actionType);
        }
    }

    public void onFontsizeValueChange(int fontsize, int actionType) {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        IControlLayerCallback controlLayerCallback;
        BarrageSettingSPDataUtils.INSTANCE.saveSysFontSizeSnapshot();
        BarrageSettingSPDataUtils.INSTANCE.setBarrageSettingFontsizeGear(fontsize);
        BaseVulcanVideoPlayer bindPlayer = this.this$0.getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null && (controlLayerCallback = playerCallbackManager.getControlLayerCallback()) != null) {
            controlLayerCallback.onBarrageSettingFontsizeChange(fontsize, actionType);
        }
    }

    public void onLinesValueChange(int lines, int actionType) {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        IControlLayerCallback controlLayerCallback;
        BarrageSettingSPDataUtils.INSTANCE.saveSysFontSizeSnapshot();
        BarrageSettingSPDataUtils.INSTANCE.setBarrageSettingLines(lines);
        BaseVulcanVideoPlayer bindPlayer = this.this$0.getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null && (controlLayerCallback = playerCallbackManager.getControlLayerCallback()) != null) {
            controlLayerCallback.onBarrageSettingLinesChange(lines, actionType);
        }
    }

    public void onResumeDefaultClick() {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        IControlLayerCallback controlLayerCallback;
        BaseVulcanVideoPlayer bindPlayer = this.this$0.getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null && (controlLayerCallback = playerCallbackManager.getControlLayerCallback()) != null) {
            controlLayerCallback.onResumeDefaultClickAction();
        }
    }

    public void onResumeDefaultShow() {
        BaseVulcanVideoPlayerCallbackManager playerCallbackManager;
        IControlLayerCallback controlLayerCallback;
        BaseVulcanVideoPlayer bindPlayer = this.this$0.getBindPlayer();
        if (bindPlayer != null && (playerCallbackManager = bindPlayer.getPlayerCallbackManager()) != null && (controlLayerCallback = playerCallbackManager.getControlLayerCallback()) != null) {
            controlLayerCallback.onResumeDefaultShowAction();
        }
    }
}
