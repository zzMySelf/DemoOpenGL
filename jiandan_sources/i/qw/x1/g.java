package i.qw.x1;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g<T> implements ThreadContextElement<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final T f6260ad;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final ThreadLocal<T> f6261th;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final CoroutineContext.Key<?> f6262yj;

    public g(T t, @NotNull ThreadLocal<T> threadLocal) {
        this.f6260ad = t;
        this.f6261th = threadLocal;
        this.f6262yj = new h(threadLocal);
    }

    public T e(@NotNull CoroutineContext coroutineContext) {
        T t = this.f6261th.get();
        this.f6261th.set(this.f6260ad);
        return t;
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return ThreadContextElement.qw.qw(this, r, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        if (Intrinsics.areEqual((Object) getKey(), (Object) key)) {
            return this;
        }
        return null;
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return this.f6262yj;
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Intrinsics.areEqual((Object) getKey(), (Object) key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return ThreadContextElement.qw.ad(this, coroutineContext);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m413switch(@NotNull CoroutineContext coroutineContext, T t) {
        this.f6261th.set(t);
    }

    @NotNull
    public String toString() {
        return "ThreadLocal(value=" + this.f6260ad + ", threadLocal = " + this.f6261th + ')';
    }
}
