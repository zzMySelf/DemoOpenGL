package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import p041if.de;
import p041if.fe.qw;
import rx.Producer;

public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    public static final long serialVersionUID = -3353584923995471404L;
    public final de<? super T> child;
    public final T value;

    public SingleProducer(de<? super T> deVar, T t) {
        this.child = deVar;
        this.value = t;
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i2 != 0 && compareAndSet(false, true)) {
            de<? super T> deVar = this.child;
            if (!deVar.isUnsubscribed()) {
                T t = this.value;
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
    }
}
