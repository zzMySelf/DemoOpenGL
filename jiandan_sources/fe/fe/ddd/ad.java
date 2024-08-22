package fe.fe.ddd;

import com.baidu.searchbox.StartupCountStats;
import fe.fe.ddd.rg.qw;

public class ad {
    public static volatile boolean qw = false;

    public static void ad() {
        StartupCountStats.setStartupCountUploadId("691");
        StartupCountStats.setUseDurationUploadId("18");
    }

    public static void qw() {
        if (!qw) {
            synchronized (ad.class) {
                if (!qw) {
                    if (qw.qw() == null) {
                        qw.rg(fe.fe.ddd.rg.ad.th());
                    }
                    qw.fe(new StartupCountStats());
                    qw = true;
                }
            }
        }
    }
}
