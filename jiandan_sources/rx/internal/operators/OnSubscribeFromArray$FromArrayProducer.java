package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Producer;

public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements Producer {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final de<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(de<? super T> deVar, T[] tArr) {
        this.child = deVar;
        this.array = tArr;
    }

    public void fastPath() {
        de<? super T> deVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i2 = 0;
        while (i2 < length) {
            T t = tArr[i2];
            if (!deVar.isUnsubscribed()) {
                deVar.onNext(t);
                i2++;
            } else {
                return;
            }
        }
        if (!deVar.isUnsubscribed()) {
            deVar.onCompleted();
        }
    }

    public void request(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        } else if (j == Long.MAX_VALUE) {
            if (qw.ad(this, j) == 0) {
                fastPath();
            }
        } else if (i2 != 0 && qw.ad(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        de<? super T> deVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i2 = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (r11 == 0 || i2 == length) {
                    r11 = get() + j2;
                    if (r11 == 0) {
                        this.index = i2;
                        j = addAndGet(j2);
                    }
                } else if (!deVar.isUnsubscribed()) {
                    deVar.onNext(tArr[i2]);
                    i2++;
                    if (i2 != length) {
                        r11--;
                        j2--;
                    } else if (!deVar.isUnsubscribed()) {
                        deVar.onCompleted();
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
