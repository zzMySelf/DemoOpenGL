package i.qw.x1;

import i.qw.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ggg {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6263ad;

    /* renamed from: th  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6264th;

    /* renamed from: yj  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6265yj;
    @NotNull
    public volatile /* synthetic */ Object _next = this;
    @NotNull
    public volatile /* synthetic */ Object _prev = this;
    @NotNull
    public volatile /* synthetic */ Object _removedRef = null;

    @PublishedApi
    public static abstract class ad extends fe<ggg> {
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final ggg f6266ad;
        @Nullable
        @JvmField

        /* renamed from: de  reason: collision with root package name */
        public ggg f6267de;

        public ad(@NotNull ggg ggg) {
            this.f6266ad = ggg;
        }

        /* renamed from: o */
        public void fe(@NotNull ggg ggg, @Nullable Object obj) {
            boolean z = obj == null;
            ggg ggg2 = z ? this.f6266ad : this.f6267de;
            if (ggg2 != null && ggg.f6263ad.compareAndSet(ggg, this, ggg2) && z) {
                ggg ggg3 = this.f6266ad;
                ggg ggg4 = this.f6267de;
                Intrinsics.checkNotNull(ggg4);
                ggg3.d(ggg4);
            }
        }
    }

    public static final class de extends qqq {
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final ggg f6268ad;
        @NotNull
        @JvmField

        /* renamed from: de  reason: collision with root package name */
        public final qw f6269de;
        @NotNull
        @JvmField
        public final ggg qw;

        public de(@NotNull ggg ggg, @NotNull ggg ggg2, @NotNull qw qwVar) {
            this.qw = ggg;
            this.f6268ad = ggg2;
            this.f6269de = qwVar;
        }

        @Nullable
        public Object de(@Nullable Object obj) {
            Object obj2;
            Object obj3;
            if (k.qw()) {
                if (!(obj == this.qw)) {
                    throw new AssertionError();
                }
            }
            if (obj != null) {
                ggg ggg = (ggg) obj;
                Object o2 = this.f6269de.o(this);
                if (o2 == vvv.qw) {
                    ggg ggg2 = this.f6268ad;
                    if (ggg.f6263ad.compareAndSet(ggg, this, ggg2.q())) {
                        this.f6269de.pf(ggg);
                        ggg unused = ggg2.tt((qqq) null);
                    }
                    return vvv.qw;
                }
                if (o2 != null) {
                    obj2 = qw().rg(o2);
                } else {
                    obj2 = qw().th();
                }
                if (obj2 == de.qw) {
                    obj3 = qw();
                } else if (obj2 == null) {
                    obj3 = this.f6269de.when(ggg, this.f6268ad);
                } else {
                    obj3 = this.f6268ad;
                }
                ggg.f6263ad.compareAndSet(ggg, this, obj3);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        }

        public final void fe() {
            this.f6269de.yj(this);
        }

        @NotNull
        public fe<?> qw() {
            return this.f6269de.ad();
        }

        @NotNull
        public String toString() {
            return "PrepareOp(op=" + qw() + ')';
        }
    }

    public static class fe<T> extends qw {

        /* renamed from: de  reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f6270de;

        /* renamed from: fe  reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f6271fe;
        @NotNull
        public volatile /* synthetic */ Object _affectedNode = null;
        @NotNull
        public volatile /* synthetic */ Object _originalNext = null;
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final ggg f6272ad;

        static {
            Class<Object> cls = Object.class;
            Class<fe> cls2 = fe.class;
            f6270de = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_affectedNode");
            f6271fe = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_originalNext");
        }

        public fe(@NotNull ggg ggg) {
            this.f6272ad = ggg;
        }

        @Nullable
        public final ggg i() {
            return (ggg) this._originalNext;
        }

        /* renamed from: if  reason: not valid java name */
        public final boolean m414if(@NotNull ggg ggg, @NotNull Object obj) {
            if (!(obj instanceof eee)) {
                return false;
            }
            ((eee) obj).qw.k();
            return true;
        }

        public final T ppp() {
            T uk2 = uk();
            Intrinsics.checkNotNull(uk2);
            return uk2;
        }

        @Nullable
        public Object rg(@NotNull ggg ggg) {
            if (ggg == this.f6272ad) {
                return ppp.ad();
            }
            return null;
        }

        @Nullable
        /* renamed from: switch  reason: not valid java name */
        public final ggg m415switch(@NotNull qqq qqq) {
            ggg ggg = this.f6272ad;
            while (true) {
                Object obj = ggg._next;
                if (!(obj instanceof qqq)) {
                    return (ggg) obj;
                }
                qqq qqq2 = (qqq) obj;
                if (qqq.ad(qqq2)) {
                    return null;
                }
                qqq2.de(this.f6272ad);
            }
        }

        public final void th(@NotNull ggg ggg, @NotNull ggg ggg2) {
            ggg unused = ggg2.tt((qqq) null);
        }

        @Nullable
        public final ggg uk() {
            return (ggg) this._affectedNode;
        }

        @NotNull
        public final Object when(@NotNull ggg ggg, @NotNull ggg ggg2) {
            return ggg2.q();
        }

        public void yj(@NotNull de deVar) {
            f6270de.compareAndSet(this, (Object) null, deVar.qw);
            f6271fe.compareAndSet(this, (Object) null, deVar.f6268ad);
        }
    }

    public static abstract class qw extends ad {
        @Nullable
        public final Object de(@NotNull fe<?> feVar) {
            while (true) {
                ggg ggg = m417switch(feVar);
                if (ggg == null) {
                    return de.f6259ad;
                }
                Object obj = ggg._next;
                if (obj == feVar || feVar.uk()) {
                    return null;
                }
                if (obj instanceof qqq) {
                    qqq qqq = (qqq) obj;
                    if (feVar.ad(qqq)) {
                        return de.f6259ad;
                    }
                    qqq.de(ggg);
                } else {
                    Object rg2 = rg(ggg);
                    if (rg2 != null) {
                        return rg2;
                    }
                    if (m416if(ggg, obj)) {
                        continue;
                    } else {
                        de deVar = new de(ggg, (ggg) obj, this);
                        if (ggg.f6263ad.compareAndSet(ggg, obj, deVar)) {
                            try {
                                Object de2 = deVar.de(ggg);
                                if (de2 != vvv.qw) {
                                    if (k.qw()) {
                                        if (!(de2 == null)) {
                                            throw new AssertionError();
                                        }
                                    }
                                    return null;
                                }
                            } catch (Throwable th2) {
                                ggg.f6263ad.compareAndSet(ggg, deVar, obj);
                                throw th2;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        @Nullable
        public abstract ggg i();

        /* renamed from: if  reason: not valid java name */
        public abstract boolean m416if(@NotNull ggg ggg, @NotNull Object obj);

        @Nullable
        public Object o(@NotNull de deVar) {
            yj(deVar);
            return null;
        }

        public void pf(@NotNull ggg ggg) {
        }

        public final void qw(@NotNull fe<?> feVar, @Nullable Object obj) {
            boolean z = obj == null;
            ggg uk2 = uk();
            if (uk2 != null) {
                ggg i2 = i();
                if (i2 != null) {
                    if (ggg.f6263ad.compareAndSet(uk2, feVar, z ? when(uk2, i2) : i2) && z) {
                        th(uk2, i2);
                    }
                } else if (k.qw() && !(!z)) {
                    throw new AssertionError();
                }
            } else if (k.qw() && !(!z)) {
                throw new AssertionError();
            }
        }

        @Nullable
        public abstract Object rg(@NotNull ggg ggg);

        @Nullable
        /* renamed from: switch  reason: not valid java name */
        public abstract ggg m417switch(@NotNull qqq qqq);

        public abstract void th(@NotNull ggg ggg, @NotNull ggg ggg2);

        @Nullable
        public abstract ggg uk();

        @NotNull
        public abstract Object when(@NotNull ggg ggg, @NotNull ggg ggg2);

        public abstract void yj(@NotNull de deVar);
    }

    static {
        Class<Object> cls = Object.class;
        Class<ggg> cls2 = ggg.class;
        f6263ad = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f6264th = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
        f6265yj = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_removedRef");
    }

    public final ggg c(ggg ggg) {
        while (ggg.l()) {
            ggg = (ggg) ggg._prev;
        }
        return ggg;
    }

    public final void d(ggg ggg) {
        ggg ggg2;
        do {
            ggg2 = (ggg) ggg._prev;
            if (e() != ggg) {
                return;
            }
        } while (!f6264th.compareAndSet(ggg, ggg2, this));
        if (l()) {
            ggg.tt((qqq) null);
        }
    }

    @NotNull
    public final Object e() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof qqq)) {
                return obj;
            }
            ((qqq) obj).de(this);
        }
    }

    @PublishedApi
    public final boolean eee(@NotNull ggg ggg, @NotNull ggg ggg2) {
        f6264th.lazySet(ggg, this);
        f6263ad.lazySet(ggg, ggg2);
        if (!f6263ad.compareAndSet(this, ggg2, ggg)) {
            return false;
        }
        ggg.d(ggg2);
        return true;
    }

    @NotNull
    public final ggg f() {
        return ppp.de(e());
    }

    @NotNull
    public final ggg h() {
        ggg tt = tt((qqq) null);
        return tt == null ? c((ggg) this._prev) : tt;
    }

    public final void j() {
        ((eee) e()).qw.tt((qqq) null);
    }

    @PublishedApi
    public final void k() {
        ggg ggg = this;
        while (true) {
            Object e = ggg.e();
            if (!(e instanceof eee)) {
                ggg.tt((qqq) null);
                return;
            }
            ggg = ((eee) e).qw;
        }
    }

    public boolean l() {
        return e() instanceof eee;
    }

    public boolean m() {
        return p() == null;
    }

    @Nullable
    public final ggg n() {
        while (true) {
            ggg ggg = (ggg) e();
            if (ggg == this) {
                return null;
            }
            if (ggg.m()) {
                return ggg;
            }
            ggg.j();
        }
    }

    @Nullable
    @PublishedApi
    public final ggg p() {
        Object e;
        ggg ggg;
        do {
            e = e();
            if (e instanceof eee) {
                return ((eee) e).qw;
            }
            if (e == this) {
                return (ggg) e;
            }
            ggg = (ggg) e;
        } while (!f6263ad.compareAndSet(this, e, ggg.q()));
        ggg.tt((qqq) null);
        return null;
    }

    public final eee q() {
        eee eee = (eee) this._removedRef;
        if (eee != null) {
            return eee;
        }
        eee eee2 = new eee(this);
        f6265yj.lazySet(this, eee2);
        return eee2;
    }

    public final void qqq(@NotNull ggg ggg) {
        do {
        } while (!h().eee(ggg, this));
    }

    @PublishedApi
    public final int r(@NotNull ggg ggg, @NotNull ggg ggg2, @NotNull ad adVar) {
        f6264th.lazySet(ggg, this);
        f6263ad.lazySet(ggg, ggg2);
        adVar.f6267de = ggg2;
        if (!f6263ad.compareAndSet(this, ggg2, adVar)) {
            return 0;
        }
        return adVar.de(this) == null ? 1 : 2;
    }

    public final boolean rrr(@NotNull ggg ggg) {
        f6264th.lazySet(ggg, this);
        f6263ad.lazySet(ggg, this);
        while (e() == this) {
            if (f6263ad.compareAndSet(this, this, ggg)) {
                ggg.d(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: i.qw.x1.qqq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: i.qw.x1.ggg} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (f6263ad.compareAndSet(r3, r2, ((i.qw.x1.eee) r4).qw) != false) goto L_0x004b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final i.qw.x1.ggg tt(i.qw.x1.qqq r8) {
        /*
            r7 = this;
        L_0x0000:
            java.lang.Object r0 = r7._prev
            i.qw.x1.ggg r0 = (i.qw.x1.ggg) r0
            r1 = 0
            r2 = r0
        L_0x0006:
            r3 = r1
        L_0x0007:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L_0x0018
            if (r0 != r2) goto L_0x000e
            return r2
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f6264th
            boolean r0 = r1.compareAndSet(r7, r0, r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r2
        L_0x0018:
            boolean r5 = r7.l()
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            if (r4 != r8) goto L_0x0022
            return r2
        L_0x0022:
            boolean r5 = r4 instanceof i.qw.x1.qqq
            if (r5 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0032
            r0 = r4
            i.qw.x1.qqq r0 = (i.qw.x1.qqq) r0
            boolean r0 = r8.ad(r0)
            if (r0 == 0) goto L_0x0032
            return r1
        L_0x0032:
            i.qw.x1.qqq r4 = (i.qw.x1.qqq) r4
            r4.de(r2)
            goto L_0x0000
        L_0x0038:
            boolean r5 = r4 instanceof i.qw.x1.eee
            if (r5 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = f6263ad
            i.qw.x1.eee r4 = (i.qw.x1.eee) r4
            i.qw.x1.ggg r4 = r4.qw
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L_0x004b
            goto L_0x0000
        L_0x004b:
            r2 = r3
            goto L_0x0006
        L_0x004d:
            java.lang.Object r2 = r2._prev
            i.qw.x1.ggg r2 = (i.qw.x1.ggg) r2
            goto L_0x0007
        L_0x0052:
            r3 = r4
            i.qw.x1.ggg r3 = (i.qw.x1.ggg) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.x1.ggg.tt(i.qw.x1.qqq):i.qw.x1.ggg");
    }
}
