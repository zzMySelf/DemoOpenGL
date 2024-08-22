package com.tera.scan.scheduler.executor.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolExecutor extends AbstractExecutorService {
    public static final RuntimePermission xxx = new RuntimePermission("modifyThread");

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicInteger f7355ad = new AtomicInteger(o(-536870912, 0));
    public volatile int ggg;

    /* renamed from: i  reason: collision with root package name */
    public final Condition f7356i = this.f7361yj.newCondition();

    /* renamed from: if  reason: not valid java name */
    public volatile ThreadFactory f312if;

    /* renamed from: o  reason: collision with root package name */
    public int f7357o;

    /* renamed from: pf  reason: collision with root package name */
    public long f7358pf;
    public volatile boolean ppp;

    /* renamed from: switch  reason: not valid java name */
    public volatile RejectedExecutionHandler f313switch;

    /* renamed from: th  reason: collision with root package name */
    public final BlockingQueue<Runnable> f7359th;

    /* renamed from: uk  reason: collision with root package name */
    public final HashSet<Worker> f7360uk = new HashSet<>();
    public volatile int vvv;
    public volatile long when;

    /* renamed from: yj  reason: collision with root package name */
    public final ReentrantLock f7361yj = new ReentrantLock();

    public final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        public static final long serialVersionUID = 6138294804551838833L;
        public volatile long completedTasks;
        public Runnable firstTask;
        public final Thread thread;

        public Worker(Runnable runnable) {
            setState(-1);
            this.firstTask = runnable;
            this.thread = ThreadPoolExecutor.this.ddd().newThread(this);
        }

        public void interruptIfStarted() {
            Thread thread2;
            if (getState() >= 0 && (thread2 = this.thread) != null && !thread2.isInterrupted()) {
                try {
                    thread2.interrupt();
                } catch (SecurityException unused) {
                }
            }
        }

        public boolean isHeldExclusively() {
            return getState() != 0;
        }

        public boolean isLocked() {
            return isHeldExclusively();
        }

        public void lock() {
            acquire(1);
        }

        public void run() {
            ThreadPoolExecutor.this.e(this);
        }

        public boolean tryAcquire(int i2) {
            if (!compareAndSetState(0, 1)) {
                return false;
            }
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }

        public boolean tryLock() {
            return tryAcquire(1);
        }

        public boolean tryRelease(int i2) {
            setExclusiveOwnerThread((Thread) null);
            setState(0);
            return true;
        }

        public void unlock() {
            release(1);
        }
    }

    public static class qw implements RejectedExecutionHandler {
    }

    public ThreadPoolExecutor(int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        if (i2 < 0 || i3 <= 0 || i3 < i2 || j < 0) {
            throw new IllegalArgumentException();
        } else if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        } else {
            this.ggg = i2;
            this.vvv = i3;
            this.f7359th = blockingQueue;
            this.when = timeUnit.toNanos(j);
            this.f312if = threadFactory;
            this.f313switch = rejectedExecutionHandler;
        }
    }

    public static boolean b(int i2, int i3) {
        return i2 >= i3;
    }

    public static boolean c(int i2, int i3) {
        return i2 < i3;
    }

    public static int d(int i2) {
        return i2 & -536870912;
    }

    public static int h(int i2) {
        return i2 & 536870911;
    }

    public static int o(int i2, int i3) {
        return i2 | i3;
    }

    public static boolean qqq(int i2) {
        return i2 < 0;
    }

    public final void a(Runnable runnable) {
        this.f313switch.qw(runnable, this);
    }

    public final void aaa() {
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        try {
            Iterator<Worker> it = this.f7360uk.iterator();
            while (it.hasNext()) {
                it.next().interruptIfStarted();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void ad(Worker worker) {
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        if (worker != null) {
            try {
                this.f7360uk.remove(worker);
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
        pf();
        g();
        reentrantLock.unlock();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        while (true) {
            try {
                if (b(this.f7355ad.get(), 1610612736)) {
                    z = true;
                    break;
                } else if (nanos <= 0) {
                    z = false;
                    break;
                } else {
                    nanos = this.f7356i.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z;
    }

    public ThreadFactory ddd() {
        return this.f312if;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void de(int r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicInteger r0 = r3.f7355ad
            int r0 = r0.get()
            boolean r1 = b(r0, r4)
            if (r1 != 0) goto L_0x001c
            java.util.concurrent.atomic.AtomicInteger r1 = r3.f7355ad
            int r2 = h(r0)
            int r2 = o(r4, r2)
            boolean r0 = r1.compareAndSet(r0, r2)
            if (r0 == 0) goto L_0x0000
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scheduler.executor.task.ThreadPoolExecutor.de(int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Throwable} */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(com.tera.scan.scheduler.executor.task.ThreadPoolExecutor.Worker r8) {
        /*
            r7 = this;
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.Runnable r1 = r8.firstTask
            r2 = 0
            r8.firstTask = r2
            r8.unlock()
        L_0x000c:
            if (r1 != 0) goto L_0x001a
            java.lang.Runnable r1 = r7.xxx()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0015
            goto L_0x001a
        L_0x0015:
            r0 = 0
            r7.rrr(r8, r0)
            return
        L_0x001a:
            r8.lock()     // Catch:{ all -> 0x0075 }
            java.util.concurrent.atomic.AtomicInteger r3 = r7.f7355ad     // Catch:{ all -> 0x0075 }
            int r3 = r3.get()     // Catch:{ all -> 0x0075 }
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            boolean r3 = b(r3, r4)     // Catch:{ all -> 0x0075 }
            if (r3 != 0) goto L_0x003d
            boolean r3 = java.lang.Thread.interrupted()     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x0046
            java.util.concurrent.atomic.AtomicInteger r3 = r7.f7355ad     // Catch:{ all -> 0x0075 }
            int r3 = r3.get()     // Catch:{ all -> 0x0075 }
            boolean r3 = b(r3, r4)     // Catch:{ all -> 0x0075 }
            if (r3 == 0) goto L_0x0046
        L_0x003d:
            boolean r3 = r0.isInterrupted()     // Catch:{ all -> 0x0075 }
            if (r3 != 0) goto L_0x0046
            r0.interrupt()     // Catch:{ all -> 0x0075 }
        L_0x0046:
            r3 = 1
            r7.th(r0, r1)     // Catch:{ all -> 0x006b }
            r1.run()     // Catch:{ RuntimeException -> 0x0064, Error -> 0x0062, all -> 0x005b }
            r7.fe(r1, r2)     // Catch:{ all -> 0x006b }
            long r5 = r8.completedTasks     // Catch:{ all -> 0x0075 }
            long r5 = r5 + r3
            r8.completedTasks = r5     // Catch:{ all -> 0x0075 }
            r8.unlock()     // Catch:{ all -> 0x0075 }
            r1 = r2
            goto L_0x000c
        L_0x005b:
            r0 = move-exception
            java.lang.Error r2 = new java.lang.Error     // Catch:{ all -> 0x0066 }
            r2.<init>(r0)     // Catch:{ all -> 0x0066 }
            throw r2     // Catch:{ all -> 0x0066 }
        L_0x0062:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0064:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r2 = move-exception
            r7.fe(r1, r0)     // Catch:{ all -> 0x006b }
            throw r2     // Catch:{ all -> 0x006b }
        L_0x006b:
            r0 = move-exception
            long r1 = r8.completedTasks     // Catch:{ all -> 0x0075 }
            long r1 = r1 + r3
            r8.completedTasks = r1     // Catch:{ all -> 0x0075 }
            r8.unlock()     // Catch:{ all -> 0x0075 }
            throw r0     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r0 = move-exception
            r1 = 1
            r7.rrr(r8, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scheduler.executor.task.ThreadPoolExecutor.e(com.tera.scan.scheduler.executor.task.ThreadPoolExecutor$Worker):void");
    }

    public void eee() {
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            int h = h(this.f7355ad.get());
            fe.mmm.qw.i.qw.ad("ThreadPoolExecutor", "current size " + h);
            if (h - m920switch() > 0) {
                tt(runnable);
            } else if (h >= this.vvv) {
                tt(runnable);
            } else if (!qw(runnable, false)) {
                tt(runnable);
            }
        } else {
            throw null;
        }
    }

    public void f() {
    }

    public void fe(Runnable runnable, Throwable th2) {
    }

    public final void g() {
        while (true) {
            int i2 = this.f7355ad.get();
            if (!qqq(i2) && !b(i2, 1073741824)) {
                if (d(i2) == 0 && !this.f7359th.isEmpty()) {
                    return;
                }
                if (h(i2) != 0) {
                    mmm(true);
                    return;
                }
                ReentrantLock reentrantLock = this.f7361yj;
                reentrantLock.lock();
                try {
                    if (this.f7355ad.compareAndSet(i2, o(1073741824, 0))) {
                        f();
                        this.f7355ad.set(o(1610612736, 0));
                        this.f7356i.signalAll();
                        reentrantLock.unlock();
                        return;
                    }
                    reentrantLock.unlock();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            } else {
                return;
            }
        }
    }

    public int ggg() {
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        try {
            return this.f7357o;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean i(int i2) {
        return this.f7355ad.compareAndSet(i2, i2 + 1);
    }

    /* renamed from: if  reason: not valid java name */
    public final List<Runnable> m919if() {
        BlockingQueue<Runnable> blockingQueue = this.f7359th;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    arrayList.add(runnable);
                }
            }
        }
        return arrayList;
    }

    public boolean isShutdown() {
        return !qqq(this.f7355ad.get());
    }

    public boolean isTerminated() {
        return b(this.f7355ad.get(), 1610612736);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mmm(boolean r6) {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.f7361yj
            r0.lock()
            java.util.HashSet<com.tera.scan.scheduler.executor.task.ThreadPoolExecutor$Worker> r1 = r5.f7360uk     // Catch:{ all -> 0x0037 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0037 }
        L_0x000b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0037 }
            com.tera.scan.scheduler.executor.task.ThreadPoolExecutor$Worker r2 = (com.tera.scan.scheduler.executor.task.ThreadPoolExecutor.Worker) r2     // Catch:{ all -> 0x0037 }
            java.lang.Thread r3 = r2.thread     // Catch:{ all -> 0x0037 }
            boolean r4 = r3.isInterrupted()     // Catch:{ all -> 0x0037 }
            if (r4 != 0) goto L_0x0031
            boolean r4 = r2.tryLock()     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x0031
            r3.interrupt()     // Catch:{ SecurityException -> 0x0028, all -> 0x002c }
        L_0x0028:
            r2.unlock()     // Catch:{ all -> 0x0037 }
            goto L_0x0031
        L_0x002c:
            r6 = move-exception
            r2.unlock()     // Catch:{ all -> 0x0037 }
            throw r6     // Catch:{ all -> 0x0037 }
        L_0x0031:
            if (r6 == 0) goto L_0x000b
        L_0x0033:
            r0.unlock()
            return
        L_0x0037:
            r6 = move-exception
            r0.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scheduler.executor.task.ThreadPoolExecutor.mmm(boolean):void");
    }

    public final void nn() {
        mmm(false);
    }

    public final void pf() {
        do {
        } while (!uk(this.f7355ad.get()));
    }

    public int ppp() {
        return this.ggg;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a0, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0074 A[Catch:{ all -> 0x007f, all -> 0x008a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean qw(java.lang.Runnable r6, boolean r7) {
        /*
            r5 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f7355ad
            int r0 = r0.get()
            int r1 = d(r0)
            r2 = 0
            if (r1 < 0) goto L_0x001a
            if (r1 != 0) goto L_0x0019
            if (r6 != 0) goto L_0x0019
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r3 = r5.f7359th
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x001a
        L_0x0019:
            return r2
        L_0x001a:
            int r3 = h(r0)
            r4 = 536870911(0x1fffffff, float:1.0842021E-19)
            if (r3 >= r4) goto L_0x00a0
            if (r7 == 0) goto L_0x0028
            int r4 = r5.ggg
            goto L_0x002a
        L_0x0028:
            int r4 = r5.vvv
        L_0x002a:
            if (r3 < r4) goto L_0x002e
            goto L_0x00a0
        L_0x002e:
            boolean r0 = r5.i(r0)
            if (r0 == 0) goto L_0x0092
            r7 = 0
            com.tera.scan.scheduler.executor.task.ThreadPoolExecutor$Worker r0 = new com.tera.scan.scheduler.executor.task.ThreadPoolExecutor$Worker     // Catch:{ all -> 0x008d }
            r0.<init>(r6)     // Catch:{ all -> 0x008d }
            java.lang.Thread r7 = r0.thread     // Catch:{ all -> 0x008a }
            r1 = 1
            if (r7 == 0) goto L_0x0084
            java.util.concurrent.locks.ReentrantLock r3 = r5.f7361yj     // Catch:{ all -> 0x008a }
            r3.lock()     // Catch:{ all -> 0x008a }
            java.util.concurrent.atomic.AtomicInteger r4 = r5.f7355ad     // Catch:{ all -> 0x007f }
            int r4 = r4.get()     // Catch:{ all -> 0x007f }
            int r4 = d(r4)     // Catch:{ all -> 0x007f }
            if (r4 < 0) goto L_0x0057
            if (r4 != 0) goto L_0x0055
            if (r6 != 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r6 = 0
            goto L_0x006f
        L_0x0057:
            boolean r6 = r7.isAlive()     // Catch:{ all -> 0x007f }
            if (r6 != 0) goto L_0x0079
            java.util.HashSet<com.tera.scan.scheduler.executor.task.ThreadPoolExecutor$Worker> r6 = r5.f7360uk     // Catch:{ all -> 0x007f }
            r6.add(r0)     // Catch:{ all -> 0x007f }
            java.util.HashSet<com.tera.scan.scheduler.executor.task.ThreadPoolExecutor$Worker> r6 = r5.f7360uk     // Catch:{ all -> 0x007f }
            int r6 = r6.size()     // Catch:{ all -> 0x007f }
            int r4 = r5.f7357o     // Catch:{ all -> 0x007f }
            if (r6 <= r4) goto L_0x006e
            r5.f7357o = r6     // Catch:{ all -> 0x007f }
        L_0x006e:
            r6 = 1
        L_0x006f:
            r3.unlock()     // Catch:{ all -> 0x008a }
            if (r6 == 0) goto L_0x0084
            r7.start()     // Catch:{ all -> 0x008a }
            r2 = 1
            goto L_0x0084
        L_0x0079:
            java.lang.IllegalThreadStateException r6 = new java.lang.IllegalThreadStateException     // Catch:{ all -> 0x007f }
            r6.<init>()     // Catch:{ all -> 0x007f }
            throw r6     // Catch:{ all -> 0x007f }
        L_0x007f:
            r6 = move-exception
            r3.unlock()     // Catch:{ all -> 0x008a }
            throw r6     // Catch:{ all -> 0x008a }
        L_0x0084:
            if (r2 != 0) goto L_0x0089
            r5.ad(r0)
        L_0x0089:
            return r2
        L_0x008a:
            r6 = move-exception
            r7 = r0
            goto L_0x008e
        L_0x008d:
            r6 = move-exception
        L_0x008e:
            r5.ad(r7)
            throw r6
        L_0x0092:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.f7355ad
            int r0 = r0.get()
            int r3 = d(r0)
            if (r3 == r1) goto L_0x001a
            goto L_0x0000
        L_0x00a0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scheduler.executor.task.ThreadPoolExecutor.qw(java.lang.Runnable, boolean):boolean");
    }

    public void rg(boolean z) {
        if (z && this.when <= 0) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        } else if (z != this.ppp) {
            this.ppp = z;
            if (z) {
                nn();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void rrr(Worker worker, boolean z) {
        if (z) {
            pf();
        }
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        try {
            this.f7358pf += worker.completedTasks;
            this.f7360uk.remove(worker);
            reentrantLock.unlock();
            g();
            int i2 = this.f7355ad.get();
            if (c(i2, 536870912)) {
                if (!z) {
                    int i3 = this.ppp ? 0 : this.ggg;
                    if (i3 == 0 && !this.f7359th.isEmpty()) {
                        i3 = 1;
                    }
                    if (h(i2) >= i3) {
                        return;
                    }
                }
                qw((Runnable) null, false);
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public void shutdown() {
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        try {
            yj();
            de(0);
            nn();
            eee();
            reentrantLock.unlock();
            g();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        try {
            yj();
            de(536870912);
            aaa();
            List<Runnable> list = m919if();
            reentrantLock.unlock();
            g();
            return list;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public int m920switch() {
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        int i2 = 0;
        try {
            Iterator<Worker> it = this.f7360uk.iterator();
            while (it.hasNext()) {
                if (it.next().isLocked()) {
                    i2++;
                }
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void th(Thread thread, Runnable runnable) {
    }

    /* JADX INFO: finally extract failed */
    public String toString() {
        String str;
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        try {
            long j = this.f7358pf;
            int size = this.f7360uk.size();
            Iterator<Worker> it = this.f7360uk.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Worker next = it.next();
                j += next.completedTasks;
                if (next.isLocked()) {
                    i2++;
                }
            }
            reentrantLock.unlock();
            int i3 = this.f7355ad.get();
            if (c(i3, 0)) {
                str = "Running";
            } else {
                str = b(i3, 1610612736) ? "Terminated" : "Shutting down";
            }
            return super.toString() + "[" + str + ", pool size = " + size + ", active threads = " + i2 + ", queued tasks = " + this.f7359th.size() + ", completed tasks = " + j + "]";
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final void tt(Runnable runnable) {
        int i2 = this.f7355ad.get();
        if (!qqq(i2)) {
            a(runnable);
        } else if (this.f7359th.offer(runnable)) {
            if (h(i2) == 0) {
                qw((Runnable) null, false);
            }
        } else if (!qw(runnable, false)) {
            a(runnable);
        }
    }

    public final boolean uk(int i2) {
        return this.f7355ad.compareAndSet(i2, i2 - 1);
    }

    public BlockingQueue<Runnable> vvv() {
        return this.f7359th;
    }

    public long when() {
        ReentrantLock reentrantLock = this.f7361yj;
        reentrantLock.lock();
        try {
            long j = this.f7358pf;
            Iterator<Worker> it = this.f7360uk.iterator();
            while (it.hasNext()) {
                j += it.next().completedTasks;
            }
            return j;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Runnable xxx() {
        Runnable runnable;
        loop0:
        while (true) {
            boolean z = false;
            while (true) {
                int i2 = this.f7355ad.get();
                int d = d(i2);
                if (d < 0 || (d < 536870912 && !this.f7359th.isEmpty())) {
                    int h = h(i2);
                    boolean z2 = this.ppp || h > this.ggg;
                    if ((h <= this.vvv && (!z2 || !z)) || (h <= 1 && !this.f7359th.isEmpty())) {
                        if (z2) {
                            try {
                                runnable = this.f7359th.poll(this.when, TimeUnit.NANOSECONDS);
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            runnable = this.f7359th.take();
                        }
                        if (runnable != null) {
                            return runnable;
                        }
                        z = true;
                    } else if (uk(i2)) {
                        return null;
                    }
                }
            }
        }
        pf();
        return null;
    }

    public final void yj() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(xxx);
            ReentrantLock reentrantLock = this.f7361yj;
            reentrantLock.lock();
            try {
                Iterator<Worker> it = this.f7360uk.iterator();
                while (it.hasNext()) {
                    securityManager.checkAccess(it.next().thread);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
