package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.o.qw;

public final class FlowableRetryBiPredicate$RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final Subscriber<? super T> downstream;
    public final BiPredicate<? super Integer, ? super Throwable> predicate;
    public long produced;
    public int retries;
    public final SubscriptionArbiter sa;
    public final Publisher<? extends T> source;

    public FlowableRetryBiPredicate$RetryBiSubscriber(Subscriber<? super T> subscriber, BiPredicate<? super Integer, ? super Throwable> biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.sa = subscriptionArbiter;
        this.source = publisher;
        this.predicate = biPredicate;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        try {
            BiPredicate<? super Integer, ? super Throwable> biPredicate = this.predicate;
            int i2 = this.retries + 1;
            this.retries = i2;
            if (!biPredicate.qw(Integer.valueOf(i2), th2)) {
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
