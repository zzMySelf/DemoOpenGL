package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ggg.qw;

public abstract class FlowableRepeatWhen$WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -5604623027276966720L;
    public final Subscriber<? super T> downstream;
    public final qw<U> processor;
    public long produced;
    public final Subscription receiver;

    public FlowableRepeatWhen$WhenSourceSubscriber(Subscriber<? super T> subscriber, qw<U> qwVar, Subscription subscription) {
        super(false);
        this.downstream = subscriber;
        this.processor = qwVar;
        this.receiver = subscription;
    }

    public final void again(U u) {
        setSubscription(EmptySubscription.INSTANCE);
        long j = this.produced;
        if (j != 0) {
            this.produced = 0;
            produced(j);
        }
        this.receiver.request(1);
        this.processor.onNext(u);
    }

    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public final void onNext(T t) {
        this.produced++;
        this.downstream.onNext(t);
    }

    public final void onSubscribe(Subscription subscription) {
        setSubscription(subscription);
    }
}
