package com.baidu.searchbox.video.feedflow.detail.graphicgenre.pic;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.video.feedflow.flow.list.DynamicCarouselModel;
import com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/pic/GraphicPicItemModelMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/video/feedflow/flow/list/DynamicCarouselModel;", "", "Lcom/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicModel;", "()V", "map", "input", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicPicItemModelMapper.kt */
public final class GraphicPicItemModelMapper implements Mapper<DynamicCarouselModel, List<CarouselPicModel>> {
    public static final GraphicPicItemModelMapper INSTANCE = new GraphicPicItemModelMapper();

    private GraphicPicItemModelMapper() {
    }

    public List<CarouselPicModel> map(DynamicCarouselModel input) {
        List dataList = new ArrayList();
        if (input != null) {
            DynamicCarouselModel $this$map_u24lambda_u2d0 = input;
            String firstImageUrl = $this$map_u24lambda_u2d0.getFirstImageUrl();
            float whRatio = $this$map_u24lambda_u2d0.getWhRatio();
            String firstImageType = $this$map_u24lambda_u2d0.getFirstImageType();
            DynamicCarouselModel dynamicCarouselModel = $this$map_u24lambda_u2d0;
            CarouselPicModel carouselPicModel = r3;
            CarouselPicModel carouselPicModel2 = new CarouselPicModel(0, firstImageUrl, (String) null, whRatio, 0, 0, firstImageType, (String) null, false, false, 948, (DefaultConstructorMarker) null);
            dataList.add(carouselPicModel);
        }
        return dataList;
    }
}
