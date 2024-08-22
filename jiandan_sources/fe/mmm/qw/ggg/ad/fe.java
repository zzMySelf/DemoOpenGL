package fe.mmm.qw.ggg.ad;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tera.scan.framework.framework.FrameworkAccount;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.p030switch.de.qw.ad;

public class fe extends ad {
    public static Intent qw(Context context, String str, String str2, ResultReceiver resultReceiver) {
        return ad.qw(context, str, str2, resultReceiver).putExtra("com.mars.EXTRA_SERVICE_TYPE", 19);
    }

    public static void rg(Context context, ResultReceiver resultReceiver, String str) {
        String str2;
        qw.ad("ActiveServiceHelper", "sendActive::start");
        qw.ad("ActiveServiceHelper", "sendActive::startACTION_SEND_ACTIVE");
        try {
            FrameworkAccount qw = fe.mmm.qw.p030switch.rg.qw.qw();
            String str3 = null;
            if (qw != null) {
                str3 = qw.getBduss();
                str2 = qw.getUid();
            } else {
                str2 = null;
            }
            ad.fe(context, qw(context, str3, str2, resultReceiver).setAction("com.dubox.drive.ACTION_SEND_ACTIVE").putExtra("com.dubox.drive.extra.ACTIVE_ACTION_TYPE", str));
        } catch (Exception e) {
            qw.ggg("ActiveServiceHelper", "sendActive", e);
        }
    }
}
