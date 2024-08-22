package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
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
    public static final long f3689th = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: yj  reason: collision with root package name */
    public static volatile int f3690yj;

    /* renamed from: ad  reason: collision with root package name */
    public final ExecutorService f3691ad;

    public interface UncaughtThrowableStrategy {

        /* renamed from: ad  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f3692ad = qw;
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

    public static final class qw implements ThreadFactory {

        /* renamed from: ad  reason: collision with root package name */
        public final String f3693ad;

        /* renamed from: th  reason: collision with root package name */
        public final UncaughtThrowableStrategy f3694th;

        /* renamed from: uk  reason: collision with root package name */
        public int f3695uk;

        /* renamed from: yj  reason: collision with root package name */
        public final boolean f3696yj;

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$qw$qw  reason: collision with other inner class name */
        public class C0175qw extends Thread {
            public C0175qw(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(9);
                if (qw.this.f3696yj) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th2) {
                    qw.this.f3694th.qw(th2);
                }
            }
        }

        public qw(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.f3693ad = str;
            this.f3694th = uncaughtThrowableStrategy;
            this.f3696yj = z;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0175qw qwVar;
            qwVar = new C0175qw(runnable, "glide-" + this.f3693ad + "-thread-" + this.f3695uk);
            this.f3695uk = this.f3695uk + 1;
            return qwVar;
        }
    }

    @VisibleForTesting
    public GlideExecutor(ExecutorService executorService) {
        this.f3691ad = executorService;
    }

    public static GlideExecutor ad() {
        return de(qw() >= 4 ? 2 : 1, UncaughtThrowableStrategy.f3692ad);
    }

    public static GlideExecutor de(int i2, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(0, i2, f3689th, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new qw("animation", uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor fe() {
        return rg(1, "disk-cache", UncaughtThrowableStrategy.f3692ad);
    }

    public static int qw() {
        if (f3690yj == 0) {
            f3690yj = Math.min(4, fe.rg.qw.o.fe.qqq.qw.qw());
        }
        return f3690yj;
    }

    public static GlideExecutor rg(int i2, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new qw(str, uncaughtThrowableStrategy, true)));
    }

    public static GlideExecutor th() {
        return yj(qw(), UBCManager.CONTENT_KEY_SOURCE, UncaughtThrowableStrategy.f3692ad);
    }

    public static GlideExecutor uk() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f3689th, TimeUnit.MILLISECONDS, new SynchronousQueue(), new qw("source-unlimited", UncaughtThrowableStrategy.f3692ad, false)));
    }

    public static GlideExecutor yj(int i2, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new qw(str, uncaughtThrowableStrategy, false)));
    }

    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f3691ad.awaitTermination(j, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.f3691ad.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f3691ad.invokeAll(collection);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.f3691ad.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.f3691ad.isShutdown();
    }

    public boolean isTerminated() {
        return this.f3691ad.isTerminated();
    }

    public void shutdown() {
        this.f3691ad.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f3691ad.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f3691ad.submit(runnable);
    }

    public String toString() {
        return this.f3691ad.toString();
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f3691ad.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f3691ad.invokeAny(collection, j, timeUnit);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f3691ad.submit(runnable, t);
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f3691ad.submit(callable);
    }
}
