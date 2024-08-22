package i.qw.z1;

import i.qw.x1.d;
import i.qw.x1.f;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

public final class o {
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public static final int f6309ad = f.fe("kotlinx.coroutines.scheduler.core.pool.size", RangesKt___RangesKt.coerceAtLeast(d.qw(), 2), 1, 0, 8, (Object) null);
    @JvmField

    /* renamed from: de  reason: collision with root package name */
    public static final int f6310de = f.fe("kotlinx.coroutines.scheduler.max.pool.size", RangesKt___RangesKt.coerceIn(d.qw() * 128, f6309ad, 2097150), 0, 2097150, 4, (Object) null);
    @JvmField

    /* renamed from: fe  reason: collision with root package name */
    public static final long f6311fe = TimeUnit.SECONDS.toNanos(f.rg("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));
    @JvmField
    public static final long qw = f.rg("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);
    @NotNull
    @JvmField

    /* renamed from: rg  reason: collision with root package name */
    public static yj f6312rg = rg.qw;

    static {
        int unused = f.fe("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
    }
}
