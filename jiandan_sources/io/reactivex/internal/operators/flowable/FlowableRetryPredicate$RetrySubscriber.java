package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.o.qw;

public final class FlowableRetryPredicate$RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final Subscriber<? super T> downstream;
    public final Predicate<? super Throwable> predicate;
    public long produced;
    public long remaining;
    public final SubscriptionArbiter sa;
    public final Publisher<? extends T> source;

    public FlowableRetryPredicate$RetrySubscriber(Subscriber<? super T> subscriber, long j, Predicate<? super Throwable> predicate2, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.sa = subscriptionArbiter;
        this.source = publisher;
        this.predicate = predicate2;
        this.remaining = j;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        long j = this.remaining;
        if (j != Long.MAX_VALUE) {
            this.remaining = j - 1;
        }
        if (j == 0) {
            this.downstream.onError(th2);
            return;
        }
        try {
            if (!this.predicate.test(th2)) {
                this.downstream.onError(th2);
            } else {
                subscribeNext();
            }
        } catch (Throwable th3) {
            qw.ad(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t) {
        this.produced++;
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        this.sa.setSubscription(subscription);
    }

    public void subscribeNext() {
        if (getAndIncrement() == 0) {
            int i2 = 1;
            while (!this.sa.isCancelled()) {
                long j = this.produced;
                if (j != 0) {
                    this.produced = 0;
                    this.sa.produced(j);
                }
                this.source.subscribe(this);
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }
}
