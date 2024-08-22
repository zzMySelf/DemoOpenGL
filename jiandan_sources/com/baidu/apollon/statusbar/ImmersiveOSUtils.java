package com.baidu.apollon.statusbar;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;

public class ImmersiveOSUtils {
    public static final String FLYME = "flyme";
    public static final String KEY_DISPLAY = "ro.build.display.id";
    public static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    public static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    public static final String LEECO = "leeco";
    public static final String LETV = "letv";
    public static final String NUBIA = "nubia";
    public static final String ZTEC2016 = "zte c2016";
    public static final String ZUKZ1 = "zuk z1";

    public static String getEMUIVersion() {
        return isEMUI() ? getSystemProperty("ro.build.version.emui", "") : "";
    }

    public static String getFlymeOSFlag() {
        return getSystemProperty("ro.build.display.id", "");
    }

    public static String getFlymeOSVersion() {
        return isFlymeOS() ? getSystemProperty("ro.build.display.id", "") : "";
    }

    public static String getMIUIVersion() {
        return isMIUI() ? getSystemProperty("ro.miui.ui.version.name", "") : "";
    }

    public static String getSystemProperty(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.emui", ""));
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Plus() {
        int i2;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains(UrlOcrConfig.IdCardKey.OS)) {
                i2 = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i2 = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (((double) i2) > 4.4d) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        int i2;
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            if (flymeOSVersion.toLowerCase().contains(UrlOcrConfig.IdCardKey.OS)) {
                i2 = Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue();
            } else {
                i2 = Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue();
            }
            if (i2 == 5) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isLeshi() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("letv") || lowerCase.contains("leeco")) {
            return true;
        }
        return false;
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name", ""));
    }

    public static boolean isMIUI6Plus() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            if (Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isNubia() {
        String str = Build.MANUFACTURER;
        return str != null && str.toLowerCase().contains("nubia");
    }

    public static boolean isSpecialOS() {
        return isZUKZ1() || isZTKC2016() || isNubia() || isLeshi();
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (Build.VERSION.SDK_INT < 27 && !isMIUI6Plus() && !isFlymeOS4Plus() && Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return true;
    }

    public static boolean isZTKC2016() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains("zte c2016");
    }

    public static boolean isZUKZ1() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains("zuk z1");
    }
}
