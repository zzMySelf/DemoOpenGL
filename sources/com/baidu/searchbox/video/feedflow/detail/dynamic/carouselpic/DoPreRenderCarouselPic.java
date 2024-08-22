package com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/carouselpic/DoPreRenderCarouselPic;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "dataList", "", "Lcom/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicModel;", "(Ljava/util/List;)V", "getDataList", "()Ljava/util/List;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: CarouselPicActionManifest.kt */
public final class DoPreRenderCarouselPic implements Action {
    private final List<CarouselPicModel> dataList;

    public DoPreRenderCarouselPic(List<CarouselPicModel> dataList2) {
        Intrinsics.checkNotNullParameter(dataList2, "dataList");
        this.dataList = dataList2;
    }

    public final List<CarouselPicModel> getDataList() {
        return this.dataList;
    }
}
