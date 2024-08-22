package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import i.qw.fe;
import i.qw.k;
import i.qw.l;
import i.qw.rg;
import i.qw.x1.c;
import i.qw.z1.de;
import i.qw.z1.i;
import i.qw.z1.o;
import i.qw.z1.pf;
import i.qw.z1.th;
import i.qw.z1.uk;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 X2\u00020\\2\u00020]:\u0003XYZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010!\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0013H\b¢\u0006\u0004\b#\u0010\u0015J\u0010\u0010$\u001a\u00020\u0001H\b¢\u0006\u0004\b$\u0010\u0017J-\u0010&\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\u00132\n\u0010(\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004H\b¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0001H\b¢\u0006\u0004\b-\u0010\u0017J\u001b\u0010/\u001a\u00020\u00012\n\u0010.\u001a\u00060 R\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b1\u0010\"J\u0019\u00102\u001a\u00020\f2\n\u0010.\u001a\u00060 R\u00020\u0000¢\u0006\u0004\b2\u00103J)\u00106\u001a\u00020\u00132\n\u0010.\u001a\u00060 R\u00020\u00002\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0004H\b¢\u0006\u0004\b8\u0010,J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0013¢\u0006\u0004\bA\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\fH\b¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0002¢\u0006\u0004\bH\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\n*\b\u0018\u00010 R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010JR\u0017\u0010\u0010\u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010LR\u0017\u0010\u001f\u001a\u00020\u00018Â\u0002@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0017R\u0016\u0010O\u001a\u00020N8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020N8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bQ\u0010PR\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010RR\u0013\u0010S\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\bS\u0010ER\u0016\u0010\u0003\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010TR\"\u0010V\u001a\u000e\u0012\n\u0012\b\u0018\u00010 R\u00020\u00000U8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "workers", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: if  reason: not valid java name */
    public static final /* synthetic */ AtomicLongFieldUpdater f255if = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    @NotNull
    @JvmField
    public static final c ppp = new c("NOT_IN_STACK");

    /* renamed from: switch  reason: not valid java name */
    public static final /* synthetic */ AtomicLongFieldUpdater f256switch = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater when = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    @NotNull
    public volatile /* synthetic */ int _isTerminated;
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final int f6446ad;
    @NotNull
    public volatile /* synthetic */ long controlState;
    @NotNull
    @JvmField

    /* renamed from: i  reason: collision with root package name */
    public final de f6447i;
    @NotNull
    @JvmField

    /* renamed from: o  reason: collision with root package name */
    public final de f6448o;
    @NotNull
    public volatile /* synthetic */ long parkedWorkersStack;
    @NotNull
    @JvmField

    /* renamed from: pf  reason: collision with root package name */
    public final AtomicReferenceArray<ad> f6449pf;
    @JvmField

    /* renamed from: th  reason: collision with root package name */
    public final int f6450th;
    @NotNull
    @JvmField

    /* renamed from: uk  reason: collision with root package name */
    public final String f6451uk;
    @JvmField

    /* renamed from: yj  reason: collision with root package name */
    public final long f6452yj;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public /* synthetic */ class qw {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CoroutineScheduler(int i2, int i3, long j, @NotNull String str) {
        this.f6446ad = i2;
        this.f6450th = i3;
        this.f6452yj = j;
        this.f6451uk = str;
        if (i2 >= 1) {
            if (this.f6450th >= this.f6446ad) {
                if (this.f6450th <= 2097150) {
                    if (this.f6452yj > 0) {
                        this.f6447i = new de();
                        this.f6448o = new de();
                        this.parkedWorkersStack = 0;
                        this.f6449pf = new AtomicReferenceArray<>(this.f6450th + 1);
                        this.controlState = ((long) this.f6446ad) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + this.f6452yj + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + this.f6450th + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + this.f6450th + " should be greater than or equals to core pool size " + this.f6446ad).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + this.f6446ad + " should be at least 1").toString());
    }

    public static /* synthetic */ boolean mmm(CoroutineScheduler coroutineScheduler, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = coroutineScheduler.controlState;
        }
        return coroutineScheduler.nn(j);
    }

    public static /* synthetic */ void yj(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = th.f6319ad;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.th(runnable, taskContext, z);
    }

    public final boolean aaa() {
        ad pf2;
        do {
            pf2 = pf();
            if (pf2 == null) {
                return false;
            }
        } while (!ad.f257if.compareAndSet(pf2, -1, 0));
        LockSupport.unpark(pf2);
        return true;
    }

    public void close() {
        ggg(10000);
    }

    public final uk ddd(ad adVar, uk ukVar, boolean z) {
        if (adVar == null || adVar.f6457th == WorkerState.TERMINATED) {
            return ukVar;
        }
        if (ukVar.f6322th.vvv() == 0 && adVar.f6457th == WorkerState.BLOCKING) {
            return ukVar;
        }
        adVar.f6455o = true;
        return adVar.f6453ad.qw(ukVar, z);
    }

    public final int de() {
        synchronized (this.f6449pf) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i2 = (int) (j & 2097151);
            boolean z = false;
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2 - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (coerceAtLeast >= this.f6446ad) {
                return 0;
            }
            if (i2 >= this.f6450th) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (i3 > 0 && this.f6449pf.get(i3) == null) {
                ad adVar = new ad(i3);
                this.f6449pf.set(i3, adVar);
                if (i3 == ((int) (2097151 & f256switch.incrementAndGet(this)))) {
                    z = true;
                }
                if (z) {
                    adVar.start();
                    int i4 = coerceAtLeast + 1;
                    return i4;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public void execute(@NotNull Runnable runnable) {
        yj(this, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    @NotNull
    public final uk fe(@NotNull Runnable runnable, @NotNull TaskContext taskContext) {
        long qw2 = o.f6312rg.qw();
        if (!(runnable instanceof uk)) {
            return new i(runnable, qw2, taskContext);
        }
        uk ukVar = (uk) runnable;
        ukVar.f6321ad = qw2;
        ukVar.f6322th = taskContext;
        return ukVar;
    }

    public final void ggg(long j) {
        int i2;
        uk ukVar;
        boolean z = false;
        if (when.compareAndSet(this, 0, 1)) {
            ad rg2 = rg();
            synchronized (this.f6449pf) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    ad adVar = this.f6449pf.get(i3);
                    Intrinsics.checkNotNull(adVar);
                    if (adVar != rg2) {
                        while (adVar.isAlive()) {
                            LockSupport.unpark(adVar);
                            adVar.join(j);
                        }
                        WorkerState workerState = adVar.f6457th;
                        if (k.qw()) {
                            if (!(workerState == WorkerState.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        adVar.f6453ad.yj(this.f6448o);
                    }
                    if (i3 == i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            this.f6448o.ad();
            this.f6447i.ad();
            while (true) {
                if (rg2 == null) {
                    ukVar = null;
                } else {
                    ukVar = rg2.rg(true);
                }
                if (ukVar == null) {
                    ukVar = (uk) this.f6447i.fe();
                }
                if (ukVar == null && (ukVar = (uk) this.f6448o.fe()) == null) {
                    break;
                }
                ppp(ukVar);
            }
            if (rg2 != null) {
                rg2.xxx(WorkerState.TERMINATED);
            }
            if (k.qw()) {
                if (((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.f6446ad) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean nn(long j) {
        if (RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f6446ad) {
            int de2 = de();
            if (de2 == 1 && this.f6446ad > 1) {
                de();
            }
            if (de2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final ad pf() {
        while (true) {
            long j = this.parkedWorkersStack;
            ad adVar = this.f6449pf.get((int) (2097151 & j));
            if (adVar == null) {
                return null;
            }
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            int uk2 = uk(adVar);
            if (uk2 >= 0) {
                if (f255if.compareAndSet(this, j, ((long) uk2) | j2)) {
                    adVar.ppp(ppp);
                    return adVar;
                }
            }
        }
    }

    public final void ppp(@NotNull uk ukVar) {
        fe qw2;
        try {
            ukVar.run();
            qw2 = rg.qw();
            if (qw2 == null) {
                return;
            }
        } catch (Throwable th2) {
            fe qw3 = rg.qw();
            if (qw3 != null) {
                qw3.rg();
            }
            throw th2;
        }
        qw2.rg();
    }

    public final boolean qw(uk ukVar) {
        boolean z = true;
        if (ukVar.f6322th.vvv() != 1) {
            z = false;
        }
        if (z) {
            return this.f6448o.qw(ukVar);
        }
        return this.f6447i.qw(ukVar);
    }

    public final ad rg() {
        Thread currentThread = Thread.currentThread();
        ad adVar = currentThread instanceof ad ? (ad) currentThread : null;
        if (adVar != null && Intrinsics.areEqual((Object) CoroutineScheduler.this, (Object) this)) {
            return adVar;
        }
        return null;
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m665switch(@NotNull ad adVar) {
        long j;
        long j2;
        int th2;
        if (adVar.yj() != ppp) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j);
            j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            th2 = adVar.th();
            if (k.qw()) {
                if (!(th2 != 0)) {
                    throw new AssertionError();
                }
            }
            adVar.ppp(this.f6449pf.get(i2));
        } while (!f255if.compareAndSet(this, j, ((long) th2) | j2));
        return true;
    }

    public final void th(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        fe qw2 = rg.qw();
        if (qw2 != null) {
            qw2.fe();
        }
        uk fe2 = fe(runnable, taskContext);
        ad rg2 = rg();
        uk ddd = ddd(rg2, fe2, z);
        if (ddd == null || qw(ddd)) {
            boolean z2 = z && rg2 != null;
            if (fe2.f6322th.vvv() != 0) {
                vvv(z2);
            } else if (!z2) {
                xxx();
            }
        } else {
            throw new RejectedExecutionException(Intrinsics.stringPlus(this.f6451uk, " was terminated"));
        }
    }

    @NotNull
    public String toString() {
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        int length = this.f6449pf.length();
        int i6 = 0;
        if (1 < length) {
            i4 = 0;
            int i7 = 0;
            i3 = 0;
            i2 = 0;
            int i8 = 1;
            while (true) {
                int i9 = i8 + 1;
                ad adVar = this.f6449pf.get(i8);
                if (adVar != null) {
                    int th2 = adVar.f6453ad.th();
                    int i10 = qw.$EnumSwitchMapping$0[adVar.f6457th.ordinal()];
                    if (i10 == 1) {
                        i6++;
                    } else if (i10 == 2) {
                        i4++;
                        StringBuilder sb = new StringBuilder();
                        sb.append(th2);
                        sb.append('b');
                        arrayList.add(sb.toString());
                    } else if (i10 == 3) {
                        i7++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(th2);
                        sb2.append('c');
                        arrayList.add(sb2.toString());
                    } else if (i10 == 4) {
                        i3++;
                        if (th2 > 0) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(th2);
                            sb3.append('d');
                            arrayList.add(sb3.toString());
                        }
                    } else if (i10 == 5) {
                        i2++;
                    }
                }
                if (i9 >= length) {
                    break;
                }
                i8 = i9;
            }
            i5 = i6;
            i6 = i7;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        long j = this.controlState;
        return this.f6451uk + '@' + l.ad(this) + "[Pool Size {core = " + this.f6446ad + ", max = " + this.f6450th + "}, Worker States {CPU = " + i6 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i3 + ", terminated = " + i2 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f6447i.de() + ", global blocking queue size = " + this.f6448o.de() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f6446ad - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    public final int uk(ad adVar) {
        Object yj2 = adVar.yj();
        while (yj2 != ppp) {
            if (yj2 == null) {
                return 0;
            }
            ad adVar2 = (ad) yj2;
            int th2 = adVar2.th();
            if (th2 != 0) {
                return th2;
            }
            yj2 = adVar2.yj();
        }
        return -1;
    }

    public final void vvv(boolean z) {
        long addAndGet = f256switch.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (!z && !aaa() && !nn(addAndGet)) {
            aaa();
        }
    }

    public final void when(@NotNull ad adVar, int i2, int i3) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            if (i4 == i2) {
                i4 = i3 == 0 ? uk(adVar) : i3;
            }
            if (i4 >= 0) {
                if (f255if.compareAndSet(this, j, j2 | ((long) i4))) {
                    return;
                }
            }
        }
    }

    public final void xxx() {
        if (!aaa() && !mmm(this, 0, 1, (Object) null)) {
            aaa();
        }
    }

    public final class ad extends Thread {

        /* renamed from: if  reason: not valid java name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f257if = AtomicIntegerFieldUpdater.newUpdater(ad.class, "workerCtl");
        @NotNull
        @JvmField

        /* renamed from: ad  reason: collision with root package name */
        public final pf f6453ad;

        /* renamed from: i  reason: collision with root package name */
        public int f6454i;
        public volatile int indexInArray;
        @Nullable
        public volatile Object nextParkedWorker;
        @JvmField

        /* renamed from: o  reason: collision with root package name */
        public boolean f6455o;
        @NotNull
        @JvmField

        /* renamed from: th  reason: collision with root package name */
        public WorkerState f6457th;

        /* renamed from: uk  reason: collision with root package name */
        public long f6458uk;
        @NotNull
        public volatile /* synthetic */ int workerCtl;

        /* renamed from: yj  reason: collision with root package name */
        public long f6459yj;

        public ad() {
            setDaemon(true);
            this.f6453ad = new pf();
            this.f6457th = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.ppp;
            this.f6454i = Random.Default.nextInt();
        }

        public final void ad(int i2) {
            if (i2 != 0 && xxx(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.xxx();
            }
        }

        public final uk ddd(boolean z) {
            long j;
            if (k.qw()) {
                if (!(this.f6453ad.th() == 0)) {
                    throw new AssertionError();
                }
            }
            int i2 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int o2 = o(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j2 = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                o2++;
                if (o2 > i2) {
                    o2 = 1;
                }
                ad adVar = coroutineScheduler.f6449pf.get(o2);
                if (!(adVar == null || adVar == this)) {
                    if (k.qw()) {
                        if (!(this.f6453ad.th() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        j = this.f6453ad.pf(adVar.f6453ad);
                    } else {
                        j = this.f6453ad.m424if(adVar.f6453ad);
                    }
                    if (j == -1) {
                        return this.f6453ad.uk();
                    }
                    if (j > 0) {
                        j2 = Math.min(j2, j);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.f6458uk = j2;
            return null;
        }

        public final void de(uk ukVar) {
            int vvv = ukVar.f6322th.vvv();
            uk(vvv);
            ad(vvv);
            CoroutineScheduler.this.ppp(ukVar);
            qw(vvv);
        }

        public final uk fe(boolean z) {
            uk ukVar;
            uk ukVar2;
            if (z) {
                boolean z2 = o(CoroutineScheduler.this.f6446ad * 2) == 0;
                if (z2 && (ukVar2 = m666if()) != null) {
                    return ukVar2;
                }
                uk uk2 = this.f6453ad.uk();
                if (uk2 != null) {
                    return uk2;
                }
                if (!z2 && (ukVar = m666if()) != null) {
                    return ukVar;
                }
            } else {
                uk ukVar3 = m666if();
                if (ukVar3 != null) {
                    return ukVar3;
                }
            }
            return ddd(false);
        }

        public final boolean ggg() {
            boolean z;
            if (this.f6457th != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) != 0) {
                        if (CoroutineScheduler.f256switch.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.f6457th = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        public final boolean i() {
            return this.nextParkedWorker != CoroutineScheduler.ppp;
        }

        /* renamed from: if  reason: not valid java name */
        public final uk m666if() {
            if (o(2) == 0) {
                uk ukVar = (uk) CoroutineScheduler.this.f6447i.fe();
                return ukVar == null ? (uk) CoroutineScheduler.this.f6448o.fe() : ukVar;
            }
            uk ukVar2 = (uk) CoroutineScheduler.this.f6448o.fe();
            return ukVar2 == null ? (uk) CoroutineScheduler.this.f6447i.fe() : ukVar2;
        }

        public final void nn() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f6449pf) {
                if (!coroutineScheduler.isTerminated()) {
                    if (((int) (coroutineScheduler.controlState & 2097151)) > coroutineScheduler.f6446ad) {
                        if (f257if.compareAndSet(this, -1, 1)) {
                            int th2 = th();
                            when(0);
                            coroutineScheduler.when(this, th2, 0);
                            int andDecrement = (int) (CoroutineScheduler.f256switch.getAndDecrement(coroutineScheduler) & 2097151);
                            if (andDecrement != th2) {
                                ad adVar = coroutineScheduler.f6449pf.get(andDecrement);
                                Intrinsics.checkNotNull(adVar);
                                coroutineScheduler.f6449pf.set(th2, adVar);
                                adVar.when(th2);
                                coroutineScheduler.when(adVar, andDecrement, th2);
                            }
                            coroutineScheduler.f6449pf.set(andDecrement, (Object) null);
                            Unit unit = Unit.INSTANCE;
                            this.f6457th = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        public final int o(int i2) {
            int i3 = this.f6454i;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f6454i = i6;
            int i7 = i2 - 1;
            if ((i7 & i2) == 0) {
                return i6 & i7;
            }
            return (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void pf() {
            if (this.f6459yj == 0) {
                this.f6459yj = System.nanoTime() + CoroutineScheduler.this.f6452yj;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f6452yj);
            if (System.nanoTime() - this.f6459yj >= 0) {
                this.f6459yj = 0;
                nn();
            }
        }

        public final void ppp(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final void qw(int i2) {
            if (i2 != 0) {
                CoroutineScheduler.f256switch.addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState workerState = this.f6457th;
                if (workerState != WorkerState.TERMINATED) {
                    if (k.qw()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.f6457th = WorkerState.DORMANT;
                }
            }
        }

        @Nullable
        public final uk rg(boolean z) {
            uk ukVar;
            if (ggg()) {
                return fe(z);
            }
            if (z) {
                ukVar = this.f6453ad.uk();
                if (ukVar == null) {
                    ukVar = (uk) CoroutineScheduler.this.f6448o.fe();
                }
            } else {
                ukVar = (uk) CoroutineScheduler.this.f6448o.fe();
            }
            return ukVar == null ? ddd(true) : ukVar;
        }

        public void run() {
            m667switch();
        }

        /* renamed from: switch  reason: not valid java name */
        public final void m667switch() {
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f6457th != WorkerState.TERMINATED) {
                    uk rg2 = rg(this.f6455o);
                    if (rg2 != null) {
                        this.f6458uk = 0;
                        de(rg2);
                    } else {
                        this.f6455o = false;
                        if (this.f6458uk == 0) {
                            vvv();
                        } else if (!z) {
                            z = true;
                        } else {
                            xxx(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f6458uk);
                            this.f6458uk = 0;
                        }
                    }
                }
            }
            xxx(WorkerState.TERMINATED);
        }

        public final int th() {
            return this.indexInArray;
        }

        public final void uk(int i2) {
            this.f6459yj = 0;
            if (this.f6457th == WorkerState.PARKING) {
                if (k.qw()) {
                    boolean z = true;
                    if (i2 != 1) {
                        z = false;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
                this.f6457th = WorkerState.BLOCKING;
            }
        }

        public final void vvv() {
            if (!i()) {
                CoroutineScheduler.this.m665switch(this);
                return;
            }
            if (k.qw()) {
                if (!(this.f6453ad.th() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (i() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.f6457th != WorkerState.TERMINATED) {
                xxx(WorkerState.PARKING);
                Thread.interrupted();
                pf();
            }
        }

        public final void when(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f6451uk);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final boolean xxx(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.f6457th;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.f256switch.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f6457th = workerState;
            }
            return z;
        }

        @Nullable
        public final Object yj() {
            return this.nextParkedWorker;
        }

        public ad(int i2) {
            this();
            when(i2);
        }
    }
}
