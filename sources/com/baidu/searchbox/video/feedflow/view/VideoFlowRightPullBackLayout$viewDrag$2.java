package com.baidu.searchbox.video.feedflow.view;

import androidx.customview.widget.ViewDragHelper;
import com.baidu.searchbox.video.feedflow.view.VideoFlowRightPullBackLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/customview/widget/ViewDragHelper;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowRightPullBackLayout.kt */
final class VideoFlowRightPullBackLayout$viewDrag$2 extends Lambda implements Function0<ViewDragHelper> {
    final /* synthetic */ VideoFlowRightPullBackLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoFlowRightPullBackLayout$viewDrag$2(VideoFlowRightPullBackLayout videoFlowRightPullBackLayout) {
        super(0);
        this.this$0 = videoFlowRightPullBackLayout;
    }

    public final ViewDragHelper invoke() {
        return ViewDragHelper.create(this.this$0, 1.0f, new VideoFlowRightPullBackLayout.ViewDragCallback());
    }
}
