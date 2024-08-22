package com.baidu.searchbox.video.channel.flow.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/channel/flow/flow/ChannelFlowLayoutLazyInflateHelper;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelFlowLayoutManager.kt */
final class ChannelFlowLayoutManager$lazyInflateHelper$2 extends Lambda implements Function0<ChannelFlowLayoutLazyInflateHelper> {
    final /* synthetic */ ChannelFlowLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowLayoutManager$lazyInflateHelper$2(ChannelFlowLayoutManager channelFlowLayoutManager) {
        super(0);
        this.this$0 = channelFlowLayoutManager;
    }

    public final ChannelFlowLayoutLazyInflateHelper invoke() {
        ChannelFlowLayoutManager channelFlowLayoutManager = this.this$0;
        return new ChannelFlowLayoutLazyInflateHelper(channelFlowLayoutManager, channelFlowLayoutManager.getManager());
    }
}
