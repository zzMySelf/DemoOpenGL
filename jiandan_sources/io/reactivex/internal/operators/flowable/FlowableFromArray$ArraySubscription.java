package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

public final class FlowableFromArray$ArraySubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    public static final long serialVersionUID = 2587302975077663557L;
    public final Subscriber<? super T> downstream;

    public FlowableFromArray$ArraySubscription(Subscriber<? super T> subscriber, T[] tArr) {
        super(tArr);
        this.downstream = subscriber;
    }

    public void fastPath() {
        T[] tArr = this.array;
        int length = tArr.length;
        Subscriber<? super T> subscriber = this.downstream;
        int i2 = this.index;
        while (i2 != length) {
            if (!this.cancelled) {
                T t = tArr[i2];
                if (t == null) {
                    subscriber.onError(new NullPointerException("array element is null"));
                    return;
                } else {
                    subscriber.onNext(t);
                    i2++;
                }
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            subscriber.onComplete();
        }
    }

    public void slowPath(long j) {
        T[] tArr = this.array;
        int length = tArr.length;
        int i2 = this.index;
        Subscriber<? super T> subscriber = this.downstream;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i2 == length) {
                    if (i2 != length) {
                        j = get();
                        if (j2 == j) {
                            this.index = i2;
                            j = addAndGet(-j2);
                        }
                    } else if (!this.cancelled) {
                        subscriber.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    T t = tArr[i2];
                    if (t == null) {
                        subscriber.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    subscriber.onNext(t);
                    j2++;
                    i2++;
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
