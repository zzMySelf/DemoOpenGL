package com.baidu.searchbox.video.detail;

import com.baidu.searchbox.feed.detail.frame.AbsStore;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/detail/VideoStore;", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/video/detail/VideoState;", "state", "(Lcom/baidu/searchbox/video/detail/VideoState;)V", "lib-detail-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoDetailRedux.kt */
public final class VideoStore extends AbsStore<VideoState> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoStore(VideoState state) {
        super(state, CollectionsKt.mutableListOf(new CommonReducer()), new ArrayList());
        Intrinsics.checkNotNullParameter(state, "state");
    }
}
