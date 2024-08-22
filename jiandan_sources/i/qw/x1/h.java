package i.qw.x1;

import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
public final class h implements CoroutineContext.Key<g<?>> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ThreadLocal<?> f6273ad;

    public h(@NotNull ThreadLocal<?> threadLocal) {
        this.f6273ad = threadLocal;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && Intrinsics.areEqual((Object) this.f6273ad, (Object) ((h) obj).f6273ad);
    }

    public int hashCode() {
        return this.f6273ad.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f6273ad + ')';
    }
}
