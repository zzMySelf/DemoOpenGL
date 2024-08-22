package com.baidu.searchbox.video.channel.flow.detail.live.player;

import com.baidu.searchbox.player.config.PlayerConfig;
import com.baidu.searchbox.video.feedflow.detail.liveplayer.LiveFlowPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/detail/live/player/ChannelLivePlayer;", "Lcom/baidu/searchbox/video/feedflow/detail/liveplayer/LiveFlowPlayer;", "key", "", "config", "Lcom/baidu/searchbox/player/config/PlayerConfig;", "(Ljava/lang/String;Lcom/baidu/searchbox/player/config/PlayerConfig;)V", "isAllowParentRequestAudioFocus", "", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelLivePlayer.kt */
public final class ChannelLivePlayer extends LiveFlowPlayer {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelLivePlayer(String key, PlayerConfig config) {
        super(key, config);
        Intrinsics.checkNotNullParameter(key, "key");
    }

    /* access modifiers changed from: protected */
    public boolean isAllowParentRequestAudioFocus() {
        return false;
    }
}
