package i.qw.w1.i0;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ggg<T> implements Continuation<T>, CoroutineStackFrame {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Continuation<T> f6230ad;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final CoroutineContext f6231th;

    public ggg(@NotNull Continuation<? super T> continuation, @NotNull CoroutineContext coroutineContext) {
        this.f6230ad = continuation;
        this.f6231th = coroutineContext;
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f6230ad;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.f6231th;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(@NotNull Object obj) {
        this.f6230ad.resumeWith(obj);
    }
}
