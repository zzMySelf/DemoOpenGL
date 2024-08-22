package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.video.feedflow.detail.player.state.PlayerState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"KEY_FLOW_PLAYER_INTELLIGENT_FILL_SCREEN_TIP", "", "isCommonSupportIntelligentScale", "", "fillScreenUpdateConfig", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/IntelFullScreenConfig;", "isLandscape", "playerState", "Lcom/baidu/searchbox/video/feedflow/detail/player/state/PlayerState;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoKernelGesturePlugin.kt */
public final class FlowVideoKernelGesturePluginKt {
    public static final String KEY_FLOW_PLAYER_INTELLIGENT_FILL_SCREEN_TIP = "key_flow_player_intelligent_fill_screen_tip";

    public static final boolean isCommonSupportIntelligentScale(IntelFullScreenConfig fillScreenUpdateConfig, boolean isLandscape, PlayerState playerState) {
        MutableLiveData<int[]> videoSize;
        int[] videoSize2;
        MutableLiveData<int[]> videoSize3;
        int[] videoSize4;
        if (fillScreenUpdateConfig != null && fillScreenUpdateConfig.getSwitch()) {
            if (playerState == null || (videoSize3 = playerState.getVideoSize()) == null || (videoSize4 = videoSize3.getValue()) == null || videoSize4.length != 2) {
                return false;
            }
            int width = videoSize4[0];
            int height = videoSize4[1];
            if (width == 0 || height == 0) {
                return false;
            }
            if (fillScreenUpdateConfig.getTargetRule(isLandscape, height >= width, ((float) width) / ((float) height)) != null) {
                return true;
            }
            return false;
        } else if (isLandscape) {
            return true;
        } else {
            return (playerState == null || (videoSize = playerState.getVideoSize()) == null || (videoSize2 = videoSize.getValue()) == null || videoSize2.length != 2 || videoSize2[0] >= videoSize2[1]) ? false : true;
        }
    }
}
