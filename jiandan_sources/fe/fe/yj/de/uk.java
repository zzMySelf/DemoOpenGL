package fe.fe.yj.de;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import fe.fe.ddd.i.qw.qw;

public class uk {

    /* renamed from: ad  reason: collision with root package name */
    public String f3220ad;
    public String qw;

    public uk() {
        fe();
    }

    public final String ad(Context context) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append(SapiDeviceInfo.OS_TYPE);
        stringBuffer.append("_");
        stringBuffer.append(this.qw);
        stringBuffer.append("_");
        stringBuffer.append(densityDpi);
        return stringBuffer.toString();
    }

    public String de(Context context) {
        String appVersion = qw.de().getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            return appVersion;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "0.8";
        }
    }

    public final void fe() {
        Context qw2 = qw.qw();
        this.qw = de(qw2);
        this.f3220ad = ad(qw2);
    }

    public String qw() {
        return this.f3220ad;
    }
}
