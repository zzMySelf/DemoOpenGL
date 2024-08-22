package fe.mmm.qw.th.qw.de;

import android.os.Build;
import com.alipay.sdk.m.u.i;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.de.ad.qw.qw;

public class ad implements RequestCommonParams.RequestCommonParamsCreator {
    public static String qw = "";

    public ad(String str) {
        qw = str;
    }

    public static String yj() {
        return "aiscan" + i.b + qw.f7746ad + i.b + RequestCommonParams.ad() + i.b + SapiDeviceInfo.OS_TYPE + "-" + SapiDeviceInfo.OS_TYPE + i.b + RequestCommonParams.de() + i.b + qw.when + i.b + "jointBridge" + i.b + "1.1.0" + i.b;
    }

    public String ad() {
        return yj();
    }

    public String de() {
        return "android_" + Build.VERSION.RELEASE + "_" + Build.MODEL + "_" + "aiscan" + "_" + qw.f7753th;
    }

    public String fe() {
        return String.valueOf(-1);
    }

    public String qw() {
        return RequestCommonParams.th();
    }

    public String rg() {
        return "android_" + Build.VERSION.RELEASE + "_" + Build.MODEL + "_" + "aiscan";
    }

    public String th() {
        return qw;
    }
}
