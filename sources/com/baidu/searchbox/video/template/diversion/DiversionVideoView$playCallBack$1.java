package com.baidu.searchbox.video.template.diversion;

import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.event.VideoModeChangeEvent;
import com.baidu.searchbox.player.callback.SimpleBaseVideoPlayerCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/template/diversion/DiversionVideoView$playCallBack$1", "Lcom/baidu/searchbox/player/callback/SimpleBaseVideoPlayerCallback;", "onVideoSwitchToFull", "", "onVideoSwitchToHalf", "lib-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DiversionVideoView.kt */
public final class DiversionVideoView$playCallBack$1 extends SimpleBaseVideoPlayerCallback {
    final /* synthetic */ DiversionVideoView this$0;

    DiversionVideoView$playCallBack$1(DiversionVideoView $receiver) {
        this.this$0 = $receiver;
    }

    public void onVideoSwitchToHalf() {
        this.this$0.currentMode = "HALF_MODE";
    }

    public void onVideoSwitchToFull() {
        this.this$0.currentMode = "FULL_MODE";
        VideoModeChangeEvent event = new VideoModeChangeEvent();
        event.mode = "FULL_MODE";
        BdEventBus.Companion.getDefault().post(event);
    }
}
