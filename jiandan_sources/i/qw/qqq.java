package i.qw;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qqq<T> extends v0 implements CompletableDeferred<T>, SelectClause1<T> {
    public qqq(@Nullable Job job) {
        super(true);
        L(job);
    }

    public boolean F() {
        return true;
    }

    public <R> void de(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        c0(selectInstance, function2);
    }

    public boolean ggg(T t) {
        return Q(t);
    }

    @Nullable
    public Object th(@NotNull Continuation<? super T> continuation) {
        return n(continuation);
    }

    public boolean when(@NotNull Throwable th2) {
        return Q(new tt(th2, false, 2, (DefaultConstructorMarker) null));
    }
}
