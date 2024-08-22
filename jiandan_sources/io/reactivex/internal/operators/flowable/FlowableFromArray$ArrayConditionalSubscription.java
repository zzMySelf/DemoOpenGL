package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;

public final class FlowableFromArray$ArrayConditionalSubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    public static final long serialVersionUID = 2587302975077663557L;
    public final ConditionalSubscriber<? super T> downstream;

    public FlowableFromArray$ArrayConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, T[] tArr) {
        super(tArr);
        this.downstream = conditionalSubscriber;
    }

    public void fastPath() {
        T[] tArr = this.array;
        int length = tArr.length;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
        int i2 = this.index;
        while (i2 != length) {
            if (!this.cancelled) {
                T t = tArr[i2];
                if (t == null) {
                    conditionalSubscriber.onError(new NullPointerException("array element is null"));
                    return;
                } else {
                    conditionalSubscriber.tryOnNext(t);
                    i2++;
                }
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            conditionalSubscriber.onComplete();
        }
    }

    public void slowPath(long j) {
        T[] tArr = this.array;
        int length = tArr.length;
        int i2 = this.index;
        ConditionalSubscriber<? super T> conditionalSubscriber = this.downstream;
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
                        conditionalSubscriber.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    T t = tArr[i2];
                    if (t == null) {
                        conditionalSubscriber.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    if (conditionalSubscriber.tryOnNext(t)) {
                        j2++;
                    }
                    i2++;
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
