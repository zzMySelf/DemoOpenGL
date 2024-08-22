package com.baidu.searchbox.video.channel.flow.pageview;

import com.baidu.searchbox.player.callback.SimpleBaseVideoPlayerCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/channel/flow/pageview/ChannelFlowPageView$playerStatusCallback$1", "Lcom/baidu/searchbox/player/callback/SimpleBaseVideoPlayerCallback;", "onVideoSwitchToFull", "", "onVideoSwitchToHalf", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowPageView.kt */
public final class ChannelFlowPageView$playerStatusCallback$1 extends SimpleBaseVideoPlayerCallback {
    final /* synthetic */ ChannelFlowPageView this$0;

    ChannelFlowPageView$playerStatusCallback$1(ChannelFlowPageView $receiver) {
        this.this$0 = $receiver;
    }

    public void onVideoSwitchToHalf() {
        super.onVideoSwitchToHalf();
        OnLandscapeStyleSwitchCallback landscapeSwitchCallback = this.this$0.getLandscapeSwitchCallback();
        if (landscapeSwitchCallback != null) {
            landscapeSwitchCallback.onLandscapeStyleSwitch(false);
        }
    }

    public void onVideoSwitchToFull() {
        super.onVideoSwitchToFull();
        OnLandscapeStyleSwitchCallback landscapeSwitchCallback = this.this$0.getLandscapeSwitchCallback();
        if (landscapeSwitchCallback != null) {
            landscapeSwitchCallback.onLandscapeStyleSwitch(true);
        }
    }
}
