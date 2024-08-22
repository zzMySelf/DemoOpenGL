package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.ad;
import th.de.ppp.qw;

public final class FlowableAmb$AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -1185974347409665484L;
    public final Subscriber<? super T> downstream;
    public final int index;
    public final AtomicLong missedRequested = new AtomicLong();
    public final ad<T> parent;
    public boolean won;

    public FlowableAmb$AmbInnerSubscriber(ad<T> adVar, int i2, Subscriber<? super T> subscriber) {
        this.parent = adVar;
        this.index = i2;
        this.downstream = subscriber;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        if (this.won) {
            this.downstream.onComplete();
        } else if (this.parent.qw(this.index)) {
            this.won = true;
            this.downstream.onComplete();
        } else {
            ((Subscription) get()).cancel();
        }
    }

    public void onError(Throwable th2) {
        if (this.won) {
            this.downstream.onError(th2);
        } else if (this.parent.qw(this.index)) {
            this.won = true;
            this.downstream.onError(th2);
        } else {
            ((Subscription) get()).cancel();
            qw.ddd(th2);
        }
    }

    public void onNext(T t) {
        if (this.won) {
            this.downstream.onNext(t);
        } else if (this.parent.qw(this.index)) {
            this.won = true;
            this.downstream.onNext(t);
        } else {
            ((Subscription) get()).cancel();
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this, this.missedRequested, subscription);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this, this.missedRequested, j);
    }
}
