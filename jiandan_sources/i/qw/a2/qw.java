package i.qw.a2;

import i.qw.c;
import i.qw.f;
import i.qw.k;
import i.qw.p0;
import i.qw.tt;
import i.qw.vvv;
import i.qw.x1.b;
import i.qw.x1.ggg;
import i.qw.x1.qqq;
import i.qw.x1.when;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
public final class qw<R> extends when implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6091i;

    /* renamed from: o  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6092o;
    @NotNull
    public volatile /* synthetic */ Object _parentHandle = null;
    @NotNull
    public volatile /* synthetic */ Object _result = ad.f6088de;
    @NotNull
    public volatile /* synthetic */ Object _state = ad.rg();
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Continuation<R> f6093uk;

    public static final class ad extends ggg {
        @NotNull
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public final DisposableHandle f6094uk;

        public ad(@NotNull DisposableHandle disposableHandle) {
            this.f6094uk = disposableHandle;
        }
    }

    public static final class de extends qqq {
        @NotNull
        @JvmField
        public final ggg.de qw;

        public de(@NotNull ggg.de deVar) {
            this.qw = deVar;
        }

        @Nullable
        public Object de(@Nullable Object obj) {
            if (obj != null) {
                qw qwVar = (qw) obj;
                this.qw.fe();
                Object rg2 = this.qw.qw().rg((Object) null);
                qw.f6091i.compareAndSet(qwVar, this, rg2 == null ? this.qw.f6269de : ad.rg());
                return rg2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }

        @NotNull
        public i.qw.x1.fe<?> qw() {
            return this.qw.qw();
        }
    }

    public final class fe extends p0 {
        public fe() {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            s((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void s(@Nullable Throwable th2) {
            if (qw.this.m396if()) {
                qw.this.when(t().rg());
            }
        }
    }

    /* renamed from: i.qw.a2.qw$qw  reason: collision with other inner class name */
    public static final class C0251qw extends i.qw.x1.fe<Object> {
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final qw<?> f6096ad;
        @NotNull
        @JvmField

        /* renamed from: de  reason: collision with root package name */
        public final i.qw.x1.ad f6097de;

        /* renamed from: fe  reason: collision with root package name */
        public final long f6098fe = ad.f6090rg.qw();

        public C0251qw(@NotNull qw<?> qwVar, @NotNull i.qw.x1.ad adVar) {
            this.f6096ad = qwVar;
            this.f6097de = adVar;
            this.f6097de.fe(this);
        }

        public void fe(@Nullable Object obj, @Nullable Object obj2) {
            o(obj2);
            this.f6097de.qw(this, obj2);
        }

        @Nullable
        public Object i(@Nullable Object obj) {
            Object pf2;
            if (obj == null && (pf2 = pf()) != null) {
                return pf2;
            }
            try {
                return this.f6097de.de(this);
            } catch (Throwable th2) {
                if (obj == null) {
                    m398if();
                }
                throw th2;
            }
        }

        /* renamed from: if  reason: not valid java name */
        public final void m398if() {
            qw.f6091i.compareAndSet(this.f6096ad, this, ad.rg());
        }

        public final void o(Object obj) {
            boolean z = obj == null;
            if (qw.f6091i.compareAndSet(this.f6096ad, this, z ? null : ad.rg()) && z) {
                this.f6096ad.u();
            }
        }

        public final Object pf() {
            qw<?> qwVar = this.f6096ad;
            while (true) {
                Object obj = qwVar._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof qqq) {
                    ((qqq) obj).de(this.f6096ad);
                } else if (obj != ad.rg()) {
                    return ad.fe();
                } else {
                    if (qw.f6091i.compareAndSet(this.f6096ad, ad.rg(), this)) {
                        return null;
                    }
                }
            }
        }

        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + yj() + ')';
        }

        public long yj() {
            return this.f6098fe;
        }
    }

    public static final class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ qw f6099ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function1 f6100th;

        public rg(qw qwVar, Function1 function1) {
            this.f6099ad = qwVar;
            this.f6100th = function1;
        }

        public final void run() {
            if (this.f6099ad.m396if()) {
                Function1 function1 = this.f6100th;
                qw qwVar = this.f6099ad;
                qwVar.m397switch();
                i.qw.y1.qw.ad(function1, qwVar);
            }
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<qw> cls2 = qw.class;
        f6091i = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_state");
        f6092o = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_result");
    }

    public qw(@NotNull Continuation<? super R> continuation) {
        this.f6093uk = continuation;
    }

    public <Q> void ddd(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.de(this, function2);
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.f6093uk;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.f6093uk.getContext();
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public Object ggg(@NotNull i.qw.x1.ad adVar) {
        return new C0251qw(this, adVar).de((Object) null);
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m396if() {
        Object pf2 = pf((ggg.de) null);
        if (pf2 == vvv.qw) {
            return true;
        }
        if (pf2 == null) {
            return false;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Unexpected trySelectIdempotent result ", pf2).toString());
    }

    @Nullable
    public Object pf(@Nullable ggg.de deVar) {
        while (true) {
            Object obj = this._state;
            if (obj == ad.rg()) {
                if (deVar == null) {
                    if (f6091i.compareAndSet(this, ad.rg(), (Object) null)) {
                        break;
                    }
                } else {
                    de deVar2 = new de(deVar);
                    if (f6091i.compareAndSet(this, ad.rg(), deVar2)) {
                        Object de2 = deVar2.de(this);
                        if (de2 != null) {
                            return de2;
                        }
                    }
                }
            } else if (obj instanceof qqq) {
                if (deVar != null) {
                    i.qw.x1.fe<?> qw = deVar.qw();
                    if ((qw instanceof C0251qw) && ((C0251qw) qw).f6096ad == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    } else if (qw.ad((qqq) obj)) {
                        return i.qw.x1.de.f6259ad;
                    }
                }
                ((qqq) obj).de(this);
            } else if (deVar != null && obj == deVar.f6269de) {
                return vvv.qw;
            } else {
                return null;
            }
        }
        u();
        return vvv.qw;
    }

    public void resumeWith(@NotNull Object obj) {
        if (!k.qw() || rg()) {
            while (true) {
                Object obj2 = this._result;
                if (obj2 == ad.f6088de) {
                    if (f6092o.compareAndSet(this, ad.f6088de, c.fe(obj, (Function1) null, 1, (Object) null))) {
                        return;
                    }
                } else if (obj2 != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (f6092o.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), ad.f6089fe)) {
                    if (Result.m1161isFailureimpl(obj)) {
                        Continuation<R> continuation = this.f6093uk;
                        Throwable r4 = Result.m1158exceptionOrNullimpl(obj);
                        Intrinsics.checkNotNull(r4);
                        Result.Companion companion = Result.Companion;
                        if (k.fe() && (continuation instanceof CoroutineStackFrame)) {
                            r4 = b.o(r4, (CoroutineStackFrame) continuation);
                        }
                        continuation.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(r4)));
                        return;
                    }
                    this.f6093uk.resumeWith(obj);
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public boolean rg() {
        while (true) {
            Object obj = this._state;
            if (obj == ad.rg()) {
                return false;
            }
            if (!(obj instanceof qqq)) {
                return true;
            }
            ((qqq) obj).de(this);
        }
    }

    @NotNull
    /* renamed from: switch  reason: not valid java name */
    public Continuation<R> m397switch() {
        return this;
    }

    public void th(long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j > 0) {
            uk(DelayKt.de(getContext()).uk(j, new rg(this, function1), getContext()));
        } else if (m396if()) {
            m397switch();
            i.qw.y1.ad.de(function1, this);
        }
    }

    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    public final void u() {
        DisposableHandle v = v();
        if (v != null) {
            v.dispose();
        }
        for (ggg ggg = (ggg) e(); !Intrinsics.areEqual((Object) ggg, (Object) this); ggg = ggg.f()) {
            if (ggg instanceof ad) {
                ((ad) ggg).f6094uk.dispose();
            }
        }
    }

    public void uk(@NotNull DisposableHandle disposableHandle) {
        ad adVar = new ad(disposableHandle);
        if (!rg()) {
            qqq(adVar);
            if (!rg()) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    public final DisposableHandle v() {
        return (DisposableHandle) this._parentHandle;
    }

    @Nullable
    @PublishedApi
    public final Object w() {
        if (!rg()) {
            y();
        }
        Object obj = this._result;
        if (obj == ad.f6088de) {
            if (f6092o.compareAndSet(this, ad.f6088de, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj = this._result;
        }
        if (obj == ad.f6089fe) {
            throw new IllegalStateException("Already resumed");
        } else if (!(obj instanceof tt)) {
            return obj;
        } else {
            throw ((tt) obj).qw;
        }
    }

    public void when(@NotNull Throwable th2) {
        if (!k.qw() || rg()) {
            while (true) {
                Object obj = this._result;
                if (obj == ad.f6088de) {
                    Continuation<R> continuation = this.f6093uk;
                    if (f6092o.compareAndSet(this, ad.f6088de, new tt((!k.fe() || !(continuation instanceof CoroutineStackFrame)) ? th2 : b.o(th2, (CoroutineStackFrame) continuation), false, 2, (DefaultConstructorMarker) null))) {
                        return;
                    }
                } else if (obj != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    throw new IllegalStateException("Already resumed");
                } else if (f6092o.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), ad.f6089fe)) {
                    Continuation<R> intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this.f6093uk);
                    Result.Companion companion = Result.Companion;
                    intercepted.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    @PublishedApi
    public final void x(@NotNull Throwable th2) {
        if (m396if()) {
            Result.Companion companion = Result.Companion;
            resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(th2)));
        } else if (!(th2 instanceof CancellationException)) {
            Object w = w();
            if (w instanceof tt) {
                Throwable th3 = ((tt) w).qw;
                if (k.fe()) {
                    th3 = b.m412switch(th3);
                }
                if (th3 == (!k.fe() ? th2 : b.m412switch(th2))) {
                    return;
                }
            }
            f.qw(getContext(), th2);
        }
    }

    public final void y() {
        Job job = (Job) getContext().get(Job.f6325fe);
        if (job != null) {
            DisposableHandle fe2 = Job.qw.fe(job, true, false, new fe(), 2, (Object) null);
            z(fe2);
            if (rg()) {
                fe2.dispose();
            }
        }
    }

    public final void z(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }
}
