package i.qw;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e1 extends u0 {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Continuation<Unit> f6120i;

    public e1(@NotNull Continuation<? super Unit> continuation) {
        this.f6120i = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void s(@Nullable Throwable th2) {
        Continuation<Unit> continuation = this.f6120i;
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1155constructorimpl(unit));
    }
}
