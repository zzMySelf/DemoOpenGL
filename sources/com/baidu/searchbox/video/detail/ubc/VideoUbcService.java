package com.baidu.searchbox.video.detail.ubc;

import com.baidu.searchbox.video.detail.dependency.impl.report.VideoUbcServiceImpl_Factory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u00018CX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/detail/ubc/VideoUbcService;", "Lcom/baidu/searchbox/video/detail/ubc/IVideoUbcService;", "()V", "videoUbc", "getVideoUbc", "()Lcom/baidu/searchbox/video/detail/ubc/IVideoUbcService;", "event1354", "", "data", "Lcom/baidu/searchbox/video/detail/ubc/VideoUbcBean;", "event2736", "event4019", "lib-support_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoUbcService.kt */
public final class VideoUbcService implements IVideoUbcService {
    public static final VideoUbcService INSTANCE = new VideoUbcService();

    private VideoUbcService() {
    }

    private final IVideoUbcService getVideoUbc() {
        return VideoUbcServiceImpl_Factory.get();
    }

    public void event1354(VideoUbcBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getVideoUbc().event1354(data);
    }

    public void event2736(VideoUbcBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getVideoUbc().event2736(data);
    }

    public void event4019(VideoUbcBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getVideoUbc().event4019(data);
    }
}
