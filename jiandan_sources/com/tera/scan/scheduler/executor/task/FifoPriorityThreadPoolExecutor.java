package com.tera.scan.scheduler.executor.task;

import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tera.scan.scheduler.executor.job.Job;
import com.tera.scan.scheduler.executor.task.ThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {
    public static final RejectedExecutionHandler aaa = new de();
    public final AtomicInteger ddd;
    public ConcurrentHashMap<Integer, fe<?>> mmm;
    public final UncaughtThrowableStrategy nn;

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
        public int f7348ad = 0;

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
            String str = "netdisk-task-pool-thread-" + this.f7348ad;
            fe.mmm.qw.i.qw.uk("PriorityScheduler", "thread name = " + str);
            qw qwVar = new qw(this, runnable, str);
            this.f7348ad = this.f7348ad + 1;
            return qwVar;
        }
    }

    public static class de extends ThreadPoolExecutor.qw {
        public void qw(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            fe.mmm.qw.i.qw.uk("PriorityPoolExecutor", "rejectedExecution e = " + threadPoolExecutor.toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FifoPriorityThreadPoolExecutor(int i2) {
        this(i2, fe.mmm.qw.i.qw.o() ? UncaughtThrowableStrategy.THROW : UncaughtThrowableStrategy.LOG);
    }

    public void fe(Runnable runnable, Throwable th2) {
        super.fe(runnable, th2);
        fe.mmm.qw.i.qw.rg("PriorityPoolExecutor", "afterExecute ");
        if (runnable instanceof fe) {
            this.mmm.remove(Integer.valueOf(((fe) runnable).f7351th));
        }
        if (th2 == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    this.nn.handle(e);
                } catch (ExecutionException e2) {
                    this.nn.handle(e2);
                }
            }
        }
    }

    public ConcurrentHashMap<Integer, fe<?>> j() {
        return this.mmm;
    }

    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new fe(runnable, t, this.ddd.getAndIncrement());
    }

    public void th(Thread thread, Runnable runnable) {
        super.th(thread, runnable);
        fe.mmm.qw.i.qw.rg("PriorityPoolExecutor", "beforeExecute ");
        if (runnable instanceof fe) {
            fe feVar = (fe) runnable;
            this.mmm.put(Integer.valueOf(feVar.f7351th), feVar);
        }
    }

    public FifoPriorityThreadPoolExecutor(int i2, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(1, i2, 60, TimeUnit.SECONDS, new ad(), uncaughtThrowableStrategy);
    }

    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new fe(callable, this.ddd.getAndIncrement());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FifoPriorityThreadPoolExecutor(int i2, int i3, long j, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i2, i3, j, timeUnit, new TaskQueue(), threadFactory, aaa);
        this.ddd = new AtomicInteger();
        this.mmm = new ConcurrentHashMap<>();
        this.nn = uncaughtThrowableStrategy;
    }

    public static class fe<T> extends FutureTask<T> implements Comparable<fe<?>> {

        /* renamed from: ad  reason: collision with root package name */
        public final int f7349ad;

        /* renamed from: i  reason: collision with root package name */
        public Runnable f7350i;

        /* renamed from: th  reason: collision with root package name */
        public final int f7351th;

        /* renamed from: uk  reason: collision with root package name */
        public Callable<T> f7352uk;

        /* renamed from: yj  reason: collision with root package name */
        public final int f7353yj;

        public fe(Runnable runnable, T t, int i2) {
            super(runnable, t);
            if (runnable instanceof IPriority) {
                this.f7350i = runnable;
                this.f7349ad = ((IPriority) runnable).getPriority();
                this.f7353yj = ((ITaskModules) runnable).qw();
                this.f7351th = i2;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        }

        /* renamed from: ad */
        public int compareTo(@NonNull fe<?> feVar) {
            int i2 = feVar.f7349ad - this.f7349ad;
            if (i2 != 0) {
                return i2;
            }
            int i3 = feVar.f7353yj - this.f7353yj;
            return i3 == 0 ? this.f7351th - feVar.f7351th : i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof fe)) {
                return false;
            }
            fe feVar = (fe) obj;
            if (this.f7351th == feVar.f7351th && this.f7349ad == feVar.f7349ad) {
                return true;
            }
            return false;
        }

        public long fe() {
            Callable<T> callable = this.f7352uk;
            if (callable != null && (callable instanceof fe.mmm.qw.a.yj.de.ad)) {
                return ((fe.mmm.qw.a.yj.de.ad) callable).pf();
            }
            Runnable runnable = this.f7350i;
            if (runnable != null && (runnable instanceof fe.mmm.qw.a.yj.de.ad)) {
                return ((fe.mmm.qw.a.yj.de.ad) runnable).pf();
            }
            Callable<T> callable2 = this.f7352uk;
            if (callable2 != null && (callable2 instanceof fe.mmm.qw.a.yj.qw.qw)) {
                return ((fe.mmm.qw.a.yj.qw.qw) callable2).m958if();
            }
            Runnable runnable2 = this.f7350i;
            if (runnable2 == null || !(runnable2 instanceof fe.mmm.qw.a.yj.qw.qw)) {
                return 0;
            }
            return ((fe.mmm.qw.a.yj.qw.qw) runnable2).m958if();
        }

        public String getName() {
            Callable<T> callable = this.f7352uk;
            if (callable != null && (callable instanceof fe.mmm.qw.a.yj.de.ad)) {
                return ((fe.mmm.qw.a.yj.de.ad) callable).getName();
            }
            Runnable runnable = this.f7350i;
            if (runnable != null && (runnable instanceof fe.mmm.qw.a.yj.de.ad)) {
                return ((fe.mmm.qw.a.yj.de.ad) runnable).getName();
            }
            Callable<T> callable2 = this.f7352uk;
            if (callable2 != null && (callable2 instanceof fe.mmm.qw.a.yj.qw.qw)) {
                return ((Job) callable2).getName();
            }
            Runnable runnable2 = this.f7350i;
            return (runnable2 == null || !(runnable2 instanceof fe.mmm.qw.a.yj.qw.qw)) ? "" : ((Job) runnable2).getName();
        }

        public int hashCode() {
            return (this.f7349ad * 31) + this.f7351th;
        }

        public fe(Callable<T> callable, int i2) {
            super(callable);
            if (callable instanceof IPriority) {
                this.f7352uk = callable;
                this.f7349ad = ((IPriority) callable).getPriority();
                this.f7353yj = ((ITaskModules) callable).qw();
                this.f7351th = i2;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Callable that implement Prioritized");
        }
    }
}
