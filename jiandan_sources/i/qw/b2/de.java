package i.qw.b2;

import i.qw.ggg;
import i.qw.xxx;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de implements Semaphore {

    /* renamed from: de  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6106de;

    /* renamed from: fe  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6107fe;

    /* renamed from: rg  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6108rg;

    /* renamed from: th  reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6109th;

    /* renamed from: yj  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6110yj;
    @NotNull
    public volatile /* synthetic */ int _availablePermits;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function1<Throwable, Unit> f6111ad;
    @NotNull
    public volatile /* synthetic */ long deqIdx;
    @NotNull
    public volatile /* synthetic */ long enqIdx;
    @NotNull
    public volatile /* synthetic */ Object head;
    public final int qw;
    @NotNull
    public volatile /* synthetic */ Object tail;

    static {
        Class<Object> cls = Object.class;
        Class<de> cls2 = de.class;
        f6106de = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "head");
        f6107fe = AtomicLongFieldUpdater.newUpdater(cls2, "deqIdx");
        f6108rg = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "tail");
        f6109th = AtomicLongFieldUpdater.newUpdater(cls2, "enqIdx");
        f6110yj = AtomicIntegerFieldUpdater.newUpdater(cls2, "_availablePermits");
    }

    public final Object fe(Continuation<? super Unit> continuation) {
        ggg<? super Unit> ad2 = xxx.ad(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        while (true) {
            if (!rg(ad2)) {
                if (f6110yj.getAndDecrement(this) > 0) {
                    ad2.ppp(Unit.INSTANCE, this.f6111ad);
                    break;
                }
            } else {
                break;
            }
        }
        Object mmm = ad2.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mmm : Unit.INSTANCE;
    }

    @Nullable
    public Object qw(@NotNull Continuation<? super Unit> continuation) {
        if (f6110yj.getAndDecrement(this) > 0) {
            return Unit.INSTANCE;
        }
        Object fe2 = fe(continuation);
        return fe2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fe2 : Unit.INSTANCE;
    }

    public void release() {
        while (true) {
            int i2 = this._availablePermits;
            if (i2 < this.qw) {
                if (f6110yj.compareAndSet(this, i2, i2 + 1) && (i2 >= 0 || yj())) {
                    return;
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("The number of released permits cannot be greater than ", Integer.valueOf(this.qw)).toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0072, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean rg(kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.Object r2 = r0.tail
            i.qw.b2.fe r2 = (i.qw.b2.fe) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = f6109th
            long r3 = r3.getAndIncrement(r0)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.f6480th
            long r5 = (long) r5
            long r5 = r3 / r5
        L_0x0015:
            r7 = r2
        L_0x0016:
            long r8 = r7.m423switch()
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 < 0) goto L_0x0029
            boolean r8 = r7.yj()
            if (r8 == 0) goto L_0x0025
            goto L_0x0029
        L_0x0025:
            i.qw.x1.a.qw(r7)
            goto L_0x003a
        L_0x0029:
            java.lang.Object r8 = r7.rg()
            i.qw.x1.c r9 = i.qw.x1.th.qw
            if (r8 != r9) goto L_0x00d4
            i.qw.x1.c r7 = i.qw.x1.th.qw
            i.qw.x1.a.qw(r7)
        L_0x003a:
            boolean r8 = i.qw.x1.a.de(r7)
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L_0x007f
            i.qw.x1.tt r8 = i.qw.x1.a.ad(r7)
        L_0x0046:
            java.lang.Object r11 = r0.tail
            i.qw.x1.tt r11 = (i.qw.x1.tt) r11
            long r12 = r11.m423switch()
            long r14 = r8.m423switch()
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x0058
        L_0x0056:
            r8 = 1
            goto L_0x0072
        L_0x0058:
            boolean r12 = r8.ggg()
            if (r12 != 0) goto L_0x0060
            r8 = 0
            goto L_0x0072
        L_0x0060:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = f6108rg
            boolean r12 = r12.compareAndSet(r0, r11, r8)
            if (r12 == 0) goto L_0x0075
            boolean r8 = r11.m422if()
            if (r8 == 0) goto L_0x0056
            r11.o()
            goto L_0x0056
        L_0x0072:
            if (r8 == 0) goto L_0x0015
            goto L_0x007f
        L_0x0075:
            boolean r11 = r8.m422if()
            if (r11 == 0) goto L_0x0046
            r8.o()
            goto L_0x0046
        L_0x007f:
            i.qw.x1.tt r2 = i.qw.x1.a.ad(r7)
            i.qw.b2.fe r2 = (i.qw.b2.fe) r2
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.f6480th
            long r5 = (long) r5
            long r3 = r3 % r5
            int r4 = (int) r3
            r3 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.f6112rg
            boolean r3 = r5.compareAndSet(r4, r3, r1)
            if (r3 == 0) goto L_0x009e
            i.qw.b2.qw r3 = new i.qw.b2.qw
            r3.<init>(r2, r4)
            r1.i(r3)
            return r10
        L_0x009e:
            i.qw.x1.c r3 = kotlinx.coroutines.sync.SemaphoreKt.f6476ad
            i.qw.x1.c r5 = kotlinx.coroutines.sync.SemaphoreKt.f6477de
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r2.f6112rg
            boolean r3 = r6.compareAndSet(r4, r3, r5)
            if (r3 == 0) goto L_0x00b6
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> r3 = r0.f6111ad
            r1.ppp(r2, r3)
            return r10
        L_0x00b6:
            boolean r1 = i.qw.k.qw()
            if (r1 == 0) goto L_0x00d3
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r2.f6112rg
            java.lang.Object r1 = r1.get(r4)
            i.qw.x1.c r2 = kotlinx.coroutines.sync.SemaphoreKt.f6478fe
            if (r1 != r2) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r10 = 0
        L_0x00ca:
            if (r10 == 0) goto L_0x00cd
            goto L_0x00d3
        L_0x00cd:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x00d3:
            return r9
        L_0x00d4:
            i.qw.x1.yj r8 = (i.qw.x1.yj) r8
            i.qw.x1.tt r8 = (i.qw.x1.tt) r8
            if (r8 == 0) goto L_0x00dd
        L_0x00da:
            r7 = r8
            goto L_0x0016
        L_0x00dd:
            long r8 = r7.m423switch()
            r10 = 1
            long r8 = r8 + r10
            r10 = r7
            i.qw.b2.fe r10 = (i.qw.b2.fe) r10
            i.qw.b2.fe r8 = kotlinx.coroutines.sync.SemaphoreKt.uk(r8, r10)
            boolean r9 = r7.pf(r8)
            if (r9 == 0) goto L_0x0016
            boolean r9 = r7.yj()
            if (r9 == 0) goto L_0x00da
            r7.o()
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.b2.de.rg(kotlinx.coroutines.CancellableContinuation):boolean");
    }

    public final boolean th(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object a = cancellableContinuation.a(Unit.INSTANCE, (Object) null, this.f6111ad);
        if (a == null) {
            return false;
        }
        cancellableContinuation.g(a);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x006e, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean yj() {
        /*
            r15 = this;
            java.lang.Object r0 = r15.head
            i.qw.b2.fe r0 = (i.qw.b2.fe) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f6107fe
            long r1 = r1.getAndIncrement(r15)
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f6480th
            long r3 = (long) r3
            long r3 = r1 / r3
        L_0x0011:
            r5 = r0
        L_0x0012:
            long r6 = r5.m423switch()
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 < 0) goto L_0x0025
            boolean r6 = r5.yj()
            if (r6 == 0) goto L_0x0021
            goto L_0x0025
        L_0x0021:
            i.qw.x1.a.qw(r5)
            goto L_0x0036
        L_0x0025:
            java.lang.Object r6 = r5.rg()
            i.qw.x1.c r7 = i.qw.x1.th.qw
            if (r6 != r7) goto L_0x00d4
            i.qw.x1.c r5 = i.qw.x1.th.qw
            i.qw.x1.a.qw(r5)
        L_0x0036:
            boolean r6 = i.qw.x1.a.de(r5)
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x007b
            i.qw.x1.tt r6 = i.qw.x1.a.ad(r5)
        L_0x0042:
            java.lang.Object r9 = r15.head
            i.qw.x1.tt r9 = (i.qw.x1.tt) r9
            long r10 = r9.m423switch()
            long r12 = r6.m423switch()
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0054
        L_0x0052:
            r6 = 1
            goto L_0x006e
        L_0x0054:
            boolean r10 = r6.ggg()
            if (r10 != 0) goto L_0x005c
            r6 = 0
            goto L_0x006e
        L_0x005c:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = f6106de
            boolean r10 = r10.compareAndSet(r15, r9, r6)
            if (r10 == 0) goto L_0x0071
            boolean r6 = r9.m422if()
            if (r6 == 0) goto L_0x0052
            r9.o()
            goto L_0x0052
        L_0x006e:
            if (r6 == 0) goto L_0x0011
            goto L_0x007b
        L_0x0071:
            boolean r9 = r6.m422if()
            if (r9 == 0) goto L_0x0042
            r6.o()
            goto L_0x0042
        L_0x007b:
            i.qw.x1.tt r0 = i.qw.x1.a.ad(r5)
            i.qw.b2.fe r0 = (i.qw.b2.fe) r0
            r0.ad()
            long r5 = r0.m423switch()
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x008d
            return r7
        L_0x008d:
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f6480th
            long r3 = (long) r3
            long r1 = r1 % r3
            int r2 = (int) r1
            i.qw.x1.c r1 = kotlinx.coroutines.sync.SemaphoreKt.f6476ad
            java.util.concurrent.atomic.AtomicReferenceArray r3 = r0.f6112rg
            java.lang.Object r1 = r3.getAndSet(r2, r1)
            if (r1 != 0) goto L_0x00c6
            int r1 = kotlinx.coroutines.sync.SemaphoreKt.qw
        L_0x00a4:
            if (r7 >= r1) goto L_0x00b6
            java.util.concurrent.atomic.AtomicReferenceArray r3 = r0.f6112rg
            java.lang.Object r3 = r3.get(r2)
            i.qw.x1.c r4 = kotlinx.coroutines.sync.SemaphoreKt.f6477de
            if (r3 != r4) goto L_0x00b3
            return r8
        L_0x00b3:
            int r7 = r7 + 1
            goto L_0x00a4
        L_0x00b6:
            i.qw.x1.c r1 = kotlinx.coroutines.sync.SemaphoreKt.f6476ad
            i.qw.x1.c r3 = kotlinx.coroutines.sync.SemaphoreKt.f6478fe
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.f6112rg
            boolean r0 = r0.compareAndSet(r2, r1, r3)
            r0 = r0 ^ r8
            return r0
        L_0x00c6:
            i.qw.x1.c r0 = kotlinx.coroutines.sync.SemaphoreKt.f6479rg
            if (r1 != r0) goto L_0x00cd
            return r7
        L_0x00cd:
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1
            boolean r0 = r15.th(r1)
            return r0
        L_0x00d4:
            i.qw.x1.yj r6 = (i.qw.x1.yj) r6
            i.qw.x1.tt r6 = (i.qw.x1.tt) r6
            if (r6 == 0) goto L_0x00dd
        L_0x00da:
            r5 = r6
            goto L_0x0012
        L_0x00dd:
            long r6 = r5.m423switch()
            r8 = 1
            long r6 = r6 + r8
            r8 = r5
            i.qw.b2.fe r8 = (i.qw.b2.fe) r8
            i.qw.b2.fe r6 = kotlinx.coroutines.sync.SemaphoreKt.uk(r6, r8)
            boolean r7 = r5.pf(r6)
            if (r7 == 0) goto L_0x0012
            boolean r7 = r5.yj()
            if (r7 == 0) goto L_0x00da
            r5.o()
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.b2.de.yj():boolean");
    }
}
