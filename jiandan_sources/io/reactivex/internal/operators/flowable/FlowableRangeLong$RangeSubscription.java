package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;

public final class FlowableRangeLong$RangeSubscription extends FlowableRangeLong$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final Subscriber<? super Long> downstream;

    public FlowableRangeLong$RangeSubscription(Subscriber<? super Long> subscriber, long j, long j2) {
        super(j, j2);
        this.downstream = subscriber;
    }

    public void fastPath() {
        long j = this.end;
        Subscriber<? super Long> subscriber = this.downstream;
        long j2 = this.index;
        while (j2 != j) {
            if (!this.cancelled) {
                subscriber.onNext(Long.valueOf(j2));
                j2++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            subscriber.onComplete();
        }
    }

    public void slowPath(long j) {
        long j2 = this.end;
        long j3 = this.index;
        Subscriber<? super Long> subscriber = this.downstream;
        do {
            long j4 = 0;
            while (true) {
                if (j4 == j || j3 == j2) {
                    if (j3 != j2) {
                        j = get();
                        if (j4 == j) {
                            this.index = j3;
                            j = addAndGet(-j4);
                        }
                    } else if (!this.cancelled) {
                        subscriber.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    subscriber.onNext(Long.valueOf(j3));
                    j4++;
                    j3++;
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
