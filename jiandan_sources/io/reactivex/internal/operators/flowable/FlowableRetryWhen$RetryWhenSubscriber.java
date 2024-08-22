package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ggg.qw;

public final class FlowableRetryWhen$RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
    public static final long serialVersionUID = -2680129890138081029L;

    public FlowableRetryWhen$RetryWhenSubscriber(Subscriber<? super T> subscriber, qw<Throwable> qwVar, Subscription subscription) {
        super(subscriber, qwVar, subscription);
    }

    public void onComplete() {
        this.receiver.cancel();
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        again(th2);
    }
}
