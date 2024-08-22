package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.o.qw;

public final class FlowableRepeatUntil$RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -7098360935104053232L;
    public final Subscriber<? super T> downstream;
    public long produced;
    public final SubscriptionArbiter sa;
    public final Publisher<? extends T> source;
    public final BooleanSupplier stop;

    public FlowableRepeatUntil$RepeatSubscriber(Subscriber<? super T> subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.sa = subscriptionArbiter;
        this.source = publisher;
        this.stop = booleanSupplier;
    }

    public void onComplete() {
        try {
            if (this.stop.getAsBoolean()) {
                this.downstream.onComplete();
            } else {
                subscribeNext();
            }
        } catch (Throwable th2) {
            qw.ad(th2);
            this.downstream.onError(th2);
        }
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
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
