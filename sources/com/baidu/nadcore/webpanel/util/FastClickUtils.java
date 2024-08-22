package com.baidu.nadcore.webpanel.util;

public class FastClickUtils {
    private static final int CLICK_GAP_TIME = 1300;
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long div = time - lastClickTime;
        lastClickTime = time;
        if (div <= 0 || div >= 1300) {
            return false;
        }
        return true;
    }
}
