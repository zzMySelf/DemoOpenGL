package com.baidu.searchbox.video.feedflow.ad.dynamic.carouselprogressbar;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.ad.dynamic.NadDynamicModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/dynamic/carouselprogressbar/UpdateCarouselSubProgressBarData;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "data", "Lcom/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicModel;", "(Lcom/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicModel;)V", "getData", "()Lcom/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicModel;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadCarouselProgressBarActionManifest.kt */
public final class UpdateCarouselSubProgressBarData implements Action {
    private final NadDynamicModel data;

    public UpdateCarouselSubProgressBarData(NadDynamicModel data2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        this.data = data2;
    }

    public final NadDynamicModel getData() {
        return this.data;
    }
}
