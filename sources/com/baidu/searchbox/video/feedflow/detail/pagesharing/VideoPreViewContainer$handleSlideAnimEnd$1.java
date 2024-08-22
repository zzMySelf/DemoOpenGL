package com.baidu.searchbox.video.feedflow.detail.pagesharing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "itemModel", "Lcom/baidu/searchbox/video/feedflow/detail/pagesharing/FeedItemClickModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPreViewContainer.kt */
final class VideoPreViewContainer$handleSlideAnimEnd$1 extends Lambda implements Function1<FeedItemClickModel, Unit> {
    final /* synthetic */ VideoPreViewContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoPreViewContainer$handleSlideAnimEnd$1(VideoPreViewContainer videoPreViewContainer) {
        super(1);
        this.this$0 = videoPreViewContainer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((FeedItemClickModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(FeedItemClickModel itemModel) {
        this.this$0.isAnimEnd = true;
        this.this$0.tryDispatchAnimEndListener(itemModel);
    }
}
