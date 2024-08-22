package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@CanIgnoreReturnValue
public abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService {
    public final ScheduledExecutorService delegate;

    public WrappingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService;
    }

    public final ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.delegate.schedule(wrapTask(runnable), j, timeUnit);
    }

    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.delegate.scheduleAtFixedRate(wrapTask(runnable), j, j2, timeUnit);
    }

    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.delegate.scheduleWithFixedDelay(wrapTask(runnable), j, j2, timeUnit);
    }

    public final <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return this.delegate.schedule(wrapTask(callable), j, timeUnit);
    }
}
