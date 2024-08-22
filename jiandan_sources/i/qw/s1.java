package i.qw;

import i.qw.x1.i;
import i.qw.x1.o;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class s1 {
    @Nullable
    public static final Object qw(@NotNull Continuation<? super Unit> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        r0.yj(context);
        Continuation<? super Unit> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        i iVar = intercepted instanceof i ? (i) intercepted : null;
        if (iVar == null) {
            obj = Unit.INSTANCE;
        } else {
            if (iVar.f6277uk.isDispatchNeeded(context)) {
                iVar.m418if(context, Unit.INSTANCE);
            } else {
                r1 r1Var = new r1();
                iVar.m418if(context.plus(r1Var), Unit.INSTANCE);
                if (r1Var.f6164ad) {
                    obj = o.fe(iVar) ? IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() : Unit.INSTANCE;
                }
            }
            obj = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }
}
