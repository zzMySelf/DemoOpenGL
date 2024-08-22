package fe.ad.qw.qw.de;

import com.alibaba.android.arouter.facade.template.ILogger;
import fe.ad.qw.qw.fe.rg;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ad extends ThreadPoolExecutor {

    /* renamed from: ad  reason: collision with root package name */
    public static final int f1187ad;

    /* renamed from: th  reason: collision with root package name */
    public static final int f1188th;

    /* renamed from: uk  reason: collision with root package name */
    public static volatile ad f1189uk;

    /* renamed from: yj  reason: collision with root package name */
    public static final int f1190yj;

    public class qw implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            fe.ad.qw.qw.ad.qw.f1186de.error(ILogger.defaultTag, "Task rejected, too many task!");
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f1187ad = availableProcessors;
        int i2 = availableProcessors + 1;
        f1188th = i2;
        f1190yj = i2;
    }

    public ad(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i2, i3, j, timeUnit, blockingQueue, threadFactory, new qw());
    }

    public static ad qw() {
        if (f1189uk == null) {
            synchronized (ad.class) {
                if (f1189uk == null) {
                    f1189uk = new ad(f1188th, f1190yj, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new de());
                }
            }
        }
        return f1189uk;
    }

    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        if (th2 == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (CancellationException e) {
                th2 = e;
            } catch (ExecutionException e2) {
                th2 = e2.getCause();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (th2 != null) {
            ILogger iLogger = fe.ad.qw.qw.ad.qw.f1186de;
            iLogger.warning(ILogger.defaultTag, "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th2.getMessage() + "]\n" + rg.qw(th2.getStackTrace()));
        }
    }
}
