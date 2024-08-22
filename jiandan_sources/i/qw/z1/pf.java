package i.qw.z1;

import i.qw.k;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class pf {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6313ad;

    /* renamed from: de  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6314de;

    /* renamed from: fe  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6315fe;

    /* renamed from: rg  reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6316rg;
    @NotNull
    public volatile /* synthetic */ int blockingTasksInBuffer = 0;
    @NotNull
    public volatile /* synthetic */ int consumerIndex = 0;
    @NotNull
    public volatile /* synthetic */ Object lastScheduledTask = null;
    @NotNull
    public volatile /* synthetic */ int producerIndex = 0;
    @NotNull
    public final AtomicReferenceArray<uk> qw = new AtomicReferenceArray<>(128);

    static {
        Class<pf> cls = pf.class;
        f6313ad = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f6314de = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f6315fe = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f6316rg = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public static /* synthetic */ uk ad(pf pfVar, uk ukVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return pfVar.qw(ukVar, z);
    }

    public final uk de(uk ukVar) {
        boolean z = true;
        if (ukVar.f6322th.vvv() != 1) {
            z = false;
        }
        if (z) {
            f6316rg.incrementAndGet(this);
        }
        if (rg() == 127) {
            return ukVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.qw.get(i2) != null) {
            Thread.yield();
        }
        this.qw.lazySet(i2, ukVar);
        f6314de.incrementAndGet(this);
        return null;
    }

    public final void fe(uk ukVar) {
        if (ukVar != null) {
            boolean z = false;
            if (ukVar.f6322th.vvv() == 1) {
                int decrementAndGet = f6316rg.decrementAndGet(this);
                if (k.qw()) {
                    if (decrementAndGet >= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    public final uk i() {
        uk andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f6315fe.compareAndSet(this, i2, i2 + 1) && (andSet = this.qw.getAndSet(i3, (Object) null)) != null) {
                fe(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final long m424if(@NotNull pf pfVar) {
        boolean z = true;
        if (k.qw()) {
            if (!(rg() == 0)) {
                throw new AssertionError();
            }
        }
        uk i2 = pfVar.i();
        if (i2 == null) {
            return m425switch(pfVar, false);
        }
        uk ad2 = ad(this, i2, false, 2, (Object) null);
        if (!k.qw()) {
            return -1;
        }
        if (ad2 != null) {
            z = false;
        }
        if (z) {
            return -1;
        }
        throw new AssertionError();
    }

    public final boolean o(de deVar) {
        uk i2 = i();
        if (i2 == null) {
            return false;
        }
        deVar.qw(i2);
        return true;
    }

    public final long pf(@NotNull pf pfVar) {
        if (k.qw()) {
            if (!(rg() == 0)) {
                throw new AssertionError();
            }
        }
        int i2 = pfVar.producerIndex;
        AtomicReferenceArray<uk> atomicReferenceArray = pfVar.qw;
        for (int i3 = pfVar.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (pfVar.blockingTasksInBuffer == 0) {
                break;
            }
            uk ukVar = atomicReferenceArray.get(i4);
            if (ukVar != null) {
                if ((ukVar.f6322th.vvv() == 1) && atomicReferenceArray.compareAndSet(i4, ukVar, (Object) null)) {
                    f6316rg.decrementAndGet(pfVar);
                    ad(this, ukVar, false, 2, (Object) null);
                    return -1;
                }
            }
        }
        return m425switch(pfVar, true);
    }

    @Nullable
    public final uk qw(@NotNull uk ukVar, boolean z) {
        if (z) {
            return de(ukVar);
        }
        uk ukVar2 = (uk) f6313ad.getAndSet(this, ukVar);
        if (ukVar2 == null) {
            return null;
        }
        return de(ukVar2);
    }

    public final int rg() {
        return this.producerIndex - this.consumerIndex;
    }

    /* renamed from: switch  reason: not valid java name */
    public final long m425switch(pf pfVar, boolean z) {
        uk ukVar;
        do {
            ukVar = (uk) pfVar.lastScheduledTask;
            if (ukVar == null) {
                return -2;
            }
            if (z) {
                boolean z2 = true;
                if (ukVar.f6322th.vvv() != 1) {
                    z2 = false;
                }
                if (!z2) {
                    return -2;
                }
            }
            long qw2 = o.f6312rg.qw() - ukVar.f6321ad;
            long j = o.qw;
            if (qw2 < j) {
                return j - qw2;
            }
        } while (!f6313ad.compareAndSet(pfVar, ukVar, (Object) null));
        ad(this, ukVar, false, 2, (Object) null);
        return -1;
    }

    public final int th() {
        return this.lastScheduledTask != null ? rg() + 1 : rg();
    }

    @Nullable
    public final uk uk() {
        uk ukVar = (uk) f6313ad.getAndSet(this, (Object) null);
        return ukVar == null ? i() : ukVar;
    }

    public final void yj(@NotNull de deVar) {
        uk ukVar = (uk) f6313ad.getAndSet(this, (Object) null);
        if (ukVar != null) {
            deVar.qw(ukVar);
        }
        do {
        } while (o(deVar));
    }
}
