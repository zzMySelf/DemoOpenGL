package fe.fe.ddd.rg;

import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;

public class qw {
    public static BdBoxActivityLifecycle qw;

    public static boolean ad() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = qw;
        return bdBoxActivityLifecycle != null && bdBoxActivityLifecycle.qw();
    }

    public static void de(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        if (iActivityLifecycle != null && (bdBoxActivityLifecycle = qw) != null) {
            bdBoxActivityLifecycle.fe(iActivityLifecycle);
        }
    }

    public static void fe(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        if (iActivityLifecycle != null && (bdBoxActivityLifecycle = qw) != null) {
            bdBoxActivityLifecycle.rg(iActivityLifecycle);
        }
    }

    public static BdBoxActivityLifecycle qw() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        synchronized (BdBoxActivityLifecycle.class) {
            bdBoxActivityLifecycle = qw;
        }
        return bdBoxActivityLifecycle;
    }

    public static void rg(BdBoxActivityLifecycle bdBoxActivityLifecycle) {
        synchronized (BdBoxActivityLifecycle.class) {
            if (qw == null) {
                qw = bdBoxActivityLifecycle;
            } else {
                throw new IllegalStateException("The main activity lifecycle has already been initialized.");
            }
        }
    }
}
