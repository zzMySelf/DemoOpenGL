package i.qw.z1;

import i.qw.x1.d;
import i.qw.x1.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

public final class qw extends ad {
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public static final qw f6317o = new qw();
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public static final CoroutineDispatcher f6318pf = new fe(f6317o, f.fe("kotlinx.coroutines.io.parallelism", RangesKt___RangesKt.coerceAtLeast(64, d.qw()), 0, 0, 12, (Object) null), "Dispatchers.IO", 1);

    public qw() {
        super(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @NotNull
    public final CoroutineDispatcher eee() {
        return f6318pf;
    }

    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }
}
