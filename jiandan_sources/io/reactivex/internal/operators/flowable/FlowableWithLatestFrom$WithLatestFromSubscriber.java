package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.ad.qw;

public final class FlowableWithLatestFrom$WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
    public static final long serialVersionUID = -312246233408980075L;
    public final BiFunction<? super T, ? super U, ? extends R> combiner;
    public final Subscriber<? super R> downstream;
    public final AtomicReference<Subscription> other = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public FlowableWithLatestFrom$WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.downstream = subscriber;
        this.combiner = biFunction;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (!tryOnNext(t)) {
            this.upstream.get().request(1);
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
    }

    public void otherError(Throwable th2) {
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(th2);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }

    public boolean setOther(Subscription subscription) {
        return SubscriptionHelper.setOnce(this.other, subscription);
    }

    public boolean tryOnNext(T t) {
        Object obj = get();
        if (obj != null) {
            try {
                Object apply = this.combiner.apply(t, obj);
                qw.rg(apply, "The combiner returned a null value");
                this.downstream.onNext(apply);
                return true;
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }
        return false;
    }
}
