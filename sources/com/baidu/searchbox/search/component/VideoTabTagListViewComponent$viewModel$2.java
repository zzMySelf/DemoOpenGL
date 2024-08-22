package com.baidu.searchbox.search.component;

import com.baidu.searchbox.search.viewmodel.VideoTabTagViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/search/viewmodel/VideoTabTagViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabTagListViewComponent.kt */
final class VideoTabTagListViewComponent$viewModel$2 extends Lambda implements Function0<VideoTabTagViewModel> {
    final /* synthetic */ VideoTabTagListViewComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTabTagListViewComponent$viewModel$2(VideoTabTagListViewComponent videoTabTagListViewComponent) {
        super(0);
        this.this$0 = videoTabTagListViewComponent;
    }

    public final VideoTabTagViewModel invoke() {
        return new VideoTabTagViewModel(this.this$0.getManager());
    }
}
