package i.qw;

import i.qw.y1.qw;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

public final class x0<T> extends p<T> {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Continuation<Unit> f6248yj;

    public x0(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.f6248yj = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, this, this);
    }

    public void Z() {
        qw.qw(this.f6248yj, this);
    }
}
