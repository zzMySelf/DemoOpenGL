package i.qw.x1;

import i.qw.c;
import i.qw.de;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rrr<T> extends de<T> implements CoroutineStackFrame {
    @NotNull
    @JvmField

    /* renamed from: yj  reason: collision with root package name */
    public final Continuation<T> f6287yj;

    public rrr(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.f6287yj = continuation;
    }

    public final boolean M() {
        return true;
    }

    @Nullable
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f6287yj;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Nullable
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public void m(@Nullable Object obj) {
        o.de(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.f6287yj), c.qw(obj, this.f6287yj), (Function1) null, 2, (Object) null);
    }

    public void q0(@Nullable Object obj) {
        Continuation<T> continuation = this.f6287yj;
        continuation.resumeWith(c.qw(obj, continuation));
    }

    @Nullable
    public final Job u0() {
        ChildHandle H = H();
        if (H == null) {
            return null;
        }
        return H.getParent();
    }
}
