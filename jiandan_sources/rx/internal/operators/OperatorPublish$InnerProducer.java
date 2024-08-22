package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.xxx;
import rx.Producer;
import rx.Subscription;

public final class OperatorPublish$InnerProducer<T> extends AtomicLong implements Producer, Subscription {
    public static final long NOT_REQUESTED = -4611686018427387904L;
    public static final long UNSUBSCRIBED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public final de<? super T> child;
    public final xxx<T> parent;

    public OperatorPublish$InnerProducer(xxx<T> xxx, de<? super T> deVar) {
        this.parent = xxx;
        this.child = deVar;
        lazySet(-4611686018427387904L);
    }

    public boolean isUnsubscribed() {
        return get() == Long.MIN_VALUE;
    }

    public long produced(long j) {
        long j2;
        long j3;
        if (j > 0) {
            do {
                j2 = get();
                if (j2 == -4611686018427387904L) {
                    throw new IllegalStateException("Produced without request");
                } else if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                } else {
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                    }
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }
        throw new IllegalArgumentException("Cant produce zero or less");
    }

    public void request(long j) {
        long j2;
        long j3;
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 >= 0) {
            do {
                j2 = get();
                if (j2 != Long.MIN_VALUE) {
                    if (j2 >= 0 && i2 == 0) {
                        return;
                    }
                    if (j2 == -4611686018427387904L) {
                        j3 = j;
                    } else {
                        j3 = j2 + j;
                        if (j3 < 0) {
                            j3 = Long.MAX_VALUE;
                        }
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j3));
            this.parent.de();
        }
    }

    public void unsubscribe() {
        if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.fe(this);
            this.parent.de();
        }
    }
}
