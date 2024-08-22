package fe.fe.ddd.when.qw.yj.i;

import android.content.Context;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.searchbox.aperf.param.CommonUtils;
import fe.fe.ddd.i.qw.qw;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public String f1730ad;
    public String qw;

    public rg() {
        de();
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

    public final void de() {
        Context qw2 = qw.qw();
        this.qw = CommonUtils.qw();
        this.f1730ad = ad(qw2);
    }

    public String qw() {
        return this.f1730ad;
    }
}
