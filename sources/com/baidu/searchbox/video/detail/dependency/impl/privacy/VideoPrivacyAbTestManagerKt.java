package com.baidu.searchbox.video.detail.dependency.impl.privacy;

import com.baidu.searchbox.abtest.AbTestManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0005\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"VIDEO_PRIVACY_SWITCH_KEY", "", "hasGetSwitcher", "", "switcher", "isVideoPrivacySwitchOpen", "video-dependency-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPrivacyAbTestManager.kt */
public final class VideoPrivacyAbTestManagerKt {
    public static final String VIDEO_PRIVACY_SWITCH_KEY = "android_video_privacy_switch";
    private static boolean hasGetSwitcher;
    private static boolean switcher = true;

    public static final boolean isVideoPrivacySwitchOpen() {
        if (!hasGetSwitcher) {
            switcher = AbTestManager.getInstance().getSwitch(VIDEO_PRIVACY_SWITCH_KEY, true);
            hasGetSwitcher = true;
        }
        return switcher;
    }
}
