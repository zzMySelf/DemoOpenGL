package i.qw.u1;

import i.qw.k;
import i.qw.vvv;
import i.qw.x1.c;
import i.qw.x1.ggg;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class de<E> extends AbstractChannel<E> {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final BufferOverflow f6181i;

    /* renamed from: if  reason: not valid java name */
    public int f249if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final ReentrantLock f6182o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public Object[] f6183pf;
    @NotNull
    public volatile /* synthetic */ int size;

    /* renamed from: uk  reason: collision with root package name */
    public final int f6184uk;

    public /* synthetic */ class qw {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public de(int i2, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.f6184uk = i2;
        this.f6181i = bufferOverflow;
        if (i2 < 1 ? false : true) {
            this.f6182o = new ReentrantLock();
            Object[] objArr = new Object[Math.min(this.f6184uk, 8)];
            ArraysKt___ArraysJvmKt.fill$default(objArr, (Object) qw.qw, 0, 0, 6, (Object) null);
            Unit unit = Unit.INSTANCE;
            this.f6183pf = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + this.f6184uk + " was specified").toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r7 != i.qw.a2.ad.fe()) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        r8.size = r1;
        r8.f6183pf[r8.f249if] = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        if ((r7 instanceof i.qw.u1.uk) == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0067, code lost:
        r3 = r7;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0079, code lost:
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("performAtomicTrySelect(describeTryOffer) returned ", r7).toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083 A[Catch:{ all -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A[Catch:{ all -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object A(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f6182o
            r0.lock()
            int r1 = r8.size     // Catch:{ all -> 0x00c0 }
            if (r1 != 0) goto L_0x0015
            i.qw.u1.uk r9 = r8.i()     // Catch:{ all -> 0x00c0 }
            if (r9 != 0) goto L_0x0011
            i.qw.x1.c r9 = i.qw.u1.qw.f6193fe     // Catch:{ all -> 0x00c0 }
        L_0x0011:
            r0.unlock()
            return r9
        L_0x0015:
            java.lang.Object[] r2 = r8.f6183pf     // Catch:{ all -> 0x00c0 }
            int r3 = r8.f249if     // Catch:{ all -> 0x00c0 }
            r2 = r2[r3]     // Catch:{ all -> 0x00c0 }
            java.lang.Object[] r3 = r8.f6183pf     // Catch:{ all -> 0x00c0 }
            int r4 = r8.f249if     // Catch:{ all -> 0x00c0 }
            r5 = 0
            r3[r4] = r5     // Catch:{ all -> 0x00c0 }
            int r3 = r1 + -1
            r8.size = r3     // Catch:{ all -> 0x00c0 }
            i.qw.x1.c r3 = i.qw.u1.qw.f6193fe     // Catch:{ all -> 0x00c0 }
            int r4 = r8.f6184uk     // Catch:{ all -> 0x00c0 }
            r6 = 1
            if (r1 != r4) goto L_0x007a
        L_0x002d:
            kotlinx.coroutines.channels.AbstractChannel$yj r4 = r8.m()     // Catch:{ all -> 0x00c0 }
            java.lang.Object r7 = r9.ggg(r4)     // Catch:{ all -> 0x00c0 }
            if (r7 != 0) goto L_0x0047
            java.lang.Object r5 = r4.ppp()     // Catch:{ all -> 0x00c0 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x00c0 }
            r3 = r5
            i.qw.u1.when r3 = (i.qw.u1.when) r3     // Catch:{ all -> 0x00c0 }
            java.lang.Object r3 = r3.t()     // Catch:{ all -> 0x00c0 }
        L_0x0045:
            r4 = 1
            goto L_0x007b
        L_0x0047:
            i.qw.x1.c r4 = i.qw.u1.qw.f6193fe     // Catch:{ all -> 0x00c0 }
            if (r7 != r4) goto L_0x004c
            goto L_0x007a
        L_0x004c:
            java.lang.Object r4 = i.qw.x1.de.f6259ad     // Catch:{ all -> 0x00c0 }
            if (r7 != r4) goto L_0x0051
            goto L_0x002d
        L_0x0051:
            java.lang.Object r3 = i.qw.a2.ad.fe()     // Catch:{ all -> 0x00c0 }
            if (r7 != r3) goto L_0x0063
            r8.size = r1     // Catch:{ all -> 0x00c0 }
            java.lang.Object[] r9 = r8.f6183pf     // Catch:{ all -> 0x00c0 }
            int r1 = r8.f249if     // Catch:{ all -> 0x00c0 }
            r9[r1] = r2     // Catch:{ all -> 0x00c0 }
            r0.unlock()
            return r7
        L_0x0063:
            boolean r3 = r7 instanceof i.qw.u1.uk     // Catch:{ all -> 0x00c0 }
            if (r3 == 0) goto L_0x006a
            r3 = r7
            r5 = r3
            goto L_0x0045
        L_0x006a:
            java.lang.String r9 = "performAtomicTrySelect(describeTryOffer) returned "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r7)     // Catch:{ all -> 0x00c0 }
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c0 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00c0 }
            r1.<init>(r9)     // Catch:{ all -> 0x00c0 }
            throw r1     // Catch:{ all -> 0x00c0 }
        L_0x007a:
            r4 = 0
        L_0x007b:
            i.qw.x1.c r7 = i.qw.u1.qw.f6193fe     // Catch:{ all -> 0x00c0 }
            if (r3 == r7) goto L_0x0091
            boolean r7 = r3 instanceof i.qw.u1.uk     // Catch:{ all -> 0x00c0 }
            if (r7 != 0) goto L_0x0091
            r8.size = r1     // Catch:{ all -> 0x00c0 }
            java.lang.Object[] r9 = r8.f6183pf     // Catch:{ all -> 0x00c0 }
            int r7 = r8.f249if     // Catch:{ all -> 0x00c0 }
            int r7 = r7 + r1
            java.lang.Object[] r1 = r8.f6183pf     // Catch:{ all -> 0x00c0 }
            int r1 = r1.length     // Catch:{ all -> 0x00c0 }
            int r7 = r7 % r1
            r9[r7] = r3     // Catch:{ all -> 0x00c0 }
            goto L_0x00a7
        L_0x0091:
            boolean r9 = r9.m668if()     // Catch:{ all -> 0x00c0 }
            if (r9 != 0) goto L_0x00a7
            r8.size = r1     // Catch:{ all -> 0x00c0 }
            java.lang.Object[] r9 = r8.f6183pf     // Catch:{ all -> 0x00c0 }
            int r1 = r8.f249if     // Catch:{ all -> 0x00c0 }
            r9[r1] = r2     // Catch:{ all -> 0x00c0 }
            java.lang.Object r9 = i.qw.a2.ad.fe()     // Catch:{ all -> 0x00c0 }
            r0.unlock()
            return r9
        L_0x00a7:
            int r9 = r8.f249if     // Catch:{ all -> 0x00c0 }
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f6183pf     // Catch:{ all -> 0x00c0 }
            int r1 = r1.length     // Catch:{ all -> 0x00c0 }
            int r9 = r9 % r1
            r8.f249if = r9     // Catch:{ all -> 0x00c0 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c0 }
            r0.unlock()
            if (r4 == 0) goto L_0x00bf
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            i.qw.u1.when r5 = (i.qw.u1.when) r5
            r5.s()
        L_0x00bf:
            return r2
        L_0x00c0:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.u1.de.A(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    public final void F(int i2, E e) {
        if (i2 < this.f6184uk) {
            G(i2);
            Object[] objArr = this.f6183pf;
            objArr[(this.f249if + i2) % objArr.length] = e;
            return;
        }
        if (k.qw()) {
            if (!(this.f6181i == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.f6183pf;
        int i3 = this.f249if;
        objArr2[i3 % objArr2.length] = null;
        objArr2[(i2 + i3) % objArr2.length] = e;
        this.f249if = (i3 + 1) % objArr2.length;
    }

    public final void G(int i2) {
        Object[] objArr = this.f6183pf;
        if (i2 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f6184uk);
            Object[] objArr2 = new Object[min];
            if (i2 > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    Object[] objArr3 = this.f6183pf;
                    objArr2[i3] = objArr3[(this.f249if + i3) % objArr3.length];
                    if (i4 >= i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            ArraysKt___ArraysJvmKt.fill((T[]) objArr2, qw.qw, i2, min);
            this.f6183pf = objArr2;
            this.f249if = 0;
        }
    }

    public final c H(int i2) {
        if (i2 < this.f6184uk) {
            this.size = i2 + 1;
            return null;
        }
        int i3 = qw.$EnumSwitchMapping$0[this.f6181i.ordinal()];
        if (i3 == 1) {
            return qw.f6192de;
        }
        if (i3 == 2) {
            return qw.f6191ad;
        }
        if (i3 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: finally extract failed */
    @NotNull
    public Object aaa(E e) {
        ReceiveOrClosed f;
        c xxx;
        ReentrantLock reentrantLock = this.f6182o;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            uk<?> i3 = i();
            if (i3 == null) {
                c H = H(i2);
                if (H == null) {
                    if (i2 == 0) {
                        do {
                            f = f();
                            if (f != null) {
                                if (f instanceof uk) {
                                    this.size = i2;
                                    reentrantLock.unlock();
                                    return f;
                                }
                                xxx = f.xxx(e, (ggg.de) null);
                            }
                        } while (xxx == null);
                        if (k.qw()) {
                            if (!(xxx == vvv.qw)) {
                                throw new AssertionError();
                            }
                        }
                        this.size = i2;
                        Unit unit = Unit.INSTANCE;
                        reentrantLock.unlock();
                        f.yj(e);
                        return f.de();
                    }
                    F(i2, e);
                    c cVar = qw.f6191ad;
                    reentrantLock.unlock();
                    return cVar;
                }
                reentrantLock.unlock();
                return H;
            }
            reentrantLock.unlock();
            return i3;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final boolean ddd() {
        return this.size == this.f6184uk && this.f6181i == BufferOverflow.SUSPEND;
    }

    public boolean p(@NotNull Cif<? super E> ifVar) {
        ReentrantLock reentrantLock = this.f6182o;
        reentrantLock.lock();
        try {
            return super.p(ifVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean r() {
        return false;
    }

    @Nullable
    public Object rg(@NotNull when when) {
        ReentrantLock reentrantLock = this.f6182o;
        reentrantLock.lock();
        try {
            return super.rg(when);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean s() {
        return this.size == 0;
    }

    public boolean t() {
        ReentrantLock reentrantLock = this.f6182o;
        reentrantLock.lock();
        try {
            return super.t();
        } finally {
            reentrantLock.unlock();
        }
    }

    @NotNull
    public String th() {
        return "(buffer:capacity=" + this.f6184uk + ",size=" + this.size + ')';
    }

    /* JADX INFO: finally extract failed */
    public void v(boolean z) {
        Function1<E, Unit> function1 = this.f6177ad;
        ReentrantLock reentrantLock = this.f6182o;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = this.f6183pf[this.f249if];
                if (!(function1 == null || obj == qw.qw)) {
                    undeliveredElementException = OnUndeliveredElementKt.de(function1, obj, undeliveredElementException);
                }
                this.f6183pf[this.f249if] = qw.qw;
                this.f249if = (this.f249if + 1) % this.f6183pf.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.v(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public final boolean vvv() {
        return false;
    }

    @Nullable
    public Object z() {
        ReentrantLock reentrantLock = this.f6182o;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object i3 = i();
                if (i3 == null) {
                    i3 = qw.f6193fe;
                }
                return i3;
            }
            Object obj = this.f6183pf[this.f249if];
            when when = null;
            this.f6183pf[this.f249if] = null;
            this.size = i2 - 1;
            Object obj2 = qw.f6193fe;
            boolean z = false;
            if (i2 == this.f6184uk) {
                when when2 = null;
                while (true) {
                    when g = g();
                    if (g == null) {
                        when = when2;
                        break;
                    }
                    c v = g.v((ggg.de) null);
                    if (v != null) {
                        if (k.qw()) {
                            if (v == vvv.qw) {
                                z = true;
                            }
                            if (!z) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = g.t();
                        when = g;
                        z = true;
                    } else {
                        g.w();
                        when2 = g;
                    }
                }
            }
            if (obj2 != qw.f6193fe && !(obj2 instanceof uk)) {
                this.size = i2;
                this.f6183pf[(this.f249if + i2) % this.f6183pf.length] = obj2;
            }
            this.f249if = (this.f249if + 1) % this.f6183pf.length;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            if (z) {
                Intrinsics.checkNotNull(when);
                when.s();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
