package fe.fe.ddd.i.ad;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.sofire.xclient.privacycontrol.lib.DeviceIdHelper;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f1458ad;
    public static String qw;

    @SuppressLint({"HardwareIds"})
    public static DeviceIdBag ad(Context context, boolean z) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        if (!fe.fe.ddd.i.ad.th.qw.qw().qw()) {
            deviceIdBag.errorCode = -3;
            return deviceIdBag;
        }
        int i2 = 1;
        if (qw != null || f1458ad) {
            if (f1458ad && qw == null) {
                i2 = 2;
            }
        } else if (z || fe.fe.ddd.i.ad.th.qw.qw().ad()) {
            qw = de(context);
            f1458ad = true;
            i2 = 0;
        } else {
            i2 = -1;
        }
        deviceIdBag.deviceId = qw;
        deviceIdBag.errorCode = i2;
        return deviceIdBag;
    }

    public static String de(Context context) {
        try {
            return DeviceIdHelper.getStringFromSettingSecure(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return null;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static DeviceIdBag qw(Context context) {
        return ad(context, false);
    }
}
