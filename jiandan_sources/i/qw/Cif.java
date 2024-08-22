package i.qw;

import i.qw.x1.rrr;
import i.qw.y1.ad;
import i.qw.y1.qw;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: i.qw.if  reason: invalid class name */
public final /* synthetic */ class Cif {
    public static /* synthetic */ Deferred ad(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return o.qw(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @NotNull
    public static final Job de(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        de deVar;
        CoroutineContext de2 = d.de(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            deVar = new y0(de2, function2);
        } else {
            deVar = new h1(de2, true);
        }
        deVar.t0(coroutineStart, deVar, function2);
        return deVar;
    }

    public static /* synthetic */ Job fe(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return o.de(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @NotNull
    public static final <T> Deferred<T> qw(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        p pVar;
        CoroutineContext de2 = d.de(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            pVar = new x0(de2, function2);
        } else {
            pVar = new p(de2, true);
        }
        pVar.t0(coroutineStart, pVar, function2);
        return pVar;
    }

    /* JADX INFO: finally extract failed */
    @Nullable
    public static final <T> Object rg(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        CoroutineContext plus = context.plus(coroutineContext);
        r0.yj(plus);
        if (plus == context) {
            rrr rrr = new rrr(plus, continuation);
            obj = ad.rg(rrr, rrr, function2);
        } else if (Intrinsics.areEqual((Object) plus.get(ContinuationInterceptor.Key), (Object) context.get(ContinuationInterceptor.Key))) {
            p1 p1Var = new p1(plus, continuation);
            Object de2 = ThreadContextKt.de(plus, (Object) null);
            try {
                Object rg2 = ad.rg(p1Var, p1Var, function2);
                ThreadContextKt.qw(plus, de2);
                obj = rg2;
            } catch (Throwable th2) {
                ThreadContextKt.qw(plus, de2);
                throw th2;
            }
        } else {
            q qVar = new q(plus, continuation);
            qw.fe(function2, qVar, qVar, (Function1) null, 4, (Object) null);
            obj = qVar.v0();
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj;
    }
}
