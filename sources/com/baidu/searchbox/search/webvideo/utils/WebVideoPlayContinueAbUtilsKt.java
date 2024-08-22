package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.searchbox.abtest.AbTestManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"isHitWebVideoPlayContinueTest", "", "lib_search_video_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebVideoPlayContinueAbUtils.kt */
public final class WebVideoPlayContinueAbUtilsKt {
    public static final boolean isHitWebVideoPlayContinueTest() {
        return AbTestManager.getInstance().getSwitch("web_video_play_continue", false);
    }
}
