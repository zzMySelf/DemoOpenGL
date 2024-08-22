package i.qw;

import i.qw.x1.b;
import i.qw.x1.c;
import i.qw.x1.i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NotCompleted;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
public class ggg<T> extends r<T> implements CancellableContinuation<T>, CoroutineStackFrame {

    /* renamed from: if  reason: not valid java name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f248if = AtomicReferenceFieldUpdater.newUpdater(ggg.class, Object.class, "_state");

    /* renamed from: pf  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6129pf = AtomicIntegerFieldUpdater.newUpdater(ggg.class, "_decision");
    @NotNull
    public volatile /* synthetic */ int _decision;
    @NotNull
    public volatile /* synthetic */ Object _state;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final CoroutineContext f6130i;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public DisposableHandle f6131o;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final Continuation<T> f6132uk;

    public ggg(@NotNull Continuation<? super T> continuation, int i2) {
        super(i2);
        this.f6132uk = continuation;
        if (k.qw()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        this.f6130i = this.f6132uk.getContext();
        this._decision = 0;
        this._state = th.f6171ad;
    }

    public static /* synthetic */ void m(ggg ggg, Object obj, int i2, Function1 function1, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 4) != 0) {
                function1 = null;
            }
            ggg.l(obj, i2, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    @Nullable
    public Object a(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        return q(t, obj, function1);
    }

    @Nullable
    public final Object aaa() {
        return this._state;
    }

    @Nullable
    public Object ad(T t, @Nullable Object obj) {
        return q(t, obj, (Function1<? super Throwable, Unit>) null);
    }

    public void b(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.f6132uk;
        CoroutineDispatcher coroutineDispatcher2 = null;
        i iVar = continuation instanceof i ? (i) continuation : null;
        if (iVar != null) {
            coroutineDispatcher2 = iVar.f6277uk;
        }
        m(this, t, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.f6162yj, (Function1) null, 4, (Object) null);
    }

    public final boolean c() {
        Continuation<T> continuation = this.f6132uk;
        return (continuation instanceof i) && ((i) continuation).when(this);
    }

    public final when d(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof when ? (when) function1 : new m0(function1);
    }

    public final void ddd(int i2) {
        if (!p()) {
            s.qw(this, i2);
        }
    }

    @NotNull
    public final Continuation<T> de() {
        return this.f6132uk;
    }

    public final void e(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    public void eee() {
        DisposableHandle rrr = rrr();
        if (rrr != null && tt()) {
            rrr.dispose();
            this.f6131o = b1.f6105ad;
        }
    }

    @NotNull
    public String f() {
        return "CancellableContinuation";
    }

    @Nullable
    public Throwable fe(@Nullable Object obj) {
        Throwable fe2 = super.fe(obj);
        if (fe2 == null) {
            return null;
        }
        Continuation de2 = de();
        return (!k.fe() || !(de2 instanceof CoroutineStackFrame)) ? fe2 : b.o(fe2, (CoroutineStackFrame) de2);
    }

    public void g(@NotNull Object obj) {
        if (k.qw()) {
            if (!(obj == vvv.qw)) {
                throw new AssertionError();
            }
        }
        ddd(this.f6162yj);
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f6132uk;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.f6130i;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void ggg() {
        DisposableHandle disposableHandle = this.f6131o;
        if (disposableHandle != null) {
            disposableHandle.dispose();
            this.f6131o = b1.f6105ad;
        }
    }

    public final void h(@NotNull Throwable th2) {
        if (!when(th2)) {
            vvv(th2);
            xxx();
        }
    }

    public void i(@NotNull Function1<? super Throwable, Unit> function1) {
        when d = d(function1);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof th)) {
                Throwable th2 = null;
                if (!(obj instanceof when)) {
                    boolean z = obj instanceof tt;
                    if (z) {
                        tt ttVar = (tt) obj;
                        if (!ttVar.ad()) {
                            e(function1, obj);
                            throw null;
                        } else if (obj instanceof ddd) {
                            if (!z) {
                                ttVar = null;
                            }
                            if (ttVar != null) {
                                th2 = ttVar.qw;
                            }
                            pf(function1, th2);
                            return;
                        } else {
                            return;
                        }
                    } else if (obj instanceof rrr) {
                        rrr rrr = (rrr) obj;
                        if (rrr.f6165ad != null) {
                            e(function1, obj);
                            throw null;
                        } else if (!(d instanceof yj)) {
                            if (rrr.de()) {
                                pf(function1, rrr.f6168rg);
                                return;
                            }
                            if (f248if.compareAndSet(this, obj, rrr.ad(rrr, (Object) null, d, (Function1) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!(d instanceof yj)) {
                        if (f248if.compareAndSet(this, obj, new rrr(obj, d, (Function1) null, (Object) null, (Throwable) null, 28, (DefaultConstructorMarker) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    e(function1, obj);
                    throw null;
                }
            } else if (f248if.compareAndSet(this, obj, d)) {
                return;
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m400if(@NotNull when when, @Nullable Throwable th2) {
        try {
            when.qw(th2);
        } catch (Throwable th3) {
            f.qw(getContext(), new CompletionHandlerException(Intrinsics.stringPlus("Exception in invokeOnCancellation handler for ", this), th3));
        }
    }

    public final void j() {
        Continuation<T> continuation = this.f6132uk;
        Throwable th2 = null;
        i iVar = continuation instanceof i ? (i) continuation : null;
        if (iVar != null) {
            th2 = iVar.ddd(this);
        }
        if (th2 != null) {
            ggg();
            vvv(th2);
        }
    }

    @JvmName(name = "resetStateReusable")
    public final boolean k() {
        if (k.qw()) {
            if (!(this.f6162yj == 2)) {
                throw new AssertionError();
            }
        }
        if (k.qw()) {
            if (!(this.f6131o != b1.f6105ad)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (k.qw() && !(!(obj instanceof NotCompleted))) {
            throw new AssertionError();
        } else if (!(obj instanceof rrr) || ((rrr) obj).f6167fe == null) {
            this._decision = 0;
            this._state = th.f6171ad;
            return true;
        } else {
            ggg();
            return false;
        }
    }

    public final void l(Object obj, int i2, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof ddd) {
                    ddd ddd = (ddd) obj2;
                    if (ddd.de()) {
                        if (function1 != null) {
                            m401switch(function1, ddd.qw);
                            return;
                        }
                        return;
                    }
                }
                uk(obj);
                throw null;
            }
        } while (!f248if.compareAndSet(this, obj2, n((NotCompleted) obj2, obj, i2, function1, (Object) null)));
        xxx();
        ddd(i2);
    }

    @Nullable
    @PublishedApi
    public final Object mmm() {
        Job job;
        boolean c = c();
        if (r()) {
            if (this.f6131o == null) {
                rrr();
            }
            if (c) {
                j();
            }
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (c) {
            j();
        }
        Object aaa = aaa();
        if (aaa instanceof tt) {
            Throwable th2 = ((tt) aaa).qw;
            if (k.fe()) {
                th2 = b.o(th2, this);
            }
            throw th2;
        } else if (!s.ad(this.f6162yj) || (job = (Job) getContext().get(Job.f6325fe)) == null || job.isActive()) {
            return rg(aaa);
        } else {
            Throwable rg2 = job.rg();
            qw(aaa, rg2);
            if (k.fe()) {
                rg2 = b.o(rg2, this);
            }
            throw rg2;
        }
    }

    public final Object n(NotCompleted notCompleted, Object obj, int i2, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof tt) {
            boolean z = true;
            if (k.qw()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!k.qw()) {
                return obj;
            }
            if (function1 != null) {
                z = false;
            }
            if (z) {
                return obj;
            }
            throw new AssertionError();
        } else if (!s.ad(i2) && obj2 == null) {
            return obj;
        } else {
            if (function1 == null && ((!(notCompleted instanceof when) || (notCompleted instanceof yj)) && obj2 == null)) {
                return obj;
            }
            return new rrr(obj, notCompleted instanceof when ? (when) notCompleted : null, function1, obj2, (Throwable) null, 16, (DefaultConstructorMarker) null);
        }
    }

    @NotNull
    public Throwable nn(@NotNull Job job) {
        return job.rg();
    }

    @Nullable
    public Object o(@NotNull Throwable th2) {
        return q(new tt(th2, false, 2, (DefaultConstructorMarker) null), (Object) null, (Function1<? super Throwable, Unit>) null);
    }

    public final boolean p() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f6129pf.compareAndSet(this, 0, 2));
        return true;
    }

    public final void pf(Function1<? super Throwable, Unit> function1, Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            f.qw(getContext(), new CompletionHandlerException(Intrinsics.stringPlus("Exception in invokeOnCancellation handler for ", this), th3));
        }
    }

    public void ppp(T t, @Nullable Function1<? super Throwable, Unit> function1) {
        l(t, this.f6162yj, function1);
    }

    public final c q(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof rrr) || obj2 == null) {
                return null;
            } else {
                rrr rrr = (rrr) obj3;
                if (rrr.f6167fe != obj2) {
                    return null;
                }
                if (!k.qw() || Intrinsics.areEqual(rrr.qw, obj)) {
                    return vvv.qw;
                }
                throw new AssertionError();
            }
        } while (!f248if.compareAndSet(this, obj3, n((NotCompleted) obj3, obj, this.f6162yj, function1, obj2)));
        xxx();
        return vvv.qw;
    }

    public final String qqq() {
        Object aaa = aaa();
        if (aaa instanceof NotCompleted) {
            return "Active";
        }
        return aaa instanceof ddd ? "Cancelled" : "Completed";
    }

    public void qw(@Nullable Object obj, @NotNull Throwable th2) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof tt)) {
                if (obj2 instanceof rrr) {
                    rrr rrr = (rrr) obj2;
                    if (!rrr.de()) {
                        if (f248if.compareAndSet(this, obj2, rrr.ad(rrr, (Object) null, (when) null, (Function1) null, (Object) null, th2, 15, (Object) null))) {
                            rrr.fe(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (f248if.compareAndSet(this, obj2, new rrr(obj2, (when) null, (Function1) null, (Object) null, th2, 14, (DefaultConstructorMarker) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean r() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f6129pf.compareAndSet(this, 0, 1));
        return true;
    }

    public void resumeWith(@NotNull Object obj) {
        m(this, c.de(obj, this), this.f6162yj, (Function1) null, 4, (Object) null);
    }

    public <T> T rg(@Nullable Object obj) {
        return obj instanceof rrr ? ((rrr) obj).qw : obj;
    }

    public final DisposableHandle rrr() {
        Job job = (Job) getContext().get(Job.f6325fe);
        if (job == null) {
            return null;
        }
        DisposableHandle fe2 = Job.qw.fe(job, true, false, new nn(this), 2, (Object) null);
        this.f6131o = fe2;
        return fe2;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m401switch(@NotNull Function1<? super Throwable, Unit> function1, @NotNull Throwable th2) {
        try {
            function1.invoke(th2);
        } catch (Throwable th3) {
            f.qw(getContext(), new CompletionHandlerException(Intrinsics.stringPlus("Exception in resume onCancellation handler for ", this), th3));
        }
    }

    @NotNull
    public String toString() {
        return f() + '(' + l.de(this.f6132uk) + "){" + qqq() + "}@" + l.ad(this);
    }

    public boolean tt() {
        return !(aaa() instanceof NotCompleted);
    }

    public final Void uk(Object obj) {
        throw new IllegalStateException(Intrinsics.stringPlus("Already resumed, but proposed with update ", obj).toString());
    }

    public boolean vvv(@Nullable Throwable th2) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof when;
        } while (!f248if.compareAndSet(this, obj, new ddd(this, th2, z)));
        when when = z ? (when) obj : null;
        if (when != null) {
            m400if(when, th2);
        }
        xxx();
        ddd(this.f6162yj);
        return true;
    }

    public final boolean when(Throwable th2) {
        if (s.de(this.f6162yj) && c()) {
            return ((i) this.f6132uk).ggg(th2);
        }
        return false;
    }

    public final void xxx() {
        if (!c()) {
            ggg();
        }
    }

    @Nullable
    public Object yj() {
        return aaa();
    }
}
