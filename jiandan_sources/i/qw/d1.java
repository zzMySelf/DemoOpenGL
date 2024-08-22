package i.qw;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d1<T> extends u0 {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final ggg<T> f6117i;

    public d1(@NotNull ggg<? super T> ggg) {
        this.f6117i = ggg;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void s(@Nullable Throwable th2) {
        Object I = t().I();
        if (k.qw() && !(!(I instanceof Incomplete))) {
            throw new AssertionError();
        } else if (I instanceof tt) {
            ggg<T> ggg = this.f6117i;
            Throwable th3 = ((tt) I).qw;
            Result.Companion companion = Result.Companion;
            ggg.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th3)));
        } else {
            ggg<T> ggg2 = this.f6117i;
            Object uk2 = w0.uk(I);
            Result.Companion companion2 = Result.Companion;
            ggg2.resumeWith(Result.m1155constructorimpl(uk2));
        }
    }
}
