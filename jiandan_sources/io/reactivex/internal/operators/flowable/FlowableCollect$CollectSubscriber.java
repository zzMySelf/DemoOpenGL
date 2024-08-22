package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableCollect$CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -3589550218733891694L;
    public final BiConsumer<? super U, ? super T> collector;
    public boolean done;
    public final U u;
    public Subscription upstream;

    public FlowableCollect$CollectSubscriber(Subscriber<? super U> subscriber, U u2, BiConsumer<? super U, ? super T> biConsumer) {
        super(subscriber);
        this.collector = biConsumer;
        this.u = u2;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            complete(this.u);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            try {
                this.collector.accept(this.u, t);
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
