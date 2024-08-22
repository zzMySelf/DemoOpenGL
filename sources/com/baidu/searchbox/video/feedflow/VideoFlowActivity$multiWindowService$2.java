package com.baidu.searchbox.video.feedflow;

import com.baidu.searchbox.video.feedflow.common.serviceimpl.MultiWindowImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/common/serviceimpl/MultiWindowImpl;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowActivity.kt */
final class VideoFlowActivity$multiWindowService$2 extends Lambda implements Function0<MultiWindowImpl> {
    final /* synthetic */ VideoFlowActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoFlowActivity$multiWindowService$2(VideoFlowActivity videoFlowActivity) {
        super(0);
        this.this$0 = videoFlowActivity;
    }

    public final MultiWindowImpl invoke() {
        return new MultiWindowImpl(this.this$0.getStore(), this.this$0);
    }
}
