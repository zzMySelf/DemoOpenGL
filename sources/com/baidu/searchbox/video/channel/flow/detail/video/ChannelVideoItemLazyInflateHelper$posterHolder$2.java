package com.baidu.searchbox.video.channel.flow.detail.video;

import com.baidu.searchbox.video.feedflow.common.downgrade.LazyInflateWrap;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.poster.PosterState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/common/downgrade/LazyInflateWrap;", "Lcom/baidu/searchbox/video/feedflow/detail/poster/PosterState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelVideoItemLazyInflateHelper.kt */
final class ChannelVideoItemLazyInflateHelper$posterHolder$2 extends Lambda implements Function0<LazyInflateWrap<PosterState>> {
    final /* synthetic */ ChannelVideoItemLazyInflateHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelVideoItemLazyInflateHelper$posterHolder$2(ChannelVideoItemLazyInflateHelper channelVideoItemLazyInflateHelper) {
        super(0);
        this.this$0 = channelVideoItemLazyInflateHelper;
    }

    public final LazyInflateWrap<PosterState> invoke() {
        return new LazyInflateWrap<>(this.this$0.inflateHelper, PosterState.class, "video_flow_cmp_poster", R.id.video_flow_cmp_poster);
    }
}
