package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;

public final class FlowableReplay$InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
    public static final long CANCELLED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public final Subscriber<? super T> child;
    public boolean emitting;
    public Object index;
    public boolean missed;
    public final FlowableReplay$ReplaySubscriber<T> parent;
    public final AtomicLong totalRequested = new AtomicLong();

    public FlowableReplay$InnerSubscription(FlowableReplay$ReplaySubscriber<T> flowableReplay$ReplaySubscriber, Subscriber<? super T> subscriber) {
        this.parent = flowableReplay$ReplaySubscriber;
        this.child = subscriber;
    }

    public void cancel() {
        dispose();
    }

    public void dispose() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.remove(this);
            this.parent.manageRequests();
            this.index = null;
        }
    }

    public <U> U index() {
        return this.index;
    }

    public boolean isDisposed() {
        return get() == Long.MIN_VALUE;
    }

    public long produced(long j) {
        return qw.th(this, j);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j) && qw.ad(this, j) != Long.MIN_VALUE) {
            qw.qw(this.totalRequested, j);
            this.parent.manageRequests();
            this.parent.buffer.replay(this);
        }
    }
}
