package i.qw;

import i.qw.x1.rg;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class f0 extends ExecutorCoroutineDispatcher implements Delay {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f6121ad;

    public void close() {
        Executor xxx = xxx();
        ExecutorService executorService = xxx instanceof ExecutorService ? (ExecutorService) xxx : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public void de(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        ScheduledFuture<?> eee = this.f6121ad ? eee(new f1(this, cancellableContinuation), cancellableContinuation.getContext(), j) : null;
        if (eee != null) {
            r0.rg(cancellableContinuation, eee);
        } else {
            m.f6142o.de(j, cancellableContinuation);
        }
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            Executor xxx = xxx();
            fe qw = rg.qw();
            xxx.execute(qw == null ? runnable : qw.uk(runnable));
        } catch (RejectedExecutionException e) {
            fe qw2 = rg.qw();
            if (qw2 != null) {
                qw2.rg();
            }
            mmm(coroutineContext, e);
            u uVar = u.qw;
            u.ad().dispatch(coroutineContext, runnable);
        }
    }

    public final ScheduledFuture<?> eee(Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            Executor xxx = xxx();
            ScheduledExecutorService scheduledExecutorService = xxx instanceof ScheduledExecutorService ? (ScheduledExecutorService) xxx : null;
            if (scheduledExecutorService == null) {
                return null;
            }
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            mmm(coroutineContext, e);
            return null;
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof f0) && ((f0) obj).xxx() == xxx();
    }

    public int hashCode() {
        return System.identityHashCode(xxx());
    }

    public final void mmm(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        r0.de(coroutineContext, e0.qw("The task was rejected", rejectedExecutionException));
    }

    public final void qqq() {
        this.f6121ad = rg.qw(xxx());
    }

    @NotNull
    public String toString() {
        return xxx().toString();
    }

    @NotNull
    public DisposableHandle uk(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        ScheduledFuture<?> eee = this.f6121ad ? eee(runnable, coroutineContext, j) : null;
        if (eee != null) {
            return new v(eee);
        }
        return m.f6142o.uk(j, runnable, coroutineContext);
    }
}
