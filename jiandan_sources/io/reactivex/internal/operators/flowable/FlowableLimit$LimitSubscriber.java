package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableLimit$LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 2288246011222124525L;
    public final Subscriber<? super T> downstream;
    public long remaining;
    public Subscription upstream;

    public FlowableLimit$LimitSubscriber(Subscriber<? super T> subscriber, long j) {
        this.downstream = subscriber;
        this.remaining = j;
        lazySet(j);
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.remaining > 0) {
            this.remaining = 0;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.remaining > 0) {
            this.remaining = 0;
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        long j = this.remaining;
        if (j > 0) {
            long j2 = j - 1;
            this.remaining = j2;
            this.downstream.onNext(t);
            if (j2 == 0) {
                this.upstream.cancel();
                this.downstream.onComplete();
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate(this.upstream, subscription)) {
            return;
        }
        if (this.remaining == 0) {
            subscription.cancel();
            EmptySubscription.complete(this.downstream);
            return;
        }
        this.upstream = subscription;
        this.downstream.onSubscribe(this);
    }

    public void request(long j) {
        long j2;
        long j3;
        if (SubscriptionHelper.validate(j)) {
            do {
                j2 = get();
                if (j2 != 0) {
                    j3 = j2 <= j ? j2 : j;
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j2 - j3));
            this.upstream.request(j3);
        }
    }
}
