package com.dxmpay.wallet.core.utils;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;

public class OSUtils {
    public static String qw;

    public static boolean ad(Context context) {
        try {
            return "harmony".equalsIgnoreCase(context.getString(Resources.getSystem().getIdentifier("config_os_brand", ResUtils.b, SapiDeviceInfo.OS_TYPE)));
        } catch (Exception e) {
            LogUtil.e("OSUtils", e.getMessage(), e);
            return false;
        }
    }

    public static String getOSName(Context context) {
        String str = qw;
        if (str != null) {
            return str;
        }
        if (isHarmonyOs(context)) {
            qw = "harmony";
            return "harmony";
        }
        qw = SapiDeviceInfo.OS_TYPE;
        return SapiDeviceInfo.OS_TYPE;
    }

    public static boolean isHarmonyOs(Context context) {
        if (ad(context)) {
            return true;
        }
        return qw();
    }

    public static boolean qw() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equalsIgnoreCase(String.valueOf(cls.getDeclaredMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
        } catch (ClassNotFoundException e) {
            LogUtil.e("OSUtils", e.getMessage(), e);
            return false;
        } catch (NoSuchMethodException e2) {
            LogUtil.e("OSUtils", e2.getMessage(), e2);
            return false;
        } catch (Exception e3) {
            LogUtil.e("OSUtils", e3.getMessage(), e3);
            return false;
        }
    }
}
