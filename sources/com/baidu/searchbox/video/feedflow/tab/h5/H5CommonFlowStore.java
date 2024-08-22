package com.baidu.searchbox.video.feedflow.tab.h5;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/h5/H5CommonFlowStore;", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "state", "(Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;)V", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: H5CommonFlowStore.kt */
public final class H5CommonFlowStore extends AbsStore<CommonState> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public H5CommonFlowStore(CommonState state) {
        super(state, H5CommonFlowStoreKt.collectReducer(), H5CommonFlowStoreKt.collectionMiddleware());
        Intrinsics.checkNotNullParameter(state, "state");
        H5CommonFlowStoreKt.initState(state);
    }
}
