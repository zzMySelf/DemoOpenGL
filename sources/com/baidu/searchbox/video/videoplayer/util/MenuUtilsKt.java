package com.baidu.searchbox.video.videoplayer.util;

import android.content.Context;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"getFullGradientBgWidth", "", "context", "Landroid/content/Context;", "getScreenLongEdge", "getScreenShortEdge", "lib-player-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MenuUtils.kt */
public final class MenuUtilsKt {
    public static final int getFullGradientBgWidth(Context context) {
        int screenWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        int screenHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        if (screenWidth < screenHeight) {
            int temp = screenWidth;
            screenWidth = screenHeight;
            screenHeight = temp;
        }
        int displayWidth = (int) (((double) screenWidth) * 0.7d);
        if (displayWidth < screenHeight) {
            return screenWidth;
        }
        return displayWidth;
    }

    public static final int getScreenShortEdge(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int screenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(context);
        int screenHeight = DeviceUtils.ScreenInfo.getDisplayHeight(context);
        if (screenWidth < screenHeight) {
            return screenWidth;
        }
        return screenHeight;
    }

    public static final int getScreenLongEdge(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int screenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(context);
        int screenHeight = DeviceUtils.ScreenInfo.getDisplayHeight(context);
        if (screenWidth < screenHeight) {
            return screenHeight;
        }
        return screenWidth;
    }
}
