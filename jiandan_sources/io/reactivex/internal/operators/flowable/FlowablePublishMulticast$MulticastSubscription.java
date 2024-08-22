package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.i;
import th.de.p039if.yj.qw;

public final class FlowablePublishMulticast$MulticastSubscription<T> extends AtomicLong implements Subscription {
    public static final long serialVersionUID = 8664815189257569791L;
    public final Subscriber<? super T> downstream;
    public long emitted;
    public final i<T> parent;

    public FlowablePublishMulticast$MulticastSubscription(Subscriber<? super T> subscriber, i<T> iVar) {
        this.downstream = subscriber;
        this.parent = iVar;
    }

    public void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.i(this);
            this.parent.uk();
        }
    }

    public boolean isCancelled() {
        return get() == Long.MIN_VALUE;
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.ad(this, j);
            this.parent.uk();
        }
    }
}
