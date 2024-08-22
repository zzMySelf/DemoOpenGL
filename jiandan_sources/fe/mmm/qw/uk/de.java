package fe.mmm.qw.uk;

import android.net.Uri;
import android.os.SystemClock;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.db.ISlowWriteMonitorable;
import com.tera.scan.db.IWaitingWriteQueueMonitorable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ISlowWriteMonitorable f8563ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final ConcurrentLinkedQueue<ad> f8564de = new ConcurrentLinkedQueue<>();

    /* renamed from: fe  reason: collision with root package name */
    public volatile long f8565fe;
    @NotNull
    public final IWaitingWriteQueueMonitorable qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final AtomicInteger f8566rg = new AtomicInteger(1);
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final AtomicInteger f8567th = new AtomicInteger(0);

    public de(@NotNull IWaitingWriteQueueMonitorable iWaitingWriteQueueMonitorable, @NotNull ISlowWriteMonitorable iSlowWriteMonitorable) {
        Intrinsics.checkNotNullParameter(iWaitingWriteQueueMonitorable, "waitingMonitor");
        Intrinsics.checkNotNullParameter(iSlowWriteMonitorable, "slowMonitor");
        this.qw = iWaitingWriteQueueMonitorable;
        this.f8563ad = iSlowWriteMonitorable;
    }

    public final void ad() {
        T t;
        Iterator<T> it = this.f8564de.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((ad) t).yj()) {
                break;
            }
        }
        ad adVar = (ad) t;
        if (adVar != null && this.f8565fe != 0 && this.f8566rg.get() < this.qw.qw()) {
            int ad2 = this.qw.ad();
            if (ad2 > 0 && this.f8564de.size() > ad2) {
                this.f8566rg.getAndSet(RangesKt___RangesKt.coerceAtLeast(this.f8566rg.get(), this.f8564de.size() / ad2));
            }
            int i2 = this.f8566rg.get() * ad2;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f8565fe;
            if (this.f8564de.size() >= i2 && elapsedRealtime >= this.qw.de()) {
                this.f8566rg.incrementAndGet();
                try {
                    this.qw.fe(this.f8564de, adVar, elapsedRealtime);
                    ExpectKt.success(Unit.INSTANCE);
                } catch (Throwable th2) {
                    LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                    ExpectKt.failure(th2);
                }
            }
        }
    }

    public final void de(@Nullable ad adVar) {
        if (adVar != null) {
            adVar.fe();
            this.f8565fe = adVar.rg();
            this.f8564de.remove(adVar);
        }
    }

    @Nullable
    public final ad qw(@Nullable Uri uri, int i2) {
        if (this.f8566rg.get() > this.qw.qw()) {
            return null;
        }
        ad adVar = new ad(uri, i2, this.f8567th, this.f8563ad);
        ad();
        this.f8564de.add(adVar);
        return adVar;
    }

    @NotNull
    public String toString() {
        String concurrentLinkedQueue = this.f8564de.toString();
        Intrinsics.checkNotNullExpressionValue(concurrentLinkedQueue, "writers.toString()");
        return concurrentLinkedQueue;
    }
}
