package i.qw;

import i.qw.x1.rrr;
import i.qw.x1.uk;
import i.qw.y1.ad;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class j {
    @Nullable
    public static final <R> Object ad(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        rrr rrr = new rrr(continuation.getContext(), continuation);
        Object rg2 = ad.rg(rrr, rrr, function2);
        if (rg2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return rg2;
    }

    @NotNull
    public static final CoroutineScope qw(@NotNull CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.f6325fe) == null) {
            coroutineContext = coroutineContext.plus(t0.ad((Job) null, 1, (Object) null));
        }
        return new uk(coroutineContext);
    }
}
