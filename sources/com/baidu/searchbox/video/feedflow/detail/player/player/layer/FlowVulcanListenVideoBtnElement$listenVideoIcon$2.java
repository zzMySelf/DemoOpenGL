package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVulcanListenVideoBtnElement.kt */
final class FlowVulcanListenVideoBtnElement$listenVideoIcon$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ FlowVulcanListenVideoBtnElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowVulcanListenVideoBtnElement$listenVideoIcon$2(FlowVulcanListenVideoBtnElement flowVulcanListenVideoBtnElement) {
        super(0);
        this.this$0 = flowVulcanListenVideoBtnElement;
    }

    public final ImageView invoke() {
        ImageView imageView = new ImageView(this.this$0.getContext());
        ImageView $this$invoke_u24lambda_u2d0 = imageView;
        $this$invoke_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams($this$invoke_u24lambda_u2d0.getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_30dp), $this$invoke_u24lambda_u2d0.getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_30dp)));
        $this$invoke_u24lambda_u2d0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FontSizeHelperKt.setVideoScaledImageDrawableRes$default($this$invoke_u24lambda_u2d0, R.drawable.video_flow_listen_video, 0, 0, 6, (Object) null);
        return imageView;
    }
}
