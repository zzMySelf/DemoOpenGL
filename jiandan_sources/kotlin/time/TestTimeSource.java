package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SinceKotlin(version = "1.3")
@ExperimentalTime
public final class TestTimeSource extends AbstractLongTimeSource {
    public long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m646overflowLRDsOJo(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m568toStringimpl(j) + '.');
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m647plusAssignLRDsOJo(long j) {
        long j2;
        long r0 = Duration.m565toLongimpl(j, getUnit());
        if (r0 == Long.MIN_VALUE || r0 == Long.MAX_VALUE) {
            double r2 = ((double) this.reading) + Duration.m562toDoubleimpl(j, getUnit());
            if (r2 > 9.223372036854776E18d || r2 < -9.223372036854776E18d) {
                m646overflowLRDsOJo(j);
            }
            j2 = (long) r2;
        } else {
            long j3 = this.reading;
            j2 = j3 + r0;
            if ((r0 ^ j3) >= 0 && (j3 ^ j2) < 0) {
                m646overflowLRDsOJo(j);
            }
        }
        this.reading = j2;
    }

    public long read() {
        return this.reading;
    }
}
