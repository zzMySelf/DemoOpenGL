package com.baidu.searchbox;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.baidu.searchbox.ui.BdActionBar;
import java.lang.reflect.Method;

public class MessageUiUtils {
    private static final String ANDROID_OS_SYSTEMPROPERTIES = "android.os.SystemProperties";
    private static final String BRAND_DEFAULT = "navigationbar_is_min";
    private static final String BRAND_NOKIA_AFTER_P = "swipe_up_to_switch_apps_enabled";
    private static final String BRAND_NOKIA_PRE_P = "navigation_bar_can_hiden";
    private static final String BRAND_OPPO = "hide_navigationbar_enable";
    private static final String BRAND_SAMSUNG = "navigationbar_hide_bar_enabled";
    private static final String BRAND_VIVO = "navigation_gesture_on";
    private static final String BRAND_XIAOMI = "force_fsg_nav_bar";
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    private static final String DEF_PACKAGE = "android";
    private static final String DEF_TYPE = "bool";
    private static final String HONOR = "HONOR";
    private static final String HUAWEI = "HUAWEI";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String NAV_BAR_NOT_OVERRIDE = "0";
    private static final String NAV_BAR_OVERRIDE = "1";
    private static final String NOKIA = "NOKIA";
    private static final String OPPO = "OPPO";
    private static final String QEMU_HW_MAINKEYS = "qemu.hw.mainkeys";
    private static final String SAMSUNG = "SAMSUNG";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
    private static final String TAG = "MessageUiUtils";
    private static final String VIVO = "VIVO";
    private static final String XIAOMI = "XIAOMI";

    public static int getNavBarHeight() {
        String key;
        Context context = MessageRuntime.getAppContext();
        if (context == null) {
            return 0;
        }
        Resources res = context.getResources();
        if (!hasNavBar(context) || navigationGestureEnabled(context)) {
            return 0;
        }
        if (isScreenPortrait()) {
            key = "navigation_bar_height";
        } else {
            key = "navigation_bar_height_landscape";
        }
        return getInternalDimensionSize(res, key);
    }

    public static boolean navigationGestureEnabled(Context context) {
        try {
            String brand = Build.BRAND;
            if (Build.VERSION.SDK_INT < 21) {
                if (Settings.System.getInt(context.getContentResolver(), getDeviceInfo(), 0) != 0) {
                    return true;
                }
                return false;
            } else if ((TextUtils.isEmpty(brand) || !brand.equalsIgnoreCase("VIVO")) && !brand.equalsIgnoreCase("OPPO")) {
                if (TextUtils.isEmpty(brand) || !brand.equalsIgnoreCase(NOKIA)) {
                    if (Settings.Global.getInt(context.getContentResolver(), getDeviceInfo(), 0) != 0) {
                        return true;
                    }
                    return false;
                } else if (Settings.Secure.getInt(context.getContentResolver(), BRAND_NOKIA_AFTER_P, 0) == 1 || Settings.System.getInt(context.getContentResolver(), BRAND_NOKIA_PRE_P, 0) != 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (Settings.Secure.getInt(context.getContentResolver(), getDeviceInfo(), 0) != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String getDeviceInfo() {
        String brand = Build.BRAND;
        if (TextUtils.isEmpty(brand) || brand.equalsIgnoreCase("HUAWEI") || brand.equalsIgnoreCase("HONOR")) {
            return BRAND_DEFAULT;
        }
        if (brand.equalsIgnoreCase("XIAOMI")) {
            return BRAND_XIAOMI;
        }
        if (brand.equalsIgnoreCase("VIVO")) {
            return BRAND_VIVO;
        }
        if (brand.equalsIgnoreCase("OPPO")) {
            return BRAND_OPPO;
        }
        if (brand.equalsIgnoreCase(NOKIA)) {
            if (Build.VERSION.SDK_INT < 28) {
                return BRAND_NOKIA_PRE_P;
            }
            return BRAND_NOKIA_AFTER_P;
        } else if (brand.equalsIgnoreCase(SAMSUNG)) {
            return BRAND_SAMSUNG;
        } else {
            return BRAND_DEFAULT;
        }
    }

    public static int getInternalDimensionSize(Resources res, String key) {
        int resourceId;
        if (res != null && (resourceId = res.getIdentifier(key, ResUtils.DIMEN, "android")) > 0) {
            return res.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    public static boolean hasNavBar(Context context) {
        if (context == null) {
            return false;
        }
        Resources res = context.getResources();
        int resId = res.getIdentifier(SHOW_NAV_BAR_RES_NAME, DEF_TYPE, "android");
        if (resId == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean hasNav = res.getBoolean(resId);
        String sNavBarOverride = getNavBarOverride();
        if ("1".equals(sNavBarOverride)) {
            return false;
        }
        if ("0".equals(sNavBarOverride)) {
            return true;
        }
        return hasNav;
    }

    private static String getNavBarOverride() {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        try {
            Method m = Class.forName(ANDROID_OS_SYSTEMPROPERTIES).getDeclaredMethod("get", new Class[]{String.class});
            m.setAccessible(true);
            return (String) m.invoke((Object) null, new Object[]{QEMU_HW_MAINKEYS});
        } catch (Throwable e2) {
            if (!DEBUG) {
                return null;
            }
            Log.i(TAG, e2.toString());
            return null;
        }
    }

    public static boolean isScreenPortrait() {
        return MessageRuntime.getAppContext().getResources().getConfiguration().orientation == 1;
    }

    public static void actionBarAdaptForFontChange(BdActionBar actionBar, Context context, int baseSizeId) {
        if (actionBar != null) {
            int actionBarHeight = DeviceUtil.ScreenInfo.dp2px(context, 38.0f);
            if (FontSizeHelper.isFontSizeBigger()) {
                actionBarHeight = (int) (((float) actionBarHeight) + (FontSizeHelper.getScaledSizeRes(0, baseSizeId) - ((float) context.getResources().getDimensionPixelSize(baseSizeId))));
            }
            ViewGroup.LayoutParams params = actionBar.getLayoutParams();
            params.height = actionBarHeight;
            actionBar.setLayoutParams(params);
        }
    }

    public static int getIndexOfStr(String str, int designatedLength) {
        if (TextUtils.isEmpty(str) || designatedLength <= 0 || str.length() < designatedLength) {
            return -1;
        }
        int desLen = designatedLength * 2;
        int curLen = 0;
        int index = 0;
        for (char c2 : str.toCharArray()) {
            int step = 2;
            if (c2 > 0 && c2 < 127) {
                step = 1;
            }
            index++;
            curLen += step;
            if (curLen == desLen) {
                return index;
            }
            if (curLen > desLen) {
                return index - 1;
            }
        }
        return index;
    }
}
