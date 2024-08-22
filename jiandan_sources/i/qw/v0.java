package i.qw;

import i.qw.x1.b;
import i.qw.x1.ggg;
import i.qw.x1.ppp;
import i.qw.x1.qqq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.ParentJob;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class v0 implements Job, ChildJob, ParentJob, SelectClause0 {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6202ad = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_state");
    @NotNull
    public volatile /* synthetic */ Object _parentHandle;
    @NotNull
    public volatile /* synthetic */ Object _state;

    public static final class ad extends u0 {
        @NotNull

        /* renamed from: i  reason: collision with root package name */
        public final v0 f6203i;
        @Nullable

        /* renamed from: if  reason: not valid java name */
        public final Object f250if;
        @NotNull

        /* renamed from: o  reason: collision with root package name */
        public final de f6204o;
        @NotNull

        /* renamed from: pf  reason: collision with root package name */
        public final mmm f6205pf;

        public ad(@NotNull v0 v0Var, @NotNull de deVar, @NotNull mmm mmm, @Nullable Object obj) {
            this.f6203i = v0Var;
            this.f6204o = deVar;
            this.f6205pf = mmm;
            this.f250if = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            s((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void s(@Nullable Throwable th2) {
            this.f6203i.y(this.f6204o, this.f6205pf, this.f250if);
        }
    }

    public static final class de implements Incomplete {
        @NotNull
        public volatile /* synthetic */ Object _exceptionsHolder = null;
        @NotNull
        public volatile /* synthetic */ int _isCompleting;
        @NotNull
        public volatile /* synthetic */ Object _rootCause;
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final a1 f6206ad;

        public de(@NotNull a1 a1Var, boolean z, @Nullable Throwable th2) {
            this.f6206ad = a1Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th2;
        }

        public final void ad(@NotNull Throwable th2) {
            Throwable rg2 = rg();
            if (rg2 == null) {
                m406if(th2);
            } else if (th2 != rg2) {
                Object fe2 = fe();
                if (fe2 == null) {
                    pf(th2);
                } else if (fe2 instanceof Throwable) {
                    if (th2 != fe2) {
                        ArrayList<Throwable> de2 = de();
                        de2.add(fe2);
                        de2.add(th2);
                        Unit unit = Unit.INSTANCE;
                        pf(de2);
                    }
                } else if (fe2 instanceof ArrayList) {
                    ((ArrayList) fe2).add(th2);
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("State is ", fe2).toString());
                }
            }
        }

        public final ArrayList<Throwable> de() {
            return new ArrayList<>(4);
        }

        public final Object fe() {
            return this._exceptionsHolder;
        }

        @NotNull
        public final List<Throwable> i(@Nullable Throwable th2) {
            ArrayList<Throwable> arrayList;
            Object fe2 = fe();
            if (fe2 == null) {
                arrayList = de();
            } else if (fe2 instanceof Throwable) {
                ArrayList<Throwable> de2 = de();
                de2.add(fe2);
                arrayList = de2;
            } else if (fe2 instanceof ArrayList) {
                arrayList = (ArrayList) fe2;
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("State is ", fe2).toString());
            }
            Throwable rg2 = rg();
            if (rg2 != null) {
                arrayList.add(0, rg2);
            }
            if (th2 != null && !Intrinsics.areEqual((Object) th2, (Object) rg2)) {
                arrayList.add(th2);
            }
            pf(w0.f6221rg);
            return arrayList;
        }

        /* renamed from: if  reason: not valid java name */
        public final void m406if(@Nullable Throwable th2) {
            this._rootCause = th2;
        }

        public boolean isActive() {
            return rg() == null;
        }

        public final void o(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        public final void pf(Object obj) {
            this._exceptionsHolder = obj;
        }

        @NotNull
        public a1 qw() {
            return this.f6206ad;
        }

        @Nullable
        public final Throwable rg() {
            return (Throwable) this._rootCause;
        }

        public final boolean th() {
            return rg() != null;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + th() + ", completing=" + yj() + ", rootCause=" + rg() + ", exceptions=" + fe() + ", list=" + qw() + ']';
        }

        public final boolean uk() {
            return fe() == w0.f6221rg;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
        public final boolean yj() {
            return this._isCompleting;
        }
    }

    public static final class fe extends ggg.ad {

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ v0 f6207fe;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ Object f6208rg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public fe(ggg ggg, v0 v0Var, Object obj) {
            super(ggg);
            this.f6207fe = v0Var;
            this.f6208rg = obj;
        }

        @Nullable
        /* renamed from: pf */
        public Object i(@NotNull ggg ggg) {
            if (this.f6207fe.I() == this.f6208rg) {
                return null;
            }
            return ppp.qw();
        }
    }

    public static final class qw<T> extends ggg<T> {
        @NotNull

        /* renamed from: switch  reason: not valid java name */
        public final v0 f251switch;

        public qw(@NotNull Continuation<? super T> continuation, @NotNull v0 v0Var) {
            super(continuation, 1);
            this.f251switch = v0Var;
        }

        @NotNull
        public String f() {
            return "AwaitContinuation";
        }

        @NotNull
        public Throwable nn(@NotNull Job job) {
            Throwable rg2;
            Object I = this.f251switch.I();
            if ((I instanceof de) && (rg2 = ((de) I).rg()) != null) {
                return rg2;
            }
            if (I instanceof tt) {
                return ((tt) I).qw;
            }
            return job.rg();
        }
    }

    public v0(boolean z) {
        this._state = z ? w0.f6223yj : w0.f6222th;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException j0(v0 v0Var, Throwable th2, String str, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            return v0Var.i0(th2, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public final Object A(de deVar, Object obj) {
        boolean th2;
        Throwable D;
        boolean z = true;
        if (k.qw()) {
            if (!(I() == deVar)) {
                throw new AssertionError();
            }
        }
        if (k.qw() && !(!deVar.uk())) {
            throw new AssertionError();
        } else if (!k.qw() || deVar.yj()) {
            tt ttVar = obj instanceof tt ? (tt) obj : null;
            Throwable th3 = ttVar == null ? null : ttVar.qw;
            synchronized (deVar) {
                th2 = deVar.th();
                List<Throwable> i2 = deVar.i(th3);
                D = D(deVar, i2);
                if (D != null) {
                    l(D, i2);
                }
            }
            if (!(D == null || D == th3)) {
                obj = new tt(D, false, 2, (DefaultConstructorMarker) null);
            }
            if (D != null) {
                if (!u(D) && !J(D)) {
                    z = false;
                }
                if (z) {
                    if (obj != null) {
                        ((tt) obj).ad();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                }
            }
            if (!th2) {
                X(D);
            }
            Y(obj);
            boolean compareAndSet = f6202ad.compareAndSet(this, deVar, w0.yj(obj));
            if (!k.qw() || compareAndSet) {
                x(deVar, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    public final mmm B(Incomplete incomplete) {
        mmm mmm = incomplete instanceof mmm ? (mmm) incomplete : null;
        if (mmm != null) {
            return mmm;
        }
        a1 qw2 = incomplete.qw();
        if (qw2 == null) {
            return null;
        }
        return U(qw2);
    }

    public final Throwable C(Object obj) {
        tt ttVar = obj instanceof tt ? (tt) obj : null;
        if (ttVar == null) {
            return null;
        }
        return ttVar.qw;
    }

    public final Throwable D(de deVar, List<? extends Throwable> list) {
        T t;
        boolean z;
        T t2 = null;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (!(((Throwable) t) instanceof CancellationException)) {
                    break;
                }
            }
            Throwable th2 = (Throwable) t;
            if (th2 != null) {
                return th2;
            }
            Throwable th3 = (Throwable) list.get(0);
            if (th3 instanceof TimeoutCancellationException) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    Throwable th4 = (Throwable) next;
                    if (th4 == th3 || !(th4 instanceof TimeoutCancellationException)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t2 = next;
                        break;
                    }
                }
                Throwable th5 = (Throwable) t2;
                if (th5 != null) {
                    return th5;
                }
            }
            return th3;
        } else if (deVar.th()) {
            return new JobCancellationException(v(), (Throwable) null, this);
        } else {
            return null;
        }
    }

    public boolean E() {
        return true;
    }

    public boolean F() {
        return false;
    }

    public final a1 G(Incomplete incomplete) {
        a1 qw2 = incomplete.qw();
        if (qw2 != null) {
            return qw2;
        }
        if (incomplete instanceof y) {
            return new a1();
        }
        if (incomplete instanceof u0) {
            b0((u0) incomplete);
            return null;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("State should have list: ", incomplete).toString());
    }

    @Nullable
    public final ChildHandle H() {
        return (ChildHandle) this._parentHandle;
    }

    @Nullable
    public final Object I() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof qqq)) {
                return obj;
            }
            ((qqq) obj).de(this);
        }
    }

    public boolean J(@NotNull Throwable th2) {
        return false;
    }

    public void K(@NotNull Throwable th2) {
        throw th2;
    }

    public final void L(@Nullable Job job) {
        if (k.qw()) {
            if (!(H() == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            f0(b1.f6105ad);
            return;
        }
        job.start();
        ChildHandle f = job.f(this);
        f0(f);
        if (nn()) {
            f.dispose();
            f0(b1.f6105ad);
        }
    }

    public boolean M() {
        return false;
    }

    public final boolean N() {
        Object I;
        do {
            I = I();
            if (!(I instanceof Incomplete)) {
                return false;
            }
        } while (g0(I) < 0);
        return true;
    }

    public final Object O(Continuation<? super Unit> continuation) {
        ggg ggg = new ggg(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        ggg.eee();
        xxx.qw(ggg, pf(new e1(ggg)));
        Object mmm = ggg.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mmm : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        V(((i.qw.v0.de) r2).qw(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        return i.qw.w0.qw();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object P(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.I()
            boolean r3 = r2 instanceof i.qw.v0.de
            if (r3 == 0) goto L_0x0052
            monitor-enter(r2)
            r3 = r2
            i.qw.v0$de r3 = (i.qw.v0.de) r3     // Catch:{ all -> 0x004f }
            boolean r3 = r3.uk()     // Catch:{ all -> 0x004f }
            if (r3 == 0) goto L_0x001a
            i.qw.x1.c r7 = i.qw.w0.f6220fe     // Catch:{ all -> 0x004f }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            i.qw.v0$de r3 = (i.qw.v0.de) r3     // Catch:{ all -> 0x004f }
            boolean r3 = r3.th()     // Catch:{ all -> 0x004f }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.z(r7)     // Catch:{ all -> 0x004f }
        L_0x002b:
            r7 = r2
            i.qw.v0$de r7 = (i.qw.v0.de) r7     // Catch:{ all -> 0x004f }
            r7.ad(r1)     // Catch:{ all -> 0x004f }
        L_0x0031:
            r7 = r2
            i.qw.v0$de r7 = (i.qw.v0.de) r7     // Catch:{ all -> 0x004f }
            java.lang.Throwable r7 = r7.rg()     // Catch:{ all -> 0x004f }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 != 0) goto L_0x0041
            goto L_0x004a
        L_0x0041:
            i.qw.v0$de r2 = (i.qw.v0.de) r2
            i.qw.a1 r7 = r2.qw()
            r6.V(r7, r0)
        L_0x004a:
            i.qw.x1.c r7 = i.qw.w0.qw
            return r7
        L_0x004f:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0052:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x009a
            if (r1 != 0) goto L_0x005c
            java.lang.Throwable r1 = r6.z(r7)
        L_0x005c:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x0070
            boolean r2 = r6.m0(r3, r1)
            if (r2 == 0) goto L_0x0002
            i.qw.x1.c r7 = i.qw.w0.qw
            return r7
        L_0x0070:
            i.qw.tt r3 = new i.qw.tt
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.n0(r2, r3)
            i.qw.x1.c r4 = i.qw.w0.qw
            if (r3 == r4) goto L_0x008a
            i.qw.x1.c r2 = i.qw.w0.f6219de
            if (r3 != r2) goto L_0x0089
            goto L_0x0002
        L_0x0089:
            return r3
        L_0x008a:
            java.lang.String r7 = "Cannot happen in "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r2)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x009a:
            i.qw.x1.c r7 = i.qw.w0.f6220fe
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.v0.P(java.lang.Object):java.lang.Object");
    }

    public final boolean Q(@Nullable Object obj) {
        Object n0;
        do {
            n0 = n0(I(), obj);
            if (n0 == w0.qw) {
                return false;
            }
            if (n0 == w0.f6218ad) {
                return true;
            }
        } while (n0 == w0.f6219de);
        m(n0);
        return true;
    }

    @Nullable
    public final Object R(@Nullable Object obj) {
        Object n0;
        do {
            n0 = n0(I(), obj);
            if (n0 == w0.qw) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, C(obj));
            }
        } while (n0 == w0.f6219de);
        return n0;
    }

    public final u0 S(Function1<? super Throwable, Unit> function1, boolean z) {
        u0 u0Var = null;
        if (z) {
            if (function1 instanceof p0) {
                u0Var = (p0) function1;
            }
            if (u0Var == null) {
                u0Var = new n0(function1);
            }
        } else {
            u0 u0Var2 = function1 instanceof u0 ? (u0) function1 : null;
            if (u0Var2 != null) {
                if (!k.qw() || (!(u0Var2 instanceof p0))) {
                    u0Var = u0Var2;
                } else {
                    throw new AssertionError();
                }
            }
            if (u0Var == null) {
                u0Var = new o0(function1);
            }
        }
        u0Var.u(this);
        return u0Var;
    }

    @NotNull
    public String T() {
        return l.qw(this);
    }

    public final mmm U(ggg ggg) {
        while (ggg.l()) {
            ggg = ggg.h();
        }
        while (true) {
            ggg = ggg.f();
            if (!ggg.l()) {
                if (ggg instanceof mmm) {
                    return (mmm) ggg;
                }
                if (ggg instanceof a1) {
                    return null;
                }
            }
        }
    }

    public final void V(a1 a1Var, Throwable th2) {
        CompletionHandlerException completionHandlerException;
        X(th2);
        CompletionHandlerException completionHandlerException2 = null;
        for (ggg ggg = (ggg) a1Var.e(); !Intrinsics.areEqual((Object) ggg, (Object) a1Var); ggg = ggg.f()) {
            if (ggg instanceof p0) {
                u0 u0Var = (u0) ggg;
                try {
                    u0Var.s(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException2, th3);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + u0Var + " for " + this, th3);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            K(completionHandlerException2);
        }
        u(th2);
    }

    public final void W(a1 a1Var, Throwable th2) {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (ggg ggg = (ggg) a1Var.e(); !Intrinsics.areEqual((Object) ggg, (Object) a1Var); ggg = ggg.f()) {
            if (ggg instanceof u0) {
                u0 u0Var = (u0) ggg;
                try {
                    u0Var.s(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        ExceptionsKt__ExceptionsKt.addSuppressed(completionHandlerException2, th3);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + u0Var + " for " + this, th3);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            K(completionHandlerException2);
        }
    }

    public void X(@Nullable Throwable th2) {
    }

    public void Y(@Nullable Object obj) {
    }

    public void Z() {
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [i.qw.j0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a0(i.qw.y r3) {
        /*
            r2 = this;
            i.qw.a1 r0 = new i.qw.a1
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            i.qw.j0 r1 = new i.qw.j0
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6202ad
            r1.compareAndSet(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.v0.a0(i.qw.y):void");
    }

    @Nullable
    public final Object aaa(@NotNull Continuation<? super Unit> continuation) {
        if (!N()) {
            r0.yj(continuation.getContext());
            return Unit.INSTANCE;
        }
        Object O = O(continuation);
        return O == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? O : Unit.INSTANCE;
    }

    public final void b0(u0 u0Var) {
        u0Var.rrr(new a1());
        f6202ad.compareAndSet(this, u0Var, u0Var.f());
    }

    public final <T, R> void c0(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object I;
        do {
            I = I();
            if (!selectInstance.rg()) {
                if (!(I instanceof Incomplete)) {
                    if (!selectInstance.m668if()) {
                        return;
                    }
                    if (I instanceof tt) {
                        selectInstance.when(((tt) I).qw);
                        return;
                    } else {
                        i.qw.y1.ad.fe(function2, w0.uk(I), selectInstance.m669switch());
                        return;
                    }
                }
            } else {
                return;
            }
        } while (g0(I) != 0);
        selectInstance.uk(pf(new g1(selectInstance, function2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d0(@org.jetbrains.annotations.NotNull i.qw.u0 r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.I()
            boolean r1 = r0 instanceof i.qw.u0
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6202ad
            i.qw.y r2 = i.qw.w0.f6223yj
            boolean r0 = r1.compareAndSet(r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            i.qw.a1 r0 = r0.qw()
            if (r0 == 0) goto L_0x0027
            r4.m()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.v0.d0(i.qw.u0):void");
    }

    @NotNull
    public CancellationException ddd() {
        Throwable th2;
        Object I = I();
        CancellationException cancellationException = null;
        if (I instanceof de) {
            th2 = ((de) I).rg();
        } else if (I instanceof tt) {
            th2 = ((tt) I).qw;
        } else if (!(I instanceof Incomplete)) {
            th2 = null;
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("Cannot be cancelling child in this state: ", I).toString());
        }
        if (th2 instanceof CancellationException) {
            cancellationException = (CancellationException) th2;
        }
        return cancellationException == null ? new JobCancellationException(Intrinsics.stringPlus("Parent job is ", h0(I)), th2, this) : cancellationException;
    }

    public final <T, R> void e0(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object I = I();
        if (I instanceof tt) {
            selectInstance.when(((tt) I).qw);
            return;
        }
        i.qw.y1.qw.fe(function2, w0.uk(I), selectInstance.m669switch(), (Function1) null, 4, (Object) null);
    }

    @NotNull
    public final ChildHandle f(@NotNull ChildJob childJob) {
        return (ChildHandle) Job.qw.fe(this, true, false, new mmm(childJob), 2, (Object) null);
    }

    public final void f0(@Nullable ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @NotNull
    public final DisposableHandle fe(boolean z, boolean z2, @NotNull Function1<? super Throwable, Unit> function1) {
        u0 S = S(function1, z);
        while (true) {
            Object I = I();
            if (I instanceof y) {
                y yVar = (y) I;
                if (!yVar.isActive()) {
                    a0(yVar);
                } else if (f6202ad.compareAndSet(this, I, S)) {
                    return S;
                }
            } else {
                Throwable th2 = null;
                if (I instanceof Incomplete) {
                    a1 qw2 = ((Incomplete) I).qw();
                    if (qw2 != null) {
                        DisposableHandle disposableHandle = b1.f6105ad;
                        if (z && (I instanceof de)) {
                            synchronized (I) {
                                th2 = ((de) I).rg();
                                if (th2 == null || ((function1 instanceof mmm) && !((de) I).yj())) {
                                    if (k(I, qw2, S)) {
                                        if (th2 == null) {
                                            return S;
                                        }
                                        disposableHandle = S;
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        if (th2 != null) {
                            if (z2) {
                                function1.invoke(th2);
                            }
                            return disposableHandle;
                        } else if (k(I, qw2, S)) {
                            return S;
                        }
                    } else if (I != null) {
                        b0((u0) I);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                } else {
                    if (z2) {
                        tt ttVar = I instanceof tt ? (tt) I : null;
                        if (ttVar != null) {
                            th2 = ttVar.qw;
                        }
                        function1.invoke(th2);
                    }
                    return b1.f6105ad;
                }
            }
        }
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return Job.qw.ad(this, r, function2);
    }

    public final int g0(Object obj) {
        if (obj instanceof y) {
            if (((y) obj).isActive()) {
                return 0;
            }
            if (!f6202ad.compareAndSet(this, obj, w0.f6223yj)) {
                return -1;
            }
            Z();
            return 1;
        } else if (!(obj instanceof j0)) {
            return 0;
        } else {
            if (!f6202ad.compareAndSet(this, obj, ((j0) obj).qw())) {
                return -1;
            }
            Z();
            return 1;
        }
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return Job.qw.de(this, key);
    }

    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.f6325fe;
    }

    public final String h0(Object obj) {
        if (obj instanceof de) {
            de deVar = (de) obj;
            if (deVar.th()) {
                return "Cancelling";
            }
            if (deVar.yj()) {
                return "Completing";
            }
            return "Active";
        } else if (!(obj instanceof Incomplete)) {
            return obj instanceof tt ? "Cancelled" : "Completed";
        } else {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
    }

    @NotNull
    public final CancellationException i0(@NotNull Throwable th2, @Nullable String str) {
        CancellationException cancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (cancellationException == null) {
            if (str == null) {
                str = v();
            }
            cancellationException = new JobCancellationException(str, th2, this);
        }
        return cancellationException;
    }

    public boolean isActive() {
        Object I = I();
        return (I instanceof Incomplete) && ((Incomplete) I).isActive();
    }

    public final boolean isCancelled() {
        Object I = I();
        return (I instanceof tt) || ((I instanceof de) && ((de) I).th());
    }

    public final boolean k(Object obj, a1 a1Var, u0 u0Var) {
        int r;
        fe feVar = new fe(u0Var, this, obj);
        do {
            r = a1Var.h().r(u0Var, a1Var, feVar);
            if (r == 1) {
                return true;
            }
        } while (r != 2);
        return false;
    }

    @NotNull
    public final String k0() {
        return T() + ExtendedMessageFormat.START_FE + h0(I()) + ExtendedMessageFormat.END_FE;
    }

    public final void l(Throwable th2, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Throwable th3 = !k.fe() ? th2 : b.m412switch(th2);
            for (Throwable th4 : list) {
                if (k.fe()) {
                    th4 = b.m412switch(th4);
                }
                if (th4 != th2 && th4 != th3 && !(th4 instanceof CancellationException) && newSetFromMap.add(th4)) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th2, th4);
                }
            }
        }
    }

    public final boolean l0(Incomplete incomplete, Object obj) {
        if (k.qw()) {
            if (!((incomplete instanceof y) || (incomplete instanceof u0))) {
                throw new AssertionError();
            }
        }
        if (k.qw() && !(!(obj instanceof tt))) {
            throw new AssertionError();
        } else if (!f6202ad.compareAndSet(this, incomplete, w0.yj(obj))) {
            return false;
        } else {
            X((Throwable) null);
            Y(obj);
            x(incomplete, obj);
            return true;
        }
    }

    public void m(@Nullable Object obj) {
    }

    public final boolean m0(Incomplete incomplete, Throwable th2) {
        if (k.qw() && !(!(incomplete instanceof de))) {
            throw new AssertionError();
        } else if (!k.qw() || incomplete.isActive()) {
            a1 G = G(incomplete);
            if (G == null) {
                return false;
            }
            if (!f6202ad.compareAndSet(this, incomplete, new de(G, false, th2))) {
                return false;
            }
            V(G, th2);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.qw.rg(this, key);
    }

    @Nullable
    public final Object n(@NotNull Continuation<Object> continuation) {
        Object I;
        do {
            I = I();
            if (!(I instanceof Incomplete)) {
                if (!(I instanceof tt)) {
                    return w0.uk(I);
                }
                Throwable th2 = ((tt) I).qw;
                if (!k.fe()) {
                    throw th2;
                } else if (!(continuation instanceof CoroutineStackFrame)) {
                    throw th2;
                } else {
                    throw b.o(th2, (CoroutineStackFrame) continuation);
                }
            }
        } while (g0(I) < 0);
        return p(continuation);
    }

    public final Object n0(Object obj, Object obj2) {
        if (!(obj instanceof Incomplete)) {
            return w0.qw;
        }
        if ((!(obj instanceof y) && !(obj instanceof u0)) || (obj instanceof mmm) || (obj2 instanceof tt)) {
            return o0((Incomplete) obj, obj2);
        }
        if (l0((Incomplete) obj, obj2)) {
            return obj2;
        }
        return w0.f6219de;
    }

    public final boolean nn() {
        return !(I() instanceof Incomplete);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0072, code lost:
        if (r2 != null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0075, code lost:
        V(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0078, code lost:
        r7 = B(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x007c, code lost:
        if (r7 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0082, code lost:
        if (p0(r1, r7, r8) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0086, code lost:
        return i.qw.w0.f6218ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x008b, code lost:
        return A(r1, r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o0(kotlinx.coroutines.Incomplete r7, java.lang.Object r8) {
        /*
            r6 = this;
            i.qw.a1 r0 = r6.G(r7)
            if (r0 != 0) goto L_0x000b
            i.qw.x1.c r7 = i.qw.w0.f6219de
            return r7
        L_0x000b:
            boolean r1 = r7 instanceof i.qw.v0.de
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r7
            i.qw.v0$de r1 = (i.qw.v0.de) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            if (r1 != 0) goto L_0x001d
            i.qw.v0$de r1 = new i.qw.v0$de
            r3 = 0
            r1.<init>(r0, r3, r2)
        L_0x001d:
            monitor-enter(r1)
            boolean r3 = r1.yj()     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x002a
            i.qw.x1.c r7 = i.qw.w0.qw     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            return r7
        L_0x002a:
            r3 = 1
            r1.o(r3)     // Catch:{ all -> 0x008c }
            if (r1 == r7) goto L_0x003e
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f6202ad     // Catch:{ all -> 0x008c }
            boolean r4 = r4.compareAndSet(r6, r7, r1)     // Catch:{ all -> 0x008c }
            if (r4 != 0) goto L_0x003e
            i.qw.x1.c r7 = i.qw.w0.f6219de     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            return r7
        L_0x003e:
            boolean r4 = i.qw.k.qw()     // Catch:{ all -> 0x008c }
            if (r4 == 0) goto L_0x0052
            boolean r4 = r1.uk()     // Catch:{ all -> 0x008c }
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x004c
            goto L_0x0052
        L_0x004c:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x008c }
            r7.<init>()     // Catch:{ all -> 0x008c }
            throw r7     // Catch:{ all -> 0x008c }
        L_0x0052:
            boolean r4 = r1.th()     // Catch:{ all -> 0x008c }
            boolean r5 = r8 instanceof i.qw.tt     // Catch:{ all -> 0x008c }
            if (r5 == 0) goto L_0x005e
            r5 = r8
            i.qw.tt r5 = (i.qw.tt) r5     // Catch:{ all -> 0x008c }
            goto L_0x005f
        L_0x005e:
            r5 = r2
        L_0x005f:
            if (r5 != 0) goto L_0x0062
            goto L_0x0067
        L_0x0062:
            java.lang.Throwable r5 = r5.qw     // Catch:{ all -> 0x008c }
            r1.ad(r5)     // Catch:{ all -> 0x008c }
        L_0x0067:
            java.lang.Throwable r5 = r1.rg()     // Catch:{ all -> 0x008c }
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x006f
            r2 = r5
        L_0x006f:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008c }
            monitor-exit(r1)
            if (r2 != 0) goto L_0x0075
            goto L_0x0078
        L_0x0075:
            r6.V(r0, r2)
        L_0x0078:
            i.qw.mmm r7 = r6.B(r7)
            if (r7 == 0) goto L_0x0087
            boolean r7 = r6.p0(r1, r7, r8)
            if (r7 == 0) goto L_0x0087
            i.qw.x1.c r7 = i.qw.w0.f6218ad
            return r7
        L_0x0087:
            java.lang.Object r7 = r6.A(r1, r8)
            return r7
        L_0x008c:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.v0.o0(kotlinx.coroutines.Incomplete, java.lang.Object):java.lang.Object");
    }

    public final Object p(Continuation<Object> continuation) {
        qw qwVar = new qw(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), this);
        qwVar.eee();
        xxx.qw(qwVar, pf(new d1(qwVar)));
        Object mmm = qwVar.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm;
    }

    public final boolean p0(de deVar, mmm mmm, Object obj) {
        while (Job.qw.fe(mmm.f6149i, false, false, new ad(this, deVar, mmm, obj), 1, (Object) null) == b1.f6105ad) {
            mmm = U(mmm);
            if (mmm == null) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final DisposableHandle pf(@NotNull Function1<? super Throwable, Unit> function1) {
        return fe(false, true, function1);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.qw.th(this, coroutineContext);
    }

    public final boolean q(@Nullable Throwable th2) {
        return r(th2);
    }

    public void qw(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(v(), (Throwable) null, this);
        }
        s(cancellationException);
    }

    public final boolean r(@Nullable Object obj) {
        Object qw2 = w0.qw;
        if (F() && (qw2 = t(obj)) == w0.f6218ad) {
            return true;
        }
        if (qw2 == w0.qw) {
            qw2 = P(obj);
        }
        if (qw2 == w0.qw || qw2 == w0.f6218ad) {
            return true;
        }
        if (qw2 == w0.f6220fe) {
            return false;
        }
        m(qw2);
        return true;
    }

    @NotNull
    public final CancellationException rg() {
        Object I = I();
        if (I instanceof de) {
            Throwable rg2 = ((de) I).rg();
            if (rg2 != null) {
                return i0(rg2, Intrinsics.stringPlus(l.qw(this), " is cancelling"));
            }
            throw new IllegalStateException(Intrinsics.stringPlus("Job is still new or active: ", this).toString());
        } else if (I instanceof Incomplete) {
            throw new IllegalStateException(Intrinsics.stringPlus("Job is still new or active: ", this).toString());
        } else if (I instanceof tt) {
            return j0(this, ((tt) I).qw, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(Intrinsics.stringPlus(l.qw(this), " has completed normally"), (Throwable) null, this);
        }
    }

    public void s(@NotNull Throwable th2) {
        r(th2);
    }

    public final boolean start() {
        int g0;
        do {
            g0 = g0(I());
            if (g0 == 0) {
                return false;
            }
        } while (g0 != 1);
        return true;
    }

    public final Object t(Object obj) {
        Object n0;
        do {
            Object I = I();
            if (!(I instanceof Incomplete) || ((I instanceof de) && ((de) I).yj())) {
                return w0.qw;
            }
            n0 = n0(I, new tt(z(obj), false, 2, (DefaultConstructorMarker) null));
        } while (n0 == w0.f6219de);
        return n0;
    }

    @NotNull
    public String toString() {
        return k0() + '@' + l.ad(this);
    }

    public final boolean u(Throwable th2) {
        if (M()) {
            return true;
        }
        boolean z = th2 instanceof CancellationException;
        ChildHandle H = H();
        if (H == null || H == b1.f6105ad) {
            return z;
        }
        if (H.fe(th2) || z) {
            return true;
        }
        return false;
    }

    @NotNull
    public String v() {
        return "Job was cancelled";
    }

    public boolean w(@NotNull Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        if (!r(th2) || !E()) {
            return false;
        }
        return true;
    }

    public final void x(Incomplete incomplete, Object obj) {
        ChildHandle H = H();
        if (H != null) {
            H.dispose();
            f0(b1.f6105ad);
        }
        Throwable th2 = null;
        tt ttVar = obj instanceof tt ? (tt) obj : null;
        if (ttVar != null) {
            th2 = ttVar.qw;
        }
        if (incomplete instanceof u0) {
            try {
                ((u0) incomplete).s(th2);
            } catch (Throwable th3) {
                K(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th3));
            }
        } else {
            a1 qw2 = incomplete.qw();
            if (qw2 != null) {
                W(qw2, th2);
            }
        }
    }

    public final void y(de deVar, mmm mmm, Object obj) {
        if (k.qw()) {
            if (!(I() == deVar)) {
                throw new AssertionError();
            }
        }
        mmm U = U(mmm);
        if (U == null || !p0(deVar, U, obj)) {
            m(A(deVar, obj));
        }
    }

    public final void yj(@NotNull ParentJob parentJob) {
        r(parentJob);
    }

    public final Throwable z(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            if (th2 == null) {
                return new JobCancellationException(v(), (Throwable) null, this);
            }
            return th2;
        } else if (obj != null) {
            return ((ParentJob) obj).ddd();
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }
}
