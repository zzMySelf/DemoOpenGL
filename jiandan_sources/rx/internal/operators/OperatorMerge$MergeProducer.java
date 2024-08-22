package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.rg.qw.qw;
import p041if.rg.qw.when;
import rx.Producer;

public final class OperatorMerge$MergeProducer<T> extends AtomicLong implements Producer {
    public static final long serialVersionUID = -1214379189873595503L;
    public final when<T> subscriber;

    public OperatorMerge$MergeProducer(when<T> when) {
        this.subscriber = when;
    }

    public long produced(int i2) {
        return addAndGet((long) (-i2));
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 > 0) {
            if (get() != Long.MAX_VALUE) {
                qw.ad(this, j);
                this.subscriber.de();
            }
        } else if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
