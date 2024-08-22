package com.baidu.searchbox.video.feedflow.abtest;

import com.baidu.searchbox.player.ab.AbConfig;
import com.baidu.searchbox.video.feedflow.common.config.VideoPreViewSwitchConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/abtest/VideoPreViewSwitcherByFeed;", "Lcom/baidu/searchbox/player/ab/AbConfig;", "Lcom/baidu/searchbox/video/feedflow/common/config/VideoPreViewSwitchConfig;", "()V", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPreViewSwitcher.kt */
public final class VideoPreViewSwitcherByFeed extends AbConfig<VideoPreViewSwitchConfig> {
    public static final VideoPreViewSwitcherByFeed INSTANCE = new VideoPreViewSwitcherByFeed();

    private VideoPreViewSwitcherByFeed() {
        super("feedvideo_video_pre_view_config_android", AnonymousClass1.INSTANCE, "", "video_pre_view_config.json");
    }
}
