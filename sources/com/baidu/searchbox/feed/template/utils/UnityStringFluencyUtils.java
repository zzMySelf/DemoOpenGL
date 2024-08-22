package com.baidu.searchbox.feed.template.utils;

import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;

public class UnityStringFluencyUtils {
    private static Boolean isHarmonyOSResult;

    public static Boolean isHarmonyOS() {
        if (!FeedAbtestManager.isFluencyOptOpen()) {
            return null;
        }
        if (isHarmonyOSResult == null) {
            isHarmonyOSResult = Boolean.valueOf(DeviceUtils.isHarmonyOS(FeedRuntime.getAppContext()));
        }
        return isHarmonyOSResult;
    }
}
