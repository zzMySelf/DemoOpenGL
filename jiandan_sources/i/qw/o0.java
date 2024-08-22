package i.qw;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class o0 extends u0 {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Function1<Throwable, Unit> f6154i;

    public o0(@NotNull Function1<? super Throwable, Unit> function1) {
        this.f6154i = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void s(@Nullable Throwable th2) {
        this.f6154i.invoke(th2);
    }
}
