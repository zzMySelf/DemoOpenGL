package i.qw.u1;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import org.jetbrains.annotations.NotNull;

public final class ggg<E> extends ppp<E> {
    @NotNull
    @JvmField

    /* renamed from: o  reason: collision with root package name */
    public final Function1<E, Unit> f6186o;

    public ggg(E e, @NotNull CancellableContinuation<? super Unit> cancellableContinuation, @NotNull Function1<? super E, Unit> function1) {
        super(e, cancellableContinuation);
        this.f6186o = function1;
    }

    public boolean m() {
        if (!super.m()) {
            return false;
        }
        w();
        return true;
    }

    public void w() {
        OnUndeliveredElementKt.ad(this.f6186o, t(), this.f6189i.getContext());
    }
}
