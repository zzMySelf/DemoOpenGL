package com.baidu.swan.config.core;

import com.baidu.searchbox.search.webvideo.vip.LcbSendVipManagerKt;

public class ConfigStrategyManager {
    private static final String KEY_LATEST_UPDATE_TIME = "latest_update_time";
    private static final String KEY_MAX_AGE = "max_age";
    private static final int MAX_AGE_MAX_LIMIT = 259200;

    public static boolean isMaxAgeExpires() {
        return (System.currentTimeMillis() - getLatestUpdateTime()) / 1000 > getConfigUpdateMaxAge();
    }

    public static void updateConfigSuccess(long maxAge, long time) {
        long maxAge2 = 0;
        if (maxAge > 0 && maxAge < LcbSendVipManagerKt.THREE_DAYS_ALL_SECONDS) {
            maxAge2 = maxAge;
        }
        ConfigSharePreUtil.get().edit().putLong("max_age", maxAge2).putLong(KEY_LATEST_UPDATE_TIME, time).apply();
    }

    public static void setConfigUpdateMaxAge(long maxAge) {
        long maxAge2 = 0;
        if (maxAge > 0 && maxAge < LcbSendVipManagerKt.THREE_DAYS_ALL_SECONDS) {
            maxAge2 = maxAge;
        }
        ConfigSharePreUtil.get().edit().putLong("max_age", maxAge2).apply();
    }

    public static void setLatestUpdateTime(long time) {
        ConfigSharePreUtil.get().edit().putLong(KEY_LATEST_UPDATE_TIME, time).apply();
    }

    private static long getConfigUpdateMaxAge() {
        return ConfigSharePreUtil.get().getLong("max_age", 0);
    }

    private static long getLatestUpdateTime() {
        return ConfigSharePreUtil.get().getLong(KEY_LATEST_UPDATE_TIME, 0);
    }
}
