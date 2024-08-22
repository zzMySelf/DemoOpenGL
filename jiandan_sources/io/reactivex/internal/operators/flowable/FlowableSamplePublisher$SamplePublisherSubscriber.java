package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.pf;
import th.de.p039if.yj.qw;

public abstract class FlowableSamplePublisher$SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -3517602651313910099L;
    public final Subscriber<? super T> downstream;
    public final AtomicReference<Subscription> other = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final Publisher<?> sampler;
    public Subscription upstream;

    public FlowableSamplePublisher$SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
        this.downstream = subscriber;
        this.sampler = publisher;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.upstream.cancel();
    }

    public void complete() {
        this.upstream.cancel();
        completeOther();
    }

    public abstract void completeMain();

    public abstract void completeOther();

    public void emit() {
        Object andSet = getAndSet((Object) null);
        if (andSet == null) {
            return;
        }
        if (this.requested.get() != 0) {
            this.downstream.onNext(andSet);
            qw.rg(this.requested, 1);
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
    }

    public void error(Throwable th2) {
        this.upstream.cancel();
        this.downstream.onError(th2);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        completeMain();
    }

    public void onError(Throwable th2) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        lazySet(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            if (this.other.get() == null) {
                this.sampler.subscribe(new pf(this));
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this.requested, j);
        }
    }

    public abstract void run();

    public void setOther(Subscription subscription) {
        SubscriptionHelper.setOnce(this.other, subscription, Long.MAX_VALUE);
    }
}
