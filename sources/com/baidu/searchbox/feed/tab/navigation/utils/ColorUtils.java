package com.baidu.searchbox.feed.tab.navigation.utils;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class ColorUtils {
    public static int toggleColorSafe(String deliverColor, int defaultColorId) {
        if (TextUtils.isEmpty(deliverColor)) {
            return ContextCompat.getColor(AppRuntime.getAppContext(), defaultColorId);
        }
        try {
            return Color.parseColor(deliverColor);
        } catch (IllegalArgumentException e2) {
            return ContextCompat.getColor(AppRuntime.getAppContext(), defaultColorId);
        }
    }
}
