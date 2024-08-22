package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.rg;

public final class FlowableTakeUntil$TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -4945480365982832967L;
    public final Subscriber<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final FlowableTakeUntil$TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        public static final long serialVersionUID = -3592821756711087922L;

        public OtherSubscriber() {
        }

        public void onComplete() {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            rg.ad(flowableTakeUntil$TakeUntilMainSubscriber.downstream, flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.upstream);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            rg.fe(flowableTakeUntil$TakeUntilMainSubscriber.downstream, th2, flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        public void onNext(Object obj) {
            SubscriptionHelper.cancel(this);
            onComplete();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableTakeUntil$TakeUntilMainSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        rg.ad(this.downstream, this, this.error);
    }

    public void onError(Throwable th2) {
        SubscriptionHelper.cancel(this.other);
        rg.fe(this.downstream, th2, this, this.error);
    }

    public void onNext(T t) {
        rg.th(this.downstream, t, this, this.error);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }
}
