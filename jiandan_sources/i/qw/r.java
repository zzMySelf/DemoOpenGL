package i.qw;

import i.qw.z1.uk;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutinesInternalError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class r<T> extends uk {
    @JvmField

    /* renamed from: yj  reason: collision with root package name */
    public int f6162yj;

    public r(int i2) {
        this.f6162yj = i2;
    }

    @NotNull
    public abstract Continuation<T> de();

    @Nullable
    public Throwable fe(@Nullable Object obj) {
        tt ttVar = obj instanceof tt ? (tt) obj : null;
        if (ttVar == null) {
            return null;
        }
        return ttVar.qw;
    }

    public void qw(@Nullable Object obj, @NotNull Throwable th2) {
    }

    public <T> T rg(@Nullable Object obj) {
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00aa, code lost:
        if (r4.v0() != false) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d5, code lost:
        if (r4.v0() != false) goto L_0x00d7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            boolean r0 = i.qw.k.qw()
            if (r0 == 0) goto L_0x0017
            int r0 = r10.f6162yj
            r1 = -1
            if (r0 == r1) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0017:
            kotlinx.coroutines.scheduling.TaskContext r0 = r10.f6322th
            kotlin.coroutines.Continuation r1 = r10.de()     // Catch:{ all -> 0x00db }
            i.qw.x1.i r1 = (i.qw.x1.i) r1     // Catch:{ all -> 0x00db }
            kotlin.coroutines.Continuation<T> r2 = r1.f6274i     // Catch:{ all -> 0x00db }
            java.lang.Object r1 = r1.f6276pf     // Catch:{ all -> 0x00db }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x00db }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.de(r3, r1)     // Catch:{ all -> 0x00db }
            i.qw.x1.c r4 = kotlinx.coroutines.internal.ThreadContextKt.qw     // Catch:{ all -> 0x00db }
            r5 = 0
            if (r1 == r4) goto L_0x0035
            i.qw.p1 r4 = i.qw.d.rg(r2, r3, r1)     // Catch:{ all -> 0x00db }
            goto L_0x0036
        L_0x0035:
            r4 = r5
        L_0x0036:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x00ce }
            java.lang.Object r7 = r10.yj()     // Catch:{ all -> 0x00ce }
            java.lang.Throwable r8 = r10.fe(r7)     // Catch:{ all -> 0x00ce }
            if (r8 != 0) goto L_0x0055
            int r9 = r10.f6162yj     // Catch:{ all -> 0x00ce }
            boolean r9 = i.qw.s.ad(r9)     // Catch:{ all -> 0x00ce }
            if (r9 == 0) goto L_0x0055
            kotlinx.coroutines.Job$ad r9 = kotlinx.coroutines.Job.f6325fe     // Catch:{ all -> 0x00ce }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch:{ all -> 0x00ce }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x00ce }
            goto L_0x0056
        L_0x0055:
            r6 = r5
        L_0x0056:
            if (r6 == 0) goto L_0x0085
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x00ce }
            if (r9 != 0) goto L_0x0085
            java.util.concurrent.CancellationException r6 = r6.rg()     // Catch:{ all -> 0x00ce }
            r10.qw(r7, r6)     // Catch:{ all -> 0x00ce }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00ce }
            boolean r7 = i.qw.k.fe()     // Catch:{ all -> 0x00ce }
            if (r7 == 0) goto L_0x0079
            boolean r7 = r2 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame     // Catch:{ all -> 0x00ce }
            if (r7 != 0) goto L_0x0072
            goto L_0x0079
        L_0x0072:
            r7 = r2
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r7     // Catch:{ all -> 0x00ce }
            java.lang.Throwable r6 = i.qw.x1.b.o(r6, r7)     // Catch:{ all -> 0x00ce }
        L_0x0079:
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)     // Catch:{ all -> 0x00ce }
            java.lang.Object r6 = kotlin.Result.m1155constructorimpl(r6)     // Catch:{ all -> 0x00ce }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00ce }
            goto L_0x00a2
        L_0x0085:
            if (r8 == 0) goto L_0x0095
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x00ce }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r8)     // Catch:{ all -> 0x00ce }
            java.lang.Object r6 = kotlin.Result.m1155constructorimpl(r6)     // Catch:{ all -> 0x00ce }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00ce }
            goto L_0x00a2
        L_0x0095:
            java.lang.Object r6 = r10.rg(r7)     // Catch:{ all -> 0x00ce }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00ce }
            java.lang.Object r6 = kotlin.Result.m1155constructorimpl(r6)     // Catch:{ all -> 0x00ce }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00ce }
        L_0x00a2:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ce }
            if (r4 == 0) goto L_0x00ac
            boolean r2 = r4.v0()     // Catch:{ all -> 0x00db }
            if (r2 == 0) goto L_0x00af
        L_0x00ac:
            kotlinx.coroutines.internal.ThreadContextKt.qw(r3, r1)     // Catch:{ all -> 0x00db }
        L_0x00af:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00bb }
            r0.ppp()     // Catch:{ all -> 0x00bb }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bb }
            java.lang.Object r0 = kotlin.Result.m1155constructorimpl(r0)     // Catch:{ all -> 0x00bb }
            goto L_0x00c6
        L_0x00bb:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m1155constructorimpl(r0)
        L_0x00c6:
            java.lang.Throwable r0 = kotlin.Result.m1158exceptionOrNullimpl(r0)
            r10.th(r5, r0)
            goto L_0x00fa
        L_0x00ce:
            r2 = move-exception
            if (r4 == 0) goto L_0x00d7
            boolean r4 = r4.v0()     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x00da
        L_0x00d7:
            kotlinx.coroutines.internal.ThreadContextKt.qw(r3, r1)     // Catch:{ all -> 0x00db }
        L_0x00da:
            throw r2     // Catch:{ all -> 0x00db }
        L_0x00db:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00e8 }
            r0.ppp()     // Catch:{ all -> 0x00e8 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e8 }
            java.lang.Object r0 = kotlin.Result.m1155constructorimpl(r0)     // Catch:{ all -> 0x00e8 }
            goto L_0x00f3
        L_0x00e8:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m1155constructorimpl(r0)
        L_0x00f3:
            java.lang.Throwable r0 = kotlin.Result.m1158exceptionOrNullimpl(r0)
            r10.th(r1, r0)
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.r.run():void");
    }

    public final void th(@Nullable Throwable th2, @Nullable Throwable th3) {
        if (th2 != null || th3 != null) {
            if (!(th2 == null || th3 == null)) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th2, th3);
            }
            if (th2 == null) {
                th2 = th3;
            }
            Intrinsics.checkNotNull(th2);
            f.qw(de().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
        }
    }

    @Nullable
    public abstract Object yj();
}
