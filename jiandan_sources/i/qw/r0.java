package i.qw;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class r0 {
    public static final void de(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        t0.de(coroutineContext, cancellationException);
    }

    @NotNull
    public static final Job i(@NotNull CoroutineContext coroutineContext) {
        return t0.uk(coroutineContext);
    }

    @NotNull
    public static final CompletableJob qw(@Nullable Job job) {
        return t0.qw(job);
    }

    public static final void rg(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Future<?> future) {
        s0.qw(cancellableContinuation, future);
    }

    @NotNull
    public static final DisposableHandle th(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return t0.rg(job, disposableHandle);
    }

    public static final void uk(@NotNull Job job) {
        t0.yj(job);
    }

    public static final void yj(@NotNull CoroutineContext coroutineContext) {
        t0.th(coroutineContext);
    }
}
