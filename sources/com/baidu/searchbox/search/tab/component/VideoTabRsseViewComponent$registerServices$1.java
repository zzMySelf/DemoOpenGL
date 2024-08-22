package com.baidu.searchbox.search.tab.component;

import com.baidu.searchbox.search.service.VideoTabRsseViewService;
import com.baidu.searchbox.search.tab.core.service.StaticServiceFetcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/search/tab/component/VideoTabRsseViewComponent$registerServices$1", "Lcom/baidu/searchbox/search/tab/core/service/StaticServiceFetcher;", "Lcom/baidu/searchbox/search/service/VideoTabRsseViewService;", "createService", "lib_search_video_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabRsseViewComponent.kt */
public final class VideoTabRsseViewComponent$registerServices$1 extends StaticServiceFetcher<VideoTabRsseViewService> {
    final /* synthetic */ VideoTabRsseViewComponent this$0;

    VideoTabRsseViewComponent$registerServices$1(VideoTabRsseViewComponent $receiver) {
        this.this$0 = $receiver;
    }

    public VideoTabRsseViewService createService() {
        return new VideoTabRsseViewService(this.this$0.getRsseView());
    }
}
