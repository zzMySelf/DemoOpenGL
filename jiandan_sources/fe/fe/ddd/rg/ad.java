package fe.fe.ddd.rg;

import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import fe.fe.ddd.i.qw.qw;

public class ad extends BdBoxActivityLifecycle {

    /* renamed from: o  reason: collision with root package name */
    public static ad f1569o;

    public static ad th() {
        if (f1569o == null) {
            synchronized (ad.class) {
                if (f1569o == null) {
                    f1569o = new ad();
                    qw.ad().registerActivityLifecycleCallbacks(f1569o);
                }
            }
        }
        return f1569o;
    }
}
