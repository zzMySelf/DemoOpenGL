package com.baidu.searchbox.push.mymessagefragment.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.push.MessageUtils;
import com.baidu.searchbox.push.PushMessageConstants;
import com.baidu.searchbox.skin.NightModeHelper;

public class BannerUtil {
    public static final int ALPHA_10 = 26;
    public static final int ALPHA_5 = 13;
    public static final String BOX_SCHEMA_PREFIX = "baiduboxapp:";

    public static void startJumpBanner(String url) {
        if (!TextUtils.isEmpty(url)) {
            try {
                if (url.startsWith("baiduboxapp:")) {
                    MessageUtils.invokeScheme(MessageRuntime.getAppContext(), url);
                } else {
                    MessageUtils.invokeWebviewFrame(2, url, PushMessageConstants.FrameType.GOTO_LIGHT);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static int getColor(String colorStr) {
        try {
            return Color.parseColor(colorStr);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return Color.parseColor("#000000");
        }
    }

    public static GradientDrawable getDrawable(Context context, int color) {
        boolean isNight = NightModeHelper.isNightMode();
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(0);
        drawable.setColor(color);
        drawable.setCornerRadius((float) DeviceUtils.ScreenInfo.dp2px(context, 12.0f));
        drawable.setAlpha(isNight ? 13 : 26);
        return drawable;
    }
}
