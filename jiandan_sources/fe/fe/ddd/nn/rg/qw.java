package fe.fe.ddd.nn.rg;

import android.text.TextUtils;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.UBCManager;
import fe.fe.vvv.ad.ad.ad;

public class qw implements PerfSampleManager.IPerfSampleCallback {

    /* renamed from: ad  reason: collision with root package name */
    public static String f1515ad = "1";

    /* renamed from: de  reason: collision with root package name */
    public static String f1516de = "0";
    public static String qw = "1157";

    public String qw() {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            String uploadType = uBCManager.getUploadType(qw);
            if (TextUtils.equals(f1515ad, uploadType)) {
                if (!ad.f1514de) {
                    fe.fe.ddd.o.qw.qw().putBoolean(ad.f1513ad, true);
                }
            } else if (TextUtils.equals(f1516de, uploadType) && ad.f1514de) {
                fe.fe.ddd.o.qw.qw().putBoolean(ad.f1513ad, false);
            }
        }
        return ad.f1514de ? qw : "";
    }
}
