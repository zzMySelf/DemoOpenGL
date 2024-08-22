package fe.fe.ddd.i.ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.sofire.xclient.privacycontrol.lib.TelephonyHelper;
import fe.fe.ddd.i.ad.th.qw;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f1456ad;

    /* renamed from: de  reason: collision with root package name */
    public static int f1457de;
    public static String qw;

    public static DeviceIdBag ad(Context context, boolean z, boolean z2) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        if (!qw.qw().qw()) {
            deviceIdBag.errorCode = -3;
            return deviceIdBag;
        }
        int de2 = de(context);
        int i2 = 1;
        if (z2 || ((qw == null && !f1456ad) || f1457de != de2)) {
            if (!z && !qw.qw().ad()) {
                i2 = -1;
            } else if (qw(context)) {
                qw = fe(context);
                f1456ad = true;
                f1457de = de2;
                i2 = 0;
            } else {
                i2 = -2;
            }
        } else if (qw == null && f1456ad) {
            i2 = 2;
        }
        deviceIdBag.deviceId = qw;
        deviceIdBag.errorCode = i2;
        return deviceIdBag;
    }

    public static int de(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String fe(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 26) {
                return TelephonyHelper.getImei(telephonyManager);
            }
            return TelephonyHelper.getDeviceId(telephonyManager);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean qw(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23 || i2 >= 29) {
            return Build.VERSION.SDK_INT < 29;
        }
        if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return true;
        }
        return false;
    }
}
