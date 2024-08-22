package kotlinx.coroutines.sync;

import com.baidu.android.common.others.lang.StringUtil;
import i.qw.k;
import i.qw.x1.ggg;
import i.qw.x1.ppp;
import i.qw.x1.qqq;
import i.qw.x1.when;
import i.qw.xxx;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00018@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR$\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater qw = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    @NotNull
    public volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class LockCont extends qw {
        @NotNull
        @JvmField

        /* renamed from: i  reason: collision with root package name */
        public final CancellableContinuation<Unit> f6460i;

        public LockCont(@Nullable Object obj, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(MutexImpl.this, obj);
            this.f6460i = cancellableContinuation;
        }

        public void s(@NotNull Object obj) {
            this.f6460i.g(obj);
        }

        @Nullable
        public Object t() {
            return this.f6460i.a(Unit.INSTANCE, (Object) null, new MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl.this, this));
        }

        @NotNull
        public String toString() {
            return "LockCont[" + this.f6469uk + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f6460i + "] for " + MutexImpl.this;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BD\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016R1\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t8\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "token", "toString", "", "tryResumeLockWaiter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class LockSelect<R> extends qw {
        @NotNull
        @JvmField

        /* renamed from: i  reason: collision with root package name */
        public final SelectInstance<R> f6462i;
        @NotNull
        @JvmField

        /* renamed from: o  reason: collision with root package name */
        public final Function2<Mutex, Continuation<? super R>, Object> f6463o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ MutexImpl f6464pf;

        public void s(@NotNull Object obj) {
            if (k.qw()) {
                if (!(obj == MutexKt.f6471de)) {
                    throw new AssertionError();
                }
            }
            i.qw.y1.qw.de(this.f6463o, this.f6464pf, this.f6462i.m669switch(), new MutexImpl$LockSelect$completeResumeLockWaiter$2(this.f6464pf, this));
        }

        @Nullable
        public Object t() {
            if (this.f6462i.m668if()) {
                return MutexKt.f6471de;
            }
            return null;
        }

        @NotNull
        public String toString() {
            return "LockSelect[" + this.f6469uk + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f6462i + "] for " + this.f6464pf;
        }
    }

    public static final class ad extends when {
        @NotNull
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public Object f6465uk;

        public ad(@NotNull Object obj) {
            this.f6465uk = obj;
        }

        @NotNull
        public String toString() {
            return "LockedQueue[" + this.f6465uk + ']';
        }
    }

    public static final class de extends i.qw.x1.fe<MutexImpl> {
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final ad f6466ad;

        public de(@NotNull ad adVar) {
            this.f6466ad = adVar;
        }

        /* renamed from: o */
        public void fe(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            MutexImpl.qw.compareAndSet(mutexImpl, this, obj == null ? MutexKt.f6475yj : this.f6466ad);
        }

        @Nullable
        /* renamed from: pf */
        public Object i(@NotNull MutexImpl mutexImpl) {
            if (this.f6466ad.s()) {
                return null;
            }
            return MutexKt.f6470ad;
        }
    }

    public static final class fe extends ggg.ad {

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ MutexImpl f6467fe;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ Object f6468rg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public fe(ggg ggg, MutexImpl mutexImpl, Object obj) {
            super(ggg);
            this.f6467fe = mutexImpl;
            this.f6468rg = obj;
        }

        @Nullable
        /* renamed from: pf */
        public Object i(@NotNull ggg ggg) {
            if (this.f6467fe._state == this.f6468rg) {
                return null;
            }
            return ppp.qw();
        }
    }

    public abstract class qw extends ggg implements DisposableHandle {
        @Nullable
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public final Object f6469uk;

        public qw(@Nullable MutexImpl mutexImpl, Object obj) {
            this.f6469uk = obj;
        }

        public final void dispose() {
            m();
        }

        public abstract void s(@NotNull Object obj);

        @Nullable
        public abstract Object t();
    }

    public void ad(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof i.qw.b2.ad) {
                if (obj == null) {
                    if (((i.qw.b2.ad) obj2).qw == MutexKt.f6473rg) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    i.qw.b2.ad adVar = (i.qw.b2.ad) obj2;
                    if (adVar.qw != obj) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException(("Mutex is locked by " + adVar.qw + " but expected " + obj).toString());
                    }
                }
                if (qw.compareAndSet(this, obj2, MutexKt.f6475yj)) {
                    return;
                }
            } else if (obj2 instanceof qqq) {
                ((qqq) obj2).de(this);
            } else if (obj2 instanceof ad) {
                if (obj != null) {
                    ad adVar2 = (ad) obj2;
                    if (adVar2.f6465uk != obj) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException(("Mutex is locked by " + adVar2.f6465uk + " but expected " + obj).toString());
                    }
                }
                ad adVar3 = (ad) obj2;
                ggg n = adVar3.n();
                if (n == null) {
                    de deVar = new de(adVar3);
                    if (qw.compareAndSet(this, obj2, deVar) && deVar.de(this) == null) {
                        return;
                    }
                } else {
                    qw qwVar = (qw) n;
                    Object t = qwVar.t();
                    if (t != null) {
                        Object obj3 = qwVar.f6469uk;
                        if (obj3 == null) {
                            obj3 = MutexKt.f6472fe;
                        }
                        adVar3.f6465uk = obj3;
                        qwVar.s(t);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj2).toString());
            }
        }
    }

    public final Object de(Object obj, Continuation<? super Unit> continuation) {
        i.qw.ggg<? super Unit> ad2 = xxx.ad(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        LockCont lockCont = new LockCont(obj, ad2);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof i.qw.b2.ad) {
                i.qw.b2.ad adVar = (i.qw.b2.ad) obj2;
                if (adVar.qw != MutexKt.f6473rg) {
                    qw.compareAndSet(this, obj2, new ad(adVar.qw));
                } else {
                    if (qw.compareAndSet(this, obj2, obj == null ? MutexKt.f6474th : new i.qw.b2.ad(obj))) {
                        ad2.ppp(Unit.INSTANCE, new MutexImpl$lockSuspend$2$1$1(this, obj));
                        break;
                    }
                }
            } else if (obj2 instanceof ad) {
                boolean z = false;
                if (((ad) obj2).f6465uk != obj) {
                    ggg ggg = (ggg) obj2;
                    fe feVar = new fe(lockCont, this, obj2);
                    while (true) {
                        int r = ggg.h().r(lockCont, ggg, feVar);
                        if (r != 1) {
                            if (r == 2) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        xxx.de(ad2, lockCont);
                        break;
                    }
                } else {
                    throw new IllegalStateException(Intrinsics.stringPlus("Already locked by ", obj).toString());
                }
            } else if (obj2 instanceof qqq) {
                ((qqq) obj2).de(this);
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj2).toString());
            }
        }
        Object mmm = ad2.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mmm : Unit.INSTANCE;
    }

    public boolean fe(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            boolean z = true;
            if (obj2 instanceof i.qw.b2.ad) {
                if (((i.qw.b2.ad) obj2).qw != MutexKt.f6473rg) {
                    return false;
                }
                if (qw.compareAndSet(this, obj2, obj == null ? MutexKt.f6474th : new i.qw.b2.ad(obj))) {
                    return true;
                }
            } else if (obj2 instanceof ad) {
                if (((ad) obj2).f6465uk == obj) {
                    z = false;
                }
                if (z) {
                    return false;
                }
                throw new IllegalStateException(Intrinsics.stringPlus("Already locked by ", obj).toString());
            } else if (obj2 instanceof qqq) {
                ((qqq) obj2).de(this);
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj2).toString());
            }
        }
    }

    @Nullable
    public Object qw(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        if (fe(obj)) {
            return Unit.INSTANCE;
        }
        Object de2 = de(obj, continuation);
        return de2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? de2 : Unit.INSTANCE;
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof i.qw.b2.ad) {
                return "Mutex[" + ((i.qw.b2.ad) obj).qw + ']';
            } else if (obj instanceof qqq) {
                ((qqq) obj).de(this);
            } else if (obj instanceof ad) {
                return "Mutex[" + ((ad) obj).f6465uk + ']';
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Illegal state ", obj).toString());
            }
        }
    }
}
