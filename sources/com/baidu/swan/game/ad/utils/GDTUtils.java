package com.baidu.swan.game.ad.utils;

import android.text.TextUtils;
import com.baidu.swan.game.ad.ioc.SwanAdRuntime;

public class GDTUtils {
    private static final long SEVEN_DAY = 604800000;

    public static boolean hasGDTBannerAd() {
        return !TextUtils.isEmpty(getGDTBannerAdAppId()) && !TextUtils.isEmpty(getGDTBannerPosId()) && System.currentTimeMillis() - SwanAdRuntime.getAdConfig().getGDTAdConfigTime().longValue() < 604800000;
    }

    public static boolean hasGDTVideoAd() {
        return !TextUtils.isEmpty(getGDTVideoAdAppId()) && !TextUtils.isEmpty(getGDTVideoPosId()) && System.currentTimeMillis() - SwanAdRuntime.getAdConfig().getGDTAdConfigTime().longValue() < 604800000;
    }

    public static boolean needGdtVideAd() {
        return SwanAdRuntime.getAdConfig().getFirstRequestOptimization() && hasGDTVideoAd();
    }

    public static String getGDTBannerAdAppId() {
        return SwanAdRuntime.getAdConfig().getGDTBannerAdAppId();
    }

    public static String getGDTBannerPosId() {
        return SwanAdRuntime.getAdConfig().getGDTAdBannerPostId();
    }

    public static String getGDTVideoAdAppId() {
        return SwanAdRuntime.getAdConfig().getGDTVideoAdAppId();
    }

    public static String getGDTVideoPosId() {
        return SwanAdRuntime.getAdConfig().getGDTAdVideoPostId();
    }

    public static boolean needVideoUIOptimization() {
        return SwanAdRuntime.getAdConfig().getVideoUIOptimization();
    }

    public static boolean needVideoRequestOptimization() {
        return hasGDTVideoAd() && SwanAdRuntime.getAdConfig().getVideoRequestOptimization();
    }
}
