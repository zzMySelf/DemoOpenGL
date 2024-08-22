package com.baidu.searchbox.video.collectiondetail.top;

import com.baidu.searchbox.collectiondetail.repos.CollectionDetailAuthorModel;
import com.baidu.searchbox.collectiondetail.repos.CollectionDetailModel;
import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/collectiondetail/top/CollectionDetailHeaderInfoMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/collectiondetail/repos/CollectionDetailModel;", "Lcom/baidu/searchbox/video/collectiondetail/top/CollectionDetailHeaderInfoModel;", "()V", "map", "input", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionDetailHeaderInfoModel.kt */
public final class CollectionDetailHeaderInfoMapper implements Mapper<CollectionDetailModel, CollectionDetailHeaderInfoModel> {
    public static final CollectionDetailHeaderInfoMapper INSTANCE = new CollectionDetailHeaderInfoMapper();

    private CollectionDetailHeaderInfoMapper() {
    }

    public CollectionDetailHeaderInfoModel map(CollectionDetailModel input) {
        AuthorModel authorModel;
        Intrinsics.checkNotNullParameter(input, "input");
        String resourceIcon = input.getResourceIcon();
        String str = input.getResourceName() + " · " + input.getResourceTitle();
        List<String> resourceTypes = input.getResourceTypes();
        String updateDescription = input.getUpdateDescription();
        String description = input.getDescription();
        CollectionDetailAuthorModel model = input.getAuthor();
        if (model != null) {
            authorModel = CollectionDetailHeaderAuthorMapper.INSTANCE.map(model);
        } else {
            authorModel = null;
        }
        return new CollectionDetailHeaderInfoModel((String) null, resourceIcon, str, resourceTypes, updateDescription, description, authorModel, input.getTotalPlayCnt(), input.getFavourite(), input.getShare(), 1, (DefaultConstructorMarker) null);
    }
}
