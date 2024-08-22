package i.qw;

import i.qw.x1.rrr;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class p1<T> extends rrr<T> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public Object f6156i;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public CoroutineContext f6157uk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p1(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext.get(q1.f6160ad) == null ? coroutineContext.plus(q1.f6160ad) : coroutineContext, continuation);
    }

    public void q0(@Nullable Object obj) {
        CoroutineContext coroutineContext = this.f6157uk;
        p1<?> p1Var = null;
        if (coroutineContext != null) {
            ThreadContextKt.qw(coroutineContext, this.f6156i);
            this.f6157uk = p1Var;
            this.f6156i = p1Var;
        }
        Object qw = c.qw(obj, this.f6287yj);
        Continuation<T> continuation = this.f6287yj;
        CoroutineContext context = continuation.getContext();
        Object de2 = ThreadContextKt.de(context, p1Var);
        if (de2 != ThreadContextKt.qw) {
            p1Var = d.rg(continuation, context, de2);
        }
        try {
            this.f6287yj.resumeWith(qw);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (p1Var == null || p1Var.v0()) {
                ThreadContextKt.qw(context, de2);
            }
        }
    }

    public final boolean v0() {
        if (this.f6157uk == null) {
            return false;
        }
        this.f6157uk = null;
        this.f6156i = null;
        return true;
    }

    public final void w0(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        this.f6157uk = coroutineContext;
        this.f6156i = obj;
    }
}
