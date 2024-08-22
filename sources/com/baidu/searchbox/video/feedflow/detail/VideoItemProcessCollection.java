package com.baidu.searchbox.video.feedflow.detail;

import com.baidu.searchbox.video.feedflow.provider.ItemUnitProvider;
import com.baidu.searchbox.video.service.BusinessProcessCollection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/VideoItemProcessCollection;", "Lcom/baidu/searchbox/video/service/BusinessProcessCollection;", "provider", "Lcom/baidu/searchbox/video/feedflow/provider/ItemUnitProvider;", "(Lcom/baidu/searchbox/video/feedflow/provider/ItemUnitProvider;)V", "collectReducer", "", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "collectionMiddleware", "Lcom/baidu/searchbox/feed/detail/frame/Middleware;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoItemStore.kt */
public final class VideoItemProcessCollection implements BusinessProcessCollection {
    private final ItemUnitProvider provider;

    public VideoItemProcessCollection(ItemUnitProvider provider2) {
        Intrinsics.checkNotNullParameter(provider2, "provider");
        this.provider = provider2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r3 == null) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.baidu.searchbox.feed.detail.frame.Middleware<com.baidu.searchbox.feed.detail.arch.ext.CommonState>> collectionMiddleware() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            com.baidu.searchbox.feed.detail.util.AbInjection$Impl r3 = com.baidu.searchbox.feed.detail.util.AbInjection.Impl.INSTANCE
            com.baidu.searchbox.feed.detail.util.AbInjection r3 = r3.get()
            boolean r3 = r3.middlewarePreCreateEnable()
            if (r3 == 0) goto L_0x0021
            com.baidu.searchbox.video.feedflow.provider.ItemUnitProvider r3 = r6.provider
            boolean r3 = r3 instanceof com.baidu.searchbox.video.feedflow.assemble.provider.FeedVideoItemUnitProvider
            if (r3 == 0) goto L_0x0021
            com.baidu.searchbox.video.feedflow.common.PreCreatorManager r3 = com.baidu.searchbox.video.feedflow.common.PreCreatorManager.INSTANCE
            com.baidu.searchbox.video.feedflow.common.ItemMiddlewarePreCreator r3 = r3.getFeedItemMiddlewarePreCreator()
            java.util.List r2 = r3.getElements()
        L_0x0021:
            if (r2 == 0) goto L_0x0035
            r3 = r2
            r4 = 0
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0032
            r3 = r2
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            if (r3 != 0) goto L_0x003b
        L_0x0035:
            com.baidu.searchbox.video.feedflow.provider.ItemUnitProvider r3 = r6.provider
            java.util.List r3 = com.baidu.searchbox.video.feedflow.detail.VideoItemStoreKt.collectionItemMiddleware(r3)
        L_0x003b:
            r4 = r3
            r5 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.VideoItemProcessCollection.collectionMiddleware():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r3 == null) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.baidu.searchbox.feed.detail.frame.Reducer<com.baidu.searchbox.feed.detail.arch.ext.CommonState>> collectReducer() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            com.baidu.searchbox.feed.detail.util.AbInjection$Impl r3 = com.baidu.searchbox.feed.detail.util.AbInjection.Impl.INSTANCE
            com.baidu.searchbox.feed.detail.util.AbInjection r3 = r3.get()
            boolean r3 = r3.reducerPreCreateEnable()
            if (r3 == 0) goto L_0x0021
            com.baidu.searchbox.video.feedflow.provider.ItemUnitProvider r3 = r6.provider
            boolean r3 = r3 instanceof com.baidu.searchbox.video.feedflow.assemble.provider.FeedVideoItemUnitProvider
            if (r3 == 0) goto L_0x0021
            com.baidu.searchbox.video.feedflow.common.PreCreatorManager r3 = com.baidu.searchbox.video.feedflow.common.PreCreatorManager.INSTANCE
            com.baidu.searchbox.video.feedflow.common.ItemReducerPreCreator r3 = r3.getFeedItemReducerPreCreator()
            java.util.List r2 = r3.getElements()
        L_0x0021:
            if (r2 == 0) goto L_0x0035
            r3 = r2
            r4 = 0
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ 1
            if (r5 == 0) goto L_0x0032
            r3 = r2
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            if (r3 != 0) goto L_0x003b
        L_0x0035:
            com.baidu.searchbox.video.feedflow.provider.ItemUnitProvider r3 = r6.provider
            java.util.List r3 = com.baidu.searchbox.video.feedflow.detail.VideoItemStoreKt.collectItemReducer(r3)
        L_0x003b:
            r4 = r3
            r5 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.VideoItemProcessCollection.collectReducer():java.util.List");
    }
}
