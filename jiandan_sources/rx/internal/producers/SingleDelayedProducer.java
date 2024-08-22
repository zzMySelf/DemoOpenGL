package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import p041if.de;
import p041if.fe.qw;
import rx.Producer;

public final class SingleDelayedProducer<T> extends AtomicInteger implements Producer {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public final de<? super T> child;
    public T value;

    public SingleDelayedProducer(de<? super T> deVar) {
        this.child = deVar;
    }

    public static <T> void emit(de<? super T> deVar, T t) {
        if (!deVar.isUnsubscribed()) {
            try {
                deVar.onNext(t);
                if (!deVar.isUnsubscribed()) {
                    deVar.onCompleted();
                }
            } catch (Throwable th2) {
                qw.yj(th2, deVar, t);
            }
        }
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i2 != 0) {
            do {
                int i3 = get();
                if (i3 != 0) {
                    if (i3 == 1 && compareAndSet(1, 3)) {
                        emit(this.child, this.value);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public void setValue(T t) {
        do {
            int i2 = get();
            if (i2 == 0) {
                this.value = t;
            } else if (i2 == 2 && compareAndSet(2, 3)) {
                emit(this.child, t);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
