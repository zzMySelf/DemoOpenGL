package com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar;

import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/carouselprogressbar/UpdateCarouselProgressBarStyle;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "isEnable", "", "isSingleStyle", "(ZZ)V", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselProgressBarActionManifest.kt */
public final class UpdateCarouselProgressBarStyle implements Action {
    private final boolean isEnable;
    private final boolean isSingleStyle;

    public UpdateCarouselProgressBarStyle(boolean isEnable2, boolean isSingleStyle2) {
        this.isEnable = isEnable2;
        this.isSingleStyle = isSingleStyle2;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean isSingleStyle() {
        return this.isSingleStyle;
    }
}
