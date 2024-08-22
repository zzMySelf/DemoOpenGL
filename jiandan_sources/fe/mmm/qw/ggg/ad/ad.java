package fe.mmm.qw.ggg.ad;

import android.os.ResultReceiver;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import fe.mmm.qw.j.when;
import fe.mmm.qw.ppp.ad.qw.qw;
import fe.mmm.qw.yj.th;

public class ad {
    public static void ad(String str, boolean z, ResultReceiver resultReceiver) {
        if (qw.ad(BaseApplication.getInstance())) {
            if (z) {
                if (OldBaseActivity.getTopActivity() != null) {
                    str = str + "_QIAN";
                } else {
                    str = str + "_HOU";
                }
            }
            String qw = when.qw(System.currentTimeMillis());
            String yj2 = th.ppp().yj(str);
            fe.mmm.qw.i.qw.ad("DailyActiveManager", "day::" + qw + ":" + str + ":" + yj2);
            if (!qw.equals(yj2)) {
                fe.rg(BaseApplication.getInstance().getApplicationContext(), resultReceiver, str);
            }
        }
    }

    public static void qw(ResultReceiver resultReceiver) {
        ad("ANDROID_ACTIVE_FRONTDESK", false, resultReceiver);
    }
}
