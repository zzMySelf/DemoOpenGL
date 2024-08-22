package i.qw;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class m0 extends when {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function1<Throwable, Unit> f6144ad;

    public m0(@NotNull Function1<? super Throwable, Unit> function1) {
        this.f6144ad = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        qw((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void qw(@Nullable Throwable th2) {
        this.f6144ad.invoke(th2);
    }

    @NotNull
    public String toString() {
        return "InvokeOnCancel[" + l.qw(this.f6144ad) + '@' + l.ad(this) + ']';
    }
}
