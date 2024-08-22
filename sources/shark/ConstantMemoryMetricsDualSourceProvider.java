package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.BufferedSource;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lshark/ConstantMemoryMetricsDualSourceProvider;", "Lshark/DualSourceProvider;", "realSourceProvider", "(Lshark/DualSourceProvider;)V", "byteTravelRange", "", "getByteTravelRange", "()J", "lastRandomAccessPosition", "maxPosition", "minPosition", "<set-?>", "randomAccessByteReads", "getRandomAccessByteReads", "setRandomAccessByteReads$shark_hprof", "(J)V", "randomAccessByteTravel", "getRandomAccessByteTravel", "setRandomAccessByteTravel$shark_hprof", "randomAccessReadCount", "getRandomAccessReadCount", "setRandomAccessReadCount$shark_hprof", "openRandomAccessSource", "Lshark/RandomAccessSource;", "openStreamingSource", "Lokio/BufferedSource;", "updateRandomAccessStatsOnRead", "", "position", "bytesRead", "shark-hprof"}, k = 1, mv = {1, 4, 1})
/* compiled from: ConstantMemoryMetricsDualSourceProvider.kt */
public final class ConstantMemoryMetricsDualSourceProvider implements DualSourceProvider {
    private long lastRandomAccessPosition = -1;
    private long maxPosition = -1;
    private long minPosition = -1;
    private long randomAccessByteReads;
    private long randomAccessByteTravel;
    private long randomAccessReadCount;
    private final DualSourceProvider realSourceProvider;

    public ConstantMemoryMetricsDualSourceProvider(DualSourceProvider realSourceProvider2) {
        Intrinsics.checkParameterIsNotNull(realSourceProvider2, "realSourceProvider");
        this.realSourceProvider = realSourceProvider2;
    }

    public final long getRandomAccessByteReads() {
        return this.randomAccessByteReads;
    }

    public final void setRandomAccessByteReads$shark_hprof(long j2) {
        this.randomAccessByteReads = j2;
    }

    public final long getRandomAccessReadCount() {
        return this.randomAccessReadCount;
    }

    public final void setRandomAccessReadCount$shark_hprof(long j2) {
        this.randomAccessReadCount = j2;
    }

    public final long getRandomAccessByteTravel() {
        return this.randomAccessByteTravel;
    }

    public final void setRandomAccessByteTravel$shark_hprof(long j2) {
        this.randomAccessByteTravel = j2;
    }

    /* access modifiers changed from: private */
    public final void updateRandomAccessStatsOnRead(long position, long bytesRead) {
        this.randomAccessByteReads += bytesRead;
        this.randomAccessReadCount++;
        long j2 = this.lastRandomAccessPosition;
        if (j2 != -1) {
            this.randomAccessByteTravel += Math.abs(position - j2);
            this.minPosition = RangesKt.coerceAtMost(this.minPosition, position);
            this.maxPosition = RangesKt.coerceAtLeast(this.maxPosition, position);
        } else {
            this.minPosition = position;
            this.maxPosition = position;
        }
        this.lastRandomAccessPosition = position;
    }

    public final long getByteTravelRange() {
        return this.maxPosition - this.minPosition;
    }

    public BufferedSource openStreamingSource() {
        return this.realSourceProvider.openStreamingSource();
    }

    public RandomAccessSource openRandomAccessSource() {
        return new ConstantMemoryMetricsDualSourceProvider$openRandomAccessSource$1(this, this.realSourceProvider.openRandomAccessSource());
    }
}
