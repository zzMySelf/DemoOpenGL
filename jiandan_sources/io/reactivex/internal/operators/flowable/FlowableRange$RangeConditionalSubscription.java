package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.fuseable.ConditionalSubscriber;

public final class FlowableRange$RangeConditionalSubscription extends FlowableRange$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final ConditionalSubscriber<? super Integer> downstream;

    public FlowableRange$RangeConditionalSubscription(ConditionalSubscriber<? super Integer> conditionalSubscriber, int i2, int i3) {
        super(i2, i3);
        this.downstream = conditionalSubscriber;
    }

    public void fastPath() {
        int i2 = this.end;
        ConditionalSubscriber<? super Integer> conditionalSubscriber = this.downstream;
        int i3 = this.index;
        while (i3 != i2) {
            if (!this.cancelled) {
                conditionalSubscriber.tryOnNext(Integer.valueOf(i3));
                i3++;
            } else {
                return;
            }
        }
        if (!this.cancelled) {
            conditionalSubscriber.onComplete();
        }
    }

    public void slowPath(long j) {
        int i2 = this.end;
        int i3 = this.index;
        ConditionalSubscriber<? super Integer> conditionalSubscriber = this.downstream;
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
                        conditionalSubscriber.onComplete();
                        return;
                    } else {
                        return;
                    }
                } else if (!this.cancelled) {
                    if (conditionalSubscriber.tryOnNext(Integer.valueOf(i3))) {
                        j2++;
                    }
                    i3++;
                } else {
                    return;
                }
            }
        } while (j != 0);
    }
}
