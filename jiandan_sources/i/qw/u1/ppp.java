package i.qw.u1;

import i.qw.k;
import i.qw.l;
import i.qw.vvv;
import i.qw.x1.c;
import i.qw.x1.ggg;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ppp<E> extends when {
    @NotNull
    @JvmField

    /* renamed from: i  reason: collision with root package name */
    public final CancellableContinuation<Unit> f6189i;

    /* renamed from: uk  reason: collision with root package name */
    public final E f6190uk;

    public ppp(E e, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f6190uk = e;
        this.f6189i = cancellableContinuation;
    }

    public void s() {
        this.f6189i.g(vvv.qw);
    }

    public E t() {
        return this.f6190uk;
    }

    @NotNull
    public String toString() {
        return l.qw(this) + '@' + l.ad(this) + '(' + t() + ')';
    }

    public void u(@NotNull uk<?> ukVar) {
        CancellableContinuation<Unit> cancellableContinuation = this.f6189i;
        Throwable A = ukVar.A();
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(A)));
    }

    @Nullable
    public c v(@Nullable ggg.de deVar) {
        Object ad2 = this.f6189i.ad(Unit.INSTANCE, deVar == null ? null : deVar.f6269de);
        if (ad2 == null) {
            return null;
        }
        if (k.qw()) {
            if (!(ad2 == vvv.qw)) {
                throw new AssertionError();
            }
        }
        if (deVar != null) {
            deVar.fe();
        }
        return vvv.qw;
    }
}
