package i.qw;

import i.qw.x1.c;
import org.jetbrains.annotations.NotNull;

public final class d0 {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final c f6116ad = new c("CLOSED_EMPTY");
    @NotNull
    public static final c qw = new c("REMOVED_TASK");

    public static final long de(long j) {
        return j / 1000000;
    }

    public static final long fe(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
