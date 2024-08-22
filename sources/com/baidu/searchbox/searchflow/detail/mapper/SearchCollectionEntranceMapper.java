package com.baidu.searchbox.searchflow.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.searchflow.detail.api.CollectionEntranceBean;
import com.baidu.searchbox.searchflow.detail.repos.CollectionEntranceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/searchflow/detail/mapper/SearchCollectionEntranceMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/searchflow/detail/api/CollectionEntranceBean;", "Lcom/baidu/searchbox/searchflow/detail/repos/CollectionEntranceModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchDetailNotablyMapper.kt */
public final class SearchCollectionEntranceMapper implements Mapper<CollectionEntranceBean, CollectionEntranceModel> {
    public static final SearchCollectionEntranceMapper INSTANCE = new SearchCollectionEntranceMapper();

    private SearchCollectionEntranceMapper() {
    }

    public CollectionEntranceModel map(CollectionEntranceBean input) {
        if (input == null) {
            return null;
        }
        CollectionEntranceBean bean = input;
        String title = bean.getTitle();
        String subTitle = bean.getSubTitle();
        String hejiId = bean.getHejiId();
        boolean areEqual = Intrinsics.areEqual((Object) "1", (Object) bean.getHasNext());
        boolean areEqual2 = Intrinsics.areEqual((Object) "1", (Object) bean.getHasPre());
        int collectionCount = bean.getCollectionCount();
        int rn = bean.getRn();
        int pn = bean.getPn();
        boolean z = 1 == bean.getHasTab();
        String hejiPoster = bean.getHejiPoster();
        int anchorIndex = bean.getAnchorIndex();
        return new CollectionEntranceModel(title, subTitle, hejiId, areEqual, areEqual2, collectionCount, rn, pn, z, bean.getItems(), hejiPoster, (String) null, anchorIndex, CollectionEntrancePoliciesMapper.INSTANCE.map(bean.getPolicies()), bean.isAuthorColl(), 2048, (DefaultConstructorMarker) null);
    }
}
