package com.baidu.searchbox.player.utils;

import android.app.Activity;

public class BdActivityUtils {
    public static void requestPortrait(Activity activity) {
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
    }

    public static void requestLandscape(Activity activity, boolean isReverse) {
        if (activity != null) {
            if (isReverse) {
                activity.setRequestedOrientation(8);
            } else {
                activity.setRequestedOrientation(0);
            }
            activity.getWindow().setFlags(1024, 1024);
        }
    }
}
