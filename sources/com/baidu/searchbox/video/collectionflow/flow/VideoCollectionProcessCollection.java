package com.baidu.searchbox.video.collectionflow.flow;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Middleware;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.video.feedflow.provider.CollectionUnitProvider;
import com.baidu.searchbox.video.service.BusinessProcessCollection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/flow/VideoCollectionProcessCollection;", "Lcom/baidu/searchbox/video/service/BusinessProcessCollection;", "provider", "Lcom/baidu/searchbox/video/feedflow/provider/CollectionUnitProvider;", "(Lcom/baidu/searchbox/video/feedflow/provider/CollectionUnitProvider;)V", "collectReducer", "", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "collectionMiddleware", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionFlowStore.kt */
public final class VideoCollectionProcessCollection implements BusinessProcessCollection {
    private final CollectionUnitProvider provider;

    public VideoCollectionProcessCollection(CollectionUnitProvider provider2) {
        Intrinsics.checkNotNullParameter(provider2, "provider");
        this.provider = provider2;
    }

    public List<Middleware<CommonState>> collectionMiddleware() {
        return CollectionFlowStoreKt.collectionMiddleware(this.provider);
    }

    public List<Reducer<CommonState>> collectReducer() {
        return CollectionFlowStoreKt.collectReducer(this.provider);
    }
}
