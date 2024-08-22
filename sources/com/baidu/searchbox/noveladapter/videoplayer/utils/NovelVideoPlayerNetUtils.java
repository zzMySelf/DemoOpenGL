package com.baidu.searchbox.noveladapter.videoplayer.utils;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.player.utils.BdNetUtils;

public class NovelVideoPlayerNetUtils implements NoProGuard {
    public static boolean isWifiOrDashengCard() {
        return BdNetUtils.isWifiOrDashengCard();
    }

    public static boolean isNetWifi() {
        return BdNetUtils.isNetWifi();
    }

    public static boolean isDashengCard() {
        return BdNetUtils.isDashengCard();
    }
}
