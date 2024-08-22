package com.baidu.searchbox.video.feedflow.ad.tailframe;

import android.view.View;
import com.baidu.searchbox.video.feedflow.ad.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoAdTailFrameView.kt */
final class FlowVideoAdTailFrameView$ratingBarRoot$2 extends Lambda implements Function0<View> {
    final /* synthetic */ FlowVideoAdTailFrameView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowVideoAdTailFrameView$ratingBarRoot$2(FlowVideoAdTailFrameView flowVideoAdTailFrameView) {
        super(0);
        this.this$0 = flowVideoAdTailFrameView;
    }

    public final View invoke() {
        return this.this$0.findViewById(R.id.ad_mini_video_detail_rating_bar_root_view);
    }
}
