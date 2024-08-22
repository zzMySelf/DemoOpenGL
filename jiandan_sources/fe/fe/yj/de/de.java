package fe.fe.yj.de;

import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import fe.fe.ddd.i.qw.qw;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f3201ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f3202de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f3203fe;
    public String qw;

    public boolean ad() {
        if (!this.f3203fe) {
            return false;
        }
        if (!this.f3202de) {
            this.f3202de = de();
        }
        return this.f3202de;
    }

    public final boolean de() {
        return DeviceInfoManager.qw.eee(qw.qw(), "pub_param", "").errorCode == 3;
    }

    public String qw() {
        if (!this.f3201ad) {
            StringBuilder sb = new StringBuilder();
            if (DeviceUtils.isHarmonyOS(qw.qw())) {
                this.f3203fe = true;
                String str = DeviceInfoManager.qw.eee(qw.qw(), "pub_param", "").deviceId;
                if (TextUtils.isEmpty(str)) {
                    str = "0.0";
                }
                sb.append("HMS");
                sb.append("_");
                sb.append(str);
            }
            this.qw = sb.toString();
            this.f3201ad = true;
        }
        return this.qw;
    }
}
