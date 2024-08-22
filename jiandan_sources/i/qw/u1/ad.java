package i.qw.u1;

import i.qw.k;
import i.qw.l;
import i.qw.u1.th;
import i.qw.vvv;
import i.qw.x1.Cswitch;
import i.qw.x1.c;
import i.qw.x1.ggg;
import i.qw.x1.ppp;
import i.qw.x1.when;
import i.qw.xxx;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ad<E> implements SendChannel<E> {

    /* renamed from: yj  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6176yj = AtomicReferenceFieldUpdater.newUpdater(ad.class, Object.class, "onCloseHandler");
    @Nullable
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final Function1<E, Unit> f6177ad;
    @NotNull
    public volatile /* synthetic */ Object onCloseHandler = null;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final when f6178th = new when();

    /* renamed from: i.qw.u1.ad$ad  reason: collision with other inner class name */
    public static final class C0252ad extends ggg.ad {

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ ad f6179fe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0252ad(ggg ggg, ad adVar) {
            super(ggg);
            this.f6179fe = adVar;
        }

        @Nullable
        /* renamed from: pf */
        public Object i(@NotNull ggg ggg) {
            if (this.f6179fe.ddd()) {
                return null;
            }
            return ppp.qw();
        }
    }

    public static final class qw<E> extends when {
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public final E f6180uk;

        public qw(E e) {
            this.f6180uk = e;
        }

        public void s() {
        }

        @Nullable
        public Object t() {
            return this.f6180uk;
        }

        @NotNull
        public String toString() {
            return "SendBuffered@" + l.ad(this) + '(' + this.f6180uk + ')';
        }

        public void u(@NotNull uk<?> ukVar) {
            if (k.qw()) {
                throw new AssertionError();
            }
        }

        @Nullable
        public c v(@Nullable ggg.de deVar) {
            c cVar = vvv.qw;
            if (deVar != null) {
                deVar.fe();
            }
            return cVar;
        }
    }

    public ad(@Nullable Function1<? super E, Unit> function1) {
        this.f6177ad = function1;
    }

    public void a(@NotNull ggg ggg) {
    }

    @NotNull
    public Object aaa(E e) {
        ReceiveOrClosed f;
        c xxx;
        do {
            f = f();
            if (f == null) {
                return qw.f6192de;
            }
            xxx = f.xxx(e, (ggg.de) null);
        } while (xxx == null);
        if (k.qw()) {
            if (!(xxx == vvv.qw)) {
                throw new AssertionError();
            }
        }
        f.yj(e);
        return f.de();
    }

    @Nullable
    public final ReceiveOrClosed<?> b(E e) {
        ggg h;
        when when = this.f6178th;
        qw qwVar = new qw(e);
        do {
            h = when.h();
            if (h instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) h;
            }
        } while (!h.eee(qwVar, when));
        return null;
    }

    public boolean c(@Nullable Throwable th2) {
        boolean z;
        uk ukVar = new uk(th2);
        when when = this.f6178th;
        while (true) {
            ggg h = when.h();
            z = true;
            if (!(h instanceof uk)) {
                if (h.eee(ukVar, when)) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            ukVar = (uk) this.f6178th.h();
        }
        m402switch(ukVar);
        if (z) {
            ggg(th2);
        }
        return z;
    }

    @Nullable
    public final Object d(E e, @NotNull Continuation<? super Unit> continuation) {
        if (aaa(e) == qw.f6191ad) {
            return Unit.INSTANCE;
        }
        Object e2 = e(e, continuation);
        return e2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? e2 : Unit.INSTANCE;
    }

    public abstract boolean ddd();

    public final Object e(E e, Continuation<? super Unit> continuation) {
        when when;
        i.qw.ggg<? super Unit> ad2 = xxx.ad(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        while (true) {
            if (nn()) {
                if (this.f6177ad == null) {
                    when = new ppp(e, ad2);
                } else {
                    when = new ggg(e, ad2, this.f6177ad);
                }
                Object rg2 = rg(when);
                if (rg2 == null) {
                    xxx.de(ad2, when);
                    break;
                } else if (rg2 instanceof uk) {
                    ppp(ad2, e, (uk) rg2);
                    break;
                } else if (rg2 != qw.f6194rg && !(rg2 instanceof Cif)) {
                    throw new IllegalStateException(Intrinsics.stringPlus("enqueueSend returned ", rg2).toString());
                }
            }
            Object aaa = aaa(e);
            if (aaa == qw.f6191ad) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                ad2.resumeWith(Result.m1155constructorimpl(unit));
                break;
            } else if (aaa != qw.f6192de) {
                if (aaa instanceof uk) {
                    ppp(ad2, e, (uk) aaa);
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("offerInternal returned ", aaa).toString());
                }
            }
        }
        Object mmm = ad2.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mmm : Unit.INSTANCE;
    }

    @Nullable
    public ReceiveOrClosed<E> f() {
        ggg ggg;
        ggg p;
        when when = this.f6178th;
        while (true) {
            ggg = (ggg) when.e();
            if (ggg != when && (ggg instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) ggg) instanceof uk) && !ggg.l()) || (p = ggg.p()) == null) {
                    break;
                }
                p.k();
            }
        }
        ggg = null;
        return (ReceiveOrClosed) ggg;
    }

    public final int fe() {
        when when = this.f6178th;
        int i2 = 0;
        for (ggg ggg = (ggg) when.e(); !Intrinsics.areEqual((Object) ggg, (Object) when); ggg = ggg.f()) {
            if (ggg instanceof ggg) {
                i2++;
            }
        }
        return i2;
    }

    @Nullable
    public final when g() {
        ggg ggg;
        ggg p;
        when when = this.f6178th;
        while (true) {
            ggg = (ggg) when.e();
            if (ggg != when && (ggg instanceof when)) {
                if (((((when) ggg) instanceof uk) && !ggg.l()) || (p = ggg.p()) == null) {
                    break;
                }
                p.k();
            }
        }
        ggg = null;
        return (when) ggg;
    }

    public final void ggg(Throwable th2) {
        c cVar;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (cVar = qw.f6195th) && f6176yj.compareAndSet(this, obj, cVar)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th2);
        }
    }

    @Nullable
    public final uk<?> i() {
        ggg h = this.f6178th.h();
        uk<?> ukVar = h instanceof uk ? (uk) h : null;
        if (ukVar == null) {
            return null;
        }
        m402switch(ukVar);
        return ukVar;
    }

    @NotNull
    public final Object mmm(E e) {
        Object aaa = aaa(e);
        if (aaa == qw.f6191ad) {
            th.ad adVar = th.f6196ad;
            Unit unit = Unit.INSTANCE;
            adVar.de(unit);
            return unit;
        } else if (aaa == qw.f6192de) {
            uk<?> i2 = i();
            if (i2 == null) {
                return th.f6196ad.ad();
            }
            return th.f6196ad.qw(when(i2));
        } else if (aaa instanceof uk) {
            return th.f6196ad.qw(when((uk) aaa));
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("trySend returned ", aaa).toString());
        }
    }

    public final boolean nn() {
        return !(this.f6178th.f() instanceof ReceiveOrClosed) && ddd();
    }

    @NotNull
    public final when o() {
        return this.f6178th;
    }

    public boolean offer(E e) {
        UndeliveredElementException fe2;
        try {
            return SendChannel.qw.ad(this, e);
        } catch (Throwable th2) {
            Function1<E, Unit> function1 = this.f6177ad;
            if (function1 == null || (fe2 = OnUndeliveredElementKt.fe(function1, e, (UndeliveredElementException) null, 2, (Object) null)) == null) {
                throw th2;
            }
            ExceptionsKt__ExceptionsKt.addSuppressed(fe2, th2);
            throw fe2;
        }
    }

    public final String pf() {
        String str;
        ggg f = this.f6178th.f();
        if (f == this.f6178th) {
            return "EmptyQueue";
        }
        if (f instanceof uk) {
            str = f.toString();
        } else if (f instanceof Cif) {
            str = "ReceiveQueued";
        } else if (f instanceof when) {
            str = "SendQueued";
        } else {
            str = Intrinsics.stringPlus("UNEXPECTED:", f);
        }
        ggg h = this.f6178th.h();
        if (h == f) {
            return str;
        }
        String str2 = str + ",queueSize=" + fe();
        if (!(h instanceof uk)) {
            return str2;
        }
        return str2 + ",closedForSend=" + h;
    }

    public final void ppp(Continuation<?> continuation, E e, uk<?> ukVar) {
        UndeliveredElementException fe2;
        m402switch(ukVar);
        Throwable A = ukVar.A();
        Function1<E, Unit> function1 = this.f6177ad;
        if (function1 == null || (fe2 = OnUndeliveredElementKt.fe(function1, e, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(A)));
            return;
        }
        ExceptionsKt__ExceptionsKt.addSuppressed(fe2, A);
        Result.Companion companion2 = Result.Companion;
        continuation.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(fe2)));
    }

    @Nullable
    public Object rg(@NotNull when when) {
        boolean z;
        ggg h;
        if (vvv()) {
            when when2 = this.f6178th;
            do {
                h = when2.h();
                if (h instanceof ReceiveOrClosed) {
                    return h;
                }
            } while (!h.eee(when, when2));
            return null;
        }
        when when3 = this.f6178th;
        C0252ad adVar = new C0252ad(when, this);
        while (true) {
            ggg h2 = when3.h();
            if (!(h2 instanceof ReceiveOrClosed)) {
                int r = h2.r(when, when3, adVar);
                z = true;
                if (r != 1) {
                    if (r == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return h2;
            }
        }
        if (!z) {
            return qw.f6194rg;
        }
        return null;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m402switch(uk<?> ukVar) {
        Object ad2 = Cswitch.ad((Object) null, 1, (DefaultConstructorMarker) null);
        while (true) {
            ggg h = ukVar.h();
            Cif ifVar = h instanceof Cif ? (Cif) h : null;
            if (ifVar == null) {
                break;
            } else if (!ifVar.m()) {
                ifVar.j();
            } else {
                ad2 = Cswitch.de(ad2, ifVar);
            }
        }
        if (ad2 != null) {
            if (!(ad2 instanceof ArrayList)) {
                ((Cif) ad2).u(ukVar);
            } else if (ad2 != null) {
                ArrayList arrayList = (ArrayList) ad2;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        ((Cif) arrayList.get(size)).u(ukVar);
                        if (i2 < 0) {
                            break;
                        }
                        size = i2;
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
        }
        a(ukVar);
    }

    @NotNull
    public String th() {
        return "";
    }

    @NotNull
    public String toString() {
        return l.qw(this) + '@' + l.ad(this) + ExtendedMessageFormat.START_FE + pf() + ExtendedMessageFormat.END_FE + th();
    }

    public abstract boolean vvv();

    public final Throwable when(uk<?> ukVar) {
        m402switch(ukVar);
        return ukVar.A();
    }

    public void xxx(@NotNull Function1<? super Throwable, Unit> function1) {
        if (!f6176yj.compareAndSet(this, (Object) null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == qw.f6195th) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException(Intrinsics.stringPlus("Another handler was already registered: ", obj));
        }
        uk<?> i2 = i();
        if (i2 != null && f6176yj.compareAndSet(this, function1, qw.f6195th)) {
            function1.invoke(i2.f6198uk);
        }
    }

    @Nullable
    public final uk<?> yj() {
        ggg f = this.f6178th.f();
        uk<?> ukVar = f instanceof uk ? (uk) f : null;
        if (ukVar == null) {
            return null;
        }
        m402switch(ukVar);
        return ukVar;
    }
}
