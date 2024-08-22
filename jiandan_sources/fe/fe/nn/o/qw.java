package fe.fe.nn.o;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.google.android.material.internal.ManufacturerUtils;
import fe.fe.nn.ppp.Cif;
import fe.fe.nn.ppp.de;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static String f2251ad = "";
    public static String qw;

    /* renamed from: fe.fe.nn.o.qw$qw  reason: collision with other inner class name */
    public static class C0111qw {
        public static int qw;

        public static String ad(DeviceIdBag deviceIdBag) {
            if (deviceIdBag == null) {
                return "";
            }
            if (deviceIdBag.errorCode == 3) {
                return String.valueOf(-1004);
            }
            if (TextUtils.isEmpty(deviceIdBag.deviceId)) {
                return "";
            }
            return deviceIdBag.deviceId;
        }

        public static boolean fe() {
            if (qw == 0) {
                try {
                    if (DeviceInfoManager.qw == null) {
                        qw = 1;
                    } else {
                        qw = 2;
                    }
                } catch (Throwable unused) {
                    qw = 1;
                }
            }
            if (qw == 2) {
                return true;
            }
            return false;
        }

        public static String i(Context context, String str) {
            try {
                if (fe()) {
                    return ad(DeviceInfoManager.qw.e(context, "sso", str, true));
                }
            } catch (Throwable unused) {
            }
            return "no_device_sdk";
        }

        /* renamed from: if  reason: not valid java name */
        public static String m148if(String str) {
            try {
                if (fe()) {
                    return ad(DeviceInfoManager.qw.c("sso", str));
                }
            } catch (Throwable unused) {
            }
            return "no_device_sdk";
        }

        public static String o(String str) {
            try {
                if (fe()) {
                    return ad(DeviceInfoManager.qw.a("sso", str));
                }
            } catch (Throwable unused) {
            }
            return "no_device_sdk";
        }

        public static String pf(String str) {
            try {
                if (fe()) {
                    return ad(DeviceInfoManager.qw.b("sso", str));
                }
            } catch (Throwable unused) {
            }
            return "no_device_sdk";
        }

        public static String yj(Context context, String str) {
            try {
                if (fe()) {
                    return ad(DeviceInfoManager.qw.xxx(context, "sso", str));
                }
            } catch (Throwable unused) {
            }
            return "no_device_sdk";
        }
    }

    public static String ad(Context context, String str) {
        try {
            String qw2 = C0111qw.yj(context, str);
            if (!"no_device_sdk".equals(qw2)) {
                return qw2;
            }
            if (!fe.fe.nn.qw.qw.uk(context).rg()) {
                return f2251ad;
            }
            if (!TextUtils.isEmpty(f2251ad)) {
                return f2251ad;
            }
            if (!de.when(context)) {
                return "";
            }
            String stringFromSettingSecure = DeviceIdHelper.getStringFromSettingSecure(context.getContentResolver(), "android_id");
            f2251ad = stringFromSettingSecure;
            if (TextUtils.isEmpty(stringFromSettingSecure)) {
                f2251ad = "";
            }
            return f2251ad;
        } catch (Throwable th2) {
            de.fe(th2);
        }
    }

    public static String de(Context context, boolean z, boolean z2, String str) {
        try {
            String de2 = C0111qw.m148if(str);
            if (!"no_device_sdk".equals(de2)) {
                return de2;
            }
            if (!fe.fe.nn.qw.qw.uk(context).rg()) {
                return Cif.ad(String.valueOf(-1000), z2);
            }
            if (z && !TextUtils.isEmpty(qw)) {
                return qw;
            }
            if (!de.when(context)) {
                return Cif.ad(String.valueOf(-1002), z2);
            }
            String a = fe.fe.nn.ggg.qw.ad().a();
            if (TextUtils.isEmpty(a)) {
                return Cif.ad(String.valueOf(-1003), z2);
            }
            qw = a;
            return a;
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }

    public static String fe(Context context) {
        String J = fe.fe.nn.qw.qw.uk(context).J();
        if (!TextUtils.isEmpty(J)) {
            return J;
        }
        String str = "0";
        if (!fe.fe.nn.qw.qw.uk(context).rg()) {
            return str;
        }
        String str2 = Build.MANUFACTURER;
        if (str2.equalsIgnoreCase("HUAWEI")) {
            str = "1";
        } else if (str2.equalsIgnoreCase("Xiaomi")) {
            str = "2";
        } else if (str2.equalsIgnoreCase(RomUtils.MANUFACTURER_OPPO)) {
            str = "3";
        } else if (str2.equalsIgnoreCase(RomUtils.MANUFACTURER_VIVO)) {
            str = "4";
        } else if (str2.equalsIgnoreCase("realme")) {
            str = BannerBaseItemInfo.TYPE_LOGIN;
        } else if (str2.equalsIgnoreCase("honor")) {
            str = BannerBaseItemInfo.TYPE_SCHEME;
        } else if (str2.equalsIgnoreCase("OnePlus")) {
            str = "7";
        } else if (str2.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
            str = "8";
        }
        fe.fe.nn.qw.qw.uk(context).n(str);
        return str;
    }

    public static String qw(Context context) {
        try {
            if (!fe.fe.nn.qw.qw.uk(context).rg()) {
                return "";
            }
            return DeviceId.getCUID(context);
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }

    public static String rg(Context context, String str) {
        try {
            String th2 = C0111qw.o(str);
            if (!"no_device_sdk".equals(th2)) {
                return th2;
            }
            return Build.MANUFACTURER;
        } catch (Throwable th3) {
            de.fe(th3);
            return "";
        }
    }

    public static String th(Context context, String str) {
        try {
            String uk2 = C0111qw.pf(str);
            if (!"no_device_sdk".equals(uk2)) {
                return uk2;
            }
            return Build.MODEL;
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }

    public static String yj(Context context, String str) {
        try {
            String rg2 = C0111qw.i(context, str);
            if (!"no_device_sdk".equals(rg2)) {
                return rg2;
            }
            if (!fe.fe.nn.qw.qw.uk(context).rg()) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSimOperator();
            }
            return String.valueOf(-1003);
        } catch (Throwable th2) {
            de.fe(th2);
            return "";
        }
    }
}
