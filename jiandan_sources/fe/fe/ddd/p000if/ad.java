package fe.fe.ddd.p000if;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: fe.fe.ddd.if.ad  reason: invalid package */
public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile ad f1460ad;
    public ScheduledExecutorService qw = Executors.newScheduledThreadPool(15);

    public ad() {
        Executors.newSingleThreadScheduledExecutor();
    }

    public static ad qw() {
        if (f1460ad == null) {
            synchronized (ad.class) {
                if (f1460ad == null) {
                    f1460ad = new ad();
                }
            }
        }
        return f1460ad;
    }

    public Executor ad() {
        return this.qw;
    }

    public void de(Runnable runnable, long j) {
        this.qw.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
