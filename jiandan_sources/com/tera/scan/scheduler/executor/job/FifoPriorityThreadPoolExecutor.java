package com.tera.scan.scheduler.executor.job;

import android.os.Process;
import android.util.Log;
import com.tera.scan.scheduler.executor.task.IPriority;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {

    /* renamed from: uk  reason: collision with root package name */
    public static final RejectedExecutionHandler f7339uk = new de();

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicInteger f7340ad;

    /* renamed from: th  reason: collision with root package name */
    public final UncaughtThrowableStrategy f7341th;

    /* renamed from: yj  reason: collision with root package name */
    public ConcurrentHashMap<Integer, fe<?>> f7342yj;

    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG {
            public void handle(Throwable th2) {
                boolean isLoggable = Log.isLoggable("PriorityPoolExecutor", 6);
            }
        },
        THROW {
            public void handle(Throwable th2) {
                super.handle(th2);
                throw new RuntimeException(th2);
            }
        };

        public void handle(Throwable th2) {
        }
    }

    public static class ad implements ThreadFactory {

        /* renamed from: ad  reason: collision with root package name */
        public int f7343ad = 0;

        public class qw extends Thread {
            public qw(ad adVar, Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        public Thread newThread(Runnable runnable) {
            String str = "netdisk-job-pool-thread-" + this.f7343ad;
            fe.mmm.qw.i.qw.uk("PriorityScheduler", "thread name = " + str);
            qw qwVar = new qw(this, runnable, str);
            this.f7343ad = this.f7343ad + 1;
            return qwVar;
        }
    }

    public static class de extends ThreadPoolExecutor.AbortPolicy {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            fe.mmm.qw.i.qw.uk("PriorityPoolExecutor", "rejectedExecution e = " + threadPoolExecutor.toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FifoPriorityThreadPoolExecutor(int i2) {
        this(i2, fe.mmm.qw.i.qw.o() ? UncaughtThrowableStrategy.THROW : UncaughtThrowableStrategy.LOG);
    }

    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        if (runnable instanceof fe) {
            this.f7342yj.remove(Integer.valueOf(((fe) runnable).f7345th));
        }
        fe.mmm.qw.i.qw.ad("PriorityPoolExecutor", "afterExecute");
        if (th2 == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    this.f7341th.handle(e);
                } catch (ExecutionException e2) {
                    this.f7341th.handle(e2);
                }
            }
        }
    }

    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable instanceof fe) {
            fe feVar = (fe) runnable;
            this.f7342yj.put(Integer.valueOf(feVar.f7345th), feVar);
        }
        fe.mmm.qw.i.qw.ad("PriorityPoolExecutor", "beforeExecute");
    }

    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new fe(runnable, t, this.f7340ad.getAndIncrement());
    }

    public ConcurrentHashMap<Integer, fe<?>> qw() {
        return this.f7342yj;
    }

    public FifoPriorityThreadPoolExecutor(int i2, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(i2, i2, 0, TimeUnit.MILLISECONDS, new ad(), uncaughtThrowableStrategy);
    }

    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new fe(callable, this.f7340ad.getAndIncrement());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FifoPriorityThreadPoolExecutor(int i2, int i3, long j, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i2, i3, j, timeUnit, new PriorityBlockingQueue(), threadFactory, f7339uk);
        this.f7340ad = new AtomicInteger();
        this.f7342yj = new ConcurrentHashMap<>();
        this.f7341th = uncaughtThrowableStrategy;
    }

    public static class fe<T> extends FutureTask<T> implements Comparable<fe<?>> {

        /* renamed from: ad  reason: collision with root package name */
        public final int f7344ad;

        /* renamed from: th  reason: collision with root package name */
        public final int f7345th;

        /* renamed from: uk  reason: collision with root package name */
        public Runnable f7346uk;

        /* renamed from: yj  reason: collision with root package name */
        public Callable<T> f7347yj;

        public fe(Runnable runnable, T t, int i2) {
            super(runnable, t);
            if (runnable instanceof IPriority) {
                this.f7346uk = runnable;
                this.f7344ad = ((IPriority) runnable).getPriority();
                this.f7345th = i2;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        }

        /* renamed from: ad */
        public int compareTo(fe<?> feVar) {
            int i2 = feVar.f7344ad - this.f7344ad;
            return i2 == 0 ? this.f7345th - feVar.f7345th : i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof fe)) {
                return false;
            }
            fe feVar = (fe) obj;
            if (this.f7345th == feVar.f7345th && this.f7344ad == feVar.f7344ad) {
                return true;
            }
            return false;
        }

        public long fe() {
            Callable<T> callable = this.f7347yj;
            if (callable != null && (callable instanceof fe.mmm.qw.a.yj.de.ad)) {
                return ((fe.mmm.qw.a.yj.de.ad) callable).pf();
            }
            Runnable runnable = this.f7346uk;
            if (runnable != null && (runnable instanceof fe.mmm.qw.a.yj.de.ad)) {
                return ((fe.mmm.qw.a.yj.de.ad) runnable).pf();
            }
            Callable<T> callable2 = this.f7347yj;
            if (callable2 != null && (callable2 instanceof fe.mmm.qw.a.yj.qw.qw)) {
                return ((fe.mmm.qw.a.yj.qw.qw) callable2).m958if();
            }
            Runnable runnable2 = this.f7346uk;
            if (runnable2 == null || !(runnable2 instanceof fe.mmm.qw.a.yj.qw.qw)) {
                return 0;
            }
            return ((fe.mmm.qw.a.yj.qw.qw) runnable2).m958if();
        }

        public String getName() {
            Callable<T> callable = this.f7347yj;
            if (callable != null && (callable instanceof Job)) {
                return ((Job) callable).getName();
            }
            Runnable runnable = this.f7346uk;
            if (runnable != null && (runnable instanceof Job)) {
                return ((Job) runnable).getName();
            }
            Callable<T> callable2 = this.f7347yj;
            if (callable2 != null && (callable2 instanceof fe.mmm.qw.a.yj.de.ad)) {
                return ((fe.mmm.qw.a.yj.de.ad) callable2).getName();
            }
            Runnable runnable2 = this.f7346uk;
            return (runnable2 == null || !(runnable2 instanceof fe.mmm.qw.a.yj.de.ad)) ? "" : ((fe.mmm.qw.a.yj.de.ad) runnable2).getName();
        }

        public int hashCode() {
            return (this.f7344ad * 31) + this.f7345th;
        }

        public fe(Callable<T> callable, int i2) {
            super(callable);
            if (callable instanceof Prioritized) {
                this.f7347yj = callable;
                this.f7344ad = ((Prioritized) callable).getPriority();
                this.f7345th = i2;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Callable that implement Prioritized");
        }
    }
}
