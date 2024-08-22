package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class ParallelCollect$ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
    public static final long serialVersionUID = -4767392946044436228L;
    public C collection;
    public final BiConsumer<? super C, ? super T> collector;
    public boolean done;

    public ParallelCollect$ParallelCollectSubscriber(Subscriber<? super C> subscriber, C c, BiConsumer<? super C, ? super T> biConsumer) {
        super(subscriber);
        this.collection = c;
        this.collector = biConsumer;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            C c = this.collection;
            this.collection = null;
            complete(c);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.collection = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            try {
                this.collector.accept(this.collection, t);
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
