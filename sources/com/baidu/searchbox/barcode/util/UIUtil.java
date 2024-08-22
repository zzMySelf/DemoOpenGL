package com.baidu.searchbox.barcode.util;

import android.content.Context;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.lightbrowser.IntentConstant;
import java.lang.reflect.Method;

public class UIUtil {
    public static void collapseStatusBar(Context context) {
        Method collapse;
        try {
            Object statusBarManager = context.getSystemService(IntentConstant.EXTRA_STATUS_BAR_LIGHT_MODE);
            if (!DeviceUtils.OSInfo.hasJellyBeanMR1()) {
                collapse = statusBarManager.getClass().getMethod("collapse", new Class[0]);
            } else {
                collapse = statusBarManager.getClass().getMethod("collapsePanels", new Class[0]);
            }
            collapse.invoke(statusBarManager, new Object[0]);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }
}
