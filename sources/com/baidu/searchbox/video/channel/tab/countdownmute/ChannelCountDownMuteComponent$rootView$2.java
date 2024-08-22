package com.baidu.searchbox.video.channel.tab.countdownmute;

import android.widget.TextView;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelCountDownMuteComponent.kt */
final class ChannelCountDownMuteComponent$rootView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ ChannelCountDownMuteComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelCountDownMuteComponent$rootView$2(ChannelCountDownMuteComponent channelCountDownMuteComponent) {
        super(0);
        this.this$0 = channelCountDownMuteComponent;
    }

    public final TextView invoke() {
        TextView textView = new TextView(this.this$0.getContext());
        ChannelCountDownMuteComponent channelCountDownMuteComponent = this.this$0;
        TextView $this$invoke_u24lambda_u2d0 = textView;
        int padding = $this$invoke_u24lambda_u2d0.getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_8_5dp);
        $this$invoke_u24lambda_u2d0.setPadding(padding, padding, padding, padding);
        $this$invoke_u24lambda_u2d0.setIncludeFontPadding(false);
        $this$invoke_u24lambda_u2d0.setText(channelCountDownMuteComponent.getCountDownText(3));
        $this$invoke_u24lambda_u2d0.setTextColor(ResourceUtils.getColor($this$invoke_u24lambda_u2d0.getContext(), R.color.video_flow_color_white));
        $this$invoke_u24lambda_u2d0.setTextSize(1, 12.0f);
        $this$invoke_u24lambda_u2d0.setGravity(17);
        $this$invoke_u24lambda_u2d0.setBackground(ResourceUtils.getDrawable($this$invoke_u24lambda_u2d0.getContext(), R.drawable.video_flow_global_mute_guide_bg));
        $this$invoke_u24lambda_u2d0.setVisibility(8);
        return textView;
    }
}
