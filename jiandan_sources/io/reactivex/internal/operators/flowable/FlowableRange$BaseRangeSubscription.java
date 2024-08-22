package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import th.de.p039if.yj.qw;

public abstract class FlowableRange$BaseRangeSubscription extends BasicQueueSubscription<Integer> {
    public static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final int end;
    public int index;

    public FlowableRange$BaseRangeSubscription(int i2, int i3) {
        this.index = i2;
        this.end = i3;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.index = this.end;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        return this.index == this.end;
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && qw.qw(this, j) == 0) {
            if (j == Long.MAX_VALUE) {
                fastPath();
            } else {
                slowPath(j);
            }
        }
    }

    public final int requestFusion(int i2) {
        return i2 & 1;
    }

    public abstract void slowPath(long j);

    public final Integer poll() {
        int i2 = this.index;
        if (i2 == this.end) {
            return null;
        }
        this.index = i2 + 1;
        return Integer.valueOf(i2);
    }
}
