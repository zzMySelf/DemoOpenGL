package com.baidu.iknow.advisory.hn.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.iknow.android.advisorysdk.utils.LogHelper;
import com.baidu.searchbox.qrcode.utils.ResUtils;

public class UIUtils {
    private static final String TAG = "StatusBarUtil";
    private static boolean get = false;
    private static int statusBarHeight = 0;

    public static synchronized int getStatusBarHeight(Context context) {
        int resourceId;
        synchronized (UIUtils.class) {
            if (!get) {
                int resourceId2 = context.getResources().getIdentifier("status_bar_height", ResUtils.DIMEN, "android");
                if (resourceId2 > 0) {
                    statusBarHeight = context.getResources().getDimensionPixelSize(resourceId2);
                    get = true;
                }
                LogHelper.d(TAG, "status bar util: " + statusBarHeight);
            }
            resourceId = statusBarHeight;
        }
        return resourceId;
    }

    public static boolean isSystemUILayoutFullScreen(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0;
    }
}
