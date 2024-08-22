package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.ad.qw;

public final class FlowableOnErrorNext$OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
    public static final long serialVersionUID = 4063763155303814625L;
    public final boolean allowFatal;
    public boolean done;
    public final Subscriber<? super T> downstream;
    public final Function<? super Throwable, ? extends Publisher<? extends T>> nextSupplier;
    public boolean once;
    public long produced;

    public FlowableOnErrorNext$OnErrorNextSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends Publisher<? extends T>> function, boolean z) {
        super(false);
        this.downstream = subscriber;
        this.nextSupplier = function;
        this.allowFatal = z;
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.once = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (!this.once) {
            this.once = true;
            if (!this.allowFatal || (th2 instanceof Exception)) {
                try {
                    Object apply = this.nextSupplier.apply(th2);
                    qw.rg(apply, "The nextSupplier returned a null Publisher");
                    Publisher publisher = (Publisher) apply;
                    long j = this.produced;
                    if (j != 0) {
                        produced(j);
                    }
                    publisher.subscribe(this);
                } catch (Throwable th3) {
                    th.de.o.qw.ad(th3);
                    this.downstream.onError(new CompositeException(th2, th3));
                }
            } else {
                this.downstream.onError(th2);
            }
        } else if (this.done) {
            th.de.ppp.qw.ddd(th2);
        } else {
            this.downstream.onError(th2);
        }
    }

    public void onNext(T t) {
        if (!this.done) {
            if (!this.once) {
                this.produced++;
            }
            this.downstream.onNext(t);
        }
    }

    public void onSubscribe(Subscription subscription) {
        setSubscription(subscription);
    }
}
