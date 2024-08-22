package com.baidu.searchbox.video.feedflow.detail.collectionpayment;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.repos.BottomEntryButtonModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailBottomEntryModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayButtonMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayButtonModel;", "()V", "map", "input", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionColumnPayButtonMapper.kt */
public final class CollectionColumnPayButtonMapper implements Mapper<FlowDetailModel, CollectionColumnPayButtonModel> {
    public static final CollectionColumnPayButtonMapper INSTANCE = new CollectionColumnPayButtonMapper();

    private CollectionColumnPayButtonMapper() {
    }

    public CollectionColumnPayButtonModel map(FlowDetailModel input) {
        BottomEntryButtonModel model;
        Intrinsics.checkNotNullParameter(input, "input");
        FlowDetailBottomEntryModel bottomEntry = input.getBottomEntry();
        if (bottomEntry == null || (model = bottomEntry.getLandBtnInfo()) == null) {
            return null;
        }
        String landBtnText = model.getLandBtnText();
        Integer intOrNull = StringsKt.toIntOrNull(model.getFirstTime());
        int i2 = 0;
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        Integer intOrNull2 = StringsKt.toIntOrNull(model.getSecondTime());
        if (intOrNull2 != null) {
            i2 = intOrNull2.intValue();
        }
        return new CollectionColumnPayButtonModel(landBtnText, intValue, i2, model.getLandBtnShowEnable());
    }
}
