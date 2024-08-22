package com.baidu.searchbox.video.channel.tab.theater;

import android.graphics.drawable.GradientDrawable;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/GradientDrawable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTheaterFlowLayoutManager.kt */
final class ChannelTheaterFlowLayoutManager$backgroundDrawable$2 extends Lambda implements Function0<GradientDrawable> {
    final /* synthetic */ ChannelTheaterFlowLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelTheaterFlowLayoutManager$backgroundDrawable$2(ChannelTheaterFlowLayoutManager channelTheaterFlowLayoutManager) {
        super(0);
        this.this$0 = channelTheaterFlowLayoutManager;
    }

    public final GradientDrawable invoke() {
        GradientDrawable $this$invoke_u24lambda_u2d0 = new GradientDrawable();
        $this$invoke_u24lambda_u2d0.setColor(ChannelTheaterFlowLayoutManager.access$getContainer(this.this$0).getResources().getColor(R.color.video_flow_theater_flow_top_entrance_bg));
        return $this$invoke_u24lambda_u2d0;
    }
}
