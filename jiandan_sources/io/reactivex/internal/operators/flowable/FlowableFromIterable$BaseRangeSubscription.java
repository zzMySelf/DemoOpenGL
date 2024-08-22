package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import th.de.p039if.ad.qw;

public abstract class FlowableFromIterable$BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
    public static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public Iterator<? extends T> it;
    public boolean once;

    public FlowableFromIterable$BaseRangeSubscription(Iterator<? extends T> it2) {
        this.it = it2;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.it = null;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        Iterator<? extends T> it2 = this.it;
        return it2 == null || !it2.hasNext();
    }

    public final T poll() {
        Iterator<? extends T> it2 = this.it;
        if (it2 == null) {
            return null;
        }
        if (!this.once) {
            this.once = true;
        } else if (!it2.hasNext()) {
            return null;
        }
        T next = this.it.next();
        qw.rg(next, "Iterator.next() returned a null value");
        return next;
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
