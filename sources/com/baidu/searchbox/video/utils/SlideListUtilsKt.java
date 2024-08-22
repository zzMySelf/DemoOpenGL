package com.baidu.searchbox.video.utils;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.detail.VideoState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¨\u0006\u0005"}, d2 = {"isPageSelected", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/video/detail/VideoState;", "lib-detail-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SlideListUtils.kt */
public final class SlideListUtilsKt {
    public static final boolean isPageSelected(Store<VideoState> store) {
        if (store == null) {
            return true;
        }
        return store.getState().isSelected();
    }
}
