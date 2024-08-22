package kotlinx.coroutines.internal;

import i.qw.x1.c;
import i.qw.x1.k;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "updateState", "Lkotlinx/coroutines/internal/ThreadState;", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ThreadContextKt {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final Function2<Object, CoroutineContext.Element, Object> f6443ad = ThreadContextKt$countAll$1.INSTANCE;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> f6444de = ThreadContextKt$findOne$1.INSTANCE;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final Function2<k, CoroutineContext.Element, k> f6445fe = ThreadContextKt$updateState$1.INSTANCE;
    @NotNull
    @JvmField
    public static final c qw = new c("NO_THREAD_ELEMENTS");

    @NotNull
    public static final Object ad(@NotNull CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, f6443ad);
        Intrinsics.checkNotNull(fold);
        return fold;
    }

    @Nullable
    public static final Object de(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj == null) {
            obj = ad(coroutineContext);
        }
        if (obj == 0) {
            return qw;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new k(coroutineContext, ((Number) obj).intValue()), f6445fe);
        }
        return ((ThreadContextElement) obj).e(coroutineContext);
    }

    public static final void qw(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        if (obj != qw) {
            if (obj instanceof k) {
                ((k) obj).ad(coroutineContext);
                return;
            }
            Object fold = coroutineContext.fold(null, f6444de);
            if (fold != null) {
                ((ThreadContextElement) fold).m656switch(coroutineContext, obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }
}
