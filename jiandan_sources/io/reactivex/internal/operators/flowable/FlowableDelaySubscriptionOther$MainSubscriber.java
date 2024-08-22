package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableDelaySubscriptionOther$MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 2259811067697317255L;
    public final Subscriber<? super T> downstream;
    public final Publisher<? extends T> main;
    public final FlowableDelaySubscriptionOther$MainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        public static final long serialVersionUID = -3892798459447644106L;

        public OtherSubscriber() {
        }

        public void onComplete() {
            if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
                FlowableDelaySubscriptionOther$MainSubscriber.this.next();
            }
        }

        public void onError(Throwable th2) {
            if (((Subscription) get()) != SubscriptionHelper.CANCELLED) {
                FlowableDelaySubscriptionOther$MainSubscriber.this.downstream.onError(th2);
            } else {
                qw.ddd(th2);
            }
        }

        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                FlowableDelaySubscriptionOther$MainSubscriber.this.next();
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableDelaySubscriptionOther$MainSubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
        this.downstream = subscriber;
        this.main = publisher;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void next() {
        this.main.subscribe(this);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this, subscription);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            SubscriptionHelper.deferredRequest(this.upstream, this, j);
        }
    }
}
