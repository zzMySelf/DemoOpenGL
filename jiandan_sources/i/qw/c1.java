package i.qw;

import i.qw.x1.ggg;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c1 extends yj {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ggg f6115ad;

    public c1(@NotNull ggg ggg) {
        this.f6115ad = ggg;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        qw((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void qw(@Nullable Throwable th2) {
        this.f6115ad.m();
    }

    @NotNull
    public String toString() {
        return "RemoveOnCancel[" + this.f6115ad + ']';
    }
}
