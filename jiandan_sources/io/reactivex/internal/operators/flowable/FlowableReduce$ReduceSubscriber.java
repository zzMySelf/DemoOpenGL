package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableReduce$ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -4663883003264602070L;
    public final BiFunction<T, T, T> reducer;
    public Subscription upstream;

    public FlowableReduce$ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
        super(subscriber);
        this.reducer = biFunction;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
        this.upstream = SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        Subscription subscription = this.upstream;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            this.upstream = subscriptionHelper;
            T t = this.value;
            if (t != null) {
                complete(t);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        Subscription subscription = this.upstream;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription == subscriptionHelper) {
            qw.ddd(th2);
            return;
        }
        this.upstream = subscriptionHelper;
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (this.upstream != SubscriptionHelper.CANCELLED) {
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                T apply = this.reducer.apply(t2, t);
                th.de.p039if.ad.qw.rg(apply, "The reducer returned a null value");
                this.value = apply;
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
