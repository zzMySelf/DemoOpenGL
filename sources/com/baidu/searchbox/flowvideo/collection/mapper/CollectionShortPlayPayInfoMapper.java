package com.baidu.searchbox.flowvideo.collection.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.collection.api.CollectionShortPlayPayInfoBean;
import com.baidu.searchbox.flowvideo.collection.repos.CollectionShortPlayPayInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/collection/mapper/CollectionShortPlayPayInfoMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/collection/api/CollectionShortPlayPayInfoBean;", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionShortPlayPayInfoModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionShortPlayPayInfoMapper.kt */
public final class CollectionShortPlayPayInfoMapper implements Mapper<CollectionShortPlayPayInfoBean, CollectionShortPlayPayInfoModel> {
    public static final CollectionShortPlayPayInfoMapper INSTANCE = new CollectionShortPlayPayInfoMapper();

    private CollectionShortPlayPayInfoMapper() {
    }

    public CollectionShortPlayPayInfoModel map(CollectionShortPlayPayInfoBean input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new CollectionShortPlayPayInfoModel(input.getCollId(), input.getText(), input.getExt());
    }
}
