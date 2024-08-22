package com.baidu.searchbox.video.channel.tab;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.feedflow.channel.ChannelPageExtParamStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/channel/tab/ChannelTabCustomTaskScheduleManager;", "", "()V", "getScheduleMiddleware", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "business", "Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTabCustomTaskScheduleMiddleware.kt */
public final class ChannelTabCustomTaskScheduleManager {
    public static final ChannelTabCustomTaskScheduleManager INSTANCE = new ChannelTabCustomTaskScheduleManager();

    private ChannelTabCustomTaskScheduleManager() {
    }

    public final Middleware<CommonState> getScheduleMiddleware(VideoBusiness business) {
        if (Intrinsics.areEqual((Object) business != null ? business.scene() : null, (Object) ChannelPageExtParamStateKt.VALUE_CHANNEL_PAGE_EXT_PARAMS_PRE_CREATE_TOP_VIEW)) {
            return new ChannelTopViewCustomTaskScheduleMiddleware();
        }
        return null;
    }
}
