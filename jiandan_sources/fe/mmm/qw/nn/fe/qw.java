package fe.mmm.qw.nn.fe;

import android.text.TextUtils;
import fe.mmm.qw.yj.th;
import fe.mmm.qw.yj.uk;

public class qw {
    public static String qw() {
        String yj2 = th.ppp().yj("net_param_sk");
        if (TextUtils.isEmpty(yj2)) {
            yj2 = uk.ad().de("net_param_sk");
        }
        return yj2 == null ? "" : yj2;
    }
}
