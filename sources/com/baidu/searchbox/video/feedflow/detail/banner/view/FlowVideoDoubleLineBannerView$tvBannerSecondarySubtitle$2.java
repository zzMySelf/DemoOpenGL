package com.baidu.searchbox.video.feedflow.detail.banner.view;

import android.widget.TextView;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoDoubleLineBannerView.kt */
final class FlowVideoDoubleLineBannerView$tvBannerSecondarySubtitle$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ FlowVideoDoubleLineBannerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowVideoDoubleLineBannerView$tvBannerSecondarySubtitle$2(FlowVideoDoubleLineBannerView flowVideoDoubleLineBannerView) {
        super(0);
        this.this$0 = flowVideoDoubleLineBannerView;
    }

    public final TextView invoke() {
        return (TextView) this.this$0.findViewById(R.id.tv_video_flow_banner_secondary_subtitle);
    }
}
