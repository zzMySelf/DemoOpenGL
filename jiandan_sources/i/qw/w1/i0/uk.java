package i.qw.w1.i0;

import i.qw.x1.rrr;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import org.jetbrains.annotations.NotNull;

public final class uk<T> extends rrr<T> {
    public uk(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    public boolean w(@NotNull Throwable th2) {
        if (th2 instanceof ChildCancelledException) {
            return true;
        }
        return r(th2);
    }
}
