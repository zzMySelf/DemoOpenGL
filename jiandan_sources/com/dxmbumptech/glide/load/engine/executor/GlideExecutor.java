package com.dxmbumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.ubc.UBCManager;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class GlideExecutor implements ExecutorService {

    /* renamed from: th  reason: collision with root package name */
    public static final long f3854th = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: yj  reason: collision with root package name */
    public static volatile int f3855yj;

    /* renamed from: ad  reason: collision with root package name */
    public final ExecutorService f3856ad;

    public interface UncaughtThrowableStrategy {

        /* renamed from: ad  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f3857ad = qw;
        public static final UncaughtThrowableStrategy qw = new qw();

        public class qw implements UncaughtThrowableStrategy {
            public void qw(Throwable th2) {
                if (th2 != null) {
                    boolean isLoggable = Log.isLoggable("GlideExecutor", 6);
                }
            }
        }

        void qw(Throwable th2);
    }

    public static final class ad implements ThreadFactory {

        /* renamed from: ad  reason: collision with root package name */
        public final String f3858ad;

        /* renamed from: th  reason: collision with root package name */
        public final UncaughtThrowableStrategy f3859th;

        /* renamed from: uk  reason: collision with root package name */
        public int f3860uk;

        /* renamed from: yj  reason: collision with root package name */
        public final boolean f3861yj;

        public class qw extends Thread {
            public qw(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (ad.this.f3861yj) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th2) {
                    ad.this.f3859th.qw(th2);
                }
            }
        }

        public ad(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.f3858ad = str;
            this.f3859th = uncaughtThrowableStrategy;
            this.f3861yj = z;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            qw qwVar;
            qwVar = new qw(runnable, "glide-" + this.f3858ad + "-thread-" + this.f3860uk);
            this.f3860uk = this.f3860uk + 1;
            return qwVar;
        }
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public int f3863ad;

        /* renamed from: de  reason: collision with root package name */
        public int f3864de;
        @NonNull

        /* renamed from: fe  reason: collision with root package name */
        public UncaughtThrowableStrategy f3865fe = UncaughtThrowableStrategy.f3857ad;
        public final boolean qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f3866rg;

        /* renamed from: th  reason: collision with root package name */
        public long f3867th;

        public qw(boolean z) {
            this.qw = z;
        }

        public qw ad(String str) {
            this.f3866rg = str;
            return this;
        }

        public qw de(@IntRange(from = 1) int i2) {
            this.f3863ad = i2;
            this.f3864de = i2;
            return this;
        }

        public GlideExecutor qw() {
            if (!TextUtils.isEmpty(this.f3866rg)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f3863ad, this.f3864de, this.f3867th, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ad(this.f3866rg, this.f3865fe, this.qw));
                if (this.f3867th != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f3866rg);
        }
    }

    @VisibleForTesting
    public GlideExecutor(ExecutorService executorService) {
        this.f3856ad = executorService;
    }

    public static qw ad() {
        int i2 = qw() >= 4 ? 2 : 1;
        qw qwVar = new qw(true);
        qwVar.de(i2);
        qwVar.ad("animation");
        return qwVar;
    }

    public static GlideExecutor de() {
        return ad().qw();
    }

    public static qw fe() {
        qw qwVar = new qw(true);
        qwVar.de(1);
        qwVar.ad("disk-cache");
        return qwVar;
    }

    public static int qw() {
        if (f3855yj == 0) {
            f3855yj = Math.min(4, fe.uk.qw.pf.fe.qqq.qw.qw());
        }
        return f3855yj;
    }

    public static GlideExecutor rg() {
        return fe().qw();
    }

    public static qw th() {
        qw qwVar = new qw(false);
        qwVar.de(qw());
        qwVar.ad(UBCManager.CONTENT_KEY_SOURCE);
        return qwVar;
    }

    public static GlideExecutor uk() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f3854th, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ad("source-unlimited", UncaughtThrowableStrategy.f3857ad, false)));
    }

    public static GlideExecutor yj() {
        return th().qw();
    }

    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f3856ad.awaitTermination(j, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.f3856ad.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f3856ad.invokeAll(collection);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f3856ad.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f3856ad.isShutdown();
    }

    public boolean isTerminated() {
        return this.f3856ad.isTerminated();
    }

    public void shutdown() {
        this.f3856ad.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f3856ad.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f3856ad.submit(runnable);
    }

    public String toString() {
        return this.f3856ad.toString();
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f3856ad.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f3856ad.invokeAny(collection, j, timeUnit);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f3856ad.submit(runnable, t);
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f3856ad.submit(callable);
    }
}
