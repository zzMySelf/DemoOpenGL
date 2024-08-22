package i.qw;

import i.qw.x1.ggg;
import i.qw.x1.i;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import org.jetbrains.annotations.NotNull;

public final class xxx {
    @NotNull
    public static final <T> ggg<T> ad(@NotNull Continuation<? super T> continuation) {
        if (!(continuation instanceof i)) {
            return new ggg<>(continuation, 1);
        }
        ggg<T> pf2 = ((i) continuation).pf();
        if (pf2 == null || !pf2.k()) {
            pf2 = null;
        }
        return pf2 == null ? new ggg<>(continuation, 2) : pf2;
    }

    public static final void de(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull ggg ggg) {
        cancellableContinuation.i(new c1(ggg));
    }

    public static final void qw(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull DisposableHandle disposableHandle) {
        cancellableContinuation.i(new w(disposableHandle));
    }
}
