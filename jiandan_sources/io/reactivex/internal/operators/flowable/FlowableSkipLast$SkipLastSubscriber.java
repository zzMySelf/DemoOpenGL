package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast$SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -3807491841935125653L;
    public final Subscriber<? super T> downstream;
    public final int skip;
    public Subscription upstream;

    public FlowableSkipLast$SkipLastSubscriber(Subscriber<? super T> subscriber, int i2) {
        super(i2);
        this.downstream = subscriber;
        this.skip = i2;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (this.skip == size()) {
            this.downstream.onNext(poll());
        } else {
            this.upstream.request(1);
        }
        offer(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        this.upstream.request(j);
    }
}
