package com.baidu.searchbox.video.page.autoplay;

import com.baidu.searchbox.video.detail.autoplay.unit.RecyclerViewProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/detail/autoplay/unit/RecyclerViewProvider;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabAutoPlayManager.kt */
final class VideoTabAutoPlayManager$recyclerViewProvider$2 extends Lambda implements Function0<RecyclerViewProvider> {
    final /* synthetic */ VideoTabAutoPlayManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoTabAutoPlayManager$recyclerViewProvider$2(VideoTabAutoPlayManager videoTabAutoPlayManager) {
        super(0);
        this.this$0 = videoTabAutoPlayManager;
    }

    public final RecyclerViewProvider invoke() {
        return new RecyclerViewProvider(this.this$0.recyclerView);
    }
}
