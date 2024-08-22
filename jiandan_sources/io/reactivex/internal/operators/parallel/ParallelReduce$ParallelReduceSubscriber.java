package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class ParallelReduce$ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    public static final long serialVersionUID = 8200530050639449080L;
    public R accumulator;
    public boolean done;
    public final BiFunction<R, ? super T, R> reducer;

    public ParallelReduce$ParallelReduceSubscriber(Subscriber<? super R> subscriber, R r, BiFunction<R, ? super T, R> biFunction) {
        super(subscriber);
        this.accumulator = r;
        this.reducer = biFunction;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            R r = this.accumulator;
            this.accumulator = null;
            complete(r);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            try {
                R apply = this.reducer.apply(this.accumulator, t);
                th.de.p039if.ad.qw.rg(apply, "The reducer returned a null value");
                this.accumulator = apply;
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                cancel();
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
