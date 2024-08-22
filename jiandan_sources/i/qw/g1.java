package i.qw;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g1<T, R> extends u0 {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final SelectInstance<R> f6127i;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final Function2<T, Continuation<? super R>, Object> f6128o;

    public g1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        this.f6127i = selectInstance;
        this.f6128o = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((Throwable) obj);
        return Unit.INSTANCE;
    }

    public void s(@Nullable Throwable th2) {
        if (this.f6127i.m668if()) {
            t().e0(this.f6127i, this.f6128o);
        }
    }
}
