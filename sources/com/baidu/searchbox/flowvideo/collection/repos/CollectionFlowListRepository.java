package com.baidu.searchbox.flowvideo.collection.repos;

import com.baidu.searchbox.feed.detail.ext.common.Result;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionFlowListRepository;", "", "getCollectionFlowListData", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionListModel;", "listParam", "Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionFlowListParam;", "(Lcom/baidu/searchbox/flowvideo/collection/repos/CollectionFlowListParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLandscapeHomeMiddlePanelListData", "Lcom/baidu/searchbox/flowvideo/collection/repos/LandscapeMiddlePanelRequestParam;", "(Lcom/baidu/searchbox/flowvideo/collection/repos/LandscapeMiddlePanelRequestParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowListRepository.kt */
public interface CollectionFlowListRepository {
    Object getCollectionFlowListData(CollectionFlowListParam collectionFlowListParam, Continuation<? super Result<CollectionListModel>> continuation);

    Object getLandscapeHomeMiddlePanelListData(LandscapeMiddlePanelRequestParam landscapeMiddlePanelRequestParam, Continuation<? super Result<CollectionListModel>> continuation);
}
