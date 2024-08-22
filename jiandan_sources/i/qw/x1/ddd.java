package i.qw.x1;

import i.qw.k;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ddd<E> {
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public static final qw f6252rg = new qw((DefaultConstructorMarker) null);

    /* renamed from: th  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6253th;
    @NotNull
    @JvmField

    /* renamed from: uk  reason: collision with root package name */
    public static final c f6254uk = new c("REMOVE_FROZEN");

    /* renamed from: yj  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6255yj;
    @NotNull
    public volatile /* synthetic */ Object _next = null;
    @NotNull
    public volatile /* synthetic */ long _state = 0;

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f6256ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f6257de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public /* synthetic */ AtomicReferenceArray f6258fe = new AtomicReferenceArray(this.qw);
    public final int qw;

    public static final class ad {
        @JvmField
        public final int qw;

        public ad(int i2) {
            this.qw = i2;
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long ad(long j, int i2) {
            return fe(j, 1073741823) | (((long) i2) << 0);
        }

        public final long de(long j, int i2) {
            return fe(j, 1152921503533105152L) | (((long) i2) << 30);
        }

        public final long fe(long j, long j2) {
            return j & (~j2);
        }

        public final int qw(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }
    }

    static {
        Class<ddd> cls = ddd.class;
        f6253th = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f6255yj = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public ddd(int i2, boolean z) {
        this.qw = i2;
        this.f6256ad = z;
        boolean z2 = true;
        this.f6257de = i2 - 1;
        if (this.f6257de <= 1073741823) {
            if (!((this.qw & this.f6257de) != 0 ? false : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final ddd<E> ad(long j) {
        ddd<E> ddd = new ddd<>(this.qw * 2, this.f6256ad);
        int i2 = (int) ((1073741823 & j) >> 0);
        int i3 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i4 = this.f6257de;
            if ((i2 & i4) != (i3 & i4)) {
                Object obj = this.f6258fe.get(i4 & i2);
                if (obj == null) {
                    obj = new ad(i2);
                }
                ddd.f6258fe.set(ddd.f6257de & i2, obj);
                i2++;
            } else {
                ddd._state = f6252rg.fe(j, 1152921504606846976L);
                return ddd;
            }
        }
    }

    public final ddd<E> de(long j) {
        while (true) {
            ddd<E> ddd = (ddd) this._next;
            if (ddd != null) {
                return ddd;
            }
            f6253th.compareAndSet(this, (Object) null, ad(j));
        }
    }

    public final boolean fe() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f6255yj.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    @NotNull
    public final ddd<E> i() {
        return de(uk());
    }

    @Nullable
    public final Object o() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return f6254uk;
            }
            int i2 = (int) ((1073741823 & j) >> 0);
            int i3 = (int) ((1152921503533105152L & j) >> 30);
            int i4 = this.f6257de;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.f6258fe.get(i4 & i2);
            if (obj == null) {
                if (this.f6256ad) {
                    return null;
                }
            } else if (obj instanceof ad) {
                return null;
            } else {
                int i5 = (i2 + 1) & 1073741823;
                if (f6255yj.compareAndSet(this, j, f6252rg.ad(j, i5))) {
                    this.f6258fe.set(this.f6257de & i2, (Object) null);
                    return obj;
                } else if (this.f6256ad) {
                    ddd ddd = this;
                    do {
                        ddd = ddd.pf(i2, i5);
                    } while (ddd != null);
                    return obj;
                }
            }
        }
    }

    public final ddd<E> pf(int i2, int i3) {
        long j;
        int i4;
        do {
            j = this._state;
            boolean z = false;
            i4 = (int) ((1073741823 & j) >> 0);
            if (k.qw()) {
                if (i4 == i2) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!f6255yj.compareAndSet(this, j, f6252rg.ad(j, i3)));
        this.f6258fe.set(this.f6257de & i4, (Object) null);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[LOOP:1: B:19:0x0068->B:22:0x007a, LOOP_START, PHI: r0 
      PHI: (r0v15 i.qw.x1.ddd) = (r0v14 i.qw.x1.ddd), (r0v17 i.qw.x1.ddd) binds: [B:18:0x0060, B:22:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int qw(@org.jetbrains.annotations.NotNull E r13) {
        /*
            r12 = this;
        L_0x0000:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0012
            i.qw.x1.ddd$qw r13 = f6252rg
            int r13 = r13.qw(r2)
            return r13
        L_0x0012:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.f6257de
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            if (r0 != r4) goto L_0x002e
            return r5
        L_0x002e:
            boolean r0 = r12.f6256ad
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f6258fe
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L_0x004d
            int r0 = r12.qw
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L_0x004c
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L_0x0000
        L_0x004c:
            return r5
        L_0x004d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f6255yj
            i.qw.x1.ddd$qw r4 = f6252rg
            long r4 = r4.de(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x0000
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f6258fe
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L_0x0068:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0072
            goto L_0x007c
        L_0x0072:
            i.qw.x1.ddd r0 = r0.i()
            i.qw.x1.ddd r0 = r0.rg(r9, r13)
            if (r0 != 0) goto L_0x0068
        L_0x007c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.x1.ddd.qw(java.lang.Object):int");
    }

    public final ddd<E> rg(int i2, E e) {
        Object obj = this.f6258fe.get(this.f6257de & i2);
        if (!(obj instanceof ad) || ((ad) obj).qw != i2) {
            return null;
        }
        this.f6258fe.set(i2 & this.f6257de, e);
        return this;
    }

    public final int th() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    public final long uk() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f6255yj.compareAndSet(this, j, j2));
        return j2;
    }

    public final boolean yj() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }
}
