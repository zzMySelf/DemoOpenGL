package fe.mmm.qw.c;

import android.os.Process;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static final int f7654ad;

    /* renamed from: de  reason: collision with root package name */
    public static final int f7655de;

    /* renamed from: fe  reason: collision with root package name */
    public static final int f7656fe;
    public ThreadPoolExecutor qw;

    public static class ad {
        public static fe qw = new fe((qw) null);
    }

    public class qw implements ThreadFactory {

        /* renamed from: ad  reason: collision with root package name */
        public final AtomicInteger f7657ad = new AtomicInteger(0);

        /* renamed from: fe.mmm.qw.c.fe$qw$qw  reason: collision with other inner class name */
        public class C0274qw extends Thread {
            public C0274qw(qw qwVar, Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        public qw(fe feVar) {
        }

        public Thread newThread(Runnable runnable) {
            return new C0274qw(this, runnable, "startup-task-thread-" + this.f7657ad.getAndIncrement());
        }
    }

    static {
        int max = (int) Math.max(3.0f, (((float) Runtime.getRuntime().availableProcessors()) * 1.5f) + 1.0f);
        f7654ad = max;
        int max2 = Math.max(1, (int) ((((float) max) * 1.0f) / 4.0f));
        f7655de = max2;
        f7656fe = f7654ad - max2;
    }

    public /* synthetic */ fe(qw qwVar) {
        this();
    }

    public static fe qw() {
        return ad.qw;
    }

    public ThreadPoolExecutor ad() {
        return this.qw;
    }

    public fe() {
        int i2 = f7656fe;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2 + 4, 40, TimeUnit.SECONDS, new LinkedBlockingQueue(), new qw(this));
        this.qw = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
