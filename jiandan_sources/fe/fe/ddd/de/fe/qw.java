package fe.fe.ddd.de.fe;

import android.text.TextUtils;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import fe.fe.vvv.ad.ad.ad;

public class qw implements PerfSampleManager.IPerfSampleCallback {

    /* renamed from: ad  reason: collision with root package name */
    public static String f1392ad = "1";

    /* renamed from: de  reason: collision with root package name */
    public static String f1393de = "0";
    public static String qw = "1794";

    public String qw() {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            String uploadType = uBCManager.getUploadType(qw);
            if (AppConfig.rg()) {
                "getSampleFlag uploadType " + uploadType;
            }
            if (TextUtils.equals(f1392ad, uploadType)) {
                if (!ad.f1391de) {
                    fe.fe.ddd.o.qw.qw().putBoolean(ad.f1390ad, true);
                }
            } else if (TextUtils.equals(f1393de, uploadType) && ad.f1391de) {
                fe.fe.ddd.o.qw.qw().putBoolean(ad.f1390ad, false);
            }
        }
        return ad.f1391de ? qw : "";
    }
}
