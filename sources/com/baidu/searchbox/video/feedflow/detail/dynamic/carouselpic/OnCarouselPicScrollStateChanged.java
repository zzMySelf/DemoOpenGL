package com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/carouselpic/OnCarouselPicScrollStateChanged;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "state", "", "model", "Lcom/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicModel;", "lastModel", "dragIdle", "", "(ILcom/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicModel;Lcom/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicModel;Z)V", "getDragIdle", "()Z", "getLastModel", "()Lcom/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicModel;", "getModel", "getState", "()I", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: CarouselPicActionManifest.kt */
public final class OnCarouselPicScrollStateChanged implements Action {
    private final boolean dragIdle;
    private final CarouselPicModel lastModel;
    private final CarouselPicModel model;
    private final int state;

    public OnCarouselPicScrollStateChanged(int state2, CarouselPicModel model2, CarouselPicModel lastModel2, boolean dragIdle2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        Intrinsics.checkNotNullParameter(lastModel2, "lastModel");
        this.state = state2;
        this.model = model2;
        this.lastModel = lastModel2;
        this.dragIdle = dragIdle2;
    }

    public final boolean getDragIdle() {
        return this.dragIdle;
    }

    public final CarouselPicModel getLastModel() {
        return this.lastModel;
    }

    public final CarouselPicModel getModel() {
        return this.model;
    }

    public final int getState() {
        return this.state;
    }
}
