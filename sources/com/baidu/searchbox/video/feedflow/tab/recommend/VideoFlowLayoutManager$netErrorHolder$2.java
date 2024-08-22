package com.baidu.searchbox.video.feedflow.tab.recommend;

import android.view.ViewGroup;
import com.baidu.searchbox.feed.detail.lazy.ComponentHolder;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.error.NetErrorState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/feed/detail/lazy/ComponentHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowLayoutManager.kt */
final class VideoFlowLayoutManager$netErrorHolder$2 extends Lambda implements Function0<ComponentHolder> {
    final /* synthetic */ VideoFlowLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoFlowLayoutManager$netErrorHolder$2(VideoFlowLayoutManager videoFlowLayoutManager) {
        super(0);
        this.this$0 = videoFlowLayoutManager;
    }

    public final ComponentHolder invoke() {
        VideoFlowLayoutManager this_$iv = this.this$0;
        int viewId$iv = R.id.video_flow_cmp_net_error;
        if (this_$iv.isDegradeInflateOptEnable()) {
            return this_$iv.inflateComponentByLazy("video_flow_net_error", viewId$iv, NetErrorState.class, (ViewGroup.LayoutParams) null);
        }
        this_$iv.inflateComponentView("video_flow_net_error", viewId$iv);
        ComponentHolder componentHolder = null;
        return null;
    }
}
