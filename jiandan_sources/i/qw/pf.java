package i.qw;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class pf {
    public static /* synthetic */ Object ad(CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return o.rg(coroutineContext, function2);
    }

    public static final <T> T qw(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        CoroutineContext coroutineContext2;
        z zVar;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor == null) {
            zVar = l1.qw.ad();
            coroutineContext2 = d.de(i0.f6136ad, coroutineContext.plus(zVar));
        } else {
            z zVar2 = null;
            z zVar3 = continuationInterceptor instanceof z ? (z) continuationInterceptor : null;
            if (zVar3 != null && zVar3.h()) {
                zVar2 = zVar3;
            }
            zVar = zVar2 == null ? l1.qw.qw() : zVar2;
            coroutineContext2 = d.de(i0.f6136ad, coroutineContext);
        }
        uk ukVar = new uk(coroutineContext2, currentThread, zVar);
        ukVar.t0(CoroutineStart.DEFAULT, ukVar, function2);
        return ukVar.u0();
    }
}
