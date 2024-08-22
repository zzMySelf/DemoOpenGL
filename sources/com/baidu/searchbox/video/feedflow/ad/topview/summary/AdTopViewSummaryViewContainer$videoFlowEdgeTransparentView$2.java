package com.baidu.searchbox.video.feedflow.ad.topview.summary;

import com.baidu.searchbox.video.feedflow.ad.R;
import com.baidu.searchbox.video.feedflow.view.EdgeTransparentView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/view/EdgeTransparentView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdTopViewSummaryViewContainer.kt */
final class AdTopViewSummaryViewContainer$videoFlowEdgeTransparentView$2 extends Lambda implements Function0<EdgeTransparentView> {
    final /* synthetic */ AdTopViewSummaryViewContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdTopViewSummaryViewContainer$videoFlowEdgeTransparentView$2(AdTopViewSummaryViewContainer adTopViewSummaryViewContainer) {
        super(0);
        this.this$0 = adTopViewSummaryViewContainer;
    }

    public final EdgeTransparentView invoke() {
        return (EdgeTransparentView) this.this$0.findViewById(R.id.video_flow_edge_transparent_view);
    }
}
