package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
public final class MoreExecutors {

    @GwtIncompatible
    public static final class DirectExecutorService extends AbstractListeningExecutorService {
        public final Object lock;
        @GuardedBy("lock")
        public int runningTasks;
        @GuardedBy("lock")
        public boolean shutdown;

        public DirectExecutorService() {
            this.lock = new Object();
            this.runningTasks = 0;
            this.shutdown = false;
        }

        private void endTask() {
            synchronized (this.lock) {
                int i2 = this.runningTasks - 1;
                this.runningTasks = i2;
                if (i2 == 0) {
                    this.lock.notifyAll();
                }
            }
        }

        private void startTask() {
            synchronized (this.lock) {
                if (!this.shutdown) {
                    this.runningTasks++;
                } else {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
            }
        }

        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j);
            synchronized (this.lock) {
                while (true) {
                    if (this.shutdown && this.runningTasks == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long nanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.lock, nanos);
                    nanos -= System.nanoTime() - nanoTime;
                }
            }
        }

        public void execute(Runnable runnable) {
            startTask();
            try {
                runnable.run();
            } finally {
                endTask();
            }
        }

        public boolean isShutdown() {
            boolean z;
            synchronized (this.lock) {
                z = this.shutdown;
            }
            return z;
        }

        public boolean isTerminated() {
            boolean z;
            synchronized (this.lock) {
                z = this.shutdown && this.runningTasks == 0;
            }
            return z;
        }

        public void shutdown() {
            synchronized (this.lock) {
                this.shutdown = true;
                if (this.runningTasks == 0) {
                    this.lock.notifyAll();
                }
            }
        }

        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }
    }

    @GwtIncompatible
    public static class ListeningDecorator extends AbstractListeningExecutorService {
        public final ExecutorService delegate;

        public ListeningDecorator(ExecutorService executorService) {
            this.delegate = (ExecutorService) Preconditions.checkNotNull(executorService);
        }

        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.delegate.awaitTermination(j, timeUnit);
        }

        public final void execute(Runnable runnable) {
            this.delegate.execute(runnable);
        }

        public final boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        public final boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        public final void shutdown() {
            this.delegate.shutdown();
        }

        public final List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }
    }

    @GwtIncompatible
    public static final class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        public final ScheduledExecutorService delegate;

        public static final class ListenableScheduledTask<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            public final ScheduledFuture<?> scheduledDelegate;

            public ListenableScheduledTask(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.scheduledDelegate = scheduledFuture;
            }

            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.scheduledDelegate.cancel(z);
                }
                return cancel;
            }

            public long getDelay(TimeUnit timeUnit) {
                return this.scheduledDelegate.getDelay(timeUnit);
            }

            public int compareTo(Delayed delayed) {
                return this.scheduledDelegate.compareTo(delayed);
            }
        }

        @GwtIncompatible
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.TrustedFuture<Void> implements Runnable {
            public final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.delegate = (Runnable) Preconditions.checkNotNull(runnable);
            }

            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th2) {
                    setException(th2);
                    throw Throwables.propagate(th2);
                }
            }
        }

        public ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.delegate = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        }

        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new ListenableScheduledTask(neverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(runnable, null);
            return new ListenableScheduledTask(create, this.delegate.schedule(create, j, timeUnit));
        }

        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask<V> create = TrustedListenableFutureTask.create(callable);
            return new ListenableScheduledTask(create, this.delegate.schedule(create, j, timeUnit));
        }
    }

    @GwtIncompatible
    @Beta
    public static void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
        new Application().addDelayedShutdownHook(executorService, j, timeUnit);
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    @GwtIncompatible
    @Beta
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
        return new Application().getExitingExecutorService(threadPoolExecutor, j, timeUnit);
    }

    @GwtIncompatible
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor, j, timeUnit);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b7 A[SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T invokeAnyImpl(com.google.common.util.concurrent.ListeningExecutorService r16, java.util.Collection<? extends java.util.concurrent.Callable<T>> r17, boolean r18, long r19, java.util.concurrent.TimeUnit r21) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r1 = r16
            com.google.common.base.Preconditions.checkNotNull(r16)
            com.google.common.base.Preconditions.checkNotNull(r21)
            int r0 = r17.size()
            r2 = 1
            if (r0 <= 0) goto L_0x0011
            r3 = 1
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            com.google.common.base.Preconditions.checkArgument(r3)
            java.util.ArrayList r3 = com.google.common.collect.Lists.newArrayListWithCapacity(r0)
            java.util.concurrent.LinkedBlockingQueue r4 = com.google.common.collect.Queues.newLinkedBlockingQueue()
            r5 = r19
            r7 = r21
            long r5 = r7.toNanos(r5)
            if (r18 == 0) goto L_0x002f
            long r7 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002c }
            goto L_0x0031
        L_0x002c:
            r0 = move-exception
            goto L_0x00bb
        L_0x002f:
            r7 = 0
        L_0x0031:
            java.util.Iterator r9 = r17.iterator()     // Catch:{ all -> 0x002c }
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Callable r10 = (java.util.concurrent.Callable) r10     // Catch:{ all -> 0x002c }
            com.google.common.util.concurrent.ListenableFuture r10 = submitAndAddQueueListener(r1, r10, r4)     // Catch:{ all -> 0x002c }
            r3.add(r10)     // Catch:{ all -> 0x002c }
            int r0 = r0 + -1
            r10 = 0
            r12 = r10
            r11 = 1
        L_0x0047:
            java.lang.Object r13 = r4.poll()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch:{ all -> 0x002c }
            if (r13 != 0) goto L_0x008d
            if (r0 <= 0) goto L_0x0063
            int r0 = r0 + -1
            java.lang.Object r14 = r9.next()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Callable r14 = (java.util.concurrent.Callable) r14     // Catch:{ all -> 0x002c }
            com.google.common.util.concurrent.ListenableFuture r14 = submitAndAddQueueListener(r1, r14, r4)     // Catch:{ all -> 0x002c }
            r3.add(r14)     // Catch:{ all -> 0x002c }
            int r11 = r11 + 1
            goto L_0x008d
        L_0x0063:
            if (r11 != 0) goto L_0x006d
            if (r12 != 0) goto L_0x006c
            java.util.concurrent.ExecutionException r12 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x002c }
            r12.<init>(r10)     // Catch:{ all -> 0x002c }
        L_0x006c:
            throw r12     // Catch:{ all -> 0x002c }
        L_0x006d:
            if (r18 == 0) goto L_0x0087
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x002c }
            java.lang.Object r13 = r4.poll(r5, r13)     // Catch:{ all -> 0x002c }
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch:{ all -> 0x002c }
            if (r13 == 0) goto L_0x0081
            long r14 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002c }
            long r7 = r14 - r7
            long r5 = r5 - r7
            goto L_0x008e
        L_0x0081:
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x002c }
            r0.<init>()     // Catch:{ all -> 0x002c }
            throw r0     // Catch:{ all -> 0x002c }
        L_0x0087:
            java.lang.Object r13 = r4.take()     // Catch:{ all -> 0x002c }
            java.util.concurrent.Future r13 = (java.util.concurrent.Future) r13     // Catch:{ all -> 0x002c }
        L_0x008d:
            r14 = r7
        L_0x008e:
            r6 = r5
            r5 = r0
            if (r13 == 0) goto L_0x00b7
            int r11 = r11 + -1
            java.lang.Object r0 = r13.get()     // Catch:{ ExecutionException -> 0x00b5, RuntimeException -> 0x00ad }
            java.util.Iterator r1 = r3.iterator()
        L_0x009c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00ac
            java.lang.Object r3 = r1.next()
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3
            r3.cancel(r2)
            goto L_0x009c
        L_0x00ac:
            return r0
        L_0x00ad:
            r0 = move-exception
            r8 = r0
            java.util.concurrent.ExecutionException r12 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x002c }
            r12.<init>(r8)     // Catch:{ all -> 0x002c }
            goto L_0x00b7
        L_0x00b5:
            r0 = move-exception
            r12 = r0
        L_0x00b7:
            r0 = r5
            r5 = r6
            r7 = r14
            goto L_0x0047
        L_0x00bb:
            java.util.Iterator r1 = r3.iterator()
        L_0x00bf:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00cf
            java.lang.Object r3 = r1.next()
            java.util.concurrent.Future r3 = (java.util.concurrent.Future) r3
            r3.cancel(r2)
            goto L_0x00bf
        L_0x00cf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.MoreExecutors.invokeAnyImpl(com.google.common.util.concurrent.ListeningExecutorService, java.util.Collection, boolean, long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @GwtIncompatible
    public static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke((Object) null, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @GwtIncompatible
    public static ListeningExecutorService listeningDecorator(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new ListeningDecorator(executorService);
    }

    @GwtIncompatible
    public static ListeningExecutorService newDirectExecutorService() {
        return new DirectExecutorService();
    }

    @GwtIncompatible
    @Beta
    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }

    @GwtIncompatible
    public static Thread newThread(String str, Runnable runnable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(runnable);
        Thread newThread = platformThreadFactory().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    @GwtIncompatible
    @Beta
    public static ThreadFactory platformThreadFactory() {
        if (!isAppEngine()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (InvocationTargetException e4) {
            throw Throwables.propagate(e4.getCause());
        }
    }

    public static Executor rejectionPropagatingExecutor(final Executor executor, final AbstractFuture<?> abstractFuture) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(abstractFuture);
        if (executor == directExecutor()) {
            return executor;
        }
        return new Executor() {
            public boolean thrownFromDelegate = true;

            public void execute(final Runnable runnable) {
                try {
                    executor.execute(new Runnable() {
                        public void run() {
                            AnonymousClass5.this.thrownFromDelegate = false;
                            runnable.run();
                        }
                    });
                } catch (RejectedExecutionException e) {
                    if (this.thrownFromDelegate) {
                        abstractFuture.setException(e);
                    }
                }
            }
        };
    }

    @GwtIncompatible
    public static Executor renamingDecorator(final Executor executor, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executor;
        }
        return new Executor() {
            public void execute(Runnable runnable) {
                executor.execute(Callables.threadRenaming(runnable, (Supplier<String>) supplier));
            }
        };
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Beta
    public static boolean shutdownAndAwaitTermination(ExecutorService executorService, long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j) / 2;
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @GwtIncompatible
    public static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService listeningExecutorService, Callable<T> callable, final BlockingQueue<Future<T>> blockingQueue) {
        final ListenableFuture<T> submit = listeningExecutorService.submit(callable);
        submit.addListener(new Runnable() {
            public void run() {
                blockingQueue.add(submit);
            }
        }, directExecutor());
        return submit;
    }

    @GwtIncompatible
    public static void useDaemonThreadFactory(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(threadPoolExecutor.getThreadFactory()).build());
    }

    @GwtIncompatible
    @Beta
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        return new Application().getExitingExecutorService(threadPoolExecutor);
    }

    @GwtIncompatible
    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new ScheduledListeningDecorator(scheduledExecutorService);
    }

    @GwtIncompatible
    @VisibleForTesting
    public static class Application {
        public final void addDelayedShutdownHook(ExecutorService executorService, long j, TimeUnit timeUnit) {
            Preconditions.checkNotNull(executorService);
            Preconditions.checkNotNull(timeUnit);
            final ExecutorService executorService2 = executorService;
            final long j2 = j;
            final TimeUnit timeUnit2 = timeUnit;
            addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + executorService, new Runnable() {
                public void run() {
                    try {
                        executorService2.shutdown();
                        executorService2.awaitTermination(j2, timeUnit2);
                    } catch (InterruptedException unused) {
                    }
                }
            }));
        }

        @VisibleForTesting
        public void addShutdownHook(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(threadPoolExecutor);
            ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            addDelayedShutdownHook(threadPoolExecutor, j, timeUnit);
            return unconfigurableExecutorService;
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(scheduledThreadPoolExecutor);
            ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            addDelayedShutdownHook(scheduledThreadPoolExecutor, j, timeUnit);
            return unconfigurableScheduledExecutorService;
        }

        public final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
            return getExitingExecutorService(threadPoolExecutor, 120, TimeUnit.SECONDS);
        }

        public final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120, TimeUnit.SECONDS);
        }
    }

    @GwtIncompatible
    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new Application().getExitingScheduledExecutorService(scheduledThreadPoolExecutor);
    }

    @GwtIncompatible
    public static ExecutorService renamingDecorator(ExecutorService executorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return executorService;
        }
        return new WrappingExecutorService(executorService) {
            public <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming(callable, (Supplier<String>) supplier);
            }

            public Runnable wrapTask(Runnable runnable) {
                return Callables.threadRenaming(runnable, (Supplier<String>) supplier);
            }
        };
    }

    @GwtIncompatible
    public static ScheduledExecutorService renamingDecorator(ScheduledExecutorService scheduledExecutorService, final Supplier<String> supplier) {
        Preconditions.checkNotNull(scheduledExecutorService);
        Preconditions.checkNotNull(supplier);
        if (isAppEngine()) {
            return scheduledExecutorService;
        }
        return new WrappingScheduledExecutorService(scheduledExecutorService) {
            public <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming(callable, (Supplier<String>) supplier);
            }

            public Runnable wrapTask(Runnable runnable) {
                return Callables.threadRenaming(runnable, (Supplier<String>) supplier);
            }
        };
    }
}
