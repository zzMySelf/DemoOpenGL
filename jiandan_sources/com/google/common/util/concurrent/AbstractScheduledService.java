package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
@Beta
public abstract class AbstractScheduledService implements Service {
    public static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    public final AbstractService delegate = new ServiceDelegate();

    @Beta
    public static abstract class CustomScheduler extends Scheduler {

        public class ReschedulableCallable extends ForwardingFuture<Void> implements Callable<Void> {
            @NullableDecl
            @GuardedBy("lock")
            public Future<Void> currentFuture;
            public final ScheduledExecutorService executor;
            public final ReentrantLock lock = new ReentrantLock();
            public final AbstractService service;
            public final Runnable wrappedRunnable;

            public ReschedulableCallable(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = scheduledExecutorService;
                this.service = abstractService;
            }

            public boolean cancel(boolean z) {
                this.lock.lock();
                try {
                    return this.currentFuture.cancel(z);
                } finally {
                    this.lock.unlock();
                }
            }

            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }

            public void reschedule() {
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    Throwable th2 = null;
                    this.lock.lock();
                    try {
                        if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                            this.currentFuture = this.executor.schedule(this, nextSchedule.delay, nextSchedule.unit);
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                    this.lock.unlock();
                    if (th2 != null) {
                        this.service.notifyFailed(th2);
                    }
                } catch (Throwable th4) {
                    this.service.notifyFailed(th4);
                }
            }

            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public Future<Void> delegate() {
                throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
            }
        }

        @Beta
        public static final class Schedule {
            public final long delay;
            public final TimeUnit unit;

            public Schedule(long j, TimeUnit timeUnit) {
                this.delay = j;
                this.unit = (TimeUnit) Preconditions.checkNotNull(timeUnit);
            }
        }

        public CustomScheduler() {
            super();
        }

        public abstract Schedule getNextSchedule() throws Exception;

        public final Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            ReschedulableCallable reschedulableCallable = new ReschedulableCallable(abstractService, scheduledExecutorService, runnable);
            reschedulableCallable.reschedule();
            return reschedulableCallable;
        }
    }

    public static abstract class Scheduler {
        public static Scheduler newFixedDelaySchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "delay must be > 0, found %s", j2);
            final long j3 = j;
            final long j4 = j2;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return scheduledExecutorService.scheduleWithFixedDelay(runnable, j3, j4, timeUnit2);
                }
            };
        }

        public static Scheduler newFixedRateSchedule(long j, long j2, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            Preconditions.checkArgument(j2 > 0, "period must be > 0, found %s", j2);
            final long j3 = j;
            final long j4 = j2;
            final TimeUnit timeUnit2 = timeUnit;
            return new Scheduler() {
                public Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
                    return scheduledExecutorService.scheduleAtFixedRate(runnable, j3, j4, timeUnit2);
                }
            };
        }

        public abstract Future<?> schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public Scheduler() {
        }
    }

    public final class ServiceDelegate extends AbstractService {
        @MonotonicNonNullDecl
        public volatile ScheduledExecutorService executorService;
        public final ReentrantLock lock;
        @MonotonicNonNullDecl
        public volatile Future<?> runningTask;
        public final Runnable task;

        public class Task implements Runnable {
            public Task() {
            }

            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    if (ServiceDelegate.this.runningTask.isCancelled()) {
                        ServiceDelegate.this.lock.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                    ServiceDelegate.this.lock.unlock();
                } catch (Throwable th2) {
                    ServiceDelegate.this.lock.unlock();
                    throw th2;
                }
            }
        }

        public ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        public final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (Supplier<String>) new Supplier<String>() {
                public String get() {
                    return AbstractScheduledService.this.serviceName() + " " + ServiceDelegate.this.state();
                }
            });
            this.executorService.execute(new Runnable() {
                public void run() {
                    ServiceDelegate.this.lock.lock();
                    try {
                        AbstractScheduledService.this.startUp();
                        Future unused = ServiceDelegate.this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, ServiceDelegate.this.executorService, ServiceDelegate.this.task);
                        ServiceDelegate.this.notifyStarted();
                    } catch (Throwable th2) {
                        ServiceDelegate.this.lock.unlock();
                        throw th2;
                    }
                    ServiceDelegate.this.lock.unlock();
                }
            });
        }

        public final void doStop() {
            this.runningTask.cancel(false);
            this.executorService.execute(new Runnable() {
                public void run() {
                    try {
                        ServiceDelegate.this.lock.lock();
                        if (ServiceDelegate.this.state() != Service.State.STOPPING) {
                            ServiceDelegate.this.lock.unlock();
                            return;
                        }
                        AbstractScheduledService.this.shutDown();
                        ServiceDelegate.this.lock.unlock();
                        ServiceDelegate.this.notifyStopped();
                    } catch (Throwable th2) {
                        ServiceDelegate.this.notifyFailed(th2);
                    }
                }
            });
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public ScheduledExecutorService executor() {
        final ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener() {
            public void failed(Service.State state, Throwable th2) {
                newSingleThreadScheduledExecutor.shutdown();
            }

            public void terminated(Service.State state) {
                newSingleThreadScheduledExecutor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return newSingleThreadScheduledExecutor;
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void runOneIteration() throws Exception;

    public abstract Scheduler scheduler();

    public String serviceName() {
        return AbstractScheduledService.class.getSimpleName();
    }

    public void shutDown() throws Exception {
    }

    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public void startUp() throws Exception {
    }

    public final Service.State state() {
        return this.delegate.state();
    }

    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j, timeUnit);
    }

    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j, timeUnit);
    }
}
