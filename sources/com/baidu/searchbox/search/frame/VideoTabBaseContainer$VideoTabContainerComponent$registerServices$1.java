package com.baidu.searchbox.search.frame;

import com.baidu.searchbox.search.frame.VideoTabBaseContainer;
import com.baidu.searchbox.search.tab.core.service.StaticServiceFetcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\f\u0010\u0004\u001a\u00060\u0002R\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/search/frame/VideoTabBaseContainer$VideoTabContainerComponent$registerServices$1", "Lcom/baidu/searchbox/search/tab/core/service/StaticServiceFetcher;", "Lcom/baidu/searchbox/search/frame/VideoTabBaseContainer$ContainerService;", "Lcom/baidu/searchbox/search/frame/VideoTabBaseContainer;", "createService", "lib_search_video_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabBaseContainer.kt */
public final class VideoTabBaseContainer$VideoTabContainerComponent$registerServices$1 extends StaticServiceFetcher<VideoTabBaseContainer.ContainerService> {
    final /* synthetic */ VideoTabBaseContainer this$0;

    VideoTabBaseContainer$VideoTabContainerComponent$registerServices$1(VideoTabBaseContainer $receiver) {
        this.this$0 = $receiver;
    }

    public VideoTabBaseContainer.ContainerService createService() {
        return new VideoTabBaseContainer.ContainerService();
    }
}
