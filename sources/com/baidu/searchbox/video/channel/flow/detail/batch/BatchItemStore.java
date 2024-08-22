package com.baidu.searchbox.video.channel.flow.detail.batch;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/channel/flow/detail/batch/BatchItemStore;", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "state", "(Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;)V", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelBatchItemStore.kt */
public final class BatchItemStore extends AbsStore<CommonState> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BatchItemStore(CommonState state) {
        super(state, ChannelBatchItemStoreKt.collectReducer(), ChannelBatchItemStoreKt.collectionMiddleware());
        Intrinsics.checkNotNullParameter(state, "state");
    }
}
