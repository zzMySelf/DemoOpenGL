package com.baidu.searchbox.video.detail.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"guideShowEnable", "", "isGuideShowEnable", "setGuideShowEnable", "", "enable", "lib-detail-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoDetailGuideManager.kt */
public final class VideoDetailGuideManager {
    private static boolean guideShowEnable = true;

    public static final void setGuideShowEnable(boolean enable) {
        guideShowEnable = enable;
    }

    public static final boolean isGuideShowEnable() {
        return guideShowEnable;
    }
}
