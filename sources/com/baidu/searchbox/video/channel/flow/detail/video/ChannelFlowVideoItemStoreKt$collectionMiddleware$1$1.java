package com.baidu.searchbox.video.channel.flow.detail.video;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "invoke", "(Lcom/baidu/searchbox/feed/detail/frame/Store;)Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowVideoItemStore.kt */
final class ChannelFlowVideoItemStoreKt$collectionMiddleware$1$1 extends Lambda implements Function1<Store<?>, Long> {
    public static final ChannelFlowVideoItemStoreKt$collectionMiddleware$1$1 INSTANCE = new ChannelFlowVideoItemStoreKt$collectionMiddleware$1$1();

    ChannelFlowVideoItemStoreKt$collectionMiddleware$1$1() {
        super(1);
    }

    public final Long invoke(Store<?> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        return Long.valueOf(FlowSwitchStateKt.flowSwitchState(store).getGetComponentLazyLoadingDeadline());
    }
}
