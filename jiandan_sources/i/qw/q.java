package i.qw;

import i.qw.x1.o;
import i.qw.x1.rrr;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class q<T> extends rrr<T> {

    /* renamed from: uk  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6158uk = AtomicIntegerFieldUpdater.newUpdater(q.class, "_decision");
    @NotNull
    public volatile /* synthetic */ int _decision = 0;

    public q(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    public void m(@Nullable Object obj) {
        q0(obj);
    }

    public void q0(@Nullable Object obj) {
        if (!w0()) {
            o.de(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.f6287yj), c.qw(obj, this.f6287yj), (Function1) null, 2, (Object) null);
        }
    }

    @Nullable
    public final Object v0() {
        if (x0()) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object uk2 = w0.uk(I());
        if (!(uk2 instanceof tt)) {
            return uk2;
        }
        throw ((tt) uk2).qw;
    }

    public final boolean w0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f6158uk.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean x0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f6158uk.compareAndSet(this, 0, 1));
        return true;
    }
}
