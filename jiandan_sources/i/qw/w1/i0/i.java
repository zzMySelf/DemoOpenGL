package i.qw.w1.i0;

import i.qw.y1.ad;
import kotlin.BuilderInference;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class i {
    @Nullable
    public static final <R> Object qw(@NotNull @BuilderInference Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        uk ukVar = new uk(continuation.getContext(), continuation);
        Object rg2 = ad.rg(ukVar, ukVar, function2);
        if (rg2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return rg2;
    }
}
