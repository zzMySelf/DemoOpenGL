package com.baidu.dove;

import com.baidu.searchbox.config.AppConfig;

public class DoveABUtils {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final int OPT_NETWORK_BY_NETWORKCALLBACK = 2;
    private static final String TAG = "DoveABUtils";

    public static boolean enableDoveOpt() {
        return true;
    }

    public static int getNetworkOptType() {
        return 2;
    }
}
