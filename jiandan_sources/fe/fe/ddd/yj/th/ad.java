package fe.fe.ddd.yj.th;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static String f1787ad = "0";
    public static String qw = "";

    public static String qw(String str) {
        String qw2 = HostConfig.qw();
        if (AppConfig.rg() && !TextUtils.isEmpty(qw)) {
            qw2 = qw;
        }
        String ad2 = fe.fe.yj.de.ad.th().ad(String.format("%s/ccs/v1/start/confsync", new Object[]{qw2}), 1);
        if (!TextUtils.isEmpty(str)) {
            ad2 = UrlUtil.addParam(ad2, "runtype", str);
        }
        String valueOf = String.valueOf(f1787ad);
        return !TextUtils.isEmpty(valueOf) ? UrlUtil.addParam(ad2, "type_id", valueOf) : ad2;
    }
}
