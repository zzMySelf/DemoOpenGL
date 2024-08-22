package i.qw;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

public final class e {
    @NotNull
    public static final List<CoroutineExceptionHandler> qw;

    static {
        Class<CoroutineExceptionHandler> cls = CoroutineExceptionHandler.class;
        qw = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final void qw(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th2) {
        for (CoroutineExceptionHandler handleException : qw) {
            try {
                handleException.handleException(coroutineContext, th2);
            } catch (Throwable th3) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, f.ad(th2, th3));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th2);
    }
}
