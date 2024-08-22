package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableTake$TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -5636543848937116287L;
    public boolean done;
    public final Subscriber<? super T> downstream;
    public final long limit;
    public long remaining;
    public Subscription upstream;

    public FlowableTake$TakeSubscriber(Subscriber<? super T> subscriber, long j) {
        this.downstream = subscriber;
        this.limit = j;
        this.remaining = j;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (!this.done) {
            this.done = true;
            this.upstream.cancel();
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            long j = this.remaining;
            long j2 = j - 1;
            this.remaining = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.downstream.onNext(t);
                if (z) {
                    this.upstream.cancel();
                    onComplete();
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (this.limit == 0) {
                subscription.cancel();
                this.done = true;
                EmptySubscription.complete(this.downstream);
                return;
            }
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            if (get() || !compareAndSet(false, true) || j < this.limit) {
                this.upstream.request(j);
            } else {
                this.upstream.request(Long.MAX_VALUE);
            }
        }
    }
}
