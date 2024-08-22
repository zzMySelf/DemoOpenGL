package i.qw;

import java.util.concurrent.Future;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class s0 {
    public static final void qw(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Future<?> future) {
        cancellableContinuation.i(new Cswitch(future));
    }
}
