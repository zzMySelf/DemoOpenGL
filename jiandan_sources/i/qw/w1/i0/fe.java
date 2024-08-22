package i.qw.w1.i0;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.UndispatchedContextCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe {
    /* JADX INFO: finally extract failed */
    @Nullable
    public static final <T, V> Object ad(@NotNull CoroutineContext coroutineContext, V v, @NotNull Object obj, @NotNull Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object de2 = ThreadContextKt.de(coroutineContext, obj);
        try {
            ggg ggg = new ggg(continuation, coroutineContext);
            if (function2 != null) {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(v, ggg);
                ThreadContextKt.qw(coroutineContext, de2);
                if (invoke == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th2) {
            ThreadContextKt.qw(coroutineContext, de2);
            throw th2;
        }
    }

    public static /* synthetic */ Object de(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i2, Object obj3) {
        if ((i2 & 4) != 0) {
            obj2 = ThreadContextKt.ad(coroutineContext);
        }
        return ad(coroutineContext, obj, obj2, function2, continuation);
    }

    public static final <T> FlowCollector<T> fe(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        return flowCollector instanceof ppp ? true : flowCollector instanceof Cif ? flowCollector : new UndispatchedContextCollector(flowCollector, coroutineContext);
    }
}
