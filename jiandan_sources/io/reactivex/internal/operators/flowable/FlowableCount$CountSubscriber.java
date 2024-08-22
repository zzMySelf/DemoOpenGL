package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCount$CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
    public static final long serialVersionUID = 4973004223787171406L;
    public long count;
    public Subscription upstream;

    public FlowableCount$CountSubscriber(Subscriber<? super Long> subscriber) {
        super(subscriber);
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        complete(Long.valueOf(this.count));
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(Object obj) {
        this.count++;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
