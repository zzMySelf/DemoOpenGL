package fe.fe.ddd.xxx;

import android.text.TextUtils;
import com.baidu.searchbox.requestpriority.IRequestCall;
import com.baidu.searchbox.requestpriority.IRequestPriorityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f1733ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static String f1734de = null;

    /* renamed from: fe  reason: collision with root package name */
    public static volatile List<Runnable> f1735fe = new ArrayList();
    public static int qw = -1;

    /* renamed from: rg  reason: collision with root package name */
    public static volatile int f1736rg = 0;

    /* renamed from: th  reason: collision with root package name */
    public static volatile ScheduledExecutorService f1737th;

    /* renamed from: yj  reason: collision with root package name */
    public static volatile Set<Integer> f1738yj = new HashSet();

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ IRequestCall f1739ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Object f1740th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Object f1741yj;

        public ad(IRequestCall iRequestCall, Object obj, Object obj2) {
            this.f1739ad = iRequestCall;
            this.f1740th = obj;
            this.f1741yj = obj2;
        }

        public void run() {
            this.f1739ad.ad(this.f1740th, this.f1741yj);
        }
    }

    /* renamed from: fe.fe.ddd.xxx.de$de  reason: collision with other inner class name */
    public class C0096de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ IRequestCall f1742ad;

        public C0096de(IRequestCall iRequestCall) {
            this.f1742ad = iRequestCall;
        }

        public void run() {
            if (!this.f1742ad.qw()) {
                synchronized (IRequestCall.class) {
                    de.f1738yj.add(Integer.valueOf(this.f1742ad.hashCode()));
                    if (de.f1736rg > 0) {
                        de.de();
                    }
                }
                de.o();
            }
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f1743ad;

        public qw(CountDownLatch countDownLatch) {
            this.f1743ad = countDownLatch;
        }

        public void run() {
            this.f1743ad.countDown();
        }
    }

    public static /* synthetic */ int de() {
        int i2 = f1736rg;
        f1736rg = i2 - 1;
        return i2;
    }

    public static boolean i() {
        qw qw2;
        if (qw == -1) {
            qw = 1;
            IRequestPriorityManager qw3 = ad.qw();
            if (qw3 == null || (qw2 = qw3.qw()) == null) {
                return false;
            }
            String qw4 = qw2.qw();
            f1734de = qw4;
            f1733ad = true ^ TextUtils.isEmpty(qw4);
        }
        return f1733ad;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m92if(IRequestCall iRequestCall) {
        synchronized (IRequestCall.class) {
            f1736rg++;
        }
        m93switch().schedule(new C0096de(iRequestCall), 4000, TimeUnit.MILLISECONDS);
    }

    public static void o() {
        synchronized (f1735fe) {
            int size = f1735fe.size();
            for (int i2 = 0; i2 < size; i2++) {
                f1735fe.get(i2).run();
            }
            f1735fe.clear();
        }
    }

    public static void pf(IRequestCall iRequestCall) {
        if (i() && uk(iRequestCall)) {
            synchronized (IRequestCall.class) {
                if (f1738yj.contains(Integer.valueOf(iRequestCall.hashCode()))) {
                    f1738yj.remove(Integer.valueOf(iRequestCall.hashCode()));
                } else if (f1736rg > 0) {
                    f1736rg--;
                }
            }
            if (f1736rg <= 0) {
                o();
            }
        }
    }

    public static void rg(Runnable runnable) {
        synchronized (f1735fe) {
            f1735fe.add(runnable);
        }
        if (f1736rg <= 0) {
            o();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static ScheduledExecutorService m93switch() {
        if (f1737th == null) {
            synchronized (de.class) {
                if (f1737th == null) {
                    f1737th = new ScheduledThreadPoolExecutor(1);
                }
            }
        }
        return f1737th;
    }

    public static <T> void th(IRequestCall iRequestCall, T t, T t2) {
        if (uk(iRequestCall)) {
            m92if(iRequestCall);
            iRequestCall.ad(t, t2);
        } else if (f1736rg > 0) {
            rg(new ad(iRequestCall, t, t2));
        } else {
            iRequestCall.ad(t, t2);
        }
    }

    public static boolean uk(IRequestCall iRequestCall) {
        return f1734de.contains(iRequestCall.rg() + "|" + iRequestCall.de());
    }

    public static Object yj(IRequestCall iRequestCall) throws Exception {
        if (uk(iRequestCall)) {
            m92if(iRequestCall);
        } else if (f1736rg > 0) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            rg(new qw(countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return iRequestCall.fe();
    }
}
