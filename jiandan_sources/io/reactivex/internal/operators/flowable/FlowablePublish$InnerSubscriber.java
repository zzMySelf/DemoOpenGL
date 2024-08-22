package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;

public final class FlowablePublish$InnerSubscriber<T> extends AtomicLong implements Subscription {
    public static final long serialVersionUID = -4453897557930727610L;
    public final Subscriber<? super T> child;
    public long emitted;
    public volatile FlowablePublish$PublishSubscriber<T> parent;

    public FlowablePublish$InnerSubscriber(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    public void cancel() {
        FlowablePublish$PublishSubscriber<T> flowablePublish$PublishSubscriber;
        if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE && (flowablePublish$PublishSubscriber = this.parent) != null) {
            flowablePublish$PublishSubscriber.remove(this);
            flowablePublish$PublishSubscriber.dispatch();
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.ad(this, j);
            FlowablePublish$PublishSubscriber<T> flowablePublish$PublishSubscriber = this.parent;
            if (flowablePublish$PublishSubscriber != null) {
                flowablePublish$PublishSubscriber.dispatch();
            }
        }
    }
}
