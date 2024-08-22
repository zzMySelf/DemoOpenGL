package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import p041if.de;
import p041if.fe.qw;
import p041if.o.ad;
import rx.Observable;
import rx.Observer;

public final class ReplaySubject$ReplayState<T> extends AtomicReference<ReplaySubject$ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
    public static final ReplaySubject$ReplayProducer[] EMPTY = new ReplaySubject$ReplayProducer[0];
    public static final ReplaySubject$ReplayProducer[] TERMINATED = new ReplaySubject$ReplayProducer[0];
    public static final long serialVersionUID = 5952362471246910544L;
    public final ad<T> buffer;

    public ReplaySubject$ReplayState(ad<T> adVar) {
        this.buffer = adVar;
        lazySet(EMPTY);
    }

    public boolean add(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer) {
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr;
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr2;
        do {
            replaySubject$ReplayProducerArr = (ReplaySubject$ReplayProducer[]) get();
            if (replaySubject$ReplayProducerArr == TERMINATED) {
                return false;
            }
            int length = replaySubject$ReplayProducerArr.length;
            replaySubject$ReplayProducerArr2 = new ReplaySubject$ReplayProducer[(length + 1)];
            System.arraycopy(replaySubject$ReplayProducerArr, 0, replaySubject$ReplayProducerArr2, 0, length);
            replaySubject$ReplayProducerArr2[length] = replaySubject$ReplayProducer;
        } while (!compareAndSet(replaySubject$ReplayProducerArr, replaySubject$ReplayProducerArr2));
        return true;
    }

    public boolean isTerminated() {
        return get() == TERMINATED;
    }

    public void onCompleted() {
        ad<T> adVar = this.buffer;
        adVar.complete();
        for (ReplaySubject$ReplayProducer qw : (ReplaySubject$ReplayProducer[]) getAndSet(TERMINATED)) {
            adVar.qw(qw);
        }
    }

    public void onError(Throwable th2) {
        ad<T> adVar = this.buffer;
        adVar.error(th2);
        ArrayList arrayList = null;
        for (ReplaySubject$ReplayProducer qw : (ReplaySubject$ReplayProducer[]) getAndSet(TERMINATED)) {
            try {
                adVar.qw(qw);
            } catch (Throwable th3) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th3);
            }
        }
        qw.fe(arrayList);
    }

    public void onNext(T t) {
        ad<T> adVar = this.buffer;
        adVar.next(t);
        for (ReplaySubject$ReplayProducer qw : (ReplaySubject$ReplayProducer[]) get()) {
            adVar.qw(qw);
        }
    }

    public void remove(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer) {
        ReplaySubject$ReplayProducer<T>[] replaySubject$ReplayProducerArr;
        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr2;
        do {
            replaySubject$ReplayProducerArr = (ReplaySubject$ReplayProducer[]) get();
            if (replaySubject$ReplayProducerArr != TERMINATED && replaySubject$ReplayProducerArr != EMPTY) {
                int length = replaySubject$ReplayProducerArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (replaySubject$ReplayProducerArr[i3] == replaySubject$ReplayProducer) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        replaySubject$ReplayProducerArr2 = EMPTY;
                    } else {
                        ReplaySubject$ReplayProducer[] replaySubject$ReplayProducerArr3 = new ReplaySubject$ReplayProducer[(length - 1)];
                        System.arraycopy(replaySubject$ReplayProducerArr, 0, replaySubject$ReplayProducerArr3, 0, i2);
                        System.arraycopy(replaySubject$ReplayProducerArr, i2 + 1, replaySubject$ReplayProducerArr3, i2, (length - i2) - 1);
                        replaySubject$ReplayProducerArr2 = replaySubject$ReplayProducerArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(replaySubject$ReplayProducerArr, replaySubject$ReplayProducerArr2));
    }

    public void call(de<? super T> deVar) {
        ReplaySubject$ReplayProducer replaySubject$ReplayProducer = new ReplaySubject$ReplayProducer(deVar, this);
        deVar.add(replaySubject$ReplayProducer);
        deVar.setProducer(replaySubject$ReplayProducer);
        if (!add(replaySubject$ReplayProducer) || !replaySubject$ReplayProducer.isUnsubscribed()) {
            this.buffer.qw(replaySubject$ReplayProducer);
        } else {
            remove(replaySubject$ReplayProducer);
        }
    }
}
