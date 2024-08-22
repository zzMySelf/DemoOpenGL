package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Producer;

public final class OperatorBufferWithSize$BufferSkip<T> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final int f11419ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f11420th;

    public final class BufferSkipProducer extends AtomicBoolean implements Producer {
        public static final long serialVersionUID = 3428177408082367154L;

        public BufferSkipProducer() {
        }

        public void request(long j) {
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i2 != 0) {
                OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = OperatorBufferWithSize$BufferSkip.this;
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferSkip.request(qw.de(j, (long) operatorBufferWithSize$BufferSkip.f11420th));
                } else {
                    operatorBufferWithSize$BufferSkip.request(qw.qw(qw.de(j, (long) operatorBufferWithSize$BufferSkip.f11419ad), qw.de((long) (operatorBufferWithSize$BufferSkip.f11420th - operatorBufferWithSize$BufferSkip.f11419ad), j - 1)));
                }
            }
        }
    }
}
