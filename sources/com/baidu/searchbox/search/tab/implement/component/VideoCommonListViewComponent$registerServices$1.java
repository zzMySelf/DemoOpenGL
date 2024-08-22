package com.baidu.searchbox.search.tab.implement.component;

import com.baidu.searchbox.search.tab.core.service.StaticServiceFetcher;
import com.baidu.searchbox.search.tab.implement.service.VideoListViewService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/search/tab/implement/component/VideoCommonListViewComponent$registerServices$1", "Lcom/baidu/searchbox/search/tab/core/service/StaticServiceFetcher;", "Lcom/baidu/searchbox/search/tab/implement/service/VideoListViewService;", "createService", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonListViewComponent.kt */
public final class VideoCommonListViewComponent$registerServices$1 extends StaticServiceFetcher<VideoListViewService> {
    final /* synthetic */ VideoCommonListViewComponent this$0;

    VideoCommonListViewComponent$registerServices$1(VideoCommonListViewComponent $receiver) {
        this.this$0 = $receiver;
    }

    public VideoListViewService createService() {
        return new VideoListViewService(this.this$0.getListPage());
    }
}
