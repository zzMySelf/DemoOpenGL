package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

public class OperatorElementAt$InnerProducer extends AtomicBoolean implements Producer {
    public static final long serialVersionUID = 1;
    public final Producer actual;

    public OperatorElementAt$InnerProducer(Producer producer) {
        this.actual = producer;
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i2 > 0 && compareAndSet(false, true)) {
            this.actual.request(Long.MAX_VALUE);
        }
    }
}
