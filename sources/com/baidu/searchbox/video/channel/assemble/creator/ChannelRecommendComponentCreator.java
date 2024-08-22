package com.baidu.searchbox.video.channel.assemble.creator;

import com.baidu.searchbox.video.flow.provider.creator.ChannelRecommendComponentCreatorImpl_Factory;
import com.baidu.searchbox.video.service.ComponentArchCreator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/channel/assemble/creator/ChannelRecommendComponentCreator;", "Lcom/baidu/searchbox/video/service/ComponentArchCreator;", "Impl", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelRecommendComponentCreator.kt */
public interface ChannelRecommendComponentCreator extends ComponentArchCreator {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/channel/assemble/creator/ChannelRecommendComponentCreator$Impl;", "", "()V", "get", "Lcom/baidu/searchbox/video/channel/assemble/creator/ChannelRecommendComponentCreator;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChannelRecommendComponentCreator.kt */
    public static final class Impl {
        public static final Impl INSTANCE = new Impl();

        private Impl() {
        }

        public final ChannelRecommendComponentCreator get() {
            return ChannelRecommendComponentCreatorImpl_Factory.get();
        }
    }
}
