package com.baidu.searchbox.video.feedflow.flow.collection.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionPoliciesModel;
import com.baidu.searchbox.video.feedflow.flow.list.InterestTagModel;
import com.baidu.searchbox.video.feedflow.flow.list.PoliciesModel;
import com.baidu.searchbox.video.feedflow.flow.list.ShowLessGuideModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/mapper/CollectionFlowPolicesMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionPoliciesModel;", "Lcom/baidu/searchbox/video/feedflow/flow/list/PoliciesModel;", "()V", "map", "input", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowPolicesMapper.kt */
public final class CollectionFlowPolicesMapper implements Mapper<CollectionPoliciesModel, PoliciesModel> {
    public static final CollectionFlowPolicesMapper INSTANCE = new CollectionFlowPolicesMapper();

    private CollectionFlowPolicesMapper() {
    }

    public PoliciesModel map(CollectionPoliciesModel input) {
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(input, "input");
        int i5 = 0;
        if (!StringsKt.isBlank(input.getPreloadPosition())) {
            try {
                i4 = Integer.parseInt(input.getPreloadPosition());
            } catch (Exception e2) {
                i4 = 0;
            }
            i2 = i4;
        } else {
            i2 = 0;
        }
        if (!StringsKt.isBlank(input.getPreviousPreloadPosition())) {
            try {
                i5 = Integer.parseInt(input.getPreviousPreloadPosition());
            } catch (Exception e3) {
            }
            i3 = i5;
        } else {
            i3 = 0;
        }
        return new PoliciesModel(i2, i3, false, 0, 0, (InterestTagModel) null, 0, 0, (ShowLessGuideModel) null, 508, (DefaultConstructorMarker) null);
    }
}
