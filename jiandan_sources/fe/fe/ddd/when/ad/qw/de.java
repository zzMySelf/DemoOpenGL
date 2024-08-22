package fe.fe.ddd.when.ad.qw;

import android.text.TextUtils;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.ubc.UBCManager;
import fe.fe.vvv.ad.ad.ad;

public class de implements PerfSampleManager.IPerfSampleCallback {
    public static String qw = "1";

    public String qw() {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (uBCManager == null) {
            return "";
        }
        if (TextUtils.equals(qw, uBCManager.getUploadType("1768"))) {
            return "1768";
        }
        return "";
    }
}
