package com.baidu.cpu.booster.utils;

import android.os.Build;
import android.text.TextUtils;

public class DeviceUtils {
    private static final String HR = "HONOR";
    private static final String HW = "HUAWEI";
    private static final String OPPO = "OPPO";
    private static final String VIVO = "VIVO";
    private static String sDevice;

    public static boolean isHuaWei() {
        String str = sDevice;
        if (str != null) {
            return TextUtils.equals(str, "HUAWEI");
        }
        String brand = Build.BRAND.toUpperCase();
        if (TextUtils.equals("HUAWEI", brand) || TextUtils.equals("HONOR", brand)) {
            sDevice = "HUAWEI";
            return true;
        }
        String manufacturer = Build.MANUFACTURER.toUpperCase();
        if (!manufacturer.contains("HUAWEI") && !manufacturer.contains("HONOR")) {
            return false;
        }
        sDevice = "HUAWEI";
        return true;
    }

    public static boolean isOppo() {
        String str = sDevice;
        if (str != null) {
            return TextUtils.equals(str, "OPPO");
        }
        if (TextUtils.equals("OPPO", Build.BRAND.toUpperCase())) {
            sDevice = "OPPO";
            return true;
        } else if (!Build.MANUFACTURER.toUpperCase().contains("OPPO")) {
            return false;
        } else {
            sDevice = "OPPO";
            return true;
        }
    }

    public static boolean isVivo() {
        String str = sDevice;
        if (str != null) {
            return TextUtils.equals(str, "VIVO");
        }
        if (TextUtils.equals("VIVO", Build.BRAND.toUpperCase())) {
            sDevice = "VIVO";
            return true;
        } else if (!Build.MANUFACTURER.toUpperCase().contains("VIVO")) {
            return false;
        } else {
            sDevice = "VIVO";
            return true;
        }
    }
}
