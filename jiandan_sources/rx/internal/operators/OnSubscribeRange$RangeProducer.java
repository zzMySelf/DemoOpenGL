package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p041if.de;
import p041if.rg.qw.qw;
import rx.Producer;

public final class OnSubscribeRange$RangeProducer extends AtomicLong implements Producer {
    public static final long serialVersionUID = 4114392207069098388L;
    public final de<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(de<? super Integer> deVar, int i2, int i3) {
        this.childSubscriber = deVar;
        this.currentIndex = (long) i2;
        this.endOfRange = i3;
    }

    public void fastPath() {
        long j = ((long) this.endOfRange) + 1;
        de<? super Integer> deVar = this.childSubscriber;
        long j2 = this.currentIndex;
        while (j2 != j) {
            if (!deVar.isUnsubscribed()) {
                deVar.onNext(Integer.valueOf((int) j2));
                j2++;
            } else {
                return;
            }
        }
        if (!deVar.isUnsubscribed()) {
            deVar.onCompleted();
        }
    }

    public void request(long j) {
        if (get() != Long.MAX_VALUE) {
            if (j == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && qw.ad(this, j) == 0) {
                slowPath(j);
            }
        }
    }

    public void slowPath(long j) {
        long j2 = ((long) this.endOfRange) + 1;
        long j3 = this.currentIndex;
        de<? super Integer> deVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 == j || j3 == j2) {
                    if (!deVar.isUnsubscribed()) {
                        if (j3 == j2) {
                            deVar.onCompleted();
                            return;
                        }
                        j = get();
                        if (j == j4) {
                            this.currentIndex = j3;
                            j = addAndGet(-j4);
                        }
                    } else {
                        return;
                    }
                } else if (!deVar.isUnsubscribed()) {
                    deVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
