package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

public final class FlowableRange$RangeSubscription extends FlowableRange$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final Subscriber<? super Integer> downstream;

    public FlowableRange$RangeSubscription(Subscriber<? super Integer> subscriber, int i2, int i3) {
        super(i2, i3);
        this.downstream = subscriber;
    }

    public void fastPath() {
        int i2 = this.end;
        Subscriber<? super Integer> subscriber = this.downstream;
        int i3 = this.index;
        while (i3 != i2) {
            if (!this.cancelled) {
                subscriber.onNext(Integer.valueOf(i3));
                i3++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            subscriber.onComplete();
        }
    }

    public void slowPath(long j) {
        int i2 = this.end;
        int i3 = this.index;
        Subscriber<? super Integer> subscriber = this.downstream;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i3 == i2) {
                    if (i3 != i2) {
                        j = get();
                        if (j2 == j) {
                            this.index = i3;
                            j = addAndGet(-j2);
                        }
                    } else if (!this.cancelled) {
                        subscriber.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    subscriber.onNext(Integer.valueOf(i3));
                    j2++;
                    i3++;
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
