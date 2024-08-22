package th.de.p039if.th;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: th.de.if.th.th  reason: invalid package */
public final class th {

    /* renamed from: ad  reason: collision with root package name */
    public static final int f10965ad;

    /* renamed from: de  reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f10966de = new AtomicReference<>();

    /* renamed from: fe  reason: collision with root package name */
    public static final Map<ScheduledThreadPoolExecutor, Object> f10967fe = new ConcurrentHashMap();
    public static final boolean qw;

    /* renamed from: th.de.if.th.th$ad */
    public static final class ad implements Runnable {
        public void run() {
            Iterator it = new ArrayList(th.f10967fe.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    th.f10967fe.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* renamed from: th.de.if.th.th$qw */
    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f10968ad;
        public boolean qw;

        public void qw(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.qw = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.qw = true;
            }
            if (!this.qw || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f10968ad = 1;
                return;
            }
            try {
                this.f10968ad = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f10968ad = 1;
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        qw qwVar = new qw();
        qwVar.qw(properties);
        qw = qwVar.qw;
        f10965ad = qwVar.f10968ad;
        ad();
    }

    public static void ad() {
        fe(qw);
    }

    public static void de(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f10967fe.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void fe(boolean z) {
        if (z) {
            while (true) {
                ScheduledExecutorService scheduledExecutorService = f10966de.get();
                if (scheduledExecutorService == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
                    if (f10966de.compareAndSet(scheduledExecutorService, newScheduledThreadPool)) {
                        ad adVar = new ad();
                        int i2 = f10965ad;
                        newScheduledThreadPool.scheduleAtFixedRate(adVar, (long) i2, (long) i2, TimeUnit.SECONDS);
                        return;
                    }
                    newScheduledThreadPool.shutdownNow();
                } else {
                    return;
                }
            }
        }
    }

    public static ScheduledExecutorService qw(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        de(qw, newScheduledThreadPool);
        return newScheduledThreadPool;
    }
}
