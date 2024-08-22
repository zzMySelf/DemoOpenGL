package i.qw.u1;

import i.qw.de;
import i.qw.v0;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class fe<E> extends de<Unit> implements Channel<E> {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Channel<E> f6185yj;

    public fe(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.f6185yj = channel;
    }

    public boolean c(@Nullable Throwable th2) {
        return this.f6185yj.c(th2);
    }

    @Nullable
    public Object d(E e, @NotNull Continuation<? super Unit> continuation) {
        return this.f6185yj.d(e, continuation);
    }

    @NotNull
    public SelectClause1<th<E>> eee() {
        return this.f6185yj.eee();
    }

    @NotNull
    public ChannelIterator<E> iterator() {
        return this.f6185yj.iterator();
    }

    @NotNull
    public Object mmm(E e) {
        return this.f6185yj.mmm(e);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return this.f6185yj.offer(e);
    }

    @NotNull
    public SelectClause1<E> qqq() {
        return this.f6185yj.qqq();
    }

    public final void qw(@Nullable CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(v(), (Throwable) null, this);
            }
            s(cancellationException);
        }
    }

    @NotNull
    public Object rrr() {
        return this.f6185yj.rrr();
    }

    public void s(@NotNull Throwable th2) {
        CancellationException j0 = v0.j0(this, th2, (String) null, 1, (Object) null);
        this.f6185yj.qw(j0);
        q(j0);
    }

    @Nullable
    public Object tt(@NotNull Continuation<? super th<? extends E>> continuation) {
        Object tt = this.f6185yj.tt(continuation);
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return tt;
    }

    @NotNull
    public final Channel<E> u0() {
        return this;
    }

    @NotNull
    public final Channel<E> v0() {
        return this.f6185yj;
    }

    public void xxx(@NotNull Function1<? super Throwable, Unit> function1) {
        this.f6185yj.xxx(function1);
    }
}
