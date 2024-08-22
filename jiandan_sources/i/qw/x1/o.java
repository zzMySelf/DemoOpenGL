package i.qw.x1;

import i.qw.k;
import i.qw.l1;
import i.qw.z;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class o {
    @NotNull
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public static final c f6283ad = new c("REUSABLE_CLAIMED");
    @NotNull
    public static final c qw = new c("UNDEFINED");

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        if (r8.v0() != false) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void ad(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r6, @org.jetbrains.annotations.NotNull java.lang.Object r7, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r8) {
        /*
            boolean r0 = r6 instanceof i.qw.x1.i
            if (r0 == 0) goto L_0x00ba
            i.qw.x1.i r6 = (i.qw.x1.i) r6
            java.lang.Object r8 = i.qw.c.ad(r7, r8)
            kotlinx.coroutines.CoroutineDispatcher r0 = r6.f6277uk
            kotlin.coroutines.CoroutineContext r1 = r6.getContext()
            boolean r0 = r0.isDispatchNeeded(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6.f6275o = r8
            r6.f6162yj = r1
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.f6277uk
            kotlin.coroutines.CoroutineContext r8 = r6.getContext()
            r7.dispatch(r8, r6)
            goto L_0x00bd
        L_0x0026:
            boolean r0 = i.qw.k.qw()
            i.qw.l1 r0 = i.qw.l1.qw
            i.qw.z r0 = r0.ad()
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x003f
            r6.f6275o = r8
            r6.f6162yj = r1
            r0.eee(r6)
            goto L_0x00bd
        L_0x003f:
            r0.tt(r1)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r6.getContext()     // Catch:{ all -> 0x00ad }
            kotlinx.coroutines.Job$ad r4 = kotlinx.coroutines.Job.f6325fe     // Catch:{ all -> 0x00ad }
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r4)     // Catch:{ all -> 0x00ad }
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3     // Catch:{ all -> 0x00ad }
            if (r3 == 0) goto L_0x006d
            boolean r4 = r3.isActive()     // Catch:{ all -> 0x00ad }
            if (r4 != 0) goto L_0x006d
            java.util.concurrent.CancellationException r3 = r3.rg()     // Catch:{ all -> 0x00ad }
            r6.qw(r8, r3)     // Catch:{ all -> 0x00ad }
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x00ad }
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r3)     // Catch:{ all -> 0x00ad }
            java.lang.Object r8 = kotlin.Result.m1155constructorimpl(r8)     // Catch:{ all -> 0x00ad }
            r6.resumeWith(r8)     // Catch:{ all -> 0x00ad }
            r8 = 1
            goto L_0x006e
        L_0x006d:
            r8 = 0
        L_0x006e:
            if (r8 != 0) goto L_0x00a6
            kotlin.coroutines.Continuation<T> r8 = r6.f6274i     // Catch:{ all -> 0x00ad }
            java.lang.Object r3 = r6.f6276pf     // Catch:{ all -> 0x00ad }
            kotlin.coroutines.CoroutineContext r4 = r8.getContext()     // Catch:{ all -> 0x00ad }
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.de(r4, r3)     // Catch:{ all -> 0x00ad }
            i.qw.x1.c r5 = kotlinx.coroutines.internal.ThreadContextKt.qw     // Catch:{ all -> 0x00ad }
            if (r3 == r5) goto L_0x0085
            i.qw.p1 r8 = i.qw.d.rg(r8, r4, r3)     // Catch:{ all -> 0x00ad }
            goto L_0x0086
        L_0x0085:
            r8 = r2
        L_0x0086:
            kotlin.coroutines.Continuation<T> r5 = r6.f6274i     // Catch:{ all -> 0x0099 }
            r5.resumeWith(r7)     // Catch:{ all -> 0x0099 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0099 }
            if (r8 == 0) goto L_0x0095
            boolean r7 = r8.v0()     // Catch:{ all -> 0x00ad }
            if (r7 == 0) goto L_0x00a6
        L_0x0095:
            kotlinx.coroutines.internal.ThreadContextKt.qw(r4, r3)     // Catch:{ all -> 0x00ad }
            goto L_0x00a6
        L_0x0099:
            r7 = move-exception
            if (r8 == 0) goto L_0x00a2
            boolean r8 = r8.v0()     // Catch:{ all -> 0x00ad }
            if (r8 == 0) goto L_0x00a5
        L_0x00a2:
            kotlinx.coroutines.internal.ThreadContextKt.qw(r4, r3)     // Catch:{ all -> 0x00ad }
        L_0x00a5:
            throw r7     // Catch:{ all -> 0x00ad }
        L_0x00a6:
            boolean r7 = r0.g()     // Catch:{ all -> 0x00ad }
            if (r7 != 0) goto L_0x00a6
            goto L_0x00b1
        L_0x00ad:
            r7 = move-exception
            r6.th(r7, r2)     // Catch:{ all -> 0x00b5 }
        L_0x00b1:
            r0.xxx(r1)
            goto L_0x00bd
        L_0x00b5:
            r6 = move-exception
            r0.xxx(r1)
            throw r6
        L_0x00ba:
            r6.resumeWith(r7)
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.x1.o.ad(kotlin.coroutines.Continuation, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void de(Continuation continuation, Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        ad(continuation, obj, function1);
    }

    public static final boolean fe(@NotNull i<? super Unit> iVar) {
        Unit unit = Unit.INSTANCE;
        boolean qw2 = k.qw();
        z ad2 = l1.qw.ad();
        if (ad2.c()) {
            return false;
        }
        if (ad2.b()) {
            iVar.f6275o = unit;
            iVar.f6162yj = 1;
            ad2.eee(iVar);
            return true;
        }
        ad2.tt(true);
        try {
            iVar.run();
            do {
            } while (ad2.g());
        } catch (Throwable th2) {
            ad2.xxx(true);
            throw th2;
        }
        ad2.xxx(true);
        return false;
    }
}
