package fe.fe.ddd.nn;

import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ruka.ioc.IANRMonitor;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import java.util.concurrent.atomic.AtomicBoolean;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile AtomicBoolean f1509ad = new AtomicBoolean(false);

    /* renamed from: de  reason: collision with root package name */
    public static volatile AtomicBoolean f1510de = new AtomicBoolean(false);

    /* renamed from: fe  reason: collision with root package name */
    public static volatile AtomicBoolean f1511fe = new AtomicBoolean(false);
    public static long qw = System.currentTimeMillis();

    /* renamed from: rg  reason: collision with root package name */
    public static int f1512rg = -1;

    static {
        new AtomicBoolean(false);
    }

    public static long ad() {
        return qw;
    }

    public static void de(Context context) {
        if (AppConfig.rg()) {
            IANRMonitor qw2 = qw.qw();
            "IANRMonitor = " + qw2.getClass().getSimpleName();
        }
        if (qw.qw() == qw.qw) {
            boolean rg2 = AppConfig.rg();
        } else if (!f1509ad.get() && qw.qw().qw()) {
            f1509ad.set(true);
            qw.qw().ad();
            th(context);
        }
    }

    public static void fe(Context context) {
        rg(context, 2000);
    }

    public static int qw() {
        return f1512rg;
    }

    public static void rg(Context context, int i2) {
        if (AppConfig.rg()) {
            ILooperMonitor qw2 = ad.qw();
            "iLooperMonitor = " + qw2.getClass().getSimpleName();
        }
        if (ad.qw() == ad.qw) {
            boolean rg2 = AppConfig.rg();
        } else if (!f1510de.get() && ad.qw().qw()) {
            f1510de.set(true);
            ad.qw().ad(context, i2);
            th(context);
        }
    }

    public static void th(Context context) {
        if (!f1511fe.getAndSet(true)) {
            Track.fe().uk(context);
        }
    }
}
