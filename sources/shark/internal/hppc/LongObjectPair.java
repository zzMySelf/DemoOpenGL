package shark.internal.hppc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lshark/internal/hppc/LongObjectPair;", "B", "", "first", "", "second", "(JLjava/lang/Object;)V", "getFirst", "()J", "getSecond", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(JLjava/lang/Object;)Lshark/internal/hppc/LongObjectPair;", "equals", "", "other", "hashCode", "", "toString", "", "shark-graph"}, k = 1, mv = {1, 4, 1})
/* compiled from: Tuples.kt */
public final class LongObjectPair<B> {
    private final long first;
    private final B second;

    public static /* synthetic */ LongObjectPair copy$default(LongObjectPair longObjectPair, long j2, B b2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = longObjectPair.first;
        }
        if ((i2 & 2) != 0) {
            b2 = longObjectPair.second;
        }
        return longObjectPair.copy(j2, b2);
    }

    public final long component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final LongObjectPair<B> copy(long j2, B b2) {
        return new LongObjectPair<>(j2, b2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongObjectPair)) {
            return false;
        }
        LongObjectPair longObjectPair = (LongObjectPair) obj;
        return this.first == longObjectPair.first && Intrinsics.areEqual((Object) this.second, (Object) longObjectPair.second);
    }

    public int hashCode() {
        long j2 = this.first;
        int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
        B b2 = this.second;
        return i2 + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return "LongObjectPair(first=" + this.first + ", second=" + this.second + ")";
    }

    public LongObjectPair(long first2, B second2) {
        this.first = first2;
        this.second = second2;
    }

    public final long getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }
}
