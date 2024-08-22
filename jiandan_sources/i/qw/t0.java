package i.qw;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final /* synthetic */ class t0 {
    public static /* synthetic */ CompletableJob ad(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return r0.qw(job);
    }

    public static final void de(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.f6325fe);
        if (job != null) {
            job.qw(cancellationException);
        }
    }

    public static /* synthetic */ void fe(CoroutineContext coroutineContext, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        r0.de(coroutineContext, cancellationException);
    }

    @NotNull
    public static final CompletableJob qw(@Nullable Job job) {
        return new q0(job);
    }

    @NotNull
    public static final DisposableHandle rg(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return job.pf(new x(disposableHandle));
    }

    public static final void th(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.f6325fe);
        if (job != null) {
            r0.uk(job);
        }
    }

    @NotNull
    public static final Job uk(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.f6325fe);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Current context doesn't contain Job in it: ", coroutineContext).toString());
    }

    public static final void yj(@NotNull Job job) {
        if (!job.isActive()) {
            throw job.rg();
        }
    }
}
