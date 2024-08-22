package i.qw.w1.i0;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class yj implements CoroutineContext.Element {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public static final qw f6242yj = new qw((DefaultConstructorMarker) null);
    @NotNull
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final Throwable f6243ad;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final CoroutineContext.Key<?> f6244th = f6242yj;

    public static final class qw implements CoroutineContext.Key<yj> {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public yj(@NotNull Throwable th2) {
        this.f6243ad = th2;
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return this.f6244th;
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }
}
