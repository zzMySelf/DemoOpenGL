package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.searchbox.player.ubc.BaseVideoStatisticsDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/utils/SearchH5VideoStatisticsDispatcher;", "Lcom/baidu/searchbox/player/ubc/BaseVideoStatisticsDispatcher;", "videoUniqueKey", "", "(Ljava/lang/String;)V", "onMenuClick", "", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5VideoStatisticsDispatcher.kt */
public final class SearchH5VideoStatisticsDispatcher extends BaseVideoStatisticsDispatcher {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchH5VideoStatisticsDispatcher(String videoUniqueKey) {
        super(videoUniqueKey);
        Intrinsics.checkNotNullParameter(videoUniqueKey, "videoUniqueKey");
    }

    public final void onMenuClick() {
        SearchH5VideoUbcUtils.onMenuClick();
    }
}
