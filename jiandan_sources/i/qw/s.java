package i.qw;

import i.qw.x1.i;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

public final class s {
    public static final boolean ad(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean de(int i2) {
        return i2 == 2;
    }

    public static final <T> void fe(@NotNull r<? super T> rVar, @NotNull Continuation<? super T> continuation, boolean z) {
        Object obj;
        Object yj2 = rVar.yj();
        Throwable fe2 = rVar.fe(yj2);
        if (fe2 != null) {
            Result.Companion companion = Result.Companion;
            obj = ResultKt.createFailure(fe2);
        } else {
            Result.Companion companion2 = Result.Companion;
            obj = rVar.rg(yj2);
        }
        Object r3 = Result.m1155constructorimpl(obj);
        if (z) {
            i iVar = (i) continuation;
            Continuation<T> continuation2 = iVar.f6274i;
            Object obj2 = iVar.f6276pf;
            CoroutineContext context = continuation2.getContext();
            Object de2 = ThreadContextKt.de(context, obj2);
            p1<?> rg2 = de2 != ThreadContextKt.qw ? d.rg(continuation2, context, de2) : null;
            try {
                iVar.f6274i.resumeWith(r3);
                Unit unit = Unit.INSTANCE;
            } finally {
                if (rg2 == null || rg2.v0()) {
                    ThreadContextKt.qw(context, de2);
                }
            }
        } else {
            continuation.resumeWith(r3);
        }
    }

    public static final <T> void qw(@NotNull r<? super T> rVar, int i2) {
        boolean z = true;
        if (k.qw()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> de2 = rVar.de();
        if (i2 != 4) {
            z = false;
        }
        if (z || !(de2 instanceof i) || ad(i2) != ad(rVar.f6162yj)) {
            fe(rVar, de2, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((i) de2).f6277uk;
        CoroutineContext context = de2.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, rVar);
        } else {
            rg(rVar);
        }
    }

    public static final void rg(r<?> rVar) {
        z ad2 = l1.qw.ad();
        if (ad2.b()) {
            ad2.eee(rVar);
            return;
        }
        ad2.tt(true);
        try {
            fe(rVar, rVar.de(), true);
            do {
            } while (ad2.g());
        } catch (Throwable th2) {
            ad2.xxx(true);
            throw th2;
        }
        ad2.xxx(true);
    }
}
