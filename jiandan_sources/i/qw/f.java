package i.qw;

import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

public final class f {
    @NotNull
    public static final Throwable ad(@NotNull Throwable th2, @NotNull Throwable th3) {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        ExceptionsKt__ExceptionsKt.addSuppressed(runtimeException, th2);
        return runtimeException;
    }

    public static final void qw(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th2) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.f6323de);
            if (coroutineExceptionHandler == null) {
                e.qw(coroutineContext, th2);
            } else {
                coroutineExceptionHandler.handleException(coroutineContext, th2);
            }
        } catch (Throwable th3) {
            e.qw(coroutineContext, ad(th2, th3));
        }
    }
}
