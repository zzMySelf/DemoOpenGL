package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;

public final class FlowableRangeLong$RangeConditionalSubscription extends FlowableRangeLong$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final ConditionalSubscriber<? super Long> downstream;

    public FlowableRangeLong$RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j, long j2) {
        super(j, j2);
        this.downstream = conditionalSubscriber;
    }

    public void fastPath() {
        long j = this.end;
        ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
        long j2 = this.index;
        while (j2 != j) {
            if (!this.cancelled) {
                conditionalSubscriber.tryOnNext(Long.valueOf(j2));
                j2++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            conditionalSubscriber.onComplete();
        }
    }

    public void slowPath(long j) {
        long j2 = this.end;
        long j3 = this.index;
        ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
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
                        conditionalSubscriber.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    if (conditionalSubscriber.tryOnNext(Long.valueOf(j3))) {
                        j4++;
                    }
                    j3++;
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
