package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Producer;

public final class OperatorBufferWithSize$BufferOverlap<T> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final de<? super List<T>> f11414ad;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f11415i;

    /* renamed from: th  reason: collision with root package name */
    public final int f11416th;

    /* renamed from: uk  reason: collision with root package name */
    public final ArrayDeque<List<T>> f11417uk;

    /* renamed from: yj  reason: collision with root package name */
    public final int f11418yj;

    public final class BufferOverlapProducer extends AtomicBoolean implements Producer {
        public static final long serialVersionUID = -4015894850868853147L;

        public BufferOverlapProducer() {
        }

        public void request(long j) {
            OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = OperatorBufferWithSize$BufferOverlap.this;
            if (qw.rg(operatorBufferWithSize$BufferOverlap.f11415i, j, operatorBufferWithSize$BufferOverlap.f11417uk, operatorBufferWithSize$BufferOverlap.f11414ad) && j != 0) {
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferOverlap.request(qw.de((long) operatorBufferWithSize$BufferOverlap.f11418yj, j));
                } else {
                    operatorBufferWithSize$BufferOverlap.request(qw.qw(qw.de((long) operatorBufferWithSize$BufferOverlap.f11418yj, j - 1), (long) operatorBufferWithSize$BufferOverlap.f11416th));
                }
            }
        }
    }
}
