package fe.fe.ddd.i.ad;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper;
import fe.fe.ddd.i.ad.th.qw;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f1459ad;
    public static String qw;

    public static DeviceIdBag ad(Context context) {
        return de(context, false);
    }

    public static DeviceIdBag de(Context context, boolean z) {
        DeviceIdBag deviceIdBag = new DeviceIdBag();
        if (!qw.qw().qw()) {
            deviceIdBag.errorCode = -3;
            return deviceIdBag;
        }
        int i2 = 2;
        if (!TextUtils.isEmpty(qw) || f1459ad) {
            if (!f1459ad || !TextUtils.isEmpty(qw)) {
                i2 = 1;
            }
        } else if (z || qw.qw().ad()) {
            String fe2 = fe();
            qw = fe2;
            if (!TextUtils.isEmpty(fe2)) {
                i2 = 0;
            }
            f1459ad = true;
        } else {
            i2 = -1;
        }
        deviceIdBag.deviceId = qw;
        deviceIdBag.errorCode = i2;
        return deviceIdBag;
    }

    public static String fe() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().equalsIgnoreCase("wlan0")) {
                    byte[] mac = WifiInfoHelper.getMac(nextElement);
                    String str = null;
                    if (mac != null) {
                        str = qw(mac);
                    }
                    if (TextUtils.isEmpty(str)) {
                        return "";
                    }
                    return str;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return "";
    }

    public static String qw(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02x:", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
