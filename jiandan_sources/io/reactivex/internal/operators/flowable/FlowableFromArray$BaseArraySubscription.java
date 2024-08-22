package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import th.de.p039if.ad.qw;

public abstract class FlowableFromArray$BaseArraySubscription<T> extends BasicQueueSubscription<T> {
    public static final long serialVersionUID = -2252972430506210021L;
    public final T[] array;
    public volatile boolean cancelled;
    public int index;

    public FlowableFromArray$BaseArraySubscription(T[] tArr) {
        this.array = tArr;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.index = this.array.length;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        return this.index == this.array.length;
    }

    public final T poll() {
        int i2 = this.index;
        T[] tArr = this.array;
        if (i2 == tArr.length) {
            return null;
        }
        this.index = i2 + 1;
        T t = tArr[i2];
        qw.rg(t, "array element is null");
        return t;
    }

    public final void request(long j) {
        if (SubscriptionHelper.validate(j) && th.de.p039if.yj.qw.qw(this, j) == 0) {
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
}
